package com.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.policy.bean.Login;


public interface LoginRepository extends JpaRepository<Login, String>{
	@Query("SELECT dl FROM Login dl WHERE dl.userName =?1 and dl.password=?2")
	public Login validateLogin(String userName,String password);

}
