package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.HDSTallySheet;

public interface HDSTallySheetRepository extends JpaRepository<HDSTallySheet, Long> {
	
	
	public List<HDSTallySheet> findByOrderId(long orderId);
	
}
