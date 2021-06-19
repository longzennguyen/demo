package com.hdsoft.JptAPI.HDS.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hdsoft.JptAPI.Models.MMovement;

public interface M_MovementRepository extends JpaRepository<MMovement, Long>,CrudRepository<MMovement, Long> {
	public MMovement findByMovementID(long movementID);
	public List<MMovement> findTop100ByAdorgidOrderByMovementIDDesc(long adorgid);
	
}
