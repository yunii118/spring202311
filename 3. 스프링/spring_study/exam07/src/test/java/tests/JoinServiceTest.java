package tests;

import config.ControllerConfig;
import config.DbConfig;
import config.ControllerConfig;
import config.DbConfig;
import config.MvcConfig;
import controllers.member.RequestJoin;
import models.member.JoinService;
import models.member.Member;
import models.member.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;


//@SpringJUnitWebConfig
//@WebAppConfiguration
@Transactional // 테스트 후 자동으로 rollback됨
@SpringJUnitWebConfig
@ContextConfiguration(classes = {MvcConfig.class, ControllerConfig.class})
public class JoinServiceTest {
    @Autowired
    private WebApplicationContext ctx;
    // 테스트 전에 생성하면 됨
    private MockMvc mockmvc;
    @Autowired
    private DataSource dataSrouce;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private JoinService joinService;

    @BeforeEach
    void setup(){
        mockmvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest() {
        try (Connection conn = dataSrouce.getConnection()) {
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("MemberDao - exist 메서드 테스트")
    void existsTest() {
        String userId = "user01";
        boolean result = memberDao.exist(userId);

        assertTrue(result);
    }

    @Test
    @DisplayName("JoinService - join 메서드 테스트")
    void joinTest(){
        RequestJoin form = new RequestJoin();
        form.setUserId("user02");
        form.setUserPw("12345678");
        form.setUserNm("사용자02");
        form.setEmail("user02@test.org");


        joinService.join(form);

        Member member = memberDao.get(form.getUserId());
        System.out.println(member);
    }

    @Test
    @DisplayName("회원가입 통합 테스트")
    void joinTest2() throws Exception {
        // 요청, 응답에 대한 테스트 가능
        mockmvc.perform(post("/member/join")
                .param("userId", "user01"))
                .andDo(MockMvcResultHandlers.print());
                // andReturn : body쪽 데이터로 무언가를 하겠다

    }
}