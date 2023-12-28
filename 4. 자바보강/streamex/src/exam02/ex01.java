package exam02;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class ex01 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stat = nums.stream().mapToInt(s -> s).summaryStatistics();

        long sum = stat.getSum();
        double avg = stat.getAverage();
        long count = stat.getCount();
        int max = stat.getMax();
        int min = stat.getMin();

        System.out.printf("nums의 합계 = %d, 평균 = %.2f, 인자 수 = %d, 최댓값 = %d, 최솟값 = %d%n", sum, avg, count, max, min);
    }
}
