package controllers.member;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    @GetMapping("/member/join")
    public String join(Model model){
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("1234")
                .userNm("<h1>사용자01</h1>")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();

        model.addAttribute("member", member);
        model.addAttribute("pageTitle", "회원가입");
        return "member/join";
    }
    @PostMapping("/member/join")
    public String joinPs(RequestJoin form){
        System.out.println(form);
        return "member/join";
    }

    @GetMapping("/member/login")
    public String login(){

        return "member/login";
    }
    @PostMapping("member/login")
    public String loginPs(RequestLogin form){
        System.out.println(form);
        return "member/login";
    }
    @GetMapping("/member/list")
    public String members(Model model){

        List<Member> members = new ArrayList<>();
        for (int i = 1;i<=10;i++){
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userId("user" + i)
                    .userPw("1234")
                    .userNm("사용자" + i )
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }
        model.addAttribute("members", members);
        return "member/list";
    }
}
