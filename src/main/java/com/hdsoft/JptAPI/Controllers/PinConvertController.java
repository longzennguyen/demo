package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.PinConvert;
import com.hdsoft.JptAPI.Repositories.PinConvertRepository;

@RestController
@RequestMapping("/api/v1/pinconvert")
public class PinConvertController {
	
	@Autowired
	PinConvertRepository pinconvertRepo;
	
	@GetMapping
	public List<PinConvert> findAll() {
		return pinconvertRepo.findAll();
	}
	
}
