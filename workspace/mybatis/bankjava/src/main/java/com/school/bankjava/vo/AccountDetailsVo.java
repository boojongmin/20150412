package com.school.bankjava.vo;

public class AccountDetailsVo {
	public AccountDetailsVo(){}
	public AccountDetailsVo(long accounts_id, int type, int amount) {
		this.accounts_id = accounts_id;
		this.type = type;
		this.amount = amount;
	}
	private long id;
	private long accounts_id;
	private int type;
	private int amount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAccounts_id() {
		return accounts_id;
	}
	public void setAccounts_id(long accounts_id) {
		this.accounts_id = accounts_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
