package com.revature.service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.User;
import com.revature.repositories.UserDao;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
		
		String encodedPassword = this.passwordEncoder.encode(p.getPassword());
		p.setPassword(encodedPassword);
		
		return userDao.save(p);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = this.findByUsername(username);
		if (u == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
				new ArrayList<>());
	}
	
}
