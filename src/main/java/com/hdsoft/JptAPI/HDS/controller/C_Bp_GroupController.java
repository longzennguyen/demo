package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_Bp_GroupRepository;
import com.hdsoft.JptAPI.HDS.model.C_Bp_GroupModel;

@RestController
@RequestMapping("/api/v1/cbgroup")
public class C_Bp_GroupController {
	@Autowired
	C_Bp_GroupRepository cbgr;
	GetIDUUDate g = new GetIDUUDate();
	//HDS Base App
	//GET
	@GetMapping
	@RequestMapping("findbyorg")
	public List<C_Bp_GroupModel> getAllByOrg(@RequestParam long adorgid){
		return cbgr.findByAdorgid(adorgid);
	}
	//POST
	@PostMapping
	@RequestMapping("create")
	public C_Bp_GroupModel createCBG(@RequestParam String name,@RequestParam String value,@RequestParam long adorgid) {
		C_Bp_GroupModel c = new C_Bp_GroupModel();
		c.setAd_client_id(1000003);
		c.setAdorgid(adorgid);
		c.setC_bp_group_uu(g.getUUID());
		c.setCreated(g.getDate());
		c.setCreatedby(100);
		c.setId(g.getNextID("C_BP_Group"));
		c.setName(name);
		c.setValue(value);
		c.setUpdated(g.getDate());
		c.setUpdatedby(100);
		return cbgr.saveAndFlush(c);
	}
}
