package main;

import aopex.Calculator;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aopex.RecCalculator;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx=
                new AnnotationConfigApplicationContext(AppCtx.class);

        RecCalculator cal = ctx.getBean(RecCalculator.class); // ProxyCalculator가 불러와진것. Proxy객체가 불러와짐
        long result = cal.factorial(10L);
        System.out.printf("cal : %d%n", result);



        ctx.close();
    }
}
