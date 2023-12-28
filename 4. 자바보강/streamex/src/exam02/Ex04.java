package exam02;

import java.util.Random;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) {
        Random rand = new Random();
        //rand.ints().limit(10).forEach(System.out::println);
        // limit : 갯수 한정
        rand.ints(10).forEach(System.out::println);
    }
}
