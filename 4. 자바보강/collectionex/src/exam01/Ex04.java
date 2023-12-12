package exam01;

import java.lang.invoke.VarHandle;
import java.util.Vector;

public class Ex04 {
    public static void main(String[] args) {
        // Vector - arrayList와 구조 거의 비슷
        Vector<String> names = new Vector<>(3);
        System.out.println("capacity : " + names.capacity());
        names.add("이름1");
        names.add("이름2");
        names.add("이름3");
        names.add("이름4");

        System.out.println("자료 추가 후 capacity : " + names.capacity());
    }
}
