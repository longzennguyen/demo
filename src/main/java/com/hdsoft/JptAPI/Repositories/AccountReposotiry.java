package com.hdsoft.JptAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Account;

public interface AccountReposotiry extends JpaRepository<Account, Long>{
	
	public Account findByEmail(String email);

}
