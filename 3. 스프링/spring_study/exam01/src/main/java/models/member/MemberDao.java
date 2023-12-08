package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;

import java.util.*;

public class MemberDao {
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
