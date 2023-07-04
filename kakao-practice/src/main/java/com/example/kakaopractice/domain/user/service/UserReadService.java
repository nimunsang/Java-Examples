package com.example.kakaopractice.domain.user.service;

import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.repository.UserRepository;
import com.example.kakaopractice.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserReadService {

    private final UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findUserById(id).orElseThrow();
    }

    public boolean checkUserAlreadyExists(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }
}
