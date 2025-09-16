package org.pcheltas.inf_sec_1.repository;

import org.pcheltas.inf_sec_1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
