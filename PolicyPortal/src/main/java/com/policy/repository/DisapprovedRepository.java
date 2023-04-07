package com.policy.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.policy.bean.Disapproved;

@Repository
public interface DisapprovedRepository extends JpaRepositoryImplementation<Disapproved, String> {

}
