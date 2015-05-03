package kr.bankspring.study.step05;

import java.sql.Types;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ServiceTransactionAop {
  
    public ServiceTransactionAop(TransactionTemplate transactionTemplate){
      this.transactionTemplate = transactionTemplate;
    }
    
    TransactionTemplate transactionTemplate;
    
    public Object aroundMonitor(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("-> 트랜젝션  시작");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
          @Override
          protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
            try {
               Object retVal = pjp.proceed();
            } catch (Exception e) {
              transactionStatus.setRollbackOnly();
            } catch (Throwable e) {
              e.printStackTrace();
            }
          }
        });
        System.out.println("-> 트랜젝션 종료");
        return null;
    }
}