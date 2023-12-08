package config;

import models.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정 클래스라고 알려줌
public class AppCtx {
    @Bean // 관리 객체라고 알려줌
    public Greeter greeter(){
        return new Greeter();
    }
}
