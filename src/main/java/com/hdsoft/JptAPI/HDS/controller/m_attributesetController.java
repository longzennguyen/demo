package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_AttributesetRepository;
import com.hdsoft.JptAPI.HDS.model.M_AttributesetModel;

@RestController
@RequestMapping("api/v1/attributeset")
public class m_attributesetController {
	@Autowired 
	M_AttributesetRepository mabr;
	GetIDUUDate g = new GetIDUUDate();
	//HDS Base App
	@GetMapping
	@RequestMapping("/listallbyorg")
	public List<M_AttributesetModel> findByOrg(@RequestParam long adorgid){
		return mabr.findByAdorgid(adorgid);
	}
	
	//POST
	@PostMapping
	@RequestMapping("create")
	public M_AttributesetModel newAttributeset(@RequestParam long ad_org_id,@RequestParam String name) {
		M_AttributesetModel m = new M_AttributesetModel();
		m.setAdorgid(ad_org_id);
		m.setM_attributeset_id(g.getNextID("M_AttributeSet"));
		m.setName(name);
		m.setAd_client_id(1000003);
		m.setCreated(g.getDate());
		m.setUpdated(g.getDate());
		m.setM_attributeset_uu(g.getUUID());
		m.setUpdatedby(100);
		m.setCreatedby(100);
		return mabr.saveAndFlush(m);
	}
	
}
