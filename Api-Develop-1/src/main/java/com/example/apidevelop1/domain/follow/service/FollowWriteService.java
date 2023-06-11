package com.example.apidevelop1.domain.follow.service;

import com.example.apidevelop1.domain.follow.entity.Follow;
import com.example.apidevelop1.domain.follow.repository.FollowRepository;
import com.example.apidevelop1.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        if (followReadService.exists(follow)) {
            throw new IllegalArgumentException("이미 팔로잉중입니다.");
        }
        return followRepository.save(follow);
    }

    public int delete(Long fromId, Long toId) {
        Follow follow = Follow.builder()
                .fromId(fromId)
                .toId(toId)
                .build();

        if (!followReadService.exists(follow)) {
            throw new IllegalArgumentException("팔로잉 중이 아닙니다.");
        }
        return followRepository.delete(follow);
    }
}
