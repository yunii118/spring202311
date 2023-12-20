package mapper;

import models.member.MemberDto;

public interface MemberMapper {
    int register(MemberDto memberDto);
    int exist(String userId);
    MemberDto get(String userId);
}
