package org.scoula.member.dto;
//회원가입 요청 DTO

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
public class MemberJoinDTO {
    //회원가입: ID, 비밀번호, 이메일, 이미지

    private String username;           // 사용자 ID
    private String password;           // 비밀번호
    private String email;              // 이메일

    private MultipartFile avatar;      // 아바타 이미지 파일
    /*MultipartFile: 클라이언트가 업로드한 파일 데이터를 서버에서 처리하기 위한 객체*/

    // MemberVO 변환 메서드
    // org.scoula.security.account.domain.MemberVO 클래스에 @Builder 추가
    public MemberVO toVO() {
        return MemberVO.builder()
                .username(username)
                .password(password)
                .email(email)
                .build();
    }
    //toVO() 메서드로 MemberVO 객체로 변환 -> Service 레이어에서 DTO → VO로 변환하여 DB에 저장
    /*
     Builder 패턴
     - 복잡한 객체 생성시 가독성을 높이고, 생성자 오버로딩을 피할 수 있는 객체 생성 패턴
     필드가 많을 때도 생성자 파라미터 순서 실수를 방지함
     필요한 값만 설정할 수 있어 유연
     */

    /*
    DTO(data Transfer Object) : 계창 간 데이터 전달을 위한 객체
    (주로 Controller<->Service<->View간)
    VO(Value Object) : 도메인 모델 객체, 실제DB와 연동되는 Entity 또는 핵심 객체
     */
}
