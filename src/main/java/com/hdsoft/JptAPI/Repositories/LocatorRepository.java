package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.Locator;


public interface LocatorRepository extends JpaRepository<Locator, Long>{

	public List<Locator> findByWarehouseIDOrderByLocatorID(long warehouseID);
	
	public List<Locator> findByAdclientidOrderByLocatorID(long adclientid);
	
	public List<Locator> findByName(String name);
	
	public List<Locator> findByAdclientid(long adclientid);
}
