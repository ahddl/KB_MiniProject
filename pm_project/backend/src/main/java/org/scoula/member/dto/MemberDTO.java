package org.scoula.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO { //회원정보 응답 DTO
    private String username;
    private String email;
    private Date regDate;              // 등록일
    private Date updateDate;           // 수정일
    private MultipartFile avatar;
    private List<String> authList;     // 권한 목록 (join 처리 필요)

    // MemberVO 에서 DTO 생성 (정적 팩토리 메서드)
    public static MemberDTO of(MemberVO m) {
        return MemberDTO.builder()
                .username(m.getUsername())
        .email(m.getEmail())   //password는 노출되면 안되므로 작성 x
        .regDate(m.getRegDate())
        .updateDate(m.getUpdateDate())
        .authList(m.getAuthList().stream()
                        .map(a -> a.getAuth())
        .toList())
        .build();
    }
            }
