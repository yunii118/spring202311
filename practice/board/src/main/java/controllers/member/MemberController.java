package controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;
    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form, Model model){
        model.addAttribute("pageTitle", "회원가입");
        return "/member/join";
    }
    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model){
        joinValidator.validate(form, errors);
        if(errors.hasErrors()){
            return "/member/join";
        }
        joinService.join(form);

        return "redirect:/member/login";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form, Model model){

        model.addAttribute("pageTitle", "로그인");

        return "/member/login";
    }
    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form, Errors errors, Model model){
        loginValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "/member/login";
        }
        return "redirect:/";
    }
}
