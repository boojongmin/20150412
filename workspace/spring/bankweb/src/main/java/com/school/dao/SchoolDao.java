package com.school.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.school.vo.AccountDetailsVo;
import com.school.vo.UsersVo;

@Repository
public class SchoolDao {

  @Autowired
  SqlSession sqlSession;
  
  private final String idPrefix = "com.school.mybatis.mapper.";

  public int getTotalCount() {
    sqlSession.selectOne("");
    return sqlSession.selectOne(idPrefix + "totalCount");
  }

  public void callMakeUser(String userId) {
    sqlSession.insert(idPrefix + "makeUser", userId);
  }

  public UsersVo selectUserVoIfNullSelectLastuser(UsersVo vo) {
    return sqlSession.selectOne(idPrefix + "selectUserVoIfNullSelectLastuser", vo);
  }


  public UsersVo selectUserVoTrim(UsersVo usersVo) {
    return sqlSession.selectOne(idPrefix + "selectUserVoTrim", usersVo);
  }

  public void insertAccountDetails(Collection<AccountDetailsVo> collection) {
    sqlSession.insert(idPrefix + "insertAccountDetails", collection);
    sqlSession.commit();
  }

  public UsersVo selectUsersVoResultMap() {
    return sqlSession.selectOne(idPrefix + "selectUsersVoResultMap");
  }
  public List<UsersVo> getUserList() {
    return sqlSession.selectList(idPrefix + "getUserList");
  }

  public void createUser(UsersVo usersVo) {
    sqlSession.insert(idPrefix + "createUser", usersVo);
    
  }

}
