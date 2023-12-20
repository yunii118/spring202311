package models.member;

import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final MemberMapper memberMapper;


    public boolean register(MemberDto memberDto){
        int affectedRows = memberMapper.register(memberDto);

        return affectedRows > 0;
    }

    public boolean exist(String userId){
        int cnt = memberMapper.exist(userId);
        return cnt > 0;
    }

    public MemberDto get(String userId){
        return memberMapper.get(userId);
    }
}
