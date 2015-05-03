package kr.bankspring.study.step04.clazz;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class BankService {
  BankDao bankDao;
  TransactionTemplate transactionTemplate;
  
//  DataSourceTransactionManager transactionManager;
//
//  public BankFacade(BankDao bankDao, DataSourceTransactionManager transactionManager) {
//    this.bankDao = bankDao;
//    this.transactionManager = transactionManager;
//  }
  
  public BankService(BankDao bankDao, TransactionTemplate transactionTemplate) {
    this.bankDao = bankDao;
    this.transactionTemplate = transactionTemplate;
  }
  
  public void dmlUser(UsersVo vo, String changeName){
    this.transactionTemplate.execute(
          new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
              try{
                bankDao.insertUser(vo);
                vo.setName(changeName);
                bankDao.updateUser(vo);
                if(true) throw new Exception("에러");
                bankDao.deleteUser(vo.getUserid());
              }catch(Exception e){
                e.printStackTrace();
                status.setRollbackOnly();
              }
            }
          });
  }
  
  
//  public void dmlUser(UsersVo vo, String changeName){
//    DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
//    TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
//    try{
//      bankDao.insertUser(vo);
//      vo.setName(changeName);
//      bankDao.updateUser(vo);
//      if(true) throw new Exception("에러");
//      bankDao.deleteUser(vo.getUserid());
//      transactionManager.commit(transactionStatus);
//      System.out.println(">>>");
//    }catch(Exception e){
//      e.printStackTrace();
//      transactionManager.rollback(transactionStatus);
//    }
//  }
  

}
