package controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 쿠키 연습
 */
@Controller
public class TestController {

    @GetMapping("/cookie/test1")
    public String test1(HttpServletResponse response, HttpServletRequest request){
        Cookie cookie = new Cookie("key1", "value1");
        response.addCookie(cookie);
        Cookie cookie2 = new Cookie("key2", "value2");
        cookie2.setPath(request.getContextPath());// /exam07, 이 경로의 하위경로에는 다 적용
        //cookie2.setMaxAge(7 * 24 * 60 * 60);
        //cookie2.setMaxAge(0);
        // 1970.1.1 자정으로 시간 설정됨 -> 쿠키 삭제
        cookie2.setHttpOnly(true);
        // false - 자바스크립트로 브라우저에서 조회 가능
        // true - 자바스크립트 조회 안됨. 서버쪽에서만 요청을 통한 조회 가능함

        response.addCookie(cookie2);

        return "test";
    }

    @GetMapping("/cookie1/test2")
    public String test2(@CookieValue(name="key2", defaultValue = "기본값") String key2){ // 쿠키 없으면 오류 발생
        // required=false : 값 없어도 오류 발생 안하도록. null값 들어감
        // defaultValue="기본값" : 값 없으면 기본값이 대입되도록
        System.out.printf("key2=%s%n", key2);
        return "test";
    }

    @GetMapping("/session/test1")
    public String test3(HttpSession session){
        session.setAttribute("key1", "value1");

        return "test";
    }

    @GetMapping("/session/test2")
    public String test4(HttpServletRequest request){
        HttpSession session = request.getSession();
        String val = session.getAttribute("key1").toString();
        System.out.printf("key1 = %s%n", val);

        return "test";
    }
}
