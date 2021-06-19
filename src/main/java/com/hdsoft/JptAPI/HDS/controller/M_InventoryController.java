package com.hdsoft.JptAPI.HDS.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.M_InventoryRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_WarehouseRepository;
import com.hdsoft.JptAPI.HDS.model.M_Inventory;

@RestController
@RequestMapping("api/v1/m_inventory")
public class M_InventoryController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	M_InventoryRepository mirInventoryRepository;
	@Autowired
	M_WarehouseRepository mw1;
	@GetMapping
	public List<M_Inventory> findTopByDocumentno() {
		return mirInventoryRepository.findAllByAdclientid(1000014);
	}
	@GetMapping
	@RequestMapping("/checkinventoryinday")
	public M_Inventory checkInDayProcess(@RequestParam String date,@RequestParam long m_warehouse_id) {
		return mirInventoryRepository.getInDayProcess(Timestamp.valueOf(date+" 00:00:01"),Timestamp.valueOf(date+" 23:59:59"), m_warehouse_id);
	}
	
	//Kiem kho Thach Ban
	@PostMapping
	@RequestMapping("/createkiemkho")
	public M_Inventory createInventory(@RequestParam String documentno,@RequestParam long warehouseid) {
		M_Inventory m_Inventory = new M_Inventory();
		m_Inventory.setAd_client_id((long) mw1.getOne(warehouseid).getAdclientid());
		m_Inventory.setAd_org_id((long) mw1.getOne(warehouseid).getAdorgid());
		m_Inventory.setCreated(g.getDate());
		m_Inventory.setUpdated(g.getDate());
		m_Inventory.setUpdatedby(100);
		m_Inventory.setCreatedby(100);
		m_Inventory.setMovementdate(g.getDate());
		m_Inventory.setDocstatus("DR");
		m_Inventory.setDocaction("CO");
		m_Inventory.setC_doctype_id(1000023);
		m_Inventory.setId(g.getNextID("M_Inventory"));
		m_Inventory.setM_Inventory_uu(g.getUUID());
		m_Inventory.setDocumentno(documentno);
		m_Inventory.setM_warehouse_id(warehouseid);
		m_Inventory.setProcessing("N");
		m_Inventory.setGeneratelist("N");
		m_Inventory.setApprovalamt(0);
		return mirInventoryRepository.saveAndFlush(m_Inventory);
	}
	// create alklk client
	@PostMapping
	@RequestMapping("/createkiemkhoallclient")
	public M_Inventory createInventoryallclient(@RequestParam String documentno,@RequestParam long warehouseid,@RequestParam long doctypeid) {
		M_Inventory m_Inventory = new M_Inventory();
		m_Inventory.setAd_client_id((long) mw1.getOne(warehouseid).getAdclientid());
		m_Inventory.setAd_org_id((long) mw1.getOne(warehouseid).getAdorgid());
		m_Inventory.setCreated(g.getDate());
		m_Inventory.setUpdated(g.getDate());
		m_Inventory.setUpdatedby(100);
		m_Inventory.setCreatedby(100);
		m_Inventory.setMovementdate(g.getDate());
		m_Inventory.setDocstatus("DR");
		m_Inventory.setDocaction("CO");
		m_Inventory.setC_doctype_id(doctypeid);
		m_Inventory.setId(g.getNextID("M_Inventory"));
		m_Inventory.setM_Inventory_uu(g.getUUID());
		m_Inventory.setDocumentno(documentno);
		m_Inventory.setM_warehouse_id(warehouseid);
		m_Inventory.setProcessing("N");
		m_Inventory.setGeneratelist("N");
		m_Inventory.setApprovalamt(0);
		return mirInventoryRepository.saveAndFlush(m_Inventory);
	}
	//Get max documentno của m_inventory dùng cho mọi client , mọi dạng documentno
	@GetMapping
	@RequestMapping("getmaxdocumentno")
	public M_Inventory getMaxDocumentNo(@RequestParam String documentno) {
		if(mirInventoryRepository.findByDocumentnoStartsWith(documentno).size()==0) {
			return null;
		}else {
			return mirInventoryRepository.findByDocumentnoStartsWith(documentno).get(mirInventoryRepository.findByDocumentnoStartsWith(documentno).size()-1);
		}
	}
	
}
