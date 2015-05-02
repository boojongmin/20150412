package kr.bankspring.study.step09;

public class AccountsVo {
  private long id;
  private UsersVo usersVo;
  private String accountNumber;
  private int amount;
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
 
  public UsersVo getUsersVo() {
    return usersVo;
  }
  public void setUsersVo(UsersVo usersVo) {
    this.usersVo = usersVo;
  }
  public String getAccountNumber() {
    return accountNumber;
  }
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
  public int getAmount() {
    return amount;
  }
  public void setAmount(int amount) {
    this.amount = amount;
  }
}
