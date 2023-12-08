package models.member;

import java.util.List;

// 조립클래스
public class ServiceManager {
    // 데이터를 담는 객체는 여러개를 만들 필요가 있음
    // 기능을 담당하는 클래스의 경우 굳이 여러 객체를 만들 필요가 없음
    private static ServiceManager instance = null;
   private static ServiceManager getInstance(){
        if(instance == null){
            instance = new ServiceManager();
        }
        return instance;
    }
    public MemberDao memberDao(){
        return new CachedMemberDao();
    }

    public JoinValidator joinValidator(){
        return new JoinValidator(memberDao());
    }

    public JoinService joinService(){
        return new JoinService(memberDao(), joinValidator());
    }

    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
