package org.scoula.member.service;
//서비스 인터페이스
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;

public interface MemberService {
    boolean checkDuplicate(String username);     // ID 중복 체크
    MemberDTO get(String username);              // 회원 조회
    MemberDTO join(MemberJoinDTO member);        // 회원가입
    MemberDTO update(MemberUpdateDTO member);    // 회원정보 수정 <- 추가
    void changePassword(ChangePasswordDTO changePassword); // 비밀번호 변경
}
/*
Service
- 비즈니스 로직을 처리하는 계층
- Controller에서 받은 요청을 바탕으로 "어떤 작업을 어떻게 처리할지" 결정하는 중간 관리자 역할
 */