package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_InventoryLineRepository;
import com.hdsoft.JptAPI.HDS.model.m_InventoryLine;

@RestController
@RequestMapping("api/v1/m_inventoryline")
public class M_InventoryLineController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired 
	M_InventoryLineRepository inventoryLineRepository;
	@GetMapping
	public List<m_InventoryLine> findbyid(@RequestParam long id){
		return inventoryLineRepository.findById(id);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST,value="/detail")
	public m_InventoryLine createdDetail(@RequestParam long m_inventory_id,@RequestParam long locatorid,
			@RequestParam long productid,@RequestParam long line,@RequestParam String qtybook,@RequestParam String qtycount,
			@RequestParam long asiid) {
		m_InventoryLine m = new m_InventoryLine();
		m.setAd_org_id(1000000);
		m.setAdclientid(1000000);
		m.setCreated(g.getDate());
		m.setCreatedby(1000005);
		m.setM_inventoryline_id(g.getNextID("M_InventoryLine"));
		m.setInventorytype("D");
		m.setLine(line);
		m.setM_attributesetinstance(asiid);
		m.setM_inventory_id(m_inventory_id);
		m.setM_inventoryline_uu(g.getUUID());
		m.setM_locator_id(locatorid);
		m.setM_product_id(productid);
		m.setProcessed("N");
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
		m.setUpdatedby(1000005);
		return inventoryLineRepository.saveAndFlush(m);
	}
}
