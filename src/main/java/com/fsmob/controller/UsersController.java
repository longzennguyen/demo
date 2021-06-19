package com.fsmob.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsmob.Repository.UsersRepository;
import com.fsmob.model.Users;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
	@Autowired 
	UsersRepository ur1;
	ProcessDontHaveTable p1 = new ProcessDontHaveTable();
	@GetMapping
	@RequestMapping("login")
	public Users findByUsernameAndPassword(@RequestParam String username,@RequestParam String password) {
		Users u1 = new Users();
		u1 = ur1.findByUsernameAndPassword(username, password);
		if(u1 != null) {
			if(u1.isIsactive()) {
					u1.setToken(p1.generateNewToken());
				ur1.save(u1);
			}else {
				return null;
			}
		}else 
			return null;
		return u1;
	}
	@GetMapping
	@RequestMapping("findbytoken")
	public Users findByToken(@RequestParam String token){
		return ur1.findByToken(token);
	}
	
	@PostMapping
	@RequestMapping("create")
	public Users createNewAccoutn(@RequestParam String password,
			@RequestParam String username,
			@RequestParam String email,
			@RequestParam String phone,
			@RequestParam String role
			) {
		
		Users u1 = new Users();
		Users u2 = new Users();
		u2= ur1.findByPhone(phone);
		if(u2!=null) {
			return null;
		}
		try {
			u1.setUserid(ur1.maxID()+1);
		} catch (Exception e) {
			System.out.println("Here");
			u1.setUserid(1);
		}
		
		u1.setEmail(email);
		u1.setIsactive(true);
		u1.setLastlogin(new Timestamp(System.currentTimeMillis()));
		u1.setPassword(password);
		u1.setRole(role);
		u1.setToken(null);
		u1.setPhone(phone);
		u1.setUsername(username);
		return ur1.saveAndFlush(u1);
	}
	
}
