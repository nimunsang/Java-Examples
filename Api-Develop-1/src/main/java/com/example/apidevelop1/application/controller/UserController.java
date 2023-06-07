package com.example.apidevelop1.application.controller;

import com.example.apidevelop1.domain.user.dto.UserDto;
import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.service.UserReadService;
import com.example.apidevelop1.domain.user.service.UserWriteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {
    private final UserWriteService userWriteService;
    private final UserReadService userReadService;

    @Tag(name="Create")
    @PostMapping("/create")
    public UserDto register(@RequestBody UserRegisterCommand userRegisterCommand) {
        User user = userWriteService.register(userRegisterCommand);
        return user.toDto();
    }

    @Tag(name="findUser")
    @GetMapping("find-id/{id}")
    public UserDto findById(@PathVariable Long id) {
        User user = userReadService.findById(id);
        return user.toDto();
    }

    @Tag(name="findUser")
    @GetMapping("find-name/{name}")
    public UserDto findByName(@PathVariable String name) {
        User user = userReadService.findByName(name);
        return user.toDto();
    }

    @Tag(name="findUser")
    @GetMapping("find-email/{email}")
    public UserDto findByEmail(@PathVariable String email) {
        User user = userReadService.findByEmail(email);
        return user.toDto();
    }

    @Tag(name="findUser")
    @GetMapping("find-date/{date}")
    public List<UserDto> findByCreatedDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<User> user = userReadService.findByCreatedDate(date);
        return user
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    @Tag(name="updateUser")
    @PostMapping("update/{id}/name")
    public UserDto updateNameById(@PathVariable Long id, @RequestBody String to) {
        User user = userWriteService.updateNameById(id, to);
        return user.toDto();
    }

    @Tag(name="updateUser")
    @PostMapping("update/{id}/email")
    public UserDto updateEmailById(@PathVariable Long id, @RequestBody String to) {
        User user = userWriteService.updateEmailById(id, to);
        return user.toDto();
    }

    @Tag(name="deleteUser")
    @PostMapping("/delete/id")
    public int deleteById(@RequestBody Long id) {
        return userWriteService.deleteById(id);
    }

    @Tag(name="deleteUser")
    @PostMapping("/delete/name")
    public int deleteByName(@RequestBody String name) {
        return userWriteService.deleteByName(name);
    }

    @Tag(name="deleteUser")
    @PostMapping("/delete/email")
    public int deleteByEmail(@RequestBody String email) {
        return userWriteService.deleteByEmail(email);
    }

    @Tag(name="deleteUser")
    @PostMapping("/delete/created-date")
    public int deleteByCreatedDate(@RequestBody LocalDate createdDate) {
        return userWriteService.deleteByCreatedDate(createdDate);
    }
}
