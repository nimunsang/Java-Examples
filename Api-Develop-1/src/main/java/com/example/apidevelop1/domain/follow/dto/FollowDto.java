package com.example.apidevelop1.domain.follow.dto;

import com.example.apidevelop1.domain.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class FollowDto {

    private final int followCount;

    private final List<User> follows;

}
