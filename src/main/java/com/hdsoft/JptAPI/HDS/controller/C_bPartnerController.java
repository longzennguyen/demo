package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_bPartnerRepository;
import com.hdsoft.JptAPI.HDS.model.C_bPartnerModel;

@RestController
@RequestMapping("/api/v1/c_bpartner")
public class C_bPartnerController {
	@Autowired
	private C_bPartnerRepository cbpRepo;
	GetIDUUDate g = new GetIDUUDate();
	
	@GetMapping
	@RequestMapping("/{id}")
	public C_bPartnerModel findById(@PathVariable long id){
		return cbpRepo.getOne(id);
	}
	
	
	//HDS Base App Mobile
	//GET
	@GetMapping
	@RequestMapping("findbywarehouse")
	public List<C_bPartnerModel> findAllByOrg(@RequestParam long adorgid){
		return cbpRepo.findByAdorgid(adorgid);
	}
	//POST
	@PostMapping
	@RequestMapping("taodoitac")
	public C_bPartnerModel taoDoiTac(@RequestParam String value,@RequestParam String name,@RequestParam long m_warehouse_id) {
		C_bPartnerModel c_bPartnerModel = new C_bPartnerModel();
		c_bPartnerModel.setC_bpartner_id(g.getNextID("C_BPartner"));
		c_bPartnerModel.setM_warehouse_id(m_warehouse_id);
		c_bPartnerModel.setName(name);
		c_bPartnerModel.setValue(value);
		c_bPartnerModel.setCreated(g.getDate());
		c_bPartnerModel.setCreatedby(100);
		c_bPartnerModel.setUpdated(g.getDate());
		c_bPartnerModel.setUpdatedby(100);
		c_bPartnerModel.setC_bpartner_uu(g.getUUID());
		return cbpRepo.saveAndFlush(c_bPartnerModel);
	}
	//Tạo đối tác hoàn thiện
	@PostMapping
	@RequestMapping("create")
	public C_bPartnerModel taoDoiTacN(@RequestParam String value,@RequestParam String name,@RequestParam long m_warehouse_id,@RequestParam String isvendor,
			@RequestParam String iscustomer,@RequestParam String isemployee,@RequestParam String issalesrep,@RequestParam long c_bp_group_id,@RequestParam long adorgid) {
		C_bPartnerModel c_bPartnerModel = new C_bPartnerModel();
		c_bPartnerModel.setC_bpartner_id(g.getNextID("C_BPartner"));
		c_bPartnerModel.setM_warehouse_id(m_warehouse_id);
		c_bPartnerModel.setName(name);
		c_bPartnerModel.setValue(value);
		c_bPartnerModel.setCreated(g.getDate());
		c_bPartnerModel.setAdclientid(1000003);
		c_bPartnerModel.setAdorgid(adorgid);
		c_bPartnerModel.setC_bp_group_id(c_bp_group_id);
		c_bPartnerModel.setCreatedby(100);
		c_bPartnerModel.setUpdated(g.getDate());
		c_bPartnerModel.setUpdatedby(100);
		c_bPartnerModel.setIscustomer(iscustomer);
		c_bPartnerModel.setIsemployee(isemployee);
		c_bPartnerModel.setIssalesrep(issalesrep);
		c_bPartnerModel.setIsvendor(isvendor);
		c_bPartnerModel.setC_bpartner_uu(g.getUUID());
		return cbpRepo.saveAndFlush(c_bPartnerModel);
	}
//	@GetMapping
//	@RequestMapping("findbywarehouse")
//	public List<C_bPartnerModel> findAllByOrg(@RequestParam long adorgid){
//		return cbpRepo.findByAdorgid(adorgid);
//	}
}
