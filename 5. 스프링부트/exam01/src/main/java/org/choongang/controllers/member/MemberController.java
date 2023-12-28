package org.choongang.controllers.member;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join(){
        log.info("로그 메세지!");
        log.info("로그 {}, {}", "값1","값2");
        return "member/join";
    }

    @ResponseBody
    @GetMapping("/info")
    public Member info(){
        Member member =Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build();
        return member;
    }

}
