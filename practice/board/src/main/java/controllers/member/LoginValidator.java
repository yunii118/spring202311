package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import models.member.MemberDto;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestLogin form = (RequestLogin)target;

        String userId = form.getUserId();
        String userPw = form.getUserPw();

        // id로 get
        MemberDto memberDto = memberDao.get(userId);
        // id 올바른지 확인
        if(StringUtils.hasText(userId) && memberDto == null){
            errors.reject("LoginFailed");
        }

        // 비밀번호 일치 확인
        if(StringUtils.hasText(userPw) && !BCrypt.checkpw(userPw, memberDto.getUserPw())){
            errors.reject("LoginFailed");
        }
    }
}
