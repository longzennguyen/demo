package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Costdetail;
import com.hdsoft.JptAPI.Services.CostdetailService;
import com.hdsoft.JptAPI.Services.CostdetailServiceImpl;

@RestController
@RequestMapping("/api/v1/costdetail")
public class CostdetailController {
	@Autowired
	private CostdetailService costdetailService = new CostdetailServiceImpl();
	
	
	@RequestMapping(value = "{ff_cost_id}", method = RequestMethod.GET)
	public List<Costdetail> getCostDetailByCostID(@PathVariable int ff_cost_id) {
		return costdetailService.findByCostID(ff_cost_id);
	}
	



}
