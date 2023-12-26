package org.choongang.jpaex;

import org.choongang.entities.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex01Test {
    @PersistenceContext // autowired와 비슷
    private EntityManager em; // 사용시 트랜젝션 처리 해줘야함

    @BeforeEach
    void init(){
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        //member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear();// 영속 상태 엔티티 모두 비우기

    }

    @Test
    void test1(){
        Member member = new Member();
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        //member.setCreatedAt(LocalDateTime.now());

        // 영속성 콘텍스트 안에 넣어줌 - 변화 감지 시작
        em.persist(member);
        em.flush();
        // 여기까지는 insert

        em.detach(member); // 영속성 분리 - 변화감지 안됨

        member.setName("(수정)사용자01");
        em.flush();
        // update 쿼리 -> 상태 변화 감지.

        em.merge(member); // 분리된 영속 상태 엔티티 -> 영속상태로 바꿔줌
        em.flush();
        // 변화 감지



      /*  em.remove(member); // 제거 상태로 변경
        em.flush();
        // delete 쿼리
       */
    }


    @Test
    void test2(){
        Member member = em.find(Member.class, 1L); // select 실행
        // find - 기본키 가지고만 조회. 조회시 한계 존재
        // JPQL - 일반 SQL과는 차이가 있음
        //   - 문법, 조회결과시 엔티티 : 영속상태, 변화감지
        //   - 쿼리 : 테이블 x, 엔티티 기준의 쿼리
        System.out.println(member);
        // 영속성 콘텍스트에 존재 - 바로 꺼냄
        // 없으면 select 쿼리 날려서 db에서 꺼냄

        Member member2 = em.find(Member.class, 1L); // select 실행 x
        System.out.println(member2);
    }

    @Test
    void test3(){
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class).getResultList();
        members.forEach(System.out::println);
    }
}
