package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppCtx2.class);

        // 빈의 이름 = 메서드명
        // 이름과 클래스 둘다 명시해줘야함
        JoinService joinService = ctx.getBean("joinService", JoinService.class);
        ListService listService = ctx.getBean("listService", ListService.class);

        // 롬복 가끔 오류 있을때 있음
        // setter getter 오류 생기면 코드 삭제 후 컴파일 -> 붙여넣고 다시 컴파일
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);
        listService.print();
        ctx.close();
    }
}
