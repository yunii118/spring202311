package controllers.member;

import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component // Db 접근
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 아이디로 회원이 조회 되는지
         * 2. 조회된 회원의 비밀번호와 입력한 비밀번호의 일치 여부
         * */
        // 아이디로 회원이 조회되는지
        RequestLogin form = (RequestLogin)target;
        String userId = form.userId();
        String userPw = form.userPw();
        Member member = memberDao.get(userId);
        if(member == null){
            errors.reject("Login.auth.fail");
        }
        // 비밀번호가 일치하지 않습니다 -> 아이디는 맞다! 보안측면에서 좋지 않음
        if(member != null && StringUtils.hasText(userPw) && !BCrypt.checkpw(userPw, member.getUserPw())){
            // !BCrypt.checkpw(userPw, member.getUserPw()) -> 검증 실패시
            errors.reject("Login.auth.fail");
        }
    }
}
