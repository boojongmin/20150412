package kr.bankspring.study.step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("kr/bankspring/study/step02/application-context.xml");
    A a1 = context.getBean("a1", A.class);
    A a2 = context.getBean("a2", A.class);
    
    B1 b1 = context.getBean("b1", B1.class);
    B2 b2 = context.getBean("b2", B2.class);
    
    System.out.println("a1 : " + a1);
    System.out.println("a2 : " + a2);
    
    System.out.println("b1 : " + b1);
    System.out.println("b2 : " + b2);
    
    System.out.println("b1.a : " + b1.a);
    System.out.println("b2.a : " + b2.a);
    
    
    A a3 = context.getBean("a1", A.class);
    System.out.println("a1 == a3 : " + (a1 == a3));
    
  }

}
