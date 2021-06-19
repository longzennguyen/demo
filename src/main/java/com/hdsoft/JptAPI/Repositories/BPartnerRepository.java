package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.BPartner;

public interface BPartnerRepository extends JpaRepository<BPartner, Long>{
	
	public List<BPartner> findByClientId(long clientId);
	
}
