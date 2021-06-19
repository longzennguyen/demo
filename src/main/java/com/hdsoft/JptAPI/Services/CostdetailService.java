package com.hdsoft.JptAPI.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.Models.Costdetail;

@Service
public interface CostdetailService {
	
	
	public List<Costdetail> findByCostID(int ff_cost_id);
}
