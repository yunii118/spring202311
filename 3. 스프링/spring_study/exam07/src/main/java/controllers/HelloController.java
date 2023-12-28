package controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // controller임을 나타내는 애노테이션.
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String nm, Model model){

        // 커맨드 객체
        // 데이터를 처리할 수 있는 객체
        model.addAttribute("name", nm);

        return "hello";
    }
    // @RequestParam - 자동 형변환
//    @ GetMapping("/hello")
//    public String hello(HttpServletRequest request, HttpServletResponse response, HttpSession session){
//        //System.out.println(name + ", " + num);
//        System.out.println("request : " + request);
//        System.out.println("response : " + response);
//        System.out.println("session : " + session);
//        return "hello";// /WEB-INF/templates/hello.jsp로 이동
//    }


//    @GetMapping("/hello")
//    public ModelAndView hello(){
//        ModelAndView mv = new ModelAndView();
//        // request 범위의 attribute 추가
//        // request.setAttribute("message", "안녕하세요")
//        mv.addObject("message", "안녕하세요.");
//        mv.setViewName("hello"); //WEB-INF/templates/hello.jsp
//
//        return mv;
//    }
}
