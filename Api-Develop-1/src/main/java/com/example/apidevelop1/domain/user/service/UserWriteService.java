package com.example.apidevelop1.domain.user.service;


import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.dto.UserUpdateCommand;
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
    public int update(UserUpdateCommand userUpdateCommand) {
        User user = userReadService.findById(userUpdateCommand.getId());
        String name = userUpdateCommand.getName() == null ? user.getName() : userUpdateCommand.getName();
        String email = userUpdateCommand.getEmail() == null ? user.getEmail() : userUpdateCommand.getEmail();
        User updateUser = User.builder()
                .id(user.getId())
                .name(name)
                .email(email)
                .createdDate(user.getCreatedDate())
                .build();

        return userRepository.update(updateUser);
    }

    @Transactional
    public int deleteById(Long id) {
        User user = userReadService.findById(id);
        return userRepository.delete(user);
    }
}
