package com.hdsoft.JptAPI.HDS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_ProductPriceRepository;
import com.hdsoft.JptAPI.HDS.model.m_productprice;
@RestController
@RequestMapping("api/v1/productprice")
public class M_ProductpriceController {
	@Autowired
	M_ProductPriceRepository mppr;
	GetIDUUDate g = new GetIDUUDate();
	//HDS Base App
	//GET
	@GetMapping
	@RequestMapping("getbyproductid")
	public m_productprice findbyproductID(@RequestParam long productid,@RequestParam long orgid) {
		return mppr.findByProductid(productid).get(0);
	}
	//POST
	@PostMapping
	@RequestMapping("/create")
	public m_productprice created(@RequestParam long pricebuy,@RequestParam long purprice,@RequestParam long productid, 
			@RequestParam long adorgid) {
		m_productprice mppm = new m_productprice();
		mppm.setCreated(g.getDate());
		mppm.setCreatedby(100);
		mppm.setM_product_id(productid);
		mppm.setM_productprice_id(g.getNextID("M_ProductPrice"));
		mppm.setM_productprice_uu(g.getUUID());
		mppm.setOrgid(adorgid);
		mppm.setPricelist(pricebuy);
		mppm.setPricestd(purprice);
		mppm.setUpdated(g.getDate());
		mppm.setUpdatedby(100);
		mppm.setM_pricelist_version_id(1000007);
		mppm.setAd_client_id(1000003);
		return mppr.saveAndFlush(mppm);
	}
	//PUT
	@PutMapping
	@RequestMapping("/update")
	public m_productprice update(@RequestParam long pricebuy,@RequestParam long purprice,@RequestParam long productid, @RequestParam long adorgid ) {
		m_productprice mppm = new m_productprice();
		mppm  = mppr.findByProductid(productid).get(0);
		System.out.println("Old Price: "+mppm.getPricelist());
		mppm.setPricelist(pricebuy);
		System.out.println("Set Price Buy : "+mppm.getPricelist());
		mppm.setPricestd(purprice);
		System.out.println("Set Price Pur : "+mppm.getPricestd());
		mppm.setCreated(g.getDate());
		mppm.setUpdated(g.getDate());
		mppm.setCreatedby(100);
		mppm.setUpdatedby(100);
		mppm.setM_productprice_uu(g.getUUID());
		return	mppr.saveAndFlush(mppm);
	}
	
}
