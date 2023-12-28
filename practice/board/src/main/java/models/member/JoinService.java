package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberDao memberDao;

    public void join(RequestJoin form){
        String hash= BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt());

        MemberDto memberDto = MemberDto.builder()
                .userId(form.getUserId())
                .userPw(hash)
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();
        memberDao.register(memberDto);

    }

}
