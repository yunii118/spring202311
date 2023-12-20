package tests;

import config.ControllerConfig;
import config.MvcConfig;
import models.member.JoinService;
import models.member.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Connection;

@Transactional
@SpringJUnitWebConfig
@ContextConfiguration(classes = {MvcConfig.class, ControllerConfig.class})
public class JoinServiceTest {
    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mockMvc;
    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberDao memberDao;
    @Autowired
    private JoinService joinService;

    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest(){
        try(Connection conn = dataSource.getConnection();){
            System.out.println(conn);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
