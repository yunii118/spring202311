package config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

public class CommonInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 사이트 전역에 처리할 값도 이런식으로 처리하면 됨
        request.setAttribute("commonValue", "공통값");

        // 공통값만 하기 위해서
        return true;
    }
}
