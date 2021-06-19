package com.hdsoft.JptAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdsoft.JptAPI.Models.Costdetail;
import com.hdsoft.JptAPI.Repositories.CostdetailRepository;


@Service
public class CostdetailServiceImpl implements CostdetailService{

	@Autowired
	private CostdetailRepository costdetailRepository;
	

	@Override
	public List<Costdetail> findByCostID(int ff_cost_id) {
		// TODO Auto-generated method stub
		return costdetailRepository.findByCostID(ff_cost_id);
	}




	
}
