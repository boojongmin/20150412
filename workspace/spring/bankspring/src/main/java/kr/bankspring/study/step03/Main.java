package kr.bankspring.study.step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("kr/bankspring/study/step03/application-context.xml");
    System.out.println("----------------------------------------------------");
    
    FireBallBullet bean = context.getBean(FireBallBullet.class);
    Magician fireBallMagician = context.getBean("fireBallMagician", Magician.class);
    Magician iceStormMagician = context.getBean("iceStormMagician", Magician.class);
    Magician lightningBallMagician = context.getBean("lightningBallMagician", Magician.class);

    fireBallMagician.magic();
    iceStormMagician.magic();
    lightningBallMagician.magic();
    
    
    ((ConfigurableApplicationContext)context).close();
    
    
//    BeanDefinitionRegistry factory = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
//    factory.removeBeanDefinition("fireBallMagician");
//    ((ConfigurableApplicationContext)context).close();
  }

}
