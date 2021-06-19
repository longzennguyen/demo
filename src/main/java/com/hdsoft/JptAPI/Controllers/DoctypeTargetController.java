package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.DoctypeTarget;
import com.hdsoft.JptAPI.Repositories.DoctypeTargetRepository;

@RestController
@RequestMapping("/api/v1/doctype")
public class DoctypeTargetController {
	
	@Autowired
	private DoctypeTargetRepository doctypeTargetRepository;
	
	@GetMapping
	public List<DoctypeTarget> listAll() {
		return doctypeTargetRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public DoctypeTarget findById(@PathVariable long id) {
		return doctypeTargetRepository.getOne(id);
	}
}
