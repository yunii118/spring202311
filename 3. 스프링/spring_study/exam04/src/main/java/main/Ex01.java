package main;

import config.AppCtx;
import config.AppCtx2;
import models.member.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(AppCtx.class);
        JoinService joinService = ctx.getBean(JoinService.class);
        ListService listService = ctx.getBean(ListService.class);
        MemberDao memberDao = ctx.getBean(MemberDao.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        memberDao.register(member);

        listService.print();


        ctx.close();

    }



}
