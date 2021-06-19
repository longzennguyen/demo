package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdsoft.JptAPI.HDS.model.m_movementLine;

public interface M_MovementLineRepository extends JpaRepository<m_movementLine, Long> {
	
	public List<m_movementLine> findByMovementId(long movementId);
}
