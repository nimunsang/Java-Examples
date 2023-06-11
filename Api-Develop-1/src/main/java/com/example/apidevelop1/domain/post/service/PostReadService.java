package com.example.apidevelop1.domain.post.service;

import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostReadService {

    private final PostRepository postRepository;

    public Post getPostById(Long id) {
        return postRepository.getPostById(id).orElseThrow();
    }

    public List<Post> getAllPagesOrderByCreatedAtDesc(int page, int take) {
        return postRepository.getPagesOrderByCreatedAtDesc(page, take);
    }

    public List<Post> getCategoryPagesOrderByCreatedAtDesc(int page, int take, String category) {
        return postRepository.getCategoryPagesOrderByCreatedAtDesc(page, take, category);
    }


}
