package config;

import controllers.HelloController;
import controllers.member.MemberController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"controllers", "models"}) // controllers 하위 패키지/클래스들 관리. 알아서스캔
public class ControllerConfig {
   /* @Bean
    public HelloController helloController(){
        return new HelloController();
    }

    @Bean
    public MemberController memberController(){
        return new MemberController();
    }*/


}
