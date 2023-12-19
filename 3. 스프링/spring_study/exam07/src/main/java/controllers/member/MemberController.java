package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @ModelAttribute("hobbies")
    public List<String> hobbies(){
        // MemberController 내 모든 url에서 공유
        return Arrays.asList("자바", "오라클", "JSP", "스프링");
    }
    @GetMapping("/join")
    //@RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, path="/member/join")
    public String join(@ModelAttribute RequestJoin form, Model model){
        //model.addAttribute("requestJoin", new RequestJoin());

        //String[] addCss={"member/style1", "member/style2"};
        //List<String> addScript = Arrays.asList("member/script1", "member/script2");
        //model.addAttribute("addCss", addCss);
        //model.addAttribute("addScript", addScript);

        model.addAttribute("pageTitle", "회원가입");

        return "/member/join";
    }
    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model){
        joinValidator.validate(form, errors);
        if(errors.hasErrors()){
            // 검증 실패시
            return "/member/join";
        }
        // 커맨드객체 다음에 에러객체 사용해야함
        // System.out.println(form);
        // model.addAttribute("requestJoin", form);
        // 커맨드객체 RequestJoin -> requestJoin이라는 이름으로 속성 자동 추가됨
        // -> 템플릿 내에서 바로 접근 가능함

        // 회원가입 처리
        joinService.join(form);

        // response.sendRedirect(request.getContextPath() + "/member/login")
        return "redirect:/member/login";
        //return "forward:/member/login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form){


        return "/member/login";
    }
    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors){
        loginValidator.validate(form,errors);
        if(errors.hasErrors()){
            return "/member/login";
        }
        // 로그인 처리
        loginService.login(form);
        //System.out.println(form);

        return "redirect:/"; // 로그인 성공시 메인페이지 주소로 이동
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 세션 비우기
        return "redirect:/member/login"; // 로그인 페이지 이동
    }



    @GetMapping("/list")
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
        return "/member/list";
    }
    /*@InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(joinValidator);
    };*/
}
