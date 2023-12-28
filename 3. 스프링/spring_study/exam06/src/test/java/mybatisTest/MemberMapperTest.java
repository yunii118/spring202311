package mybatisTest;

import config.AppCtx;
import mapper.MemberMapper;
import models.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppCtx.class)
public class MemberMapperTest {
    @Autowired
    private MemberMapper mapper;

    @Test
    @DisplayName("회원목록 조회 테스트")
    void memberListTest(){
        Member mem = Member.builder()
                .userId("USER")
                .userNm("사용자")
                .build();
        List<Member> members = mapper.getMembers(mem);

        for(Member member : members){
            System.out.println(member);
        }

        System.out.println(mapper.getClass().getName());
    }

    @Test
    @DisplayName("회원 추가 테스트")
    void memberInsertTest(){
        Member member = Member.builder()
                .userId("USER203")
                .userPw("123456")
                .userNm("사용자203")
                .email("user203@test.org")
                .build();
        int affectedRow = mapper.register(member);
        System.out.println(affectedRow);
        System.out.println(member);
    }


    @Test
    @DisplayName("회원정보 수정 테스트")
    void memberUpdateTest(){
        Member member = Member.builder()
                .userId("USER202")
                .userPw("(수정)123456")
//                .userNm("(수정)사용자202")
                .email("(수정)user202@test.org")
                .build();
        int affectedRow = mapper.update(member);
        System.out.println(affectedRow);
    }
    @Test
    @DisplayName("회원 삭제 테스트")
    void memberDeleteTest(){
        int affectedRows = mapper.delete("USER199");
        System.out.println(affectedRows);
    }
}
