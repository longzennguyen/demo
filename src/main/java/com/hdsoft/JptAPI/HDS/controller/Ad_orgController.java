package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;
import com.hdsoft.JptAPI.HDS.Repositories.Ad_orgRepository;
import com.hdsoft.JptAPI.HDS.model.Ad_OrgModel;

@RestController
@RequestMapping("api/v1/adorg")
public class Ad_orgController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	Ad_orgRepository ar;
	//GET
	@GetMapping
	@RequestMapping("timkiem")
	public Ad_OrgModel find(@RequestParam String name, @RequestParam String value){
		return ar.findByNameAndValue(name, value);
	}
	@GetMapping
	@RequestMapping("gencode")
	public String genCode() {
		String  code= "HDS";
		Random random = new Random();
		while((""+code).length() < 7) {
			code += random.nextInt(9);
		}
		
		return code;
	}
	//POST
	@PostMapping
	@RequestMapping("/taochinhanh")
	public Ad_OrgModel TaoMoiToChuc(@RequestParam String name,@RequestParam String value) {
		Ad_OrgModel ad_OrgModel = new Ad_OrgModel();
		ad_OrgModel.setAd_org_id(g.getNextID("AD_Org"));
		ad_OrgModel.setAd_org_uu(g.getUUID());
		ad_OrgModel.setAdclientid(1000003);
		ad_OrgModel.setCreated(g.getDate());
		ad_OrgModel.setCreatedby(100);
		ad_OrgModel.setUpdated(g.getDate());
		ad_OrgModel.setUpdatedby(100);
		ad_OrgModel.setIssummary("N");
		ad_OrgModel.setName(name);
		ad_OrgModel.setValue(value);
		return ar.saveAndFlush(ad_OrgModel);
	}
	
	
}
