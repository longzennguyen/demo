package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.Models.MMovementLine;

public interface MMovementLineRepository extends JpaRepository<MMovementLine, Long>{
	
	public List<MMovementLine> findByMovementId(long movementId);
	public MMovementLine findTopByOrderByMovementLineIdDesc();
}
