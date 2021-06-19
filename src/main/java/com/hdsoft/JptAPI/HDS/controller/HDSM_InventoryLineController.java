package com.hdsoft.JptAPI.HDS.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;
import com.hdsoft.JptAPI.HDS.Repositories.hdsm_inventorylineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.model.HDSM_InventoryLine;
import com.hdsoft.JptAPI.HDS.model.HDSM_InventoryLineAllInfomation;
import com.hdsoft.JptAPI.HDS.model.m_InventoryLine;

@RestController
@RequestMapping("api/v1/hdsm_inventoryline")
public class HDSM_InventoryLineController {
	@Autowired
	hdsm_inventorylineRepository m1;
	@Autowired
	m_locatorRepository ml1;
	@Autowired
	m_productRepository mp1;
	@Autowired
	m_attributesetinstanceRepository ma1;
	@Autowired
	C_Uom_ConversionRepository c1;
	GetIDUUDate g = new GetIDUUDate();
	@GetMapping
	@RequestMapping("detail")
	public List<HDSM_InventoryLineAllInfomation> detailAll(@RequestParam long m_inventory_id){
		List<HDSM_InventoryLineAllInfomation> l1 = new ArrayList<HDSM_InventoryLineAllInfomation>();
		for (HDSM_InventoryLine h1 : m1.findByInventoryID(m_inventory_id)) {
			HDSM_InventoryLineAllInfomation h2 = new HDSM_InventoryLineAllInfomation();
			h2.setM_inventory_id(h1.getM_inventory_id());
			h2.setM_locator_id(h1.getM_locator_id());
			h2.setLocatorName(ml1.getOne(h2.getM_locator_id()).getValue());
			h2.setM_product_id(h1.getM_product_id());
			h2.setProductName(mp1.getOne(h2.getM_product_id()).getValue());
			h2.setLine(h1.getLine());
			h2.setQtycount(h1.getQtycount());
			h2.setM_attributesetinstance(h1.getM_attributesetinstance());
			h2.setAsiName(ma1.getOne(h2.getM_attributesetinstance()).getDescription());
			h2.setChenh(h2.getQtybook()-h2.getQtycount());
			l1.add(h2);
		}
		
		
		return l1;
	}
	@RequestMapping(method = RequestMethod.POST,value="/detail")
	public HDSM_InventoryLine createdDetail(@RequestParam long m_inventory_id,@RequestParam long locatorid,
			@RequestParam long productid,@RequestParam long line,@RequestParam String qtybook,@RequestParam String qtycount,
			@RequestParam long asiid) {
		HDSM_InventoryLine m = new HDSM_InventoryLine();
		m.setAd_org_id(1000000);
		m.setAdclientid(1000000);
		m.setCreated(g.getDate());
		m.setCreatedby(100);
		m.setM_inventoryline_id(g.getNextID("HDSM_InventoryLine"));
		m.setInventorytype("D");
		m.setLine(line);
		m.setM_attributesetinstance(asiid);
		m.setM_inventory_id(m_inventory_id);
		m.setM_inventoryline_uu(g.getUUID());
		m.setM_locator_id(locatorid);
		m.setM_product_id(productid);
		try {
			m.setDescription(ma1.getOne(asiid).getDescription());
		} catch (Exception e) {
			m.setDescription("");
			// TODO: handle exception
		}
		
		m.setProcessed("N");
		
		m.setC_uom_id(100);
		
		double qty1=0,qty2=0;
		try {
			qty1= Double.parseDouble(qtybook+"");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			qty2= Double.parseDouble(qtycount+"");
		} catch (Exception e) {
			// TODO: handle exception
		}
		m.setQtybook(qty1);
		m.setQtycount(qty2);
		m.setUpdated(g.getDate());
		try {
			m.setC_uom_id(1000046);
			DecimalFormat f = new DecimalFormat("##.##");
			double qtyenter = Double.parseDouble(f.format(c1.findByProductidAndUomidAndUomtoid(productid, 1000046	, 1000047).getDividerate()));
			m.setQtyentered(m.getQtycount()/qtyenter);
		} catch (Exception e) {
			m.setC_uom_id(1000047);
			m.setQtyentered(m.getQtycount());
			// TODO: handle exception
		}
		m.setUpdatedby(100);
		return m1.saveAndFlush(m);
	}
	@DeleteMapping
	@RequestMapping("deletedetail")
	public long deleteAllDetailOfInventory(@RequestParam long m_inventory_id) {
		
		return m1.deleteByInventoryID(m_inventory_id);
	}
	
}
