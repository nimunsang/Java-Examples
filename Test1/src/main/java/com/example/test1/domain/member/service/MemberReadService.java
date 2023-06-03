package com.example.test1.domain.member.service;

import com.example.test1.domain.member.dto.MemberDto;
import com.example.test1.domain.member.entity.Member;
import com.example.test1.domain.member.entity.MemberNicknameHistory;
import com.example.test1.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.test1.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberReadService {
    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;
    private final MemberRepository memberRepository;

    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getEmail(),
                member.getNickname(),
                member.getBirthday()
        );
    }

    public List<MemberNicknameHistory> getMemberNicknameHistory(Long memberId) {
        return memberNicknameHistoryRepository
                .getMemberNicknameHistory(memberId);
    }

    public MemberDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return toDto(member);
    }
}
