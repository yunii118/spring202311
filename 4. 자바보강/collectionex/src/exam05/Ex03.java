package exam05;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[][] nums1 = {{10, 20, 30}, {40, 50, 60}};
        int[][] nums2 = {{10, 20, 30}, {40, 50, 60}};

        System.out.println(Arrays.deepEquals(nums1, nums2));
    }
}
