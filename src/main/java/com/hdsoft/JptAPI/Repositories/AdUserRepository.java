package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.AdUser;

public interface AdUserRepository extends JpaRepository<AdUser, Long> {

	public List<AdUser> findByEmail(String email);
	
	public List<AdUser> findByClientId(long clientId);
	
}
