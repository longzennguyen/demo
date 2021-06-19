package com.hdsoft.JptAPI.HDS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_WarehouseRepository;
import com.hdsoft.JptAPI.HDS.model.M_WarehouseModel;

@RestController
@RequestMapping("/api/v1/m_wareshouse")
public class M_WarehouseController {
	@Autowired
	M_WarehouseRepository mw;
	GetIDUUDate g = new GetIDUUDate();
	//GET 
	@GetMapping
	@RequestMapping("/find")
	public M_WarehouseModel findByValueAndName(@RequestParam String value,@RequestParam String name,@RequestParam long adorgid) {
		return mw.findByNameAndValueAndAdclientidAndAdorgid(name,value,1000003,adorgid);
	}
	@GetMapping
	@RequestMapping("/getAll")
	public List<M_WarehouseModel> findAll(@RequestParam long adorgid) {
		return mw.findByAdorgid(adorgid);
	}
	@GetMapping
	@RequestMapping("/getbyclient")
	public List<M_WarehouseModel> findbyclient(@RequestParam long clientid) {
		return mw.findByAdclientid(clientid);
	}
	
	
	
	//POST
	@PostMapping
	@RequestMapping("create")
	public M_WarehouseModel taoKhoMoi(@RequestParam long adorgid,@RequestParam String value,@RequestParam String name) {
		M_WarehouseModel m = new M_WarehouseModel();
		m.setAdclientid(1000003);
		m.setAdorgid(adorgid);
		m.setCreated(g.getDate());
		m.setM_warehouse_id(g.getNextID("M_Warehouse"));
		m.setM_warehouse_uu(g.getUUID());
		m.setCreatedby(100);
		m.setC_location_id(1000338);// Hà Nội
		m.setName(name);
		m.setSeparator("*");
		m.setUpdated(g.getDate());
		m.setUpdatedby(100);
		m.setM_reservelocator_id((long) 1000773);//locator chờ xử lý
		m.setValue(value);
		return mw.saveAndFlush(m);
	}
}
