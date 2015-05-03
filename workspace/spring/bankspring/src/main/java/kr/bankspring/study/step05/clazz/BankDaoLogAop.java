package kr.bankspring.study.step05.clazz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class BankDaoLogAop {
  public void beforeLogger(JoinPoint joinPoint){
    System.out.println("beforeLogger : " + joinPoint);
  }
  
  public void afterLogger(JoinPoint joinPoint){
    System.out.println("afterLogger : " + joinPoint);
  }
  
  public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable{
    System.out.println("around 시작 : " + pjp);
    Object returnValue = pjp.proceed();
    System.out.println("around 종료 : " + pjp);
    return returnValue;
  }
  
  public void afterReturningLogger(JoinPoint joinPoint, Object returnValue){
    System.out.println("afterReturningLogger : " + joinPoint);
    System.out.println("returnValue : " + returnValue);
  }
  
  public void afterThrowingLogger(JoinPoint joinPoint, Exception exception){
    System.out.println("afterReturningLogger : " + joinPoint);
    System.out.println("exception : " + exception);
  }

}
