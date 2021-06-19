package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Cost;
import com.hdsoft.JptAPI.Services.CostService;
import com.hdsoft.JptAPI.Services.CostServiceImpl;

@RestController
@RequestMapping("/api/v1/cost")
public class CostController {
	
	@Autowired
	private CostService costService = new CostServiceImpl();
	
	@GetMapping
	public List<Cost> listAllCost() {
		return costService.findAllCost();
	}
	
	@RequestMapping(value = "{bookingvalue}", method = RequestMethod.GET)
	public List<Cost> getOneCost(@PathVariable String bookingvalue) {
		List<Cost> result = new ArrayList<Cost>();
		List<Cost> listAll = costService.findByBookingvalue(bookingvalue);
		for (Cost cost : listAll) {
			if (cost.getIsactive().equalsIgnoreCase("Y")) {
				result.add(cost);
			}
		}
		return result;
	}
	
	@RequestMapping(value = "{ff_cost_id}", method = RequestMethod.PUT)
	public Cost updateCost(@PathVariable int ff_cost_id, @RequestBody Cost cost) {
		return costService.updateCost(ff_cost_id, cost);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cost createCost(@RequestBody Cost cost) {
		return costService.createCost(cost);
	}
}
