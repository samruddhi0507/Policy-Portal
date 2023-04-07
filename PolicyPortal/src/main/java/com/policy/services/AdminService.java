package com.policy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.bean.Admin;
import com.policy.bean.AuthenticationStatus;
import com.policy.repository.AdminRepository;


@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	public AuthenticationStatus validateAdminLogin(String username, String password) {
		AuthenticationStatus status = null;
		Admin admin = adminRepository.validateAdmin(username, password);
		if(admin!=null) {
			status = new AuthenticationStatus(admin.getUsername(), admin.getPassword(), true);
		}
		else {
			status = new AuthenticationStatus(null, null, false);
		}
		return status;
	}
	
}
