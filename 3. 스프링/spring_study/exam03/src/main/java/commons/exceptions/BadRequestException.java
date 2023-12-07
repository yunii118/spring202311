package commons.exceptions;

public class BadRequestException extends RuntimeException{
    // 서비스 멈추는것을 막기 위해서 예외처리를 해줘야함

    public BadRequestException(String message){
        super(message);

    }
}
