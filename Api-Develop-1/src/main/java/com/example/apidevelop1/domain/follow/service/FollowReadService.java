package com.example.apidevelop1.domain.follow.service;

import com.example.apidevelop1.domain.follow.entity.Follow;
import com.example.apidevelop1.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowReadService {

    private final FollowRepository followRepository;

    public boolean alreadyExists(Follow follow) {
        return followRepository.alreadyExists(follow);
    }
}