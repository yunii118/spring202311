package commons;

import jakarta.servlet.http.HttpSession;
import models.member.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Utils {
    @Autowired
    private HttpSession session;

    public boolean isLogin(){

       return getMember() != null;
    }

    public MemberDto getMember(){
        MemberDto memberDto = (MemberDto) session.getAttribute("member");
        return memberDto;
    }

}
