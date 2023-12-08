package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProxyCalculator {

    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{

        //Signature sig = joinPoint.getSignature();
        //System.out.println(sig.toLongString());

        Object[] args = joinPoint.getArgs();
        long number = (long)args[0];
        System.out.println(number);

        long stime = System.nanoTime(); // 공통 기능
        try {

            Object result = joinPoint.proceed(); // 핵심 기능을 대신 수행하는 메서드

            return result;
        }
        finally {
            long etime = System.nanoTime();// 공통기능
            System.out.printf("걸린시간 : %d%n", etime - stime);
        }
    }

}
