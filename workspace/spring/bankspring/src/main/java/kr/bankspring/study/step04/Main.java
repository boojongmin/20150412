package kr.bankspring.study.step04;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("kr/bankspring/study/step04/application-context.xml");
    BankDao bankDao = context.getBean("bankDao", BankDao.class);
    System.out.println("사용자의 수 : " + bankDao.countUsers());
    System.out.println("사용자의 수 : " + bankDao.countUsers("boojongmin"));
    System.out.println("사용자의 수 : " + bankDao.countUsers("test"));
    UsersVo users = bankDao.getUsers("boojongmin");
    System.out.println(String.format("id: %d, userId: %s, name: %s", users.getId(), users.getUserId(), users.getName()));
    List<UsersVo> usersList = bankDao.getUsersList();
    usersList.forEach(vo -> System.out.println(String.format("id: %d, userId: %s, name: %s", vo.getId(), vo.getUserId(), vo.getName())));
    List<UsersVo> usersList2 = bankDao.getUsersList2();
    usersList2.forEach(vo -> System.out.println(String.format("id: %d, userId: %s, name: %s", vo.getId(), vo.getUserId(), vo.getName())));
    /*NamedParameterJdbcTemplate*/
    int countUser = bankDao.countUsersNamedParameter("boojongmin");
    System.out.println("사용자의 수 : " + countUser);
    /*트랜젝션 동작됨.*/
    bankDao.updateName("boojongmin2", "수정2  부종민2");
    UsersVo users2 = bankDao.getUsers("boojongmin2");
    System.out.println(String.format("id: %d, userId: %s, name: %s", users2.getId(), users2.getUserId(), users2.getName()));
    
    
    bankDao.insertUser("boojongmin3", "부종민3");
    UsersVo users3 = bankDao.getUsers("boojongmin3");
    System.out.println("is null : " + (users3 == null));
    System.out.println(String.format("id: %d, userId: %s, name: %s", users3.getId(), users3.getUserId(), users3.getName()));
    
    
    BankTransactionDao bankTranactionDao = context.getBean("bankTransactionDao", BankTransactionDao.class); 
    bankTranactionDao.insertUser("boojongmin4", "부종민4");
    UsersVo users4 = bankDao.getUsers("boojongmin4");
    System.out.println("is null : " + (users4 == null));
    System.out.println(String.format("id: %d, userId: %s, name: %s", users4.getId(), users4.getUserId(), users4.getName()));
    
    
    
  }

}
