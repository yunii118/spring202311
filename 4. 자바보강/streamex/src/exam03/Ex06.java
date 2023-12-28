package exam03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex06 {
    public static void main(String[] args) {
        String[] strs = {"aa", "aaa", "bbb", "ccc"};
        boolean result1 = Arrays.stream(strs).allMatch(s -> s.length() >= 3);
        System.out.println(result1);

        boolean result2 = Arrays.stream(strs).anyMatch(s -> s.length() >= 3);
        System.out.println(result2);

        boolean result3 = Arrays.stream(strs).noneMatch(s -> s.length() >= 3);
        System.out.println(result3);
    }
}
