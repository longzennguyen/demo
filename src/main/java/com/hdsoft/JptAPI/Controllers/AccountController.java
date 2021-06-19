package com.hdsoft.JptAPI.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Account;
import com.hdsoft.JptAPI.Repositories.AccountReposotiry;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

	@Autowired
	private AccountReposotiry accountRepo;
	
	@GetMapping
	public List<Account> listAll() {
		return accountRepo.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{email}")
	public Account accountByEmail(@PathVariable String email) {
		return accountRepo.findByEmail(email);
	}
	
}
