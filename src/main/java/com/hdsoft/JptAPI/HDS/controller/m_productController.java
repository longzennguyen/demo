package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.AprEndpoint.SocketInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_ProductPriceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.model.M_Product_CategoryCModel;
import com.hdsoft.JptAPI.HDS.model.m_product;
import com.hdsoft.JptAPI.HDS.model.m_productprice;

@RestController
@RequestMapping("api/v1/m_product")
public class m_productController {
	@Autowired
	m_productRepository mp;
	@Autowired
	M_ProductPriceRepository mppr;
	GetIDUUDate g= new GetIDUUDate();
	//GET
	@GetMapping
//	@RequestMapping("")
	public m_product getProduct(@RequestParam long id) {
		m_product m = mp.findById(id);
		return m;
	}
	//Tìm only theo value
	@GetMapping
	@RequestMapping("/findbyvalueonly")
	public m_product findByValue(@RequestParam String value) {
		return mp.findByClientIdAndValue((long) 1000000, value);
	}
	//Tìm theo value và tên
	@GetMapping
	@RequestMapping("/findbyvalue")
	public List<m_product> findByValueOrName(@RequestParam String value) {
		List<m_product> showList = new ArrayList<m_product>();
		
		for (m_product m : mp.findByValueOrName( value,value)) {
			if(m.getClientId()==1000000)
				showList.add(m);
		}
		
		return showList;
	}
	//Tan Truong
	@GetMapping
	@RequestMapping("/shownhom")
	public Long sh(@RequestParam Long productid) {
		return mp.findByClientIdAndId( (long) 1000010,productid).getM_product_category();
	}
	@GetMapping
	@RequestMapping("getsoin")
	public int SoIn(@RequestParam Long productid) {
		return mp.findByClientIdAndId( (long) 1000010,productid).getUnitsperpack();
	}
	
	
	//
	//HDS Base App
	//GET
	
	
	@GetMapping
	@RequestMapping("findbyorg")
	public List<m_product> findAllProductOfOrg(@RequestParam long ad_org_id){
		return mp.findByClientIdAndAdorgid(1000003, ad_org_id);
	}
	@GetMapping
	@RequestMapping("findt")
	public List<m_product> findAllTest(@RequestParam long ad_org_id){
		return mp.findByAdorgid(ad_org_id);
	}
	@GetMapping
	@RequestMapping("findbyidandorg")
	public m_product findByIdAndOrg(@RequestParam long orgid , @RequestParam long productid) {
		return mp.findByAdorgidAndId(orgid, productid);
	}
	@GetMapping
	@RequestMapping("findproductname")
	public List<m_product> findByname(@RequestParam long orgid , @RequestParam String name,@RequestParam String value) {
		List<m_product> list = new ArrayList<m_product>();
		list = mp.findByNameAndAdorgid(name, orgid);
		list.add(mp.findByValueAndAdorgid(name,orgid));
		list.addAll(mp.findByNameAndAdorgid(value, orgid));
		list.add(mp.findByValueAndAdorgid(value, orgid));
		return list;
	}
	@GetMapping
	@RequestMapping("findproductvalue")
	public m_product findByValue(@RequestParam long orgid , @RequestParam String value) {
		
		return mp.findByValueAndAdorgid(value, orgid);
	}
	@GetMapping
	@RequestMapping("findproductvalueandclient")
	public List<m_product> findByValueandClientid(@RequestParam long adclientid , @RequestParam String value) {
		
		return mp.findByValueAndClientId(value, adclientid);
	}
	@GetMapping
	@RequestMapping("findproductnameandclient")
	public List<m_product> findByNameandClientid(@RequestParam long adclientid , @RequestParam String value) {
		
		return mp.findByValueAndClientId(value, adclientid);
	}
	//Tạo sản phẩm mới
	//POST HDS Base
	@PostMapping
	@RequestMapping("/taosanpham")
	public m_product createM_product(@RequestParam long adorgid,@RequestParam String value,
			@RequestParam String name,@RequestParam long attribusetid,@RequestParam long productCategoryid,@RequestParam long uomid,@RequestParam long pricebuy,@RequestParam long purprice) {
		m_product m = new m_product();
		m.setClientId((long) 1000003);
		m.setId(g.getNextID("M_Product"));
		m.setName(name);
		m.setValue(value);
		m.setAd_org_id(adorgid);
		m.setC_uom_id(uomid);
		m.setM_attributeset_id(attribusetid);
		m.setM_product_category(productCategoryid);
		m.setM_product_uu(g.getUUID());
		m.setCreated(g.getDate());
		m.setUpdated(g.getDate());
		m.setCreatedby(100);
		m.setC_taxcategory_id(1000009);
		m.setUpdatedby(100);
		m.setUnitsperpack(1);
		
		return mp.saveAndFlush(m);
	}
	//PUT
	@PutMapping
	@RequestMapping("update")
	public m_product updateProduct(@RequestParam long adorgid,@RequestParam long productid,@RequestParam String value,
			@RequestParam String name,@RequestParam long attribusetid,@RequestParam long productCategoryid,@RequestParam long uomid,@RequestParam long pricebuy,@RequestParam long purprice) {
		m_product m = new m_product();
		m= mp.findByAdorgidAndId(adorgid, productid);
		m.setC_uom_id(uomid);
		m.setM_attributeset_id(attribusetid);
		m.setValue(null);
		m.setM_product_category(productCategoryid);
		m.setValue(value);
		m.setCreated(g.getDate());
		m.setUpdated(g.getDate());
		m.setCreatedby(100);
		m.setUpdatedby(100);
		m.setName(name);
		m.setUnitsperpack(1);
		return mp.save(m);
	}
	//Delete
	@DeleteMapping
	@RequestMapping("/xoasanpham")
	public String deleteProduct(@RequestParam long productid) {
		m_product m = new m_product();
		m = mp.findById(productid); 
		mp.delete(m);
		return "Successful!";
	}
	
}
