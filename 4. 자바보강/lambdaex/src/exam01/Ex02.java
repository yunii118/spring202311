package exam01;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

// stream에 람다식
public class Ex02 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       /* int[] nums2 = Arrays.stream(nums).map(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand * operand;
            }
        }).toArray()*/
        // 둘이 같은 의미
        int[] nums2 = Arrays.stream(nums).map(x -> x * x).toArray();

        System.out.println(Arrays.toString(nums2));
    }
}
