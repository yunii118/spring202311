package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListService {
    private MemberDao memberDao;
    // Nullable - null이 호출됨
    // autowired required false - setter메소드를 아예 거치지 않기 때문에 기본값인 yyMMdd가 호출됨
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    @Autowired
    @Qualifier("memberDao")
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    @Autowired// 필수가 아님을 표시, setter메소드 호출이 안됨
    public void setFormatter(@Nullable DateTimeFormatter formatter){
        this.formatter = formatter;
    }
    public void print(){
        List<Member> members = memberDao.getList();
        for(Member member : members){
            if(formatter != null){

                member.setRegDtStr(formatter.format(member.getRegDt()));
            }
            System.out.println(member);
        }
    }


}
