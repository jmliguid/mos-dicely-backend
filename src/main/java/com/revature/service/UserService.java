package com.revature.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.exceptions.UserNotFoundException;
import com.revature.model.Player;
import com.revature.repositories.UserDao;

public class UserService {
	
	@Autowired
	UserDao playerDao;
	
	// findById
	public Player findById(int id) {
		return playerDao.findById(id)
				.orElseThrow(() -> new UserNotFoundException("No User found with id " + id));
	}
	
	// findByUsername
	public Player findByUsername(String username) {
		
		return playerDao.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException("No User found with username " + username));
	}
	
	//findAll
	
	public Set<Player> findAll() {
		
		return playerDao.findAll()
							.stream()
							.collect(Collectors.toSet());
	}
	
	// Insert
	public Player insert(Player p) {
		
		return playerDao.save(p);
	}

}
