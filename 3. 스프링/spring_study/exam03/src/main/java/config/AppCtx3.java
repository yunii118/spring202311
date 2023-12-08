package config;

import models.member.Member;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class AppCtx3 {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
    //@Bean
    public DateTimeFormatter formatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

        return formatter;
    }
    @Bean
    //@Primary
    public MemberDao memberDao2(){
        return new MemberDao();
    }

}
