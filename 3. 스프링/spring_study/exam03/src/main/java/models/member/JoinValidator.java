package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class JoinValidator implements Validator<Member>, RequiredValidator {
    @Autowired
    @Qualifier("memberDao")
    private MemberDao memberDao;
    public JoinValidator(){}
    // 전략 패턴
    // 변화에는 닫혀있고, 확장에는 열린 구조
    // 필요한 객체를 내부에 직접 생성하기보다는
    // 외부에서 주입받도록
    public JoinValidator(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    @Override
    public void validate(Member member) {

        // 상속을 통한 확장보다는
        // 구성요소로 포함시켜 확장시키는게 더 나음
        // 상속은 하나밖에 안되기 때문에 제한점이 생김
        // 아래와 같이 선언할 경우 다형성 측면에서 안좋음, 변수 통제가 안됨
        // private MemberDao memberDao = new MemberDao();

        /* 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명)
        * null 또는 빈 공백문자 안됨*/
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

//        if (userId == null || userId.isBlank()){
//            throw new BadRequestException("아이디를 입력하세요.");
//        }
//
//        if (userPw == null || userPw.isBlank()){
//            throw new BadRequestException("비밀번호를 입력하세요.");
//        }
//
//        if (userNm == null || userNm.isBlank()){
//            throw new BadRequestException("이름을 입력하세요.")
//        }
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

