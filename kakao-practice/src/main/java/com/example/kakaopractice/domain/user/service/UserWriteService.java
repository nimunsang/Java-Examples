package com.example.kakaopractice.domain.user.service;

import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserWriteService {

    private final UserRepository userRepository;

    public void createDummyUser() {
        User user = User.builder()
                .email("abc@abc.com")
                .name("heechan")
                .password("hello")
                .role("hellorole")
                .build();
        userRepository.save(user);
    }
}
