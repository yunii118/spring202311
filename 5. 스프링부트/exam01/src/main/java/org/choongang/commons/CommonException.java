package org.choongang.commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private HttpStatus status;

    public CommonException(String message){
        this(message, HttpStatus.INTERNAL_SERVER_ERROR); // 500코드
    }

    public CommonException(String message, HttpStatus status){
        // 직접 상세코드 설정
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
