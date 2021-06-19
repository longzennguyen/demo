package com.hdsoft.JptAPI.Repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.MSaleorder;

public interface MSaleorderRepository extends JpaRepository<MSaleorder, Long> {
	
	public MSaleorder findByOrderId(long OrderId);
	
}
