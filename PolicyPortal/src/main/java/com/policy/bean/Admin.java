package com.policy.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="admin")
public class Admin {
	@Id
	@Column(name="aid")
	private String aid;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	public Admin() {
		
	}
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public Admin(String aid, String username, String password) {
		super();
		this.aid = aid;
		this.username = username;
		this.password = password;
	}

	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
