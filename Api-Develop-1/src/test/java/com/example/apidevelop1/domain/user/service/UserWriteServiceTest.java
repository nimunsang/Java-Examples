package com.example.apidevelop1.domain.user.service;

import com.example.apidevelop1.IntegrationTest;
import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@IntegrationTest
public class UserWriteServiceTest {

    @Autowired
    private UserWriteService userWriteService;

    @Autowired
    private UserRepository userRepository;

    @DisplayName("사용자정보 등록 테스트")
    @Test
    public void testRegister() {
        var command = new UserRegisterCommand(
                "heechan",
                "sk980919@naver.com"
        );

        var user = userWriteService.register(command);

        assertEquals(command, user);
    }

    private void assertEquals(UserRegisterCommand userRegisterCommand, User user) {
        Assertions.assertNotNull(userRegisterCommand.getName());
        Assertions.assertNotNull(userRegisterCommand.getEmail());

        Assertions.assertEquals(userRegisterCommand.getEmail(), user.getEmail());
        Assertions.assertEquals(userRegisterCommand.getName(), user.getName());
    }
}
