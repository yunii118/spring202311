package models.member;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 회원가입
@Configuration
public class JoinService {
    // 이렇게 열려있는 구조로 바꾸면 통제하기 쉬움
    // ex -> memberDao = new CachedMemberDao()라고 할 경우
    // memberDao를 상속받는 다른 객체 사용 불가능
    private MemberDao memberDao;
    private JoinValidator validator;

    public JoinService(MemberDao memberDao, JoinValidator validator){
        this.memberDao = memberDao;
        this.validator = validator;
    }
    @Bean
    public void join(Member member){
        // 데이터 검증
        // 여기에 예외처리를 할 경우 하나로만 처리되기 때문에 좋지않음
        // 호출하는 클래스에서 상황별로 예외처리
        validator.validate(member);
        // 데이터 추가
        memberDao.register(member);

    }
}
