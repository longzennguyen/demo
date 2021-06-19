package com.hdsoft.JptAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdsoft.JptAPI.Models.CostType;

@Repository
public interface CostTypeRepository extends JpaRepository<CostType, Integer>{
	
}
