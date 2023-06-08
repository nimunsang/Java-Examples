package com.example.apidevelop1.domain.follow.service;

import com.example.apidevelop1.domain.follow.entity.Follow;
import com.example.apidevelop1.domain.follow.repository.FollowRepository;
import com.example.apidevelop1.domain.post.service.PostReadService;
import com.example.apidevelop1.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FollowWriteService {

    private final FollowRepository followRepository;
    private final FollowReadService followReadService;
    private final UserReadService userReadService;

    public Follow create(Long fromId, Long toId) {
        Follow follow = Follow.builder()
                .fromId(fromId)
                .toId(toId)
                .build();

        if (userReadService.findById(fromId) == null || userReadService.findById(toId) == null) {
            throw new IllegalArgumentException("존재하지 않는 id입니다.");
        }
        if (followReadService.alreadyExists(follow)) {
            throw new IllegalArgumentException("이미 팔로잉중입니다.");
        }
        return followRepository.save(follow);
    }

    public Follow delete(Long fromId, Long toId) {
        // TODO: 언팔로잉 구현
    }
}
