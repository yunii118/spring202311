package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import aopex.*;

@Configuration
public class AppCtx {
    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
}
