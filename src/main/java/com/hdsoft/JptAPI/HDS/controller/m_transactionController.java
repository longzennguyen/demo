package com.hdsoft.JptAPI.HDS.controller;

import java.security.cert.CollectionCertStoreParameters;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.model.TransactionInformation;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.HDS.model.m_transaction;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutlineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_transactionRepository;

import javassist.bytecode.Mnemonic;


@RestController
@RequestMapping("api/v1/m_transaction")
public class m_transactionController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	m_transactionRepository mtr;
	@Autowired
	m_locatorRepository ml;
	@Autowired
	m_attributesetinstanceRepository atr;
	@Autowired
	m_productRepository mpr;
	public m_transactionController() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping
	public m_transaction findAll(){
		List<m_transaction> listDisplay = new ArrayList<m_transaction>();
		listDisplay = mtr.findAll();
		Collections.sort(listDisplay);
		System.out.println("AHAHAHHAHAHAHAHAHAAH: " + mtr.findByOrderByIdDesc().size()+" ID: "+mtr.findByOrderByIdDesc().get(0).getId() );

		return mtr.getOne(listDisplay.get(0).getId());
	}
	@GetMapping
	@RequestMapping("/getmaxid/")
	public m_transaction findGreatThan(){
		return mtr.findTopByOrderByIdDesc();
	}
	
	
	
						//POST
	//Chuyển đến
	@RequestMapping(method = RequestMethod.POST,value="/movement/nhapkho")
	public m_transaction createdNewRecord(@RequestParam long m_locator_id,
			@RequestParam long m_product_id,@RequestParam double movementqty,
			@RequestParam Long m_inoutline_id,
			@RequestParam long m_attributesetinstance_id,
			@RequestParam String movementtype ) {
		m_transaction m = new m_transaction();
//		long id = nextID2();
		m.setId(g.getNextID("M_Transaction"));
		m.setAd_client_id((long) 1000014);
		m.setAd_org_id((long) 1000039);
		m.setCreated(g.getDate());
		m.setCreatedby((long) 1000080);
		m.setM_transaction_uu(g.getUUID());
		m.setUpdated(g.getDate());
		m.setUpdatedby((long) 1000080);
		m.setM_locator_id(m_locator_id);
		m.setM_product_id(m_product_id);
		m.setMovementdate(g.getDate());
		m.setMovementqty(movementqty);
		m.setM_inoutline_id(m_inoutline_id);
		m.setM_attributesetinstance_id(m_attributesetinstance_id);
		m.setMovementtype(movementtype);
		return mtr.save(m);
	}
	
	//HDS Base APP
	//GET
	@GetMapping
	@RequestMapping("giaodich")
	public List<TransactionInformation> TransactionShow(@RequestParam long productid,@RequestParam Long orgid){
		List<TransactionInformation> listshow =  new ArrayList<TransactionInformation>();
		
		for (m_transaction mt : mtr.findTop100ByAdclientidAndAdorgidAndMproductidOrderByCreatedDesc(1000003,orgid,productid)) {
			TransactionInformation ti = new TransactionInformation();
			ti.setCreated(Timestamp.valueOf(mt.getCreated().toString()));
			ti.setLocatorName(ml.findByIdAndAdorgid(mt.getM_locator_id(), orgid).getValue());
			ti.setLot(atr.getOne(mt.getM_attributesetinstance_id()).getLot());
			ti.setM_attributesetinstance_id(mt.getM_attributesetinstance_id());
			ti.setM_locator_id(mt.getM_locator_id());
			ti.setM_product_id(mt.getM_product_id());
			ti.setM_transaction_id(mt.getId());
			ti.setMovementdate(mt.getMovementdate());
			ti.setMovementqty(mt.getMovementqty());
			//
			String movementT = "";
			if(mt.getMovementtype().equals("V+")) {
				movementT = "Nhận từ NCC";//Material receipt
			}else if(mt.getMovementtype().equals("V-")) {
				movementT="Trả lại NCC";// Vendor Return
			}else if(mt.getMovementtype().equals("M+"))
				movementT = "Chuyển tới";
			else if(mt.getMovementtype().equals("M-"))
				movementT = "Chuyển đi";
			else if(mt.getMovementtype().equals("P+"))
				movementT = "Sản xuất ra";
			else if (mt.getMovementtype().equals("P-"))
				movementT = "Đưa vào SX";
			else {
				movementT = mt.getMovementtype();
			}
			ti.setMovementtype(movementT);
			ti.setProductName(mpr.getOne(mt.getM_product_id()).getValue());
			listshow.add(ti);
			//
		}
		return listshow;
	}
	//POST
	//Tạo giao dịch
	@RequestMapping(method = RequestMethod.POST,value="/move")
	public m_transaction createdGD(@RequestParam long m_locator_id,
			@RequestParam long m_product_id,@RequestParam double movementqty,
			@RequestParam String movementtype,@RequestParam long adorgid ) {
		m_transaction m = new m_transaction();
//		long id = nextID2();
		m.setId(g.getNextID("M_Transaction"));
		m.setAd_client_id((long) 1000003);
		m.setAd_org_id((long) adorgid);
		m.setCreated(g.getDate());
		m.setCreatedby((long) 100);
		m.setM_transaction_uu(g.getUUID());
		m.setUpdated(g.getDate());
		m.setUpdatedby((long) 100);
		m.setM_locator_id(m_locator_id);
		m.setM_product_id(m_product_id);
		m.setMovementdate(g.getDate());
		m.setMovementqty(movementqty);
		m.setM_inoutline_id(null);
		m.setM_attributesetinstance_id((long) 1354623);
		m.setMovementtype(movementtype);
		return mtr.saveAndFlush(m);
	}
}
