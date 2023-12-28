package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao;
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     * 실제로 검증을 수행할 메서드
     *
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     */
    @Override
    public void validate(Object target, Errors errors) {
        /*
        * 1. 필수항목 검증 -> RequestJoin
        * 2. 중복아이디
        * 3. 아이디 최소자리수 -> RequestJoin
        * 4. 비밀번호 최소자리수 -> RequestJoin
        * 5. 이메일 형식 체크 -> RequestJoin
        * 6. 비밀번호, 비밀번호 확인 일치 여부
        */

        RequestJoin form = (RequestJoin) target;
        String userId = form.getUserId();

        if(StringUtils.hasText(userId) && memberDao.exist(userId)){
            errors.rejectValue("userId", "Duplicated");
        }

        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();

        if(StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)
                && !userPw.equals(confirmPw)){
            errors.rejectValue("confirmPw", "MisMatch");
        }

    }
}
