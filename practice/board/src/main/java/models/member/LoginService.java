package models.member;

import controllers.member.RequestLogin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberDao memberDao;

    public void login(RequestLogin form, Errors errors){
        String userId = form.getUserId();
        String userPw = form.getUserPw();

        // id로 get
        MemberDto memberDto = memberDao.get(userId);
        // 비밀번호 일치 확인
        if(StringUtils.hasText(userPw) && !BCrypt.checkpw(userPw, memberDto.getUserPw())){
            errors.reject("LoginFailed");
        }
    }

}
