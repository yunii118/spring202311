package models.member.sub;

import org.springframework.stereotype.Repository;

@Repository("memberDao2") // 빈의 이름을 바꿔줌
public class MemberDao {
    // memberDao로 객체 생성될것
    // 자바에서는 클래스를 패키지명 + 클래스명으로 구분하지만
    // 스프링에서는 클래스명을 보고 판단하기 때문에
    // models.member의 MemberDao와 이름이 같아
    // 자동 스캔시 충돌 발생함
    // -> 빈의 이름을 바꿔줌
}
