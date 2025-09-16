package org.pcheltas.inf_sec_1.controller;

import org.pcheltas.inf_sec_1.dto.PostRequestDto;
import org.pcheltas.inf_sec_1.dto.PostResponseDto;
import org.pcheltas.inf_sec_1.mapper.PostMapper;
import org.pcheltas.inf_sec_1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;

    @Autowired
    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getPosts() {
        List<PostResponseDto> posts = postService.getAllPosts().stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostRequestDto postRequestDto) {
        PostResponseDto createdPost = postMapper.toDto(postService.savePost(postMapper.toEntity(postRequestDto)));
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }
}
