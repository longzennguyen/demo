package com.hdsoft.JptAPI.Repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.MAttributeSetInstance;



public interface MAttributeSetInstanceRepository extends JpaRepository<MAttributeSetInstance, Long>{
		
	public List<MAttributeSetInstance> findByGuaranteeDate (Date guaranteeDate);
	
	public List<MAttributeSetInstance> findByClientIdAndAttributeSetId (long clientId, Integer attributeSetId);
}
