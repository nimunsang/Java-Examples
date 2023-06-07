package com.example.apidevelop1.domain.user.service;


import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserWriteService {
    private final UserRepository userRepository;
    private final UserReadService userReadService;

    @Transactional
    public User register(UserRegisterCommand userRegisterCommand) {
        User user = User
                .builder()
                .name(userRegisterCommand.getName())
                .email(userRegisterCommand.getEmail())
                .build();

        if (userRepository.nameNotExistsInDatabase(user.getName()) && userRepository.emailNotExistsInDatabase(user.getEmail())) {
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("이미 존재하는 이메일 또는 이름입니다.");
        }
    }

    @Transactional
    public User updateNameById(Long id, String to) {
        // 해당 id를 가진 사용자의 이름 변경
        User user = userReadService.findById(id);
        user.changeName(to);
        return userRepository.update(user);
    }

    @Transactional
    public User updateEmailById(Long id, String to) {
        // 해당 id를 가진 사용자의 이메일 변경
        User user = userReadService.findById(id);
        user.changeEmail(to);
        return userRepository.update(user);
    }

    @Transactional
    public int deleteById(Long id) {
        User user = userReadService.findById(id);
        return userRepository.delete(user);
    }

    @Transactional
    public int deleteByEmail(String email) {
        User user = userReadService.findByEmail(email);
        return userRepository.delete(user);
    }

    @Transactional
    public int deleteByName(String name) {
        User user = userReadService.findByName(name);
        return userRepository.delete(user);
    }

    @Transactional
    public int deleteByCreatedDate(LocalDate createdDate) {
        List<User> users = userReadService.findByCreatedDate(createdDate);
        return userRepository.delete(users);
    }
}
