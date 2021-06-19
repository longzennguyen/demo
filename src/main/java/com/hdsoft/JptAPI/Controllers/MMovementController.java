package com.hdsoft.JptAPI.Controllers;

import java.sql.Timestamp;
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

import com.hdsoft.JptAPI.HDS.controller.GetIDUUDate;
import com.hdsoft.JptAPI.Models.MMovement;
import com.hdsoft.JptAPI.Repositories.MMovementRepository;

@RestController
@RequestMapping("/api/v1/movement")
public class MMovementController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	private MMovementRepository mMovementRepository;

	@GetMapping
	public List<MMovement> listAll() {
		return mMovementRepository.findAll();
	}

	@GetMapping
	@RequestMapping("/tantruong")
	public List<MMovement> findByTanTruong() {
		List<MMovement> result = new ArrayList<>();
		List<MMovement> findByDocumentNo = mMovementRepository.findAll();
		for (MMovement movement : findByDocumentNo) {
			if (movement.getAd_client_id() == 1000010) {
				result.add(movement);
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/{documentNo}")
	public MMovement findMaxDocumentNo(@PathVariable String documentNo) {
		return mMovementRepository.findByDocumentnoStartingWithOrderByCreatedDesc(documentNo).get(0);
	}

	@GetMapping
	@RequestMapping("/documentno/{documentNo}")
	public List<MMovement> findByDocumentNo(@PathVariable String documentNo) {
		return mMovementRepository.findByDocumentno(documentNo);
	}
	
	@GetMapping
	@RequestMapping("getdocumentnofocuspattern")
	public String getDocumentNo(@RequestParam String documentno,@RequestParam long clientid) {
		if (mMovementRepository.findbydocumentofmaxid(clientid, documentno+"%").size()==0) {
			return null;
		}else {
			return mMovementRepository.findbydocumentofmaxid(clientid, documentno+"%").get(0).getDocumentno();
		}
		
	}
	
	@GetMapping
	@RequestMapping("/findbyorderid/{orderId}")
	public List<MMovement> findByOrderId(@PathVariable long orderId) {
		return mMovementRepository.findByOrderId(orderId);
	}

	@GetMapping
	@RequestMapping("/getmaxID")
	public long maxMovementID() {
		return mMovementRepository.findTopByOrderByMovementIDDesc().getMovementID();
	}

	@GetMapping
	@RequestMapping("getmaxdocumentno")
	public MMovement getMaxDocumentNo(@RequestParam String documentno) {
		if (mMovementRepository.findByDocumentnoStartsWith(documentno).size() == 0)
			return null;
		else
			return mMovementRepository.findByDocumentnoStartsWith(documentno)
					.get(mMovementRepository.findByDocumentnoStartsWith(documentno).size() - 1);
	}

	// POST - Long Zen Nguyen
	@RequestMapping(method = RequestMethod.POST, value = "/createnewdocumentno")

	public MMovement createnewdocumentno(@RequestParam String documentno) {
		MMovement m = new MMovement();
		m.setMovementID(g.getNextID("M_Movement"));
		m.setAd_client_id(1000014);
		m.setAd_org_id(1000039);
		m.setCreated(g.getDate());
		m.setDoctypeId(1000864);// default
		m.setDocumentNo(documentno);
		m.setMovementDate(g.getDate());
		m.setOrderId(null);
		m.setCreatedby(1000080);
		m.setStatus("01");
		m.setM_movement_uu(g.getUUID());
		m.setUpdatedby(1000080);
		m.setUpdated(g.getDate());
		m.setDocstatus("CL");
		m.setDocaction("CL");
		return mMovementRepository.saveAndFlush(m);
	}

	// HDS Base APp
	@GetMapping
	@RequestMapping("getdocumentno")
	public MMovement getMaxDocumentNo1(@RequestParam String documentno,@RequestParam long adorgid) {
		if (mMovementRepository.findByAdorgidAndDocumentnoStartsWith(adorgid,documentno).size() == 0)
			return null;
		else
			return mMovementRepository.findByAdorgidAndDocumentnoStartsWith(adorgid,documentno)
					.get(mMovementRepository.findByAdorgidAndDocumentnoStartsWith(adorgid,documentno).size() - 1);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/create1")
	public MMovement createnetno(@RequestParam String documentno,@RequestParam long adorgid) {
		MMovement m = new MMovement();
		m.setMovementID(g.getNextID("M_Movement"));
		m.setAd_client_id(1000003);
		m.setAd_org_id(adorgid);
		m.setCreated(g.getDate());
		m.setDoctypeId(1000125);// default
		m.setDocumentNo(documentno);
		m.setMovementDate(g.getDate());
		m.setOrderId(null);
		m.setCreatedby(100);
		m.setStatus("01");
		m.setM_movement_uu(g.getUUID());
		m.setUpdatedby(100);
		m.setUpdated(g.getDate());
		m.setDocstatus("DR");
		m.setDocaction("CO");
		return mMovementRepository.saveAndFlush(m);
	}
}
