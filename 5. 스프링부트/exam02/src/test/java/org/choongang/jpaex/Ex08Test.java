package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.entities.HashTag;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
@Transactional
public class Ex08Test {
    @Autowired
    private BoardDataRepository boardDataRepository;
    @Autowired
    private HashTagRepository hashTagRepository;
    @BeforeEach
    void init(){
        List<HashTag> tags = new ArrayList<>();
        List<BoardData> items = new ArrayList<>();
        for(int i = 1;i <= 5; i++){
            HashTag tag = new HashTag();
            tag.setTag("태그" + i);
            tags.add(tag);


        }
        hashTagRepository.saveAllAndFlush(tags);

        for(int i = 1;i <= 5; i++){
            BoardData item = new BoardData();
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setTags(tags);

            items.add(item);
        }

        boardDataRepository.saveAllAndFlush(items);

    }

    @Test
    void test1(){
        BoardData item = boardDataRepository.findById(1L).orElse(null);
        List<HashTag> tags = item.getTags();

        System.out.println(tags);
    }

    @Test
    void test2(){
        HashTag tag = hashTagRepository.findById("태그1").orElse(null);
        List<BoardData> items = tag.getItems();
        System.out.println(items);
    }
}
