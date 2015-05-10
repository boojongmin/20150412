package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.service.SchoolService;
import com.school.vo.UsersVo;

//<bean> = 스프링이 관리할 객체
@Controller
public class SchoolController {

  @Autowired  
  SchoolService schoolService;

  @RequestMapping("/school")
  public ModelAndView school(){
    System.out.println("School 실행");
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/school/index");
    String message = "hello";
    mv.addObject("msg", message);
    return mv;
  }
  
  @RequestMapping("/school2")
  public String school2(){
    return "/school/index";
  }
  
  @RequestMapping("/list")
  public String list(Model model){
    List<UsersVo> list = schoolService.getUserList();
    model.addAttribute("list", list);
    return "/school/list";
  }
}
