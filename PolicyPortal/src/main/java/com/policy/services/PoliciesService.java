package com.policy.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.bean.Policies;
import com.policy.repository.PoliciesRepository;


@Service
public class PoliciesService {
	@Autowired
	PoliciesRepository policiesRepository;
	
	@Transactional
	public List<Policies> fetchPolicies() {
		List<Policies> list=policiesRepository.findAll();
		return list;
		
	}
	@Transactional
	public Policies savePolicy(Policies policies) {
		
		return policiesRepository.save(policies);
		
	}
	@Transactional
	public void updatePolicy(Policies policies) {
		policiesRepository.save(policies);	
	
	}
	
	@Transactional
	public void deletePolicy(int policyId) {
		policiesRepository.deleteById(policyId);
	
	}
	@Transactional 
	  public Policies getPolicy(int policyId) { 
	  Optional<Policies> optional=policiesRepository.findById(policyId);
	  Policies policies=optional.get();
	  return policies;
	  
}
}
