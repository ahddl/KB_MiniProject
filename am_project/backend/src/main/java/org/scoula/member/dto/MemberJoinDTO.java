package org.scoula.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberJoinDTO {  //회원가입 시 사용, 회원가입 요청 DTO

    /*
    회원가입시 고려사항
    - username 중복 여부 점검
    - 비밀번호 암호화
    - 회원 정보 저장시 회원 권한도 같이 저장 -> 트랜젝션 처리
    - 회원 아바타 이미지 파일 업로드 -> c:/upload/avatar/<username>.jpg 형태로 저장
     */

    //회원가입: 이름, 비밀번호, 이메일, 아바타이미지
    private String username;
    private String password;
    private String email;

    private MultipartFile avatar;

    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
}