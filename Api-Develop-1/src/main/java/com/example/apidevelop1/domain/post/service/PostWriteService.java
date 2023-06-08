package com.example.apidevelop1.domain.post.service;

import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.dto.PostCommand;
import com.example.apidevelop1.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostWriteService {

    private final PostRepository postRepository;

    public Post createPost(PostCommand postCommand) {
        Post post = Post
                .builder()
                .title(postCommand.getTitle())
                .content(postCommand.getContent())
                .category(postCommand.getCategory())
                .memberId(postCommand.getMemberId())
                .build();

        Post createdPost = postRepository.save(post);
        return createdPost;
    }
}