package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.model.C_UOM_ConversionModel;

@RestController
@RequestMapping("api/v1/uomconvert")
public class C_UOM_ConversionController {
	@Autowired
	C_Uom_ConversionRepository cucr;
	@Autowired
	m_productRepository mp1;
	//=================GET====================
	@GetMapping
	@RequestMapping("/findbyproduct")
	public List<C_UOM_ConversionModel> findByProductID(@RequestParam long productid){
		return cucr.findByProductidAndAdclientid(productid, mp1.getOne(productid).getClientId());
	}
	
	
	//=================POST===================
}
