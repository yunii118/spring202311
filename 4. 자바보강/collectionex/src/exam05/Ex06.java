package exam05;

import java.util.*;

public class Ex06 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        Collections.addAll(strs, "a", "b", "c", "d");
        Collections.shuffle(strs);
        System.out.println(Collections.max(strs));
        System.out.println(Collections.min(strs));
        System.out.println(strs);
    }
}
