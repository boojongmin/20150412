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
  
  
  

}
