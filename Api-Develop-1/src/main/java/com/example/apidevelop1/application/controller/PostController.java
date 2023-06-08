package com.example.apidevelop1.application.controller;


import com.example.apidevelop1.domain.post.dto.PostUpdateCommand;
import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.dto.PostCreateCommand;
import com.example.apidevelop1.domain.post.service.PostReadService;
import com.example.apidevelop1.domain.post.service.PostWriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name="Post")
@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostWriteService postWriteService;
    private final PostReadService postReadService;

    @Operation(summary="게시글 생성")
    @PostMapping("/create")
    public Post createPost(@RequestBody PostCreateCommand postCreateCommand) {
        Post post = postWriteService.createPost(postCreateCommand);
        return post;
    }

    @Operation(summary="게시글 읽기")
    @GetMapping("/read/{id}")
    public Post readPost(@PathVariable Long id) {
        Post post = postReadService.getPostById(id);
        return post;
    }

    @Operation(summary="게시글 수정")
    @PostMapping("/update")
    public Post updatePost(@RequestBody PostUpdateCommand postUpdateCommand) {
        Post post = postWriteService.updatePost(postUpdateCommand);
        return post;
    }

    @Operation(summary="게시글 삭제")
    @PostMapping("/delete/{id}")
    public int deletePost(@PathVariable Long id) {
        return postWriteService.deletePost(id);
    }
}
