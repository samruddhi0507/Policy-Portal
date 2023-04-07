package com.policy.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy.bean.User;
import com.policy.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public List<User> fetchUser() {
		List<User> userList = userRepository.findAll();
		return userList;

	}

	@Transactional
	public User saveUser(User user) {

		return userRepository.save(user);

	}

	@Transactional
	public User updateUser(User user) {
		userRepository.save(user);
		return user;

	}

	@Transactional
	public void deleteUser(String userName) {
		userRepository.deleteById(userName);

	}

	@Transactional
	public User getUser(String userName) {
		Optional<User> optional = userRepository.findById(userName);
		User user = optional.get();
		return user;

	}

}

