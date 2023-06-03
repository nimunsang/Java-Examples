package com.example.test1.domain.member.service;

import com.example.test1.domain.member.dto.MemberRegisterCommand;
import com.example.test1.domain.member.entity.Member;
import com.example.test1.domain.member.entity.MemberNicknameHistory;
import com.example.test1.domain.member.repository.MemberNicknameHistoryRepository;
import com.example.test1.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    private final MemberRepository memberRepository;
    private final MemberNicknameHistoryRepository memberNicknameHistoryRepository;

    public Member register(MemberRegisterCommand command) {
        /*
            목표 - 회원 정보 (이메일, 닉네임, 생년월일 )을 등록한다.
                - 닉네임은 10자를 넘길 수 없다.
            파라미터 - memberRegisterCommand
         */

        var member = Member.builder()
                .nickname(command.nickname())
                .email(command.email())
                .birthday(command.birthday())
                .build();

        return memberRepository.save(member);
    }

    public void changeNickname(Long memberId, String nickname) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        member.changeNickname(nickname);
        var savedMember = memberRepository.save(member);

        saveMemberNicknameHistory(savedMember);
    }

    private void saveMemberNicknameHistory(Member member) {
        var history = MemberNicknameHistory
                .builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();

        memberNicknameHistoryRepository.save(history);
    }
}
