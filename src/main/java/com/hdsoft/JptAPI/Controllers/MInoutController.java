package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.model.m_inout;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.Models.MInout;
import com.hdsoft.JptAPI.Models.MInoutLine;
import com.hdsoft.JptAPI.Repositories.MInoutLineRepository;
import com.hdsoft.JptAPI.Repositories.MInoutRepository;
import com.hdsoft.JptAPI.Repositories.OrderRepository;

@RestController
@RequestMapping("/api/v1/minout")
public class MInoutController {
	
	@Autowired
	private MInoutRepository minoutRepository;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private MInoutLineRepository minoutlineRepo;
	
	@GetMapping
	public List<MInout> listAll() {
		return minoutRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/{documentNo}")
	public MInout findByDocumentNo(@PathVariable String documentNo) {
		int size = minoutRepository.findByDocumentNoStartingWithOrderByDocumentNo(documentNo).size();
		return minoutRepository.findByDocumentNoStartingWithOrderByDocumentNo(documentNo).get(size - 1);
	}
	
	@GetMapping
	@RequestMapping("/orderid/{orderId}")
	public List<MInout> findByOrderId(@PathVariable long orderId) {
		return minoutRepository.findByOrderId(orderId);
	}
	@GetMapping
	@RequestMapping("/demo1")
	public List<MInoutLine> a1(){
		return minoutlineRepo.findAllByMaterialID(1064064);
	}
	@GetMapping
	@RequestMapping("/demo")
	public List<MInout> findAllDemo() {
		List<MInout> result = new ArrayList<>();
		List<MInout> listInout = minoutRepository.findByClientIdAndDoctypeIDAndDocStatus(1000000, 1000011, "CO");
		for (MInout inout : listInout) {
			Double qtyOrder = 0.0;
			Double qtyMovement = 0.0;
			System.out.println("ID:"+inout.getMaterialID());
			List<MInoutLine> listInoutline = new ArrayList<MInoutLine>();
			System.out.println("inoutid: "+inout.getMaterialID());
			listInoutline = minoutlineRepo.findAllByMaterialID(inout.getMaterialID());
			System.out.println("Size: "+listInoutline.size());
			for (MInoutLine inoutLine : listInoutline) {
				if (inoutLine.getQuantity()==null) {
					inoutLine.setQuantity(0.0);
				}
				if (inoutLine.getQtyCheck()==null) {
					inoutLine.setQtyCheck(0.0);
				}
				qtyOrder = qtyOrder + inoutLine.getQuantity();
				qtyMovement = qtyMovement + inoutLine.getQtyCheck();
			}
			if (qtyOrder - qtyMovement != 0.0) {
				if (inout.getOrderId()==null) {
					
				}else {
				System.out.println("inout: "+inout.getOrderId());
				inout.setNgayDatHang(orderRepo.getOne(inout.getOrderId()).getNgayDatHang());
				}
				result.add(inout);
			}
		}
		return result;
	}
	//get m_inout by ad_client_id
	@GetMapping
	@RequestMapping("/getallctxh")
	public List<MInout> findAllByClient(@RequestParam long ad_client_id,@RequestParam long  doctypeid) {
		List<MInout> result = new ArrayList<>();
		List<MInout> listInout = minoutRepository.findByClientIdAndDoctypeIDAndDocStatus(ad_client_id, doctypeid, "CO");
		for (MInout inout : listInout) {
			Double qtyOrder = 0.0;
			Double qtyMovement = 0.0;
			System.out.println("ID:"+inout.getMaterialID());
			List<MInoutLine> listInoutline = new ArrayList<MInoutLine>();
			System.out.println("inoutid: "+inout.getMaterialID());
			listInoutline = minoutlineRepo.findAllByMaterialID(inout.getMaterialID());
			System.out.println("Size: "+listInoutline.size());
			for (MInoutLine inoutLine : listInoutline) {
				if (inoutLine.getQuantity()==null) {
					inoutLine.setQuantity(0.0);
				}
				if (inoutLine.getQtyCheck()==null) {
					inoutLine.setQtyCheck(0.0);
				}
				qtyOrder = qtyOrder + inoutLine.getQuantity();
				qtyMovement = qtyMovement + inoutLine.getQtyCheck();
			}
			if (qtyOrder - qtyMovement != 0.0) {
				if (inout.getOrderId()==null) {
					
				}else {
				System.out.println("inout: "+inout.getOrderId());
				inout.setNgayDatHang(orderRepo.getOne(inout.getOrderId()).getNgayDatHang());
				}
				result.add(inout);
			}
		}
		return result;
	}
	
}
