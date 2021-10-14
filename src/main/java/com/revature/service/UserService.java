package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;
import com.revature.repositories.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	// findById
	public User findById(int id) {
		return userDao.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No User found with id " + id));
	}
	
	// findByUsername
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("No User found with username " + username));
	}
	
	//findAll
	
	public Set<User> findAll() {
		
		return userDao.findAll()
							.stream()
							.collect(Collectors.toSet());
	}
	
	// Insert
	public User insert(User p) {
		
		return userDao.save(p);
	}

}
