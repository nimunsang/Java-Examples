package com.example.apidevelop1.domain.post.service;

import com.example.apidevelop1.domain.post.dto.PostUpdateCommand;
import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.dto.PostCreateCommand;
import com.example.apidevelop1.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostWriteService {

    private final PostRepository postRepository;
    private final PostReadService postReadService;

    @Transactional
    public Post createPost(PostCreateCommand postCreateCommand) {
        Post post = Post
                .builder()
                .title(postCreateCommand.getTitle())
                .content(postCreateCommand.getContent())
                .category(postCreateCommand.getCategory())
                .userId(postCreateCommand.getUserId())
                .build();

        return postRepository.save(post);
    }

    @Transactional
    public Post updatePost(PostUpdateCommand postUpdateCommand) {
        Post post = postReadService.getPostById(postUpdateCommand.getId());
        Post updatedPost = Post.builder()
                        .id(post.getId())
                        .title(postUpdateCommand.getTitle() == null ? post.getTitle() : postUpdateCommand.getTitle())
                        .content(postUpdateCommand.getContent() == null ? post.getContent() : postUpdateCommand.getContent())
                        .category(postUpdateCommand.getCategory() == null ? post.getCategory() : postUpdateCommand.getCategory())
                        .userId(post.getUserId())
                        .createdAt(post.getCreatedAt())
                        .build();

        return postRepository.save(updatedPost);
    }

    @Transactional
    public int deletePost(Long id) {
        Post post = postReadService.getPostById(id);
        if (post.getCategory().equals("질문")) {
            throw new IllegalArgumentException("질문글은 삭제할 수 없습니다.");
        }
        return postRepository.delete(id);
    }

}