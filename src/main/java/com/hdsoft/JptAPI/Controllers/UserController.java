package com.hdsoft.JptAPI.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.User;
import com.hdsoft.JptAPI.Repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public User getUserByEmail(@PathVariable String email) {
		return userRepository.findByEmail(email);
	}
	
}
