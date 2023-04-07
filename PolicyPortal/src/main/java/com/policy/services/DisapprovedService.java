package com.policy.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.bean.Disapproved;
import com.policy.repository.DisapprovedRepository;


@Service
public class DisapprovedService {
	@Autowired
	DisapprovedRepository disapprovedRepository;

	public List<Disapproved> getAllDisapproved() {
		return disapprovedRepository.findAll();
	}

	public Optional<Disapproved> getDisapproved(String userName) {
		return disapprovedRepository.findById(userName);
	}

	public String addDisapproved(Disapproved disapproved) {
	    Date date=new Date();
		String status="disapproved";
		disapproved.setDate(date);
		disapproved.setStatus(status);
		disapprovedRepository.save(disapproved);
		return "added";
	}
}