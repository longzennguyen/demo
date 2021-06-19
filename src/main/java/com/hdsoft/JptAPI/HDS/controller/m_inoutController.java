package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.SortOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.model.m_inout;
import com.hdsoft.JptAPI.HDS.Repositories.*;

@RestController
@RequestMapping("api/v1/lm_inout")
public class m_inoutController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	m_inoutRepository mRepository;

	// GET
	@GetMapping()
	public List<m_inout> findAll() {
		return mRepository.findAll();
	}

	@GetMapping
	@RequestMapping("/documentno")
	public m_inout maxDocumentNo(@RequestParam String documentno) {
		return mRepository.findByDocumentnoStartingWith(documentno)
				.get(mRepository.findByDocumentnoStartingWith(documentno).size() - 1);
//			return mRepository.getMaxDocument(documentno); 
	}
	@GetMapping
	@RequestMapping("findbyvalueandclient")
	public m_inout findbyvalueandclient(@RequestParam String documentno, @RequestParam long clientid) {
		return mRepository.findByDocumentnoAndAdclientid(documentno,clientid);
	}
	
	//nhap hang
	@GetMapping
	@RequestMapping("getmaxdocumentbyclient")
	public String getmaxbyclient(@RequestParam long client, @RequestParam String documentnoPatterm) {
		if (mRepository.listMInoutDESC(client, documentnoPatterm + "%").size()==0) {
			return "NH-1";
		}else {
			return mRepository.listMInoutDESC(client, documentnoPatterm + "%").get(0).getDocumentno();
		}
		
	}
	//xuat hang
		@GetMapping
		@RequestMapping("getmaxdocumentbyclientxh")
		public String getmaxbyclientXH(@RequestParam long client, @RequestParam String documentnoPatterm) {
			if (mRepository.listMInoutDESC(client, documentnoPatterm + "%").size()==0) {
				return null;
			}else {
				return mRepository.listMInoutDESC(client, documentnoPatterm + "%").get(0).getDocumentno();
			}
			
		}

	// POST
	@RequestMapping(method = RequestMethod.POST, value = "/nhapkho")
	public m_inout insertNewRecord(@RequestParam String documentNo, @RequestParam long c_order_id) {
		m_inout miu = new m_inout();
		miu.setAd_client_id(1000014);
		miu.setId(g.getNextID("M_InOut"));
		miu.setAd_org_id(1000039);
		miu.setC_bpartner_id(1003545);
		miu.setC_doctype_id(1000856);
		miu.setC_invoice_id(null);
		miu.setC_order_id(c_order_id);
		miu.setCreated(g.getDate());
		miu.setM_warehouse_id(1000075);
		miu.setDocstatus("DR");
		miu.setDocumentno(documentNo);
		miu.setCreatedby((long) 1003545);
		miu.setUpdatedby(1003545);
		miu.setDocaction("CL");
		miu.setMovementtype("V+");
		miu.setMovementdate(g.getDate());
		miu.setDateacct(g.getDate());
		miu.setDropship_location_id(null);
		miu.setM_inout_uu(g.getUUID());
		miu.setDeliveryrule('A');
		miu.setIssotrox("N");
		miu.setFreightcostrule('I');
		miu.setDeliveryviarule('P');
		miu.setPriorityrule('5');
		miu.setC_bpartner_location_id((long) 1002144);
		System.out.println(miu.toString());
		return mRepository.saveAndFlush(miu);
	}

	// HDS Base App
	// GET
	@GetMapping
	@RequestMapping("getmaxdocumentbyorg")
	public m_inout getmaxbyorg(@RequestParam long adorgid, @RequestParam String documentnoPatterm) {
		return mRepository.findByAdorgidAndDocumentnoContainingIgnoreCase(adorgid, documentnoPatterm)
				.get(mRepository.findByAdorgidAndDocumentnoContainingIgnoreCase(adorgid, documentnoPatterm).size() - 1);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/create")
	public m_inout createnew(@RequestParam String documentNo, @RequestParam long adorgid,
			@RequestParam long c_bpartner_id, @RequestParam long warehouseid) {
		m_inout miu = new m_inout();
		miu.setAd_client_id(1000003);
		miu.setId(g.getNextID("M_InOut"));
		miu.setAd_org_id(adorgid);
		miu.setC_bpartner_id(c_bpartner_id);
		miu.setC_doctype_id(1000117);
		miu.setC_invoice_id(null);
		miu.setC_order_id(null);
		miu.setCreated(g.getDate());
		miu.setM_warehouse_id(warehouseid);
		miu.setDocstatus("DR");
		miu.setDocumentno(documentNo);
		miu.setCreatedby((long) 100);
		miu.setUpdatedby(100);
		miu.setUpdated(g.getDate());
		miu.setDocaction("CL");
		miu.setMovementtype("V+");
		miu.setMovementdate(g.getDate());
		miu.setIssotrox("N");
		miu.setDateacct(g.getDate());
		miu.setDropship_location_id(null);
		miu.setM_inout_uu(g.getUUID());
		miu.setDeliveryrule('A');
		miu.setFreightcostrule('I');
		miu.setDeliveryviarule('P');
		miu.setPriorityrule('5');
		// get c_bpartner_location_id từ c_order:
		miu.setC_bpartner_location_id((long) 1002144);
		System.out.println(miu.toString());
		return mRepository.saveAndFlush(miu);
	}

	// Thach Ban
	@GetMapping
	@RequestMapping("demo")
	public List<m_inout> listAllKH() {
		return mRepository.findByAdclientid(1000000);
	}
	
	@GetMapping
	@RequestMapping("/findbyclient")
	public List<m_inout> listAllKH1(@RequestParam long clientid) {
		
		return mRepository.findByAdclientid(clientid);
		
	}

	// nhap kho
	@RequestMapping(method = RequestMethod.POST, value = "/createdocumentnotb")
	public m_inout createnewXKTB(@RequestParam String documentNo, @RequestParam long adorgid,
			@RequestParam long c_bpartner_id, @RequestParam long mwarehouseid) {
		m_inout miu = new m_inout();
		miu.setAd_client_id(1000000);
		miu.setId(g.getNextID("M_InOut"));
		miu.setAd_org_id(adorgid);
		miu.setC_bpartner_id(c_bpartner_id);
		miu.setC_doctype_id(1000014);
		miu.setC_invoice_id(null);
		miu.setC_order_id(null);
		miu.setCreated(g.getDate());
		miu.setM_warehouse_id(mwarehouseid);
		miu.setDocstatus("DR");
		miu.setDocumentno(documentNo);
		miu.setCreatedby((long) 100);
		miu.setUpdatedby(100);
		miu.setUpdated(g.getDate());
		miu.setDocaction("CL");
		miu.setMovementtype("V+");
		miu.setMovementdate(g.getDate());
		miu.setDateacct(g.getDate());
		miu.setDropship_location_id(null);
		miu.setM_inout_uu(g.getUUID());
		miu.setDeliveryrule('A');
		miu.setIssotrox("N");
		miu.setFreightcostrule('I');
		miu.setDeliveryviarule('P');
		miu.setPriorityrule('5');
		// get c_bpartner_location_id từ c_order:
		miu.setC_bpartner_location_id((long) 1002144);
		System.out.println(miu.toString());
		return mRepository.saveAndFlush(miu);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/createdocumentnobyclient")
	public m_inout createnewXKAllClient(@RequestParam String documentNo,
			@RequestParam long adorgid,
			@RequestParam long c_bpartner_id,
			@RequestParam long mwarehouseid,
			@RequestParam long adclientid,
			@RequestParam long doctypeid,
			@RequestParam long cbpartnerlocation) {
		m_inout miu = new m_inout();
		miu.setAd_client_id(adclientid);
		miu.setId(g.getNextID("M_InOut"));
		miu.setAd_org_id(adorgid);
		miu.setC_bpartner_id(c_bpartner_id);
		miu.setC_doctype_id(doctypeid);
		miu.setC_invoice_id(null);
		miu.setC_order_id(null);
		miu.setCreated(g.getDate());
		miu.setM_warehouse_id(mwarehouseid);
		miu.setDocstatus("DR");
		miu.setDocumentno(documentNo);
		miu.setCreatedby((long) 100);
		miu.setUpdatedby(100);
		miu.setUpdated(g.getDate());
		miu.setDocaction("CL");
		miu.setMovementtype("V+");
		miu.setMovementdate(g.getDate());
		miu.setDateacct(g.getDate());
		miu.setDropship_location_id(null);
		miu.setM_inout_uu(g.getUUID());
		miu.setDeliveryrule('A');
		miu.setIssotrox("N");
		miu.setFreightcostrule('I');
		miu.setDeliveryviarule('P');
		miu.setPriorityrule('5');
		// get c_bpartner_location_id từ c_order:
		miu.setC_bpartner_location_id((long) cbpartnerlocation);
		System.out.println(miu.toString());
		return mRepository.saveAndFlush(miu);
	}

	// HDS TB App
	@RequestMapping(method = RequestMethod.POST, value = "/createxk")
	public m_inout createnewXK(@RequestParam String documentNo, @RequestParam long adorgid,
			@RequestParam long c_bpartner_id) {
		m_inout miu = new m_inout();
		miu.setAd_client_id(1000000);
		miu.setId(g.getNextID("M_InOut"));
		miu.setAd_org_id(adorgid);
		miu.setC_bpartner_id(c_bpartner_id);
		miu.setC_doctype_id(1000011);
		miu.setC_invoice_id(null);
		miu.setC_order_id(null);
		miu.setCreated(g.getDate());
		miu.setM_warehouse_id(1000000);
		miu.setDocstatus("CO");
		miu.setDocumentno(documentNo);
		miu.setCreatedby((long) 100);
		miu.setUpdatedby(100);
		miu.setUpdated(g.getDate());
		miu.setDocaction("CL");
		miu.setMovementtype("C-");
		miu.setMovementdate(g.getDate());
		miu.setDateacct(g.getDate());
		miu.setDropship_location_id(null);
		miu.setM_inout_uu(g.getUUID());
		miu.setDeliveryrule('A');
		miu.setFreightcostrule('I');
		miu.setIssotrox("Y");
		miu.setDeliveryviarule('P');
		miu.setPriorityrule('5');
		// get c_bpartner_location_id từ c_order:
		miu.setC_bpartner_location_id((long) 1002144);
		System.out.println(miu.toString());
		return mRepository.saveAndFlush(miu);
	}
	
	//xh all client
	@RequestMapping(method = RequestMethod.POST, value = "/createxkallclient")
	public m_inout createnewXKAllClient1(
			@RequestParam String documentNo,
			@RequestParam long adorgid,
			@RequestParam long c_bpartner_id,
			@RequestParam long clientid,
			@RequestParam long doctypeid,
			@RequestParam long warehouseid,
			@RequestParam long cbpartnerlocationid) {
		m_inout miu = new m_inout();
		miu.setAd_client_id(clientid);
		miu.setId(g.getNextID("M_InOut"));
		miu.setAd_org_id(adorgid);
		miu.setC_bpartner_id(c_bpartner_id);
		miu.setC_doctype_id(doctypeid);
		miu.setC_invoice_id(null);
		miu.setC_order_id(null);
		miu.setCreated(g.getDate());
		miu.setM_warehouse_id(warehouseid);
		miu.setDocstatus("CO");
		miu.setDocumentno(documentNo);
		miu.setCreatedby((long) 100);
		miu.setUpdatedby(100);
		miu.setUpdated(g.getDate());
		miu.setDocaction("CL");
		miu.setMovementtype("C-");
		miu.setMovementdate(g.getDate());
		miu.setDateacct(g.getDate());
		miu.setDropship_location_id(null);
		miu.setM_inout_uu(g.getUUID());
		miu.setDeliveryrule('A');
		miu.setFreightcostrule('I');
		miu.setIssotrox("Y");
		miu.setDeliveryviarule('P');
		miu.setPriorityrule('5');
		// get c_bpartner_location_id từ c_order:
		miu.setC_bpartner_location_id((long) cbpartnerlocationid);
		System.out.println(miu.toString());
		return mRepository.saveAndFlush(miu);
	}

	// Update đóng KH
	@PutMapping
	@RequestMapping("/closekh")
	public m_inout updateStatus(@RequestParam long id) {
		m_inout m1 = new m_inout();
		m1 = mRepository.getOne(id);
		m1.setDocstatus("CO");
		return mRepository.saveAndFlush(m1);
	}

}
