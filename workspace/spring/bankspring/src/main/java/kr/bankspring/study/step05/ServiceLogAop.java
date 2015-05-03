package kr.bankspring.study.step05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceLogAop {
    public void beforeMonitor(JoinPoint jp){
        System.out.println("beforeMonitor : " + jp.getClass());
    }
    public void afterMonitor(JoinPoint jp){
        System.out.println("afterMonitor : " + jp.getClass());
    }
    public Object aroundMonitor(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("-> around 시작");
        Object retVal = pjp.proceed();
        System.out.println("-> around 종료");
        return retVal;
    }
    public void afterReturningMonitor(JoinPoint jp, Object retVal){
        System.out.println("afterReturningMonitor");
    }
    public void afterThrowingMonitor(JoinPoint jp, Exception exception){
        System.out.println("afterThrowingMonitor : " + exception.getMessage());
    }
    
}