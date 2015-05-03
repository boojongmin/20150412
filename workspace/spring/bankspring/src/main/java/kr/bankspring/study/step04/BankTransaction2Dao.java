package kr.bankspring.study.step04;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class BankTransaction2Dao implements IBankDao {

  private JdbcTemplate jdbcTemplate;
  private TransactionTemplate transactionTemplate;

  public BankTransaction2Dao(DataSource dataSource, TransactionTemplate transactionTemplate) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.transactionTemplate = transactionTemplate;
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
            new Object[] {userId}, new RowMapper<UsersVo>() {
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
    List<UsersVo> usersList =
        this.jdbcTemplate.query("select id, userid, name from users", new ActorMapper());
    return usersList;
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

  // @Override
  // public void updateName(String userId, String changeName) {
  // DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
  // TransactionStatus status =
  // platformTransactionManager.getTransaction(paramTransactionDefinition);
  // try {
  // this.jdbcTemplate.update("update users set name= ? where userid = ?", changeName, userId);
  // if (true)
  // throw new Exception("aaaa");
  // platformTransactionManager.commit(status);
  // } catch (Exception e) {
  // e.printStackTrace();
  // platformTransactionManager.rollback(status);
  // }
  // }

  @Override
  public void updateName(String userId, String changeName) {
    transactionTemplate.execute(new TransactionCallbackWithoutResult() {
      @Override
      protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
        try {
          String updateQuery = "update users set name= ? where userid = ?";
          Object[] params = new Object[] {userId, changeName};
          int[] types = new int[] {Types.VARCHAR, Types.VARCHAR};
          jdbcTemplate.update(updateQuery, params, types);
        } catch (Exception e) {
          transactionStatus.setRollbackOnly();
        }
      }
    });
  }

  // @Override
  // public void insertUser(String userId, String name) {
  // DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
  // TransactionStatus status =
  // platformTransactionManager.getTransaction(paramTransactionDefinition);
  // try {
  // this.jdbcTemplate.update("insert into users(userid, name) values(?, ?)", userId, name);
  // if (true)
  // throw new Exception("aaaa");
  // platformTransactionManager.commit(status);
  // } catch (Exception e) {
  // e.printStackTrace();
  // platformTransactionManager.rollback(status);
  // System.out.println(">>>>>");
  // }
  // }

  @Override
  public void insertUser(String userId, String name) {
    transactionTemplate.execute(new TransactionCallback<Integer>() {
      @Override
      public Integer doInTransaction(TransactionStatus transactionStatus) {
        try {
          String inserQuery = "insert into users(userid, name) values(?, ?)";
          Object[] params = new Object[] {userId, name};
          int[] types = new int[] {Types.VARCHAR, Types.VARCHAR};
          int value = jdbcTemplate.update(inserQuery, params, types);
          if (true)
            throw new Exception("error");
          return value;
        } catch (Exception e) {
          transactionStatus.setRollbackOnly();
        }
        return 0;
      }
    });

  }

  @Override
  public int countUsersNamedParameter(String userId) {
    // TODO Auto-generated method stub
    return 0;
  }



}
