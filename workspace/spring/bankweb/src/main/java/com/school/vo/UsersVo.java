package com.school.vo;

import java.util.List;

public class UsersVo {
	private long id;
	private String userId;
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
