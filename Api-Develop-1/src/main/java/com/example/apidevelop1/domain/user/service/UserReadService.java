package com.example.apidevelop1.domain.user.service;


import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserReadService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        // 해당 id로 단일 검색
        return userRepository.findById(id).orElseThrow();
    }

    public User findByName(String name) {
        // 해당 이름으로 단일 검색
        return userRepository.findByName(name).orElseThrow();
    }

    public User findByEmail(String email) {
        // 해당 이메일로 단일 검색
        return userRepository.findByEmail(email).orElseThrow();
    }

    public List<User> findByCreatedDate(LocalDate date) {
        // 해당 날짜로 모두 검색
        return userRepository.findByCreatedDate(date).orElseThrow();
    }
}
