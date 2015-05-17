package com.school.vo;

import java.util.List;

import javax.validation.constraints.Size;

public class UsersVo {
  
	private long id;
	@Size(min=5, max=20, message="사용자 ID는 5~20로 입력해주세요.")
	private String userId;
	@Size(min=2, max=10, message="이름은 2~10로 입력해주세요.")
	private String name;
	private List<AccountsVo> accountsList;
	
	public List<AccountsVo> getAccountsList() {
		return accountsList;
	}
	public void setAccountsList(List<AccountsVo> accountsList) {
		this.accountsList = accountsList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
