package kr.bankspring.study.step05;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class BankDao implements IBankDao {

  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public BankDao(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  @Override
  public int countUsers() {
    return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
  }

  @Override
  public int countUsers(String userId) {
    return this.jdbcTemplate.queryForObject("select count(*) from users where userid = ? ",
        Integer.class, userId);
  }

  @Override
  public UsersVo getUsers(String userId) {
    UsersVo usersVo =
        this.jdbcTemplate.queryForObject("select id, userid, name from users where userid = ?",
            new Object[] {userId}, 
            new RowMapper<UsersVo>() {
              public UsersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                UsersVo usersVo = new UsersVo();
                usersVo.setId(rs.getLong("id"));
                usersVo.setUserId(rs.getString("userid"));
                usersVo.setName(rs.getString("name"));
                return usersVo;
              }
            });
    return usersVo;
  }

  @Override
  public List<UsersVo> getUsersList() {
    List<UsersVo> usersList =
        this.jdbcTemplate.query("select id, userid, name from users", new RowMapper<UsersVo>() {
          public UsersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
            UsersVo usersVo = new UsersVo();
            usersVo.setId(rs.getLong("id"));
            usersVo.setUserId(rs.getString("userid"));
            usersVo.setName(rs.getString("name"));
            return usersVo;
          }
        });
    return usersList;
  }
  
  @Override
  public List<UsersVo> getUsersList2() {
    List<UsersVo> usersList = this.jdbcTemplate.query("select id, userid, name from users", new ActorMapper());
    return usersList;
  }
 
  @Override
  public int countUsersNamedParameter(String userId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource("userId", userId);
    return this.namedParameterJdbcTemplate.queryForObject("select count(*) from users where userid = :userId ", namedParameters, Integer.class);
  }


  private static final class ActorMapper implements RowMapper<UsersVo> {
    public UsersVo mapRow(ResultSet rs, int rowNum) throws SQLException {
      UsersVo usersVo = new UsersVo();
      usersVo.setId(rs.getLong("id"));
      usersVo.setUserId(rs.getString("userid"));
      usersVo.setName(rs.getString("name"));
      return usersVo;
    }
  }
  
  @Override
  public void updateName(String userId, String changeName){
    this.jdbcTemplate.update( "update users set name= ? where userid = ?", changeName, userId);
  }
  
  @Override
  public void insertUser(String userId, String name){
    Map<String, String> paramMap = new HashMap();
    paramMap.put("name", name);
    paramMap.put("userId", userId);
    this.namedParameterJdbcTemplate.update( "insert into users(userid, name) values(:userId, :name)", paramMap );
  }
  
  
  
  
  
  
  
  
}
