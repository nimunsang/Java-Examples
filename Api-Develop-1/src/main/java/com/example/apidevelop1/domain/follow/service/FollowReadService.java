package com.example.apidevelop1.domain.follow.service;

import com.example.apidevelop1.domain.follow.entity.Follow;
import com.example.apidevelop1.domain.follow.repository.FollowRepository;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.service.UserReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FollowReadService {

    private final FollowRepository followRepository;

    private final UserReadService userReadService;

    public boolean exists(Follow follow) {
        return followRepository.exists(follow);
    }

    public List<User> getFollowers(Long userId) {
        User user = userReadService.findById(userId);

        List<Long> followerIds = followRepository.getFollowerIds(user);

        return followerIds.stream()
                .map(userReadService::findById)
                .collect(Collectors.toList());
    }

    public List<User> getFollowings(Long userId) {
        User user = userReadService.findById(userId);

        List<Long> followingIds = followRepository.getFollowingIds(user);

        return followingIds.stream()
                .map(userReadService::findById)
                .collect(Collectors.toList());
    }
}