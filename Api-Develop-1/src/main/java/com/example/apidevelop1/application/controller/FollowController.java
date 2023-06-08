package com.example.apidevelop1.application.controller;


import com.example.apidevelop1.domain.follow.entity.Follow;
import com.example.apidevelop1.domain.follow.service.FollowWriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Follow")
@RequestMapping("/follow")
@RequiredArgsConstructor
@RestController
public class FollowController {

    private final FollowWriteService followWriteService;

    @Operation(summary="팔로우 생성")
    @PostMapping("/{fromId}/{toId}")
    public Follow follow(@PathVariable long fromId, @PathVariable long toId) {
        return followWriteService.create(fromId, toId);
    }
}
