 package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.BPartner;
import com.hdsoft.JptAPI.Repositories.BPartnerRepository;

@RestController
@RequestMapping("/api/v1/cbpartner")
public class BPartnerController {

	@Autowired
	private BPartnerRepository partnerRepo;
	
	@GetMapping
	public List<BPartner> listAll() {
		return partnerRepo.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{id}")
	public BPartner findByID(@PathVariable long id) {
		return partnerRepo.getOne(id);
	}
	
	@GetMapping
	@RequestMapping("/demo")
	public List<BPartner> listKHDemo() {
		return partnerRepo.findByClientId(1000000);
	}
	@GetMapping
	@RequestMapping("/findbyclient")
	public List<BPartner> findbyclient(@RequestParam long clientid) {
		return partnerRepo.findByClientId(clientid);
	}
	
	
}
