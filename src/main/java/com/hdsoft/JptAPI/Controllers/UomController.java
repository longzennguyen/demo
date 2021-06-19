package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Uom;
import com.hdsoft.JptAPI.Repositories.UomRepository;

@RestController
@RequestMapping("/api/v1/uom")
public class UomController {
	
	@Autowired
	private UomRepository uomRepository;
	
	@GetMapping
	public List<Uom> listAll() {
		return uomRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public Uom findById(@PathVariable long id) {
		return uomRepository.getOne(id);
	}
	
}
