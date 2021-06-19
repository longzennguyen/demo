package com.hdsoft.JptAPI.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.Models.Cost;

@Service
public interface CostService {

	public List<Cost> findAllCost();

	public Cost getOneCost(int ff_cost_id);

	public Cost createCost(Cost cost);

	public Cost updateCost(int ff_cost_id, Cost cost);

	public List<Cost> findByBookingvalue(String bookingvalue);
	
}
