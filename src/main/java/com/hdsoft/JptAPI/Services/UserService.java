package com.hdsoft.JptAPI.Services;

import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.Models.User;

@Service
public interface UserService {
	
	public User updateValidationkey(String email, User user);
	
	public User getUser(String email);
}
