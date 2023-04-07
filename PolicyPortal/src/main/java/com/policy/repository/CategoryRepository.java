package com.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.policy.bean.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
