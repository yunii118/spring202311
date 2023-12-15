package exam05;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Ex05 {
    public static void main(String[] args) {
        Integer[] nums = {10, 3, 5, 33, 19, 25};
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));
    }
}
