package kr.bankspring.study.step07.clazz;

import java.util.List;

public interface IBankDao {
  public void insertUser(UsersVo vo);
  public void updateUser(UsersVo vo);
  public void deleteUser(String userid);
  public List<UsersVo> getUsers();
  public UsersVo getUserByUserid(String userid);
}
