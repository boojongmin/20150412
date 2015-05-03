package kr.bankspring.study.step09;

import java.util.HashSet;
import java.util.Set;

public class UsersVo {
  public UsersVo(){
    this.accountList = new HashSet<AccountsVo>();
  }
  
  private long id;
  private String userId;
  private String name;
  private Set<AccountsVo> accountList;
  
  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }
  public String getUserId() {
    return userId;
  }
  public void setUserId(String userId) {
    this.userId = userId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Set<AccountsVo> getAccountList() {
    return accountList;
  }
  public void setAccountList(Set<AccountsVo> accountList) {
    this.accountList = accountList;
  }
}
