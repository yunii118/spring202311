package config;

import models.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
// import 하나만 있을때는 value 생략 가능함
// Import({AppCtx3.class})
// 중괄호도 생략 가능
@Import(value={AppCtx3.class})
@Configuration
public class AppCtx2 {
    // 스프링에게 함수 조립 위임


    @Bean
    public JoinValidator joinValidator(){
        return new JoinValidator();
    }
    @Bean
    public JoinService joinService(){
        return new JoinService();
    }
    @Bean
    public ListService listService(){
        return new ListService();
    }

    // Autowired 애노테이션
    // 위의 4가지 객체를 한 통에 담음
    // 다른 험슈에서 필요한 객체가 같은 통에 존재할경우
    // 해당 객체를 알아서 넣어줌

}
