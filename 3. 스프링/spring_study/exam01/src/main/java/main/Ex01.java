package main;

import config.AppCtx;
import models.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // ApplicationContext - 스프릳 컨테이너
        // AnnotationConfig - 해당 방식으로 담음, 설정 방식
        //(관리할 객체)
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppCtx.class);

        // Class명.class - class에 대핸 정보를 불러옴
        // 모든 클래스는 class라는 함수 가지고있음.
        Greeter g1 = ctx.getBean("greeter", Greeter.class);
        g1.hello("이이름");

        Greeter g2 = ctx.getBean("greeter", Greeter.class);
        System.out.println(g1 == g2);
        ctx.close();
    }
}
