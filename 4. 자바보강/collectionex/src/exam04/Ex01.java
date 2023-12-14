package exam04;

import java.util.*;

public class Ex01 {
    public static void main(String[] args) {
        // HashMap<String, String> members = new HashMap<>();
        // 키 자료형의 Comparable 인터페이스
        // 대안 정렬 기준 java.util.Comparator 인터페이스
        //Comparator<String> com = (a,b) -> a.compareTo(b);
        Comparator<String> com = String::compareTo;

        TreeMap<String, String> members = new TreeMap<>(Comparator.reverseOrder());
        members.put("user01", "이이름");
        members.put("user02", "김이름");
        members.put("user03", "박이름");

       /* members.put("user02", "(수정)김이름");

        members.remove("user02");

        System.out.println("user02 : " + members.get("user02"));*/

        /*
        Set<String> set = members.keySet();
        Iterator<String> iterator = set.iterator();

        while(iterator.hasNext()){
            String id = iterator.next();
            System.out.println(members.get(id));
        }
        */

        Set<Map.Entry<String, String>> entries = members.entrySet();
        for(Map.Entry<String, String> entry : entries){
            System.out.printf("key = %s, value = %s%n", entry.getKey(), entry.getValue());
        }

        Set<String> keys = members.keySet();

    }
}
