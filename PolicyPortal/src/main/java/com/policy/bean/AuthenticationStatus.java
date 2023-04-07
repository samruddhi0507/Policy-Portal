package com.policy.bean;

public class AuthenticationStatus {

	private String userName;
	private String password;
	private boolean authenticated;
	
	public AuthenticationStatus() {
	
	}

	public AuthenticationStatus(String userName, String password, boolean authenticated) {
		super();
		this.userName = userName;
		this.password = password;
		this.authenticated = authenticated;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
