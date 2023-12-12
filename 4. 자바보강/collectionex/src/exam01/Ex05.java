package exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");
        names.add("이름5");

        Iterator<String> iter = names.iterator();
        while(iter.hasNext()){
            String name = iter.next();
            System.out.println(name);
        }
        // 이미 iterator의 마지막값에 도달하여 while문을 벗어났음
        // -> 1개의 iterator - 한번의 반복문
        iter = names.iterator();

        while(iter.hasNext()){
            String name = iter.next();
            System.out.println(name);
        }


        /*for(String name : names){
            // 향상된 for문 - collection, 배열에서 사용
            System.out.println(name);
        }*/

        names.forEach(System.out::println);
    }
}
