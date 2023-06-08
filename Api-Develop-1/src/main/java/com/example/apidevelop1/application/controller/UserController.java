package com.example.apidevelop1.application.controller;

import com.example.apidevelop1.domain.user.dto.UserDto;
import com.example.apidevelop1.domain.user.dto.UserRegisterCommand;
import com.example.apidevelop1.domain.user.dto.UserUpdateCommand;
import com.example.apidevelop1.domain.user.entity.User;
import com.example.apidevelop1.domain.user.service.UserReadService;
import com.example.apidevelop1.domain.user.service.UserWriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Tag(name="User")
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserWriteService userWriteService;
    private final UserReadService userReadService;

    @Operation(summary="사용자 등록")
    @PostMapping("/create")
    public UserDto register(@RequestBody UserRegisterCommand userRegisterCommand) {
        User user = userWriteService.register(userRegisterCommand);
        return user.toDto();
    }

    @Operation(summary="id로 사용자 검색")
    @GetMapping("find-id/{id}")
    public UserDto findById(@PathVariable Long id) {
        User user = userReadService.findById(id);
        return user.toDto();
    }

    @Operation(summary="이름으로 사용자 검색")
    @GetMapping("find-name/{name}")
    public UserDto findByName(@PathVariable String name) {
        User user = userReadService.findByName(name);
        return user.toDto();
    }

    @Operation(summary="Email로 사용자 검색")
    @GetMapping("find-email/{email}")
    public UserDto findByEmail(@PathVariable String email) {
        User user = userReadService.findByEmail(email);
        return user.toDto();
    }

    @Operation(summary="생성일자로 사용자 검색")
    @GetMapping("find-date/{date}")
    public List<UserDto> findByCreatedDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<User> user = userReadService.findByCreatedDate(date);
        return user
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary="사용자 정보 수정")
    @PostMapping("/update")
    public int update(@RequestBody UserUpdateCommand userUpdateCommand) {
        return userWriteService.update(userUpdateCommand);
    }

    @Operation(summary="id로 사용자 삭제")
    @PostMapping("/delete/id")
    public int deleteById(@RequestBody Long id) {
        return userWriteService.deleteById(id);
    }

    @Operation(summary="이름으로 사용자 삭제")
    @PostMapping("/delete/name")
    public int deleteByName(@RequestBody String name) {
        return userWriteService.deleteByName(name);
    }

    @Operation(summary="Email로 사용자 삭제")
    @PostMapping("/delete/email")
    public int deleteByEmail(@RequestBody String email) {
        return userWriteService.deleteByEmail(email);
    }

    @Operation(summary="생성일자의 사용자 모두 삭제")
    @PostMapping("/delete/created-date")
    public int deleteByCreatedDate(@RequestBody LocalDate createdDate) {
        return userWriteService.deleteByCreatedDate(createdDate);
    }
}
