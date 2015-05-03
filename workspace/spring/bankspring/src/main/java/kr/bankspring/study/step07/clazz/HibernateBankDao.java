package kr.bankspring.study.step07.clazz;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

public class HibernateBankDao implements IBankDao {
  private SessionFactory sessionFactory;
  
  
  public HibernateBankDao(SessionFactory sessionFactory) {
    super();
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void insertUser(UsersVo vo) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.save(vo);
    session.getTransaction().commit();
  }

  @Override
  public void updateUser(UsersVo vo) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.save(vo);
    session.getTransaction().commit();
  }

  @Override
  public void deleteUser(String userid) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Criteria criteria = session.createCriteria(UsersVo.class);
    criteria.add(Expression.eq("userid", userid));
    UsersVo vo = (UsersVo)criteria.uniqueResult();
    session.delete(vo);
    session.getTransaction().commit();
  }

  @Override
  public List<UsersVo> getUsers() {
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(UsersVo.class);
    return criteria.list();
  }

  @Override
  public UsersVo getUserByUserid(String userid) {
    Session session = sessionFactory.getCurrentSession();
    Criteria criteria = session.createCriteria(UsersVo.class);
    criteria.add(Expression.eq("userid", userid));
    UsersVo vo = (UsersVo)criteria.uniqueResult();
    return vo;
  }

}
