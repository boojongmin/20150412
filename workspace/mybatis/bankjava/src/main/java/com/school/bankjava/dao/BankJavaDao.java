package com.school.bankjava.dao;

import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.school.bankjava.test.template.AbstractSessionTemplate;
import com.school.bankjava.vo.AccountDetailsVo;
import com.school.bankjava.vo.UsersVo;

public class BankJavaDao {
	private SqlSession sqlSession;
	private String idPrefix = "com.school.bankjava.mapper.";
	private SqlSessionFactory sqlSessionFactory;

	public BankJavaDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int getTotalCount() {
		return sqlSession.selectOne(idPrefix + "totalCount");
	}

	public void callMakeUser(String userId) {
		sqlSession.insert(idPrefix + "makeUser", userId);		
	}

	public UsersVo selectUserVoIfNullSelectLastuser(UsersVo vo) {
		return sqlSession.selectOne(idPrefix + "selectUserVoIfNullSelectLastuser", vo);
	}

	public UsersVo selectUserVoIfNullSelectLastuser_choose(UsersVo vo) {
		AbstractSessionTemplate template = new AbstractSessionTemplate(){
			@Override
			protected Object doIt() {
				return this.sqlSession.selectOne(idPrefix + "selectUserVoIfNullSelectLastuser_choose", vo);
			}
		};
		UsersVo work = (UsersVo) template.work();
		return work;
	}

	public UsersVo selectUserVoTrim(UsersVo usersVo) {
		return sqlSession.selectOne(idPrefix + "selectUserVoTrim", usersVo);
	}

	public void insertAccountDetails(Collection<AccountDetailsVo> collection) {
		sqlSession.insert(idPrefix + "insertAccountDetails", collection);
		sqlSession.commit();
	}

	public UsersVo selectUsersVoResultMap() {
		return sqlSession.selectOne(idPrefix + "selectUsersVoResultMap");
	}
	
	
	

}
