package org.choongang.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.entities.Member;
import org.choongang.restcontrollers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ApiTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원가입 성공시 응답코드 201")
    void joinTest() throws Exception{
        // MediaType.APPLICATION_JSON == applicaton/json

        RequestJoin form = new RequestJoin();
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setConfirmPw("123545678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");
        form.setRegDt(LocalDateTime.now());

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        String body =om.writeValueAsString(form); // 자바 객체 -> JSON 문자열
        System.out.println(body);

        mockMvc.perform(post("/api/member")
                        .header("Content-Type", MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(body))
                .andDo(print())
                .andExpect(status().isCreated()); // 201코드
        // andExpect - 상태코드가 맞는지 확인
    }

    @Test
    @DisplayName("JSON 문자열 -> Member 객체로 변환")
    void infoTest() throws Exception{
        String body = mockMvc.perform(get("/api/member"))
                .andDo(print())
                .andReturn().getResponse().getContentAsString(Charset.forName("UTF-8"));

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        Member member = om.readValue(body, Member.class);
        System.out.println(member);

    }

    @Test
    void listTest() throws Exception{
        String body = mockMvc.perform(get("/api/member/list"))
                .andDo(print()) // 상세 정보 출력
                .andReturn().getResponse()
                .getContentAsString(Charset.forName("UTF-8"));

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());

        List<Member> members = om.readValue(body, new TypeReference<>() {});
        members.forEach(System.out::println);
    }
}
