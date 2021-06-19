package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.StorageOnHand;
import com.hdsoft.JptAPI.Repositories.StorageOnHandRepository;

@RestController
@RequestMapping("/api/v1/storageonhand")
public class StorageOnHandController {
	
	@Autowired
	public StorageOnHandRepository storageOnHandRepository;
	
	@GetMapping
	public List<StorageOnHand> findAll() {
		return storageOnHandRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{locatorId}")
	public List<StorageOnHand> findByLocatorId(@PathVariable long locatorId) {
		return storageOnHandRepository.findByLocatorId(locatorId);
	}
	
	
}
