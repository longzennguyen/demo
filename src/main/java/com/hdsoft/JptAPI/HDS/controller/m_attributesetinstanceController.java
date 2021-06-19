package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.model.*;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
@RestController
@RequestMapping("api/v1/asi")
public class m_attributesetinstanceController {
	GetIDUUDate giud = new GetIDUUDate();
	@Autowired
	m_attributesetinstanceRepository attributesetinstanceRepository;
	
	//Get
	//get ra all m_attributesetinstance có ad_client_id 100014 và description là  {description}
	@GetMapping 
	@RequestMapping("/{description}")
	public List<m_attributesetinstance> findbyvalue(@PathVariable String description){
		
		List<m_attributesetinstance> l1 = new ArrayList<m_attributesetinstance>();
		l1= attributesetinstanceRepository.findByAdclient(1000014);
		List<m_attributesetinstance> l2 = new ArrayList<m_attributesetinstance>();
		for (m_attributesetinstance m_attributesetinstance : l1) {
			if(m_attributesetinstance.getAdclient()==1000014 && m_attributesetinstance.getLot().equals(description))
				l2.add(m_attributesetinstance);
		}
		return l2;
	}
	@GetMapping
	@RequestMapping("findbylocationandproductid")
	public List<m_attributesetinstance> findbylocationandproductid(@RequestParam long productid,@RequestParam long locatorid){
		return attributesetinstanceRepository.findAllById(attributesetinstanceRepository.listASIFocusLocatorAndProduct(locatorid, productid));
	}
	
	
	@GetMapping 
	@RequestMapping("findbydesandadclient/{description}")
	public List<m_attributesetinstance> findByDescriptionAndAdClient(@PathVariable String description) {
		return   attributesetinstanceRepository.findByLotAndAdclient(description, 1000014);
	}
	
	@GetMapping 
	@RequestMapping("lotlike/{description}")
	public List<m_attributesetinstance> findlotlike(@PathVariable String description) {
		return   attributesetinstanceRepository.findByLotStartsWith(description);
	}
	
	@GetMapping 
	@RequestMapping("find/{description}")
	public List<m_attributesetinstance> findByDescription(@PathVariable String description) {
		//description = lot
		List<m_attributesetinstance> l1 = new ArrayList<m_attributesetinstance>();
		for (m_attributesetinstance m : attributesetinstanceRepository.findByAdclient(1000014)) {
			if(m.getLot().equalsIgnoreCase(description)) {
				l1.add(m);
			}
		}
		return l1;
	}
	
	//post
	@RequestMapping(method = RequestMethod.POST,value="/createnewasi")
	public m_attributesetinstance createNewASI(@RequestParam String lot) {
		m_attributesetinstance m = new m_attributesetinstance();
		m = attributesetinstanceRepository.findTopByOrderByIdDesc();
		m_attributesetinstance mInsert = new m_attributesetinstance();
		mInsert.setAdclient(1000014);
		mInsert.setAd_org_id(1000039);
		mInsert.setCreated(giud.getDate());
		mInsert.setCreatedby(1000080);
		mInsert.setM_attributesetinstance_uu(giud.getUUID());
		mInsert.setLot(lot);
		mInsert.setDescription(lot);
		mInsert.setId(giud.getNextID("M_AttributeSetInstance"));
		mInsert.setUpdated(giud.getDate());
		mInsert.setUpdatedby(1000080);
		return attributesetinstanceRepository.saveAndFlush(mInsert);
	}
	//HDS Base App
	@RequestMapping(method = RequestMethod.POST,value="/create")
	public m_attributesetinstance createNewASI1(@RequestParam String lot,@RequestParam long adorgid) {
		m_attributesetinstance m = new m_attributesetinstance();
		m = attributesetinstanceRepository.findTopByOrderByIdDesc();
		m_attributesetinstance mInsert = new m_attributesetinstance();
		mInsert.setAdclient(1000003);
		mInsert.setAd_org_id(adorgid);
		mInsert.setCreated(giud.getDate());
		mInsert.setCreatedby(100);
		mInsert.setM_attributesetinstance_uu(giud.getUUID());
		mInsert.setLot(lot);
		mInsert.setDescription(lot);
		mInsert.setId(giud.getNextID("M_AttributeSetInstance"));
		mInsert.setUpdated(giud.getDate());
		mInsert.setUpdatedby(100);
		return attributesetinstanceRepository.saveAndFlush(mInsert);
	}
	//Thạch Bàn
	@GetMapping 
	@RequestMapping("findasiexisted")
	public m_attributesetinstance find1(@RequestParam long adclientid,@RequestParam String description) {
		return attributesetinstanceRepository.findTopByDescriptionAndAdclient(description, adclientid);
	}
	@RequestMapping(method = RequestMethod.POST,value="/createtb")
	public m_attributesetinstance createNewASITB(@RequestParam String lot,@RequestParam long adorgid) {
		m_attributesetinstance m = new m_attributesetinstance();
		m = attributesetinstanceRepository.findTopByOrderByIdDesc();
		m_attributesetinstance mInsert = new m_attributesetinstance();
		mInsert.setAdclient(1000000);
		mInsert.setAd_org_id(adorgid);
		mInsert.setCreated(giud.getDate());
		mInsert.setCreatedby(100);
		mInsert.setM_attributesetinstance_uu(giud.getUUID());
		mInsert.setLot(lot);
		mInsert.setDescription(lot);
		mInsert.setId(giud.getNextID("M_AttributeSetInstance"));
		mInsert.setUpdated(giud.getDate());
		mInsert.setUpdatedby(100);
		return attributesetinstanceRepository.saveAndFlush(mInsert);
	}
}
