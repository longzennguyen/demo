package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.HDSerial;
import com.hdsoft.JptAPI.Repositories.HDSerialRepository;

@RestController
@RequestMapping("/api/v1/serial")
public class HDSerialController {
	
	@Autowired
	private HDSerialRepository hdSerialRepository;
	
	@GetMapping
	public List<HDSerial> findByOrderAndProduct(@RequestParam long orderlineId, @RequestParam long productId) {
		return hdSerialRepository.findByOrderlineIdAndProductId(orderlineId, productId);
	}
	
	@GetMapping
	@RequestMapping("/check")
	public HDSerial findBySerial(@RequestParam String serial, @RequestParam long orderlineId) {
		return hdSerialRepository.findBySerialAndOrderlineId(serial, orderlineId);
	}
	
}
