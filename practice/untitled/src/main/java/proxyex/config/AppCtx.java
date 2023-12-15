package proxyex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import proxyex.aopex.Calculator;
import proxyex.aopex.RecCalculator;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {

    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }


    @Bean
    public ProxyCalculator proxyCalculator(){
        return new ProxyCalculator();
    }
}
