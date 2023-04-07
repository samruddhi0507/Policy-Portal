package com.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.bean.Policies;



@Repository
public interface PoliciesRepository extends JpaRepository<Policies, Integer> {

}