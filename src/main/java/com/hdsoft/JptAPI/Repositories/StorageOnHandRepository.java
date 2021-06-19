package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.StorageOnHand;

public interface StorageOnHandRepository extends JpaRepository<StorageOnHand, Long>{
	
	public List<StorageOnHand> findByLocatorId(long locatorId);
	
	public List<StorageOnHand> findByProductId(long productId);
	
	public List<StorageOnHand> findByProductIdAndLocatorIdOrderByAttributeSetInstanceIdDesc(long productId, long locatorId);
	
	public List<StorageOnHand> findByClientIdAndQuantityOnHandGreaterThan(long clientId, Double param);
}
