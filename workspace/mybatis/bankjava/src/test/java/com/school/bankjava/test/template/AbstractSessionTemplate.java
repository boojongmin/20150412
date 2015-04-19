package com.school.bankjava.test.template;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.school.bankjava.dao.BankJavaDao;
import com.school.bankjava.mybatis.FactoryManager;

public abstract class AbstractSessionTemplate {
	private SqlSessionFactory sqlSessionFactory = FactoryManager.sqlSessionFactory;

	protected abstract Object doIt();
	protected SqlSession sqlSession = null;
	
	public Object work(){
		Object obj = null;
		
		try{
			sqlSession = sqlSessionFactory.openSession(false);
			
			obj = doIt();
			
			sqlSession.commit();
			sqlSession.close();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return obj;
	}

}
