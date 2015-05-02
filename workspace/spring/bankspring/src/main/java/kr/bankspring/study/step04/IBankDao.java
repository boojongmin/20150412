package kr.bankspring.study.step04;

import java.util.List;

public interface IBankDao {
  public int countUsers();

  public int countUsers(String userId) ;
  public UsersVo getUsers(String userId);
  public List<UsersVo> getUsersList() ; 
  public List<UsersVo> getUsersList2() ;
  public int countUsersNamedParameter(String userId) ;
  public void updateName(String userId, String changeName) ; 
  public void insertUser(String userId, String name); 
}
