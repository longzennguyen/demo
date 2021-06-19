package com.hdsoft.JptAPI.Services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.Models.Cost;
import com.hdsoft.JptAPI.Repositories.CostRepository;

@Service
public class CostServiceImpl implements CostService {

	@Autowired
	private CostRepository costRepository;
	
	@Override
	public List<Cost> findAllCost() {
		return costRepository.findAll();
	}

	@Override
	public Cost getOneCost(int ff_cost_id) {
		return costRepository.getOne(ff_cost_id);
	}

	@Override
	public Cost createCost(Cost cost) {
		Cost lastCost = costRepository.findAll().get(costRepository.findAll().size() - 1);
		cost.setFf_cost_id(lastCost.getFf_cost_id() + 1);
		return costRepository.saveAndFlush(cost);
	}

	@Override
	public Cost updateCost(int ff_cost_id, Cost cost) {
		Cost existingCost = costRepository.getOne(ff_cost_id);
		BeanUtils.copyProperties(cost, existingCost, "ff_cost_id");
		return costRepository.saveAndFlush(existingCost);
	}
	
	@Override
	public List<Cost> findByBookingvalue(String bookingvalue) {
		return costRepository.findByBookingvalue(bookingvalue);
	}

}
