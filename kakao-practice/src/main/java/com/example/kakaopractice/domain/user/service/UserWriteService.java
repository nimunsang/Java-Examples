package com.example.kakaopractice.domain.user.service;

import com.example.kakaopractice.domain.user.entity.User;
import com.example.kakaopractice.domain.user.dto.UserCreateDto;
import com.example.kakaopractice.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserWriteService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void createUser(UserCreateDto userCreateDto) {

        User user = User.builder()
                .email(userCreateDto.getEmail())
                .username(userCreateDto.getUsername())
                .password(passwordEncoder.encode(userCreateDto.getPassword()))
                .build();

        userRepository.save(user);
    }

    public void createDummyUser() {
        User user = User.builder()
                .email("abc@abc.com")
                .username("heechan")
                .password("hello")
                .roles("admin")
                .build();
        userRepository.save(user);
    }
}
