package com.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.bean.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {

}