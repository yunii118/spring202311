package proxyex;

import aopex.RecCalculator;

public class Ex01 {
    public static void main(String[] args) {
        long stime = System.nanoTime(); // 공통 기능
        // 핵심기능
        ImplCalculator cal1 = new ImplCalculator();
        long result1 = cal1.factorial(10L);
        System.out.println("cal1 : " + result1);
        // 공통기능
        long etime = System.nanoTime();
        System.out.printf("for문 걸린 시간 : %d%n", etime - stime);

        // 공통기능
        stime = System.nanoTime();
        // 핵심기능
        RecCalculator cal2 = new RecCalculator();
        long result2 = cal2.factorial(10L);
        System.out.println("cal2 : " + result2);
        // 공통 기능
        etime = System.nanoTime();
        System.out.printf("재귀함수 걸린 시간 : %d%n", etime - stime);
    }
}
