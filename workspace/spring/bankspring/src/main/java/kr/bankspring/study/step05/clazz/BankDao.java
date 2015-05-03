package kr.bankspring.study.step05.clazz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BankDao {
  DriverManagerDataSource dataSource;
  JdbcTemplate jdbcTemplate;

  public BankDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }
  
  // sql
  // ddl(create, drop, alter, truncate), select, dml(insert, update, delete), transaction(commit, rollbak) 
  
  public void insertUser(UsersVo vo){
    this.jdbcTemplate.update("insert into users(userid, name) values(?, ?)", vo.getUserid(), vo.getName());
  }
  
  public void updateUser(UsersVo vo){
    this.jdbcTemplate.update("update users set name = ? where userid = ? ", vo.getName(), vo.getUserid());
  }
  
  public void deleteUser(String userid){
    this.jdbcTemplate.update("delete from users where userid = ? ", userid);
  }
  
  
  public List<UsersVo> getUsers() {
    List<UsersVo> list = jdbcTemplate.query(
                          "select id, userid, name from users", 
                          new UsersRowMapper());
    return list;
  }

  public UsersVo getUserByUserid(String userid) {
    UsersVo usersVo = jdbcTemplate.queryForObject(
                          "select id, userid, name from users where userid = ?",
                          new Object[]{ userid },
                          new UsersRowMapper());
    return usersVo;
  }
  
  public static final class UsersRowMapper implements RowMapper<UsersVo>{
    @Override
    public UsersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
      UsersVo usersVo = new UsersVo();
      usersVo.setId( rs.getLong("id") );
      usersVo.setName( rs.getString("name") );
      usersVo.setUserid( rs.getString("userid"));
      return usersVo;
    }
  }
  
  
  
// jdbc 예제
  public List<UsersVo> getUsers11() {
    List list = new ArrayList();
    Connection connection = null;
    PreparedStatement prepareStatement = null;
    ResultSet resultSet = null;
    try {
      connection = dataSource.getConnection();
      prepareStatement =
      connection.prepareStatement("select id, userid, name from users");
      resultSet = prepareStatement.executeQuery();
      while (resultSet.next()) {
        long id = resultSet.getLong("id");
        String userid = resultSet.getString("userid");
        String name = resultSet.getString("name");
        UsersVo usersVo = new UsersVo();
        usersVo.setId(id);
        usersVo.setUserid(userid);
        usersVo.setName(name);
        list.add(usersVo);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }finally{
      try {
        if(resultSet != null) resultSet.close();
        if(prepareStatement != null) prepareStatement.close();
        if(connection != null) connection.close();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return list;
  }

}
