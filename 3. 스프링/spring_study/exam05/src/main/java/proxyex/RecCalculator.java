package proxyex;

import proxyex.Calculator;

public class RecCalculator implements Calculator {
    // 재귀방식
    // 본인이 본인을 호출
    @Override
    public long factorial(long num){
        if(num<1L){
            return 1L;
        }

        return num * factorial(num-1);
        // 재귀(Recursive) 방식
        // 본인 것을 계속 호출하기 때문에 스택, 메모리에 계속 쌓임
        // 효율 안나옴
        // 꼭 필요할때만 사용
    }
}
