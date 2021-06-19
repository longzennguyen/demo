package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_Product_CategoryCRepository;
import com.hdsoft.JptAPI.HDS.model.M_Product_CategoryCModel;

@RestController
@RequestMapping("api/v1/productcategory")
public class m_product_categoryController {
	@Autowired
	M_Product_CategoryCRepository mpcr;
	GetIDUUDate g = new GetIDUUDate();
	//HDS Base App
	//GET
	@GetMapping
	@RequestMapping("findallbyorg")
	public List<M_Product_CategoryCModel> findAllByOrg(@RequestParam long adorgid){
		return mpcr.findByAdorgid(adorgid);
	}
	//POST
	//Tạo nhóm sản phẩm
	@PostMapping
	@RequestMapping("create")
	public M_Product_CategoryCModel createNew(@RequestParam String name, @RequestParam String value
			,@RequestParam long adorgid) {
		M_Product_CategoryCModel m = new M_Product_CategoryCModel();
		m.setAd_client_id(1000003);
		m.setAdorgid(adorgid);
		m.setM_product_category_id(g.getNextID("M_Product_Category"));
		m.setM_product_category_uu(g.getUUID());
		m.setName(name);
		m.setValue(value);
		m.setCreated(g.getDate());
		m.setPlannedmargin(0);
		m.setUpdated(g.getDate());
		m.setUpdatedby(100);
		m.setCreatedby(100);
		return mpcr.saveAndFlush(m);
	}
}
