package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_UomRepository;
import com.hdsoft.JptAPI.HDS.model.C_UOM;

@RestController
@RequestMapping("api/v1/uom")
public class c_uomController {
	@Autowired
	C_UomRepository cur ;
	GetIDUUDate g = new GetIDUUDate();
	//HDS Base App
	//GET
	@GetMapping
	@RequestMapping("listallbyorg")
	public List<C_UOM> findAllByOrg(@RequestParam long adorgid){
		return cur.findByAdorgid(adorgid);
	}
	@GetMapping
	@RequestMapping("listalluombyclient")
	public List<C_UOM> listAllByClient(@RequestParam long clientid){
		return cur.listUOmByClient(clientid);
	}
	//POST
	@PostMapping
	@RequestMapping("create")
	public C_UOM createNew(@RequestParam long adorgid,@RequestParam String name,@RequestParam String symbol) {
		C_UOM c = new C_UOM();
		c.setAd_client_id(1000003);
		c.setAdorgid(adorgid);
		c.setC_uom_id(g.getNextID("C_UOM"));
		c.setC_uom_uu(g.getUUID());
		c.setCreated(g.getDate());
		c.setUpdated(g.getDate());
		c.setX12de355(symbol);
		c.setCreatedby(100);
		c.setStdprecision(2);
		c.setName(name);
		c.setUpdatedby(100);
		c.setCostingprecision(0);
		return cur.saveAndFlush(c);
	}
}
