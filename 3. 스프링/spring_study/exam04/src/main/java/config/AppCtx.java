package config;

import models.member.MemberDao;
import org.springframework.context.annotation.*;

@Configuration
// ManualBean은 수동 등록해야만 사용 가능하게
/*
@ComponentScan(value = "models",
            excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = ManualBean.class))
            // models : 패키지명

 */
/*@ComponentScan(value = "models",
        excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = MemberDao.class))*/
// 클래스 자체를 배제
@ComponentScan(value = "models",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "models..*Dao")) // .. : 하위패키지를 포함한 모든 클래스
public class AppCtx {
    // 수동
    // 이름일 동일한 경우 수동 등록 빈이 자동 등록 빈보다
    // 우선순위가 높음
    /*@Bean
    public MemberDao memberDao(){
        System.out.println("수동 등록 빈");
        return new MemberDao();
    }*/

}
