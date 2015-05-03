package kr.bankspring.study.step04.clazz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MainTemp {
  
  public static void main(String[] args) throws SQLException{
    //스프링 선언
    ApplicationContext context = 
        new ClassPathXmlApplicationContext("kr/bankspring/study/step04/clazz/application-context.xml");
    
    DriverManagerDataSource dataSource= context.getBean("dataSource", DriverManagerDataSource.class);
    Connection connection = dataSource.getConnection();
    PreparedStatement prepareStatement = connection.prepareStatement("select id, userid, name from users");
    ResultSet resultSet = prepareStatement.executeQuery();
    while(resultSet.next()){
      long id = resultSet.getLong("id");
      String userid = resultSet.getString("userid");
      String name = resultSet.getString("name");
      System.out.println(id + " / " + userid + " / " + name);
    }
    resultSet.close();
    prepareStatement.close();
    connection.close();
    //DAO(Database Access Obejct) 객체 사용
    
    //DB 내용 출력
    
  }
  
}
