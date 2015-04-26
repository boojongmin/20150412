package com.school.bankjava.step05;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.school.bankjava.vo.UsersVo;

public class Main {

	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://192.168.0.34:3306/school");
		dataSource.setUsername("student");
		dataSource.setPassword("1234");
				
		TransactionFactory transactionFactory = new JdbcTransactionFactory();

		Environment environment = new Environment("development", transactionFactory, dataSource);

		Configuration configuration = new Configuration(environment);
		configuration.setLazyLoadingEnabled(true);
//		configuration.setEnhancementEnabled(true);
//		configuration.getTypeAliasRegistry().registerAlias(Blog.class);
//		configuration.getTypeAliasRegistry().registerAlias(Post.class);
//		configuration.getTypeAliasRegistry().registerAlias(Author.class);
		configuration.addMapper(UserMapper.class);
//		configuration.addMapper(BoundAuthorMapper.class);

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(configuration);
		SqlSession session = factory.openSession();
		
		UserMapper usersMapper = session.getMapper(UserMapper.class);
		UsersVo usersVo = new UsersVo();
		usersMapper.insertUserChnaged(usersVo);
		
		session.commit();
		
		
		
		
		
		

	}

}
