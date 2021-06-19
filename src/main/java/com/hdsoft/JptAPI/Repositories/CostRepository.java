package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdsoft.JptAPI.Models.Cost;

@Repository
public interface CostRepository extends JpaRepository<Cost, Integer> {
	
	public List<Cost> findByBookingvalue(String bookingvalue);
	
}
