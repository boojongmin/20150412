package kr.bankspring.study.step05;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("kr/bankspring/study/step05/application-context.xml");
    IBankService bankService = context.getBean("bankService", IBankService.class);
    bankService.dmlAddUserAndChangeNam("boojongmin5", "부종민5", "수정 부종민5");
  }
}
