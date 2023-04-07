package com.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.policy.bean.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	@Query("SELECT a FROM Admin a WHERE a.username =?1 and a.password=?2")
	public  Admin validateAdmin(String username,String password);
	}