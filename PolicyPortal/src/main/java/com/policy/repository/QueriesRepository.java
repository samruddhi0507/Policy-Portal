package com.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.bean.Queries;



@Repository
public interface QueriesRepository extends JpaRepository<Queries, String> {

}
