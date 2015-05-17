package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.service.SchoolService;
import com.school.vo.UsersVo;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
  
  @Autowired  
  SchoolService schoolService;
  
  @RequestMapping("/list")
  public String getList(){
    return "/school/ajax/list";
  }
  
  @RequestMapping("/hello")
  @ResponseBody
  public String hello(){
    return "hello ajax~ asynchro call";
  }
  
  @RequestMapping("/getAjaxList")
  @ResponseBody
  public List<UsersVo> getAjaxList(){
    return schoolService.getUserList();
  }
  

}
