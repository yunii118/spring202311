package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import config.ManualBean;
import org.springframework.stereotype.Repository;

import java.util.*;
//@ManualBean
@Repository
public class MemberDao {// memberDao로 객체 생성됨

    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member){
       members.put(member.getUserId(), member);
    }

    public boolean exists(String userId){
        return members.containsKey(userId);
    }

    public List<Member> getList(){
        return new ArrayList<>(members.values());
    }
}