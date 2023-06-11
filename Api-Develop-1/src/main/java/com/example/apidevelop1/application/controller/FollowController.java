package com.example.apidevelop1.application.controller;


import com.example.apidevelop1.domain.follow.dto.FollowDto;
import com.example.apidevelop1.domain.follow.entity.Follow;
import com.example.apidevelop1.domain.follow.service.FollowReadService;
import com.example.apidevelop1.domain.follow.service.FollowWriteService;
import com.example.apidevelop1.domain.user.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Follow")
@RequestMapping("/follow")
@RequiredArgsConstructor
@RestController
public class FollowController {

    private final FollowWriteService followWriteService;
    private final FollowReadService followReadService;

    @Operation(summary="팔로우 생성")
    @PostMapping("/{fromId}/{toId}")
    public Follow follow(@PathVariable long fromId, @PathVariable long toId) {
        return followWriteService.create(fromId, toId);
    }

    @Operation(summary="팔로우 삭제")
    @DeleteMapping("/{fromId}/{toId}")
    public int unfollow(@PathVariable long fromId, @PathVariable long toId) {
        return followWriteService.delete(fromId, toId);
    }

    @Operation(summary="팔로워 조회")
    @GetMapping("/follower/{id}")
    public FollowDto getFollowers(@PathVariable long id) {
        List<User> followers = followReadService.getFollowers(id);
        return new FollowDto(followers.size(), followers);
    }

    @Operation(summary="팔로잉 조회")
    @GetMapping("/following/{id}")
    public FollowDto getFollowings(@PathVariable long id) {
        List<User> followings = followReadService.getFollowings(id);
        return new FollowDto(followings.size(), followings);
    }

}
