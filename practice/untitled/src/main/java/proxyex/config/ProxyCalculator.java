package proxyex.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProxyCalculator {
    @Pointcut("execution(* proxyex.aopex..*(..))")
    public void publicTarget(){};
    @Around("publicTarget()")
    public Object proceed(ProceedingJoinPoint joinPoint) throws Throwable{
        long stime = System.nanoTime();
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long etime = System.nanoTime();
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}
