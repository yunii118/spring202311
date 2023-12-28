package org.choongang.jpaex;

import com.querydsl.core.BooleanBuilder;
import org.choongang.entities.BoardData;
import org.choongang.entities.QBoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
@Transactional
public class Ex05Test {
    @Autowired
    private BoardDataRepository repository;

    @BeforeEach
    void init() {
        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            items.add(item);
        }

        repository.saveAllAndFlush(items);
    }

    @Test
    void test1(){
        List<BoardData> items = repository.getSubjects("목");
        items.forEach(System.out::println);
    }

    @Test
    void test2(){
        QBoardData boardData = QBoardData.boardData; // singleton 형태로 접근할 수 있게 생성되어있음
        // 조건 관련된 query 메서드 정의되어있음
        List<BoardData> items = (List<BoardData>)repository.findAll(boardData.subject.contains("목"));

        items.forEach(System.out::println);
    }

    @Test
    void test3(){
        QBoardData boardData = QBoardData.boardData;
        List<BoardData> items = (List<BoardData>) repository.findAll(boardData.subject.contains("목"), Sort.by(desc("createdAt")));

        items.forEach(System.out::println);
    }

    @Test
    void test4(){
        QBoardData boardData = QBoardData.boardData;
        Pageable pageable = PageRequest.of(1, 3, Sort.by(desc("createdAt")));
        Page<BoardData> data = repository.findAll(boardData.subject.contains("목"), pageable);

        data.forEach(System.out::println);
    }

    @Test
    void test5(){
        QBoardData boardData = QBoardData.boardData;
        BooleanBuilder andBuilder = new BooleanBuilder();
        BooleanBuilder orBuilder = new BooleanBuilder();

        andBuilder.and(boardData.seq.in(1L, 3L, 5L));

        orBuilder.or(boardData.subject.contains("목"))
                .or(boardData.content.contains("용")); // 반환값 or - method chaining 의도하고 만든것

        andBuilder.and(orBuilder);
        // and가 포함되었을 경우 둘이 나눠서 작성하는게 좋음(소괄호 쓴것같은 효과 낼 수 있음
        List<BoardData> items = (List<BoardData>) repository.findAll(andBuilder);
        // orBuilder - Predicate 의 구현 클래스, 바로 넣어줘도 상관 없음
        items.forEach(System.out::println);
    }




}
