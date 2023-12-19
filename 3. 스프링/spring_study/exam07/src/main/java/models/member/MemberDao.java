package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

   public List<Member> getList(MemberSearch search){
       // LocalDate는 2023-12-01 00:00:00 이런식으로 시간 포함됨
       // -> edate가 12-01일경우 이를 포함시키기 위해서는 23:59:59는 포함안됨
       // -> edate를 +1 해주고, 작거나 같다가 아님 작다로 조건 바궈줌
       LocalDate edate = search.getEdate();
       if(edate != null){
           LocalDate newEdate = edate.plusDays(1);
           search.setEdate(newEdate);
       }

       return memberMapper.getList(search);
   }
}
