package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.Models.Locator;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;

@RestController
@RequestMapping("/api/v1/locator")
public class LocatorController {
	@Autowired
	private LocatorRepository locatorRepository;
	@Autowired
	private m_locatorRepository mlr1;
	
	@GetMapping
	public List<Locator> listAll() {
		return locatorRepository.findByWarehouseIDOrderByLocatorID(1000034);
	}
	@GetMapping
	@RequestMapping("/locatoryazaki")
	public List<Locator> listAllYazaki() {
		return locatorRepository.findByWarehouseIDOrderByLocatorID(1000075);
	}
	
	@GetMapping
	@RequestMapping("/demo")
	public List<Locator> listAllDemo() {
		return locatorRepository.findByAdclientid(1000000);
	}
	
	@GetMapping
	@RequestMapping("/{name}")
	public Locator findByWarehouse(@PathVariable String name) {
		List<Locator> listFindByName = locatorRepository.findByName(name);
		for (Locator locator : listFindByName) {
			if (locator.getWarehouseID() == 1000034 || locator.getWarehouseID() == 1000000) {
				return locator;
			}
		}
		return null;
	}
	@GetMapping
	@RequestMapping("findbyclient")
	public List<Locator> findbyClient(@RequestParam long clientid){
		return locatorRepository.findByAdclientid(clientid);
	}
	
	
}
