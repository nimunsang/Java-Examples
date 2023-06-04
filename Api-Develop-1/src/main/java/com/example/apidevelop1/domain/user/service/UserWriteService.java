package com.example.apidevelop1.domain.user.service;


import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserWriteService {
    private final UserRepository userRepository;

    public User register(UserRegisterCommand userRegisterCommand) {
        User user = User
                .builder()
                .name(userRegisterCommand.getName())
                .email(userRegisterCommand.getEmail())
                .build();

        return userRepository.save(user);
    }

    public User updateNameById(Long id, String to) {
        // 해당 id를 가진 사용자의 이름 변경
        return userRepository.updateNameById(id, to);
    }

//    public User updateEmailById(String email) {
//        // 해당 id를 가진 사용자의 이메일 변경
//        return userRepository.updateEmailById(id);
//    }
}
