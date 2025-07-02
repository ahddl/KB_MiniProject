package org.scoula.member.mapper;
//MyBatis 매퍼 인터페이스
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;

public interface MemberMapper {
    MemberVO get(String username);                    // 회원 조회 (권한 포함)
    MemberVO findByUsername(String username);         // ID 중복 체크용 조회
    int insert(MemberVO member);                      // 회원정보 저장
    int insertAuth(AuthVO auth);                      // 권한정보 저장
    int update(MemberVO member);
    int updatePassword(ChangePasswordDTO changePasswordDTO); // 비밀번호 변경
}
/*
Mapper 인터페이스
SQL과 자바 객체 간의 매핑(연결)을 담당하는 인터페이스
Java 메서드 ↔ SQL 쿼리를 연결해주는 다리 역할
Spring에서 DAO(Data Access Object)를 대신해서 DB 접근 로직을 깔끔하게 추상화할 수 있음
 */