package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.MSaleorderDetail;

public interface MSaleorderDetailRepository extends JpaRepository<MSaleorderDetail, Long>{

	public List<MSaleorderDetail> findBySaleOrderId (long saleOrderId);
	
}
