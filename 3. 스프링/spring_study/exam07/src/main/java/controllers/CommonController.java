package controllers;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")
public class CommonController {

    @ExceptionHandler(Exception.class) // 컨트롤 내부에서 해당 예외 발생시 이 핸들러로 들어옴
    public String errorHandler(Exception e, Model model, HttpServletResponse response){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;// 500

        if(e instanceof CommonException){
            CommonException commonException = (CommonException) e;
            status = commonException.getStatus();
        }
        response.setStatus(status.value());
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error/common";
    }


}
