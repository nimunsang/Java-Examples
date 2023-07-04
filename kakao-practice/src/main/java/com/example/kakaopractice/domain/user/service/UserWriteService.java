package com.example.kakaopractice.domain.user.service;

import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.dto.UserCreateDto;
import com.example.kakaopractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserWriteService {

    private final UserRepository userRepository;

    public void createUser(UserCreateDto userCreateDto) {
        User user = User.builder()
                .email(userCreateDto.getEmail())
                .username(userCreateDto.getUsername())
                .password(userCreateDto.getPassword())
                .build();

        userRepository.save(user);
    }

    public void createDummyUser() {
        User user = User.builder()
                .email("abc@abc.com")
                .username("heechan")
                .password("hello")
                .role("admin")
                .build();
        userRepository.save(user);
    }
}
