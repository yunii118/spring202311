package exam03;

import java.util.Arrays;

public class Ex07 {
     public static void main(String[] args) {
        int[] nums = {1, 2,3 , 4, 5, 6 , 7, 8, 9, 10};
        int total = Arrays.stream(nums).reduce(0, (acc, el) -> {
            System.out.printf("acc=%d, el=%d%n", acc, el);
            acc += el;
            return acc;
        });

        System.out.println(total);
    }
}
