package org.choongang.jpaex;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.lang.annotation.Before;
import org.choongang.entities.BoardData;
import org.choongang.entities.Member;
import org.choongang.entities.QBoardData;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.backoff.BackOff;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
@Transactional
public class Ex06Test {
    @Autowired
    private BoardDataRepository boardDataRepository;
    @Autowired
    private MemberRepository memberRepository;
    @PersistenceContext
    private EntityManager em;

    @BeforeEach
     void init(){
         Member member = new Member();
         member.setEmail("user01@test.org");
         member.setName("사용자01");
         member.setPassword("12345678");

         memberRepository.saveAndFlush(member);

         List<BoardData> items = new ArrayList<>();
         for(int i = 1;i<=10;i++){
             BoardData item = new BoardData();
             item.setMember(member);
             item.setSubject("제목" + i);
             item.setContent("내용" + i);

             items.add(item);
         }

         boardDataRepository.saveAllAndFlush(items);
         em.clear(); // entity 비우기
     }

     @Test
     void test1(){
        BoardData data = boardDataRepository.findById(1L).orElse(null);
        // 관계 매핑만 해도 알아서 join 해줌
         Member member = data.getMember();
         String email = member.getEmail();
         System.out.println(email);
         System.out.println(member);
     }

     @Test
     void test2(){
        Member member = memberRepository.findByEmail("user01@test.org");
        List<BoardData> items = member.getItems();
        items.forEach(System.out::println); // BoardData -> toString()

     }

     @Test
    void test3(){
        List<BoardData> items = boardDataRepository.findAll();
        for(BoardData item : items){
            Member member = item.getMember();
            String email = member.getEmail(); //2차쿼리 실행
        }
     }
     @Test
     void test4(){
        // jpql 사용
        //List<BoardData> items = boardDataRepository.getSubjects("목");
         // @EntityGraph 사용
         List<BoardData> items = boardDataRepository.findBySubjectContaining("목");

     }

     @Test
    void test5(){
        // querydsl 사용
         QBoardData boardData = QBoardData.boardData;
         JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
         List<BoardData> items = (List<BoardData>) jpaQueryFactory.selectFrom(boardData)
                 .leftJoin(boardData.member).fetchJoin()
                 .where(boardData.subject.contains("목"))
                 .fetch();

         items.forEach(System.out::println);
     }
}
