package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MInoutLine;
import com.hdsoft.JptAPI.Repositories.MInoutLineRepository;

@RestController
@RequestMapping("/api/v1/minoutline")
public class MInoutLineController {
	
	@Autowired
	private MInoutLineRepository mInoutLineRepository;
	
	@GetMapping
	public List<MInoutLine> listAll() {
		return mInoutLineRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/search")
	public List<MInoutLine> findByProductID(@RequestParam long productID, @RequestParam long materialID) {
		return mInoutLineRepository.findByProductIDAndMaterialID(productID, materialID);
	}
	
}
