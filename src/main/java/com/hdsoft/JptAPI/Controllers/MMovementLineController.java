package com.hdsoft.JptAPI.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.controller.GetIDUUDate;
import com.hdsoft.JptAPI.HDS.model.m_movementLine;
import com.hdsoft.JptAPI.Models.MMovementLine;
import com.hdsoft.JptAPI.Repositories.MMovementLineRepository;

@RestController
@RequestMapping("/api/v1/movementline")
public class MMovementLineController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	private MMovementLineRepository movementLineRepository;
	
	@GetMapping
	public List<MMovementLine> findAll() {
		return movementLineRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{movementId}")
	public List<MMovementLine> findByDocumentNo(@PathVariable long movementId) {
		return movementLineRepository.findByMovementId(movementId);
	}
	
	@GetMapping
	@RequestMapping("/getmaxmovementlineid")
	public long getmaxidrecord() {
		return movementLineRepository.findTopByOrderByMovementLineIdDesc().getMovementLineId();
	}
	
	
	//POST
	@RequestMapping(method = RequestMethod.POST,value="/createnewmovementline")
	public MMovementLine createnewrecord(@RequestParam long locator,
			@RequestParam long locatorto,@RequestParam long movementqty,
			@RequestParam long asi,@RequestParam long movementid
			,@RequestParam long productid) {
		MMovementLine m = new MMovementLine();
		m.setAttributeSetId(asi);
		m.setCurrentLocatorId(locator);
		m.setLocatorToId(locatorto);
		m.setMovementId(movementid);
		m.setMovementLineId((long)g.getNextID("M_MovementLine"));
		m.setProductId(productid);
		m.setAd_client_id((long)1000014);
		m.setAd_org_id((long)1000039);
		m.setCreatedby((long)1000080);
		m.setUpdatedby((long)1000080);
		m.setM_attributesetinstanceto_id(asi);
		m.setCreated(g.getDate());
		m.setUpdated(g.getDate());
		m.setC_uom_id((long)100);
		System.out.println("UOM ID: "+m.getC_uom_id());
		m.setQuantity(movementqty);
		return movementLineRepository.saveAndFlush(m);
	}
	//Thạch B
	//HDS Base App
	@RequestMapping(method = RequestMethod.POST,value="/create1")
	public MMovementLine createne(@RequestParam long locator,
			@RequestParam long locatorto,@RequestParam long movementqty,
			@RequestParam long movementid
			,@RequestParam long productid,@RequestParam long adorgid) {
		MMovementLine m = new MMovementLine();
		m.setAttributeSetId(null);//1354623
		m.setCurrentLocatorId(locator);
		m.setLocatorToId(locatorto);
		m.setMovementId(movementid);
		m.setMovementLineId((long)g.getNextID("M_MovementLine"));
		m.setProductId(productid);
		m.setAd_client_id((long)1000003);
		m.setAd_org_id((long)adorgid);
		m.setCreatedby((long)100);
		m.setUpdatedby((long)100);
		m.setM_attributesetinstanceto_id(null);
		m.setCreated(g.getDate());
		m.setUpdated(g.getDate());
		m.setC_uom_id((long)100);
		m.setQuantity(m.getC_uom_id());
		return movementLineRepository.saveAndFlush(m);
	}



}
