package com.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
  
  //user/create
  @RequestMapping("/user/create")
  public String userCreate(@ModelAttribute("usersVo") UsersVo usersVo){
    return "/school/user/create";
  }
  
  @RequestMapping(value="/user/create/action", method=RequestMethod.POST)
  public String userCreateAction( @ModelAttribute("usersVo") @Valid UsersVo usersVo,
                                    BindingResult bindingResult ){
//  public String userCreateAction( @RequestParam("userid") String userid,
//                                  @RequestParam(value="name", required=true) String name){
    
    if (bindingResult.hasErrors()) {
      return "/school/user/create";
    }
    schoolService.createUser(usersVo.getUserId(), usersVo.getName());
    return "redirect:/springmvc/list";
  }
  
  @RequestMapping(value="/user/view", method=RequestMethod.GET)
  public String userView(@RequestParam("id") int id){
    
    return "/school/user/view";
  }
  
}
