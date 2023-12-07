package commons.validators;

import org.springframework.util.StringUtils;

public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e){
        // null값, 빈 값 체크하는 스프링 쪽 편의기능
        if(!StringUtils.hasText(str)){
            throw e;
        }
    }
    // 참이 아닐때 예외 발생
    default void checkTrue(boolean result, RuntimeException e){
        if(!result){
            throw e;
        }
    }

    default void checkFalse(boolean result, RuntimeException e){
        if(result){
            throw e;
        }
    }


}
