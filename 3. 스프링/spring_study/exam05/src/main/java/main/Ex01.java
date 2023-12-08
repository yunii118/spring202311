package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aopex.*;

public class Ex01 {
    public static void main(String[] args) {
        // ProxyCache -> ProxyCalculator 순으로 동작해야함
        // 반대의 경우 캐시는 동작하지 않음
        // 이렇게 함수의 동작 순서에 따라 결과가 달라지는 경우
        // 순서를 명확하게 표시를 해줘야함
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(Calculator.class);

        long result = cal.factorial(10L);
        System.out.printf("cal  : %d%n", result);
        long result2 = cal.factorial(10L);
        System.out.printf("cal  : %d%n", result2);
        long result3 = cal.factorial(10L);
        System.out.printf("cal  : %d%n", result3);
        long result4 = cal.factorial(10L);
        System.out.printf("cal  : %d%n", result4);

        ctx.close();
    }
}
