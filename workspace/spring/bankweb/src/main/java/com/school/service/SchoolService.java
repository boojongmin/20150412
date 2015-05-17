package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.SchoolDao;
import com.school.vo.UsersVo;

@Service
public class SchoolService {
  
  @Autowired
  private SchoolDao schoolDao;

  public List<UsersVo> getUserList() {
    return schoolDao.getUserList();
  }

  public void createUser(String userid, String name) {
    UsersVo usersVo = new UsersVo();
    usersVo.setUserId(userid);
    usersVo.setName(name);
    schoolDao.createUser(usersVo);
  }
  
  
  

}
