package kr.bankspring.study.step05.clazz;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) throws Exception {
    //스프링 선언
    ApplicationContext context = 
        new ClassPathXmlApplicationContext("kr/bankspring/study/step05/clazz/application-context.xml");
    //DAO 사용
    BankDao bankDao = context.getBean("bankDao", BankDao.class);
    List<UsersVo> userList = bankDao.getUsers();
    //DB 정보 출력
    System.out.println(userList.size());
    
    UsersVo usersVo = bankDao.getUserByUserid("boojongmin");
    String userInfo = String.format("id: %d / userid: %s / name: %s", usersVo.getId(), usersVo.getUserid(), usersVo.getName());
    System.out.println(userInfo);
    
//    BankFacade bankFacade = new BankFacade(bankDao);
    BankService bankFacade = context.getBean("bankService", BankService.class);
    UsersVo newUser = new UsersVo();
    newUser.setUserid("boojongmin10");
    newUser.setName("부종민5");
    String changeName = "수정 부종민5";
    bankFacade.dmlUser(newUser, changeName);   
    
  }

}
