package com.hdsoft.JptAPI.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hdsoft.JptAPI.Models.AdOrg;

public interface AdOrgRepository extends JpaRepository<AdOrg, Long>{

	public AdOrg findByClientId(long ClientId);
	
}
