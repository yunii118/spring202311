package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ListService {

    private MemberDao memberDao;// 여기에 넣으면 직접 주입
    @Autowired
    public void setMemberDao(MemberDao memberDao){
        this.memberDao = memberDao;
    }
    // 여기에 넣으면 호출시 매개변수에 주입, 간접적으로
    public void print(){
        List<Member> members = memberDao.getList();
        for(Member member : members){
            System.out.println(member);
        }
    }
}
