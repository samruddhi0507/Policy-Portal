package com.policy.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.policy.bean.Approved;



@Repository
public interface ApprovedRepository extends JpaRepositoryImplementation<Approved, String> {

}