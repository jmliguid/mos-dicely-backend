package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Player;
import com.revature.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class PlayerController {

    // standard constructors
    
	@Autowired
    UserService userService;
	
	
	// AUTH SET UP HERE
    public List<Player> getUsers() {
        return (List<Player>) userService.findAll();
    }
	
	
	// AUTH SET UP HERE
    @PostMapping("/add")
    void addUser(@RequestBody Player p) {
        userService.insert(p);
    }
    
    
    // AUTH SET UP HERE
    @GetMapping("/{id}") // if I send a get request to http://localhost:8090/api/users/5, it will capture 5 and search the User table for it
	public ResponseEntity<Player> getUserById(@PathVariable("id") int id) {
		
		// call the service method, pass the captured id through, and returnit as a reposne entity with 200 OK status
		return ResponseEntity.ok(userService.findById(id));
    }	

}