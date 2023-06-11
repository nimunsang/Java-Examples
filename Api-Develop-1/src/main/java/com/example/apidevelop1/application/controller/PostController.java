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

import java.util.List;

@Tag(name="Post")
@RequiredArgsConstructor
@RequestMapping("/posts")
@RestController
public class PostController {

    private final PostWriteService postWriteService;
    private final PostReadService postReadService;

    @Operation(summary="게시글 생성")
    @PostMapping("")
    public Post createPost(@RequestBody PostCreateCommand postCreateCommand) {
        Post post = postWriteService.createPost(postCreateCommand);
        return post;
    }

    @Operation(summary="게시글 읽기")
    @GetMapping("/{id}")
    public Post readPost(@PathVariable Long id) {
        Post post = postReadService.getPostById(id);
        return post;
    }

    @Operation(summary="게시글 수정")
    @PutMapping("")
    public Post updatePost(@RequestBody PostUpdateCommand postUpdateCommand) {
        Post post = postWriteService.updatePost(postUpdateCommand);
        return post;
    }

    @Operation(summary="게시글 삭제")
    @DeleteMapping("/{id}")
    public int deletePost(@PathVariable Long id) {
        return postWriteService.deletePost(id);
    }

    @Operation(summary="최신 모든 게시글 페이지 보기 (Offset 기반)")
    @GetMapping("/{page}/{take}")
    public List<Post> getAllPages(@PathVariable int page, @PathVariable int take) {
        return postReadService.getAllPagesOrderByCreatedAtDesc(page, take);
    }

    @Operation(summary="최신 카테고리 별 게시글 페이지 보기 (Offset 기반)")
    @GetMapping("/{category}/{page}/{take}")
    public List<Post> getCategoryPages(@PathVariable String category, @PathVariable int page, @PathVariable int take) {
        return postReadService.getCategoryPagesOrderByCreatedAtDesc(page, take, category);
    }

}
