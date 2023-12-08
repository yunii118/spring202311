package proxyex;

import org.springframework.context.annotation.Scope;

public class ImplCalculator implements Calculator{
    @Override
    public long factorial(long num){
        //long stime = System.nanoTime();
       // try {
            long total = 1L;

            for (long i = 1L; i <= num; i++) {
                total *= i;
            }

            return total;
        //}
        //finally {
            // 리턴을 해도 항상 수행됨
            // catch 안써도됨
        //    long etime = System.nanoTime();
         //   System.out.printf("for 함수 걸린시간 : %d%n", etime - stime);
        //}
    }
}
