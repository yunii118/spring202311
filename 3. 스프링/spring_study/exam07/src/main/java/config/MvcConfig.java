package config;

import commons.Utils;
import controllers.member.JoinValidator;
import models.member.Member;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc // 프록시 형태로 adepter, viewResolver, handler 다 추가됨
@Import(DbConfig.class)
public class MvcConfig implements WebMvcConfigurer {

    //WebMvcConfigurer
    // 웹에 대한 설정이 거의 다 들어가있음
    @Autowired
    private ApplicationContext applicationContext;
   /* @Autowired
    private JoinValidator joinValidator;

    // 전역 Validator
    @Override
    public Validator getValidator() {
        return joinValidator;
    }*/

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
        // 모든 요청 -> 컨트롤러 빈, 없는경우 -> 정적 자원 경로(css, js, 이미지 등)
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**") // 기본경로 ~ 현재 경로를 포함한 모든 하위 경로
                .addResourceLocations("classpath:/static/");
        // 정적 자원 경로 찾0.
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index");
        // 컨트롤러 거치지 않고 페이지 호출할때 사용하는 메소드
    }

    // timeleaf도 번역이 필요함
    // jspTemplate 말고 timeleaf 템플릿 사용하기 위한 설정
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        // true -> 최초 로딩시 번역, 다음 요청시에는 기존 파일을 그대로 사용(실 사용중 서버)
        // false -> 매번 요청시마다 다시 번역(개발중)

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        // el식 컴파일러
        templateEngine.setEnableSpringELCompiler(true);
        // Dialect 확장기능
        // DateTimeAPI - java.time패키지 추가 - #temporals, 날짜에 대한 형식화
        templateEngine.addDialect(new Java8TimeDialect());
        // layout 기능 추가
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        //<%@ page contentType="text/html"... %> 사용 안해도됨
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setDefaultEncoding("UTf-8");
        ms.setBasenames("messages.commons", "messages.validations");

        return ms;
    }

    @Bean
    public Utils utils(){
        return new Utils();
    }

}
