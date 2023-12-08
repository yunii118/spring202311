package config;


import models.Message;
import models.Message2;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx2 {
    @Bean
    @Scope("prototype") // 조회할때 마다 다른 객체 생성
    public Message message(){
        return new Message();
    }
    @Bean(initMethod = "init", destroyMethod = "close") // 이때 init과 close는 매개변수가 있으면 안됨, Bean 애노테이션 파일 참고
    public Message2 message2(){
        return new Message2();
    }

    public void afterInitiallized(){

    }

}
