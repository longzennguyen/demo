package com.hdsoft.JptAPI.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hdsoft.JptAPI.Models.Costdetail;

@Repository
public interface CostdetailRepository extends JpaRepository<Costdetail, Integer>{
	
	public List<Costdetail> findByCostID(int ff_cost_id);
	
}
