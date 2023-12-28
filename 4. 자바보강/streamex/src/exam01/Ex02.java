package exam01;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        String[] words= {"aaa", "aaa", "bb", "ccc", "ccc", "abcd"};
        Arrays.stream(words)
                .distinct()
                .filter(s -> s.length()>=3)
                .forEach(System.out::println);

        List<String> words2 = Arrays.asList(words);
        words2.stream()
                .distinct() // 중간연산
                .filter(s -> s.length() >= 3) // 중간연산
                .forEach(System.out::println); // 최종연산

    }
}
