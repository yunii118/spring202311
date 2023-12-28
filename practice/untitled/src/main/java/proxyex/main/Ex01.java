package proxyex.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import proxyex.aopex.Calculator;
import proxyex.config.AppCtx;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
        Calculator cal = ctx.getBean(Calculator.class);
        long result = cal.factorial(10);
        System.out.println(result);

        ctx.close();
    }
}
