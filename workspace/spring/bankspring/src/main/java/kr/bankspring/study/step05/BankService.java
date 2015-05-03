package kr.bankspring.study.step05;

public class BankService implements IBankService {
  private BankDao bankDao;

  public BankService(BankDao bankDao){
    this.bankDao = bankDao;
  }

  @Override
  public void dmlAddUserAndChangeNam(String userId, String name, String changeName) {
    bankDao.insertUser(userId, name);
    if(true) throw new RuntimeException("에러발생");
    bankDao.updateName(userId, changeName);
  }

}
