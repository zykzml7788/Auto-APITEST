package com.djcps.api.beans;

public class UserBean {
	private Integer id;
	private String username;
	private String password;
	private Double account;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getAccount() {
		return account;
	}
	public void setAccount(Double account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", username=" + username + ", password=" + password + ", account=" + account
				+ "]";
	}
	public UserBean() {
		super();
	}
	public UserBean(String username, String password, double account) {
		this.username=username;
		this.password=password;
		this.account=account;
	}
}
