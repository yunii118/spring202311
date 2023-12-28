package exam02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = {11, 5, 3, 22, 15, 88, 75};
        int[] nums2 = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(x->x).toArray();

        System.out.println(Arrays.toString(nums2));
    }

}
