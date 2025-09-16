package org.pcheltas.inf_sec_1.service;

import lombok.RequiredArgsConstructor;
import org.pcheltas.inf_sec_1.dto.AuthRequestDTO;
import org.pcheltas.inf_sec_1.exception.InvalidCredentialsException;
import org.pcheltas.inf_sec_1.exception.UserAlreadyExistsException;
import org.pcheltas.inf_sec_1.exception.UserNotFoundException;
import org.pcheltas.inf_sec_1.model.User;
import org.pcheltas.inf_sec_1.repository.UserRepository;
import org.pcheltas.inf_sec_1.security.JwtUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public String login(AuthRequestDTO request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid password");
        }

        return jwtUtils.generateToken(user.getUsername());
    }

    public String register(AuthRequestDTO request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already taken");
        }

        User newUser = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        userRepository.save(newUser);
        return jwtUtils.generateToken(newUser.getUsername());
    }
}