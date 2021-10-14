package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;

@CrossOrigin("*")
@RestController
@RequestMapping({ "/users" })
public class LoginController {
	
	private List<User> users = createList();
	
	@GetMapping(produces = "application/json")
	public List<User> firstPage() {
		return users;
	}
	
	@DeleteMapping(path = { "/{id}" })
	public User delete(@PathVariable("id") int id) {
		User deletedUser = null;
		for (User u : users) {
			if (u.getId() == id) {
				users.remove(u);
				deletedUser = u;
				break;
			}
		}
		return deletedUser;
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		users.add(user);
		return user;
	}
	
	private static List<User> createList() {
		List<User> tempUsers = new ArrayList<>();
		
		User user1 = new User();
		user1.setUsername("user1");
		user1.setId(1);
		user1.setPassword("password");
		user1.setChips(5000);
		
		User user2 = new User();
		user2.setUsername("user2");
		user2.setId(2);
		user2.setPassword("password1");
		user2.setChips(2300);
		
		tempUsers.add(user1);
		tempUsers.add(user2);
		return tempUsers;
	}

}
