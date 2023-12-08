package proxyex;

public class ProxyCalculator implements Calculator{

    private Calculator calculator;
    // ImplCalculator라고 집어넣어버리면
    // RecCalculator 사용 불가
    // ->부모클래스인 Calculator로 매개변수 선언
    public ProxyCalculator(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public long factorial(long num) {

        long stime = System.nanoTime();
        try {

            long result = calculator.factorial(num); // 핵심기능

            return result;
        }
        finally {
            long etime = System.nanoTime();
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}
