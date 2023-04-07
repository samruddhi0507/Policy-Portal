package com.policy.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.bean.Approvals;
import com.policy.repository.ApprovalsRepository;



@Service
public class ApprovalsService {
	@Autowired
	ApprovalsRepository approvalsRepository;

	public List<Approvals> getAllApprovals() {
		return approvalsRepository.findAll();
	}

	public Optional<Approvals> getApprovals(String userName) {
		return approvalsRepository.findById(userName);
	}

	public void addApproval(Approvals approvals) {
		Date date = new Date();
		 approvals.setDate(date);
		 String status="pending";
		approvals.setStatus(status);
		approvalsRepository.save(approvals);	
	}
	public void deleteApproval(String userName) {
		approvalsRepository.deleteById(userName);
	}
}