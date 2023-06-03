package com.example.test1.application.controller;

import com.example.test1.domain.member.dto.MemberDto;
import com.example.test1.domain.member.dto.MemberRegisterCommand;
import com.example.test1.domain.member.entity.Member;
import com.example.test1.domain.member.entity.MemberNicknameHistory;
import com.example.test1.domain.member.service.MemberReadService;
import com.example.test1.domain.member.service.MemberWriteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberWriteService memberWriteService;
    private final MemberReadService memberReadService;

    @PostMapping("/register")
    public MemberDto register(@RequestBody MemberRegisterCommand command) {
        var member = memberWriteService.register(command);
        return memberReadService.toDto(member);
    }

    @GetMapping("/history/{memberId}")
    public List<MemberNicknameHistory> getMemberNicknameHistory(@PathVariable Long memberId) {
        var memberNicknameHistory = memberReadService.getMemberNicknameHistory(memberId);
        return memberNicknameHistory;
    }

    @PostMapping("/change-nickname")
    public MemberDto changeNickname(@RequestBody Long memberId, String to) {
        memberWriteService.changeNickname(memberId, to);
        return memberReadService.getMember(memberId);
    }
}
