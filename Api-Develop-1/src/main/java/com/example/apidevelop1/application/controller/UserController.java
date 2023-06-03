package com.example.apidevelop1.application.controller;

import com.example.apidevelop1.domain.user.dto.UserDto;
import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.service.UserWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserWriteService userWriteService;

    @Tag(name="CREATE")
    @PostMapping("/create")
    public UserDto register(@RequestBody UserRegisterCommand userRegisterCommand) {
        User user = userWriteService.register(userRegisterCommand);
        return user.toDto();
    }
}
