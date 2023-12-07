package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JoinValidator implements Validator<Member>, RequiredValidator {
    @Autowired
    private MemberDao memberDao;

    @Override
    public void validate(Member member) {

        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 확인하세요."));
        checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));

        // 아이디가 이미 등록되어 있는지 체크
        checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된 아이디입니다."));

        // 비밀번호와 비밀번호 확인 일치여부 체크
        checkTrue(userPw.equals(confirmPw), new BadRequestException("비밀번호가 일치하지 않습니다."));



    }


}

