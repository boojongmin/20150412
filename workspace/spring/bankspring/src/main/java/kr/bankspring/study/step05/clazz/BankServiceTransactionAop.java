package kr.bankspring.study.step05.clazz;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class BankServiceTransactionAop {

  TransactionTemplate transactionTemplate;
  
  public BankServiceTransactionAop(TransactionTemplate transactionTemplate) {
    this.transactionTemplate = transactionTemplate;
  }


  public void aroundTransaction(ProceedingJoinPoint pjp){
    System.out.println("============ 트랜젝션 시작 ============");
    this.transactionTemplate.execute(
        new TransactionCallbackWithoutResult() {
          @Override
          protected void doInTransactionWithoutResult(TransactionStatus status) {
            try{
              pjp.proceed();
            }catch(Exception e){
              e.printStackTrace();
              status.setRollbackOnly();
            } catch (Throwable e) {
              e.printStackTrace();
            }
          }
        });
    System.out.println("============ 트랜젝션 종료 ============");
      
  }

}
