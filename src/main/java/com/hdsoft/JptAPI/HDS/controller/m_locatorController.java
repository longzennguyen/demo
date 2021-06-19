package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.model.LocatorHDSBaseApp;
import com.hdsoft.JptAPI.HDS.model.m_locator;

import javassist.convert.TransformNew;

@RestController
@RequestMapping("api/v1/m_locator")
public class m_locatorController {
	@Autowired
	public m_locatorRepository mlr;
	@Autowired
	public m_storageonhandRepository msr;
	GetIDUUDate g = new GetIDUUDate();
	//Get
	@GetMapping
	@RequestMapping("{value}")
	public m_locator Search(@PathVariable String value) {
		m_locator m = new m_locator();
		for (m_locator ml : mlr.findByValue(value)) {
			if(ml.getAd_client_id()==1000014) {
				m=ml;
			}
		}
		return m;
	}
	@GetMapping
	@RequestMapping("findbywarehouse")
	public List<m_locator> listFocusWarehouse(@RequestParam long warehouseid){
		return mlr.findByWarehouseid(warehouseid);
	}
	@GetMapping
	@RequestMapping("findbyclient")
	public List<m_locator> findbyclientid(@RequestParam long clientid){
		return mlr.listLocator(clientid);
	}
	
	
	//HDS Base App
	//GET
	@GetMapping
	@RequestMapping("getallinfo")
	public List<LocatorHDSBaseApp> getAllInfomation(@RequestParam long adorgid){
		List<LocatorHDSBaseApp> list = new ArrayList<LocatorHDSBaseApp>();
		for (m_locator m : mlr.findByAdorgid(adorgid)) {
			LocatorHDSBaseApp l = new LocatorHDSBaseApp();
			l.setCountProduct(msr.findByLocatoridAndQtyonhandGreaterThan(m.getId(), 0).size());
			l.setM_locator_id(m.getId());
			l.setNameString(m.getName());
			l.setValue(m.getValue());
			list.add(l);
		}
		return list;
	}
	//POST
	@PostMapping
	@RequestMapping("/taovitri")
	public m_locator createLocator(@RequestParam String name,@RequestParam long adorgid,@RequestParam long m_warehouse_id) {
		m_locator m = new m_locator();
		m.setAd_client_id(1000003);
		m.setAd_org_id(adorgid);
		m.setCreated(g.getDate());
		m.setCreatedby(100);
		m.setId(g.getNextID("M_Locator"));
		m.setM_locator_uu(g.getUUID());
		m.setName(name);
		m.setUpdated(g.getDate());
		m.setUpdatedby(100);
		m.setValue(name);
		m.setM_warehouse_id(m_warehouse_id);
		m.setPriorityno(50);
		return mlr.saveAndFlush(m);
		
	}
	
	//PUT
	@PutMapping
	@RequestMapping("edit")
	public m_locator editLocator(@RequestParam String locatorName,@RequestParam long locatorid) {
		m_locator m = new m_locator();
		m = mlr.findById(locatorid);
		m.setValue(locatorName);
		m.setName(locatorName);
		m.setAd_client_id(1000003);
		m.setPriorityno(m.getPriorityno());
		m.setUpdated(g.getDate());
		return mlr.saveAndFlush(m);
	}
	
	
	//Delete
	@DeleteMapping
	@RequestMapping("delete")
	public String deleteLocator(@RequestParam long locatorid) {
		m_locator locator = new m_locator();
		locator  = mlr.getOne(locatorid);
		mlr.delete(locator);
		return "Successful!";
	}
}
