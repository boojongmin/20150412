package com.school.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SchoolController implements Controller {

  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
      System.out.println("SchoolController 동작");
      
      ModelAndView mv = new ModelAndView();
      mv.setViewName("/index.jsp");
      String message = "hello";
      mv.addObject("msg", message);
    
    return mv;
  }

}
