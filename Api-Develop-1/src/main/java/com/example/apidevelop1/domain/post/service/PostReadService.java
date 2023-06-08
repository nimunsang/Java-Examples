package com.example.apidevelop1.domain.post.service;

import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostReadService {

    private final PostRepository postRepository;

    public Post getPostById(Long id) {
        Post post = postRepository.getPostById(id).orElseThrow();
        return post;
    }
}
