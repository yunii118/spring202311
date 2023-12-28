package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.entities.Member;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profile.active=test")
public class Ex09Test {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void init(){
        Member member = new Member();
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setName("사용자01");

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setMember(member);

            items.add(item);
        }
        boardDataRepository.saveAllAndFlush(items);

    }
    @Test
    void test1(){
        Member member = memberRepository.findByEmail("user01@test.org");
        memberRepository.delete(member);
        // 영속성 콘텍스트는 조회를 해야지만 삭제할 수 있음
        memberRepository.flush();
        // -> 자식 엔티티가 on delete no action - 부모엔티티 삭제하려고 할 때 아무런 행위도 취하지 않게함
        // -> 삭제되지않음. cascade 바꿔줘야함
    }
}
