package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.CostType;
import com.hdsoft.JptAPI.Repositories.CostTypeRepository;

@RestController
@RequestMapping("/api/v1/costtype")
public class CostTypeController {
	
	@Autowired
	private CostTypeRepository costtypeRepository;
	
	
	@GetMapping
	public List<CostType> listCostType() {
		return costtypeRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public CostType getCostType(@PathVariable Integer id) {
		return costtypeRepository.getOne(id);
	}

	@PostMapping
	public CostType createCostType(@RequestBody CostType costType) {
		CostType lastCostType = costtypeRepository.findAll().get(costtypeRepository.findAll().size()-1);
		costType.setFf_costtype_id(lastCostType.getFf_costtype_id() + 1);
		return costtypeRepository.saveAndFlush(costType);
	}
 }
