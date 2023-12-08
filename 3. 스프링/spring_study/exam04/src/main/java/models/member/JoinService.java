package models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

// 회원가입
@Service
@RequiredArgsConstructor
public class JoinService {
    // 이렇게 열려있는 구조로 바꾸면 통제하기 쉬움
    // ex -> memberDao = new CachedMemberDao()라고 할 경우
    // memberDao를 상속받는 다른 객체 사용 불가능

    private final MemberDao memberDao;
    @NonNull
    private JoinValidator validator;
    // 가본생성자 없이 매개변수 있는 생성자만 존재하도록
    // 객체 관리 위해 자동주입해줄수밖에 없음


    public void join(Member member){
        // 데이터 검증
        // 여기에 예외처리를 할 경우 하나로만 처리되기 때문에 좋지않음
        // 호출하는 클래스에서 상황별로 예외처리
        validator.validate(member);
        // 데이터 추가
        memberDao.register(member);

    }
}
