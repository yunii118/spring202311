package models.member;

import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {
   private final MemberMapper memberMapper;


   public boolean register(Member member){
       int affectedRows = memberMapper.register(member);

       return affectedRows > 0;
   }
   public boolean exist(String userId){
       int cnt = memberMapper.exist(userId);

       return cnt > 0; // 1이상 - 이미 등록된 아이디
   }

   public Member get(String userId){
        return memberMapper.get(userId);
   }
}
