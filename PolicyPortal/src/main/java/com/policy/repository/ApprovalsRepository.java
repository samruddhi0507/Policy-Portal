package com.policy.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import com.policy.bean.Approvals;



@Repository
public interface ApprovalsRepository extends JpaRepositoryImplementation<Approvals, String> {

}
