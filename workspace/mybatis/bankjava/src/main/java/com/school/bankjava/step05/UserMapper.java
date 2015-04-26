package com.school.bankjava.step05;

import org.apache.ibatis.annotations.Insert;

import com.school.bankjava.vo.UsersVo;

public interface UserMapper {
	
	@Insert("INSERT INTO USERS(USERID, NAME) VALUES (#{userId}, #{name})")
	public void insertUserChnaged(UsersVo userVo);

}
