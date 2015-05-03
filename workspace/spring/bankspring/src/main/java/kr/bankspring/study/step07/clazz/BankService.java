package kr.bankspring.study.step07.clazz;

public class BankService {
  IBankDao bankDao;
 
//  DataSourceTransactionManager transactionManager;
//
//  public BankFacade(BankDao bankDao, DataSourceTransactionManager transactionManager) {
//    this.bankDao = bankDao;
//    this.transactionManager = transactionManager;
//  }
  
  public BankService(IBankDao bankDao) {
    this.bankDao = bankDao;
  }
  
  public void dmlUser(UsersVo vo, String changeName){
      bankDao.insertUser(vo);
      vo.setName(changeName);
      bankDao.updateUser(vo);
      if(true) throw new RuntimeException("에러");
      bankDao.deleteUser(vo.getUserid());
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
