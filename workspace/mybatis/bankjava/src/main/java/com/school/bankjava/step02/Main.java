package com.school.bankjava.step02;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.school.bankjava.vo.UsersVo;

public class Main {

	public static void main(String[] args) {
		String resource = "com/school/bankjava/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSessionFactory sqlSessionFactory = null;
		try{
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
										.build(inputStream);
			SqlSession session = sqlSessionFactory.openSession();
			
			//사용
			UsersVo userVo = session.selectOne("com.school.bankjava.mapper.selectUserVo"
									, "boojongmin");
			System.out.println(
					String.format("ID: %s, USERID: %s, NAME: %s", 
							userVo.getId(), 
							userVo.getUserId(), 
							userVo.getName())
					);
			
			
			
			
			session.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		System.out.println("ok");
		

	}

}
