package exam01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        /*Calculator cal= new Calculator() {
            @Override
            public int square(int num) {
                return num * num;
            }
        };

        int[] nums2 = calc(nums, cal);
        */

        int[] nums2 = calc(nums, num-> num * num);

        System.out.println(Arrays.toString(nums2));

    }
    public static int[] calc(int[] nums, Calculator cal){
        int[] result = new int[nums.length];

        for(int i = 0;i<result.length;i++){
            result[i] = cal.square(nums[i]); // 단일기능
        }
        return result;
    }
}
