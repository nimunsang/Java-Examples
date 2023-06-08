package com.example.apidevelop1.application.controller;


import com.example.apidevelop1.domain.post.entity.Post;
import com.example.apidevelop1.domain.post.dto.PostCommand;
import com.example.apidevelop1.domain.post.service.PostReadService;
import com.example.apidevelop1.domain.post.service.PostWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostController {

    private final PostWriteService postWriteService;
    private final PostReadService postReadService;

    @Tag(name="createPost")
    @PostMapping("/create")
    public Post createPost(@RequestBody PostCommand postCommand) {
        Post post = postWriteService.createPost(postCommand);
        return post;
    }

    @Tag(name="ReadPost")
    @GetMapping("/read/{id}")
    public Post readPost(@PathVariable Long id) {
        Post post = postReadService.getPostById(id);
        return post;
    }
}
