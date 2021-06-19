package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.model.M_InoutLineInforChiThiXuatKhoTB;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.Models.MInout;
import com.hdsoft.JptAPI.Models.Orderline;
import com.hdsoft.JptAPI.Repositories.MInoutLineRepository;
import com.hdsoft.JptAPI.Repositories.MInoutRepository;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;

@RestController
@RequestMapping("/api/v1/orderline")
public class OrderlineController {

	@Autowired
	private OrderlineRepository orderlineRepository;

	@Autowired
	private MInoutRepository inoutRepository;

	@Autowired
	private MInoutLineRepository inoutLineRepository;

	@Autowired
	private m_productRepository productRepo;
	@GetMapping
	public List<Orderline> findAll() {
		return orderlineRepository.findAll();
	}
	
	@GetMapping
	@RequestMapping("/check/{orderId}")
	public List<Orderline> findByOrderCheckQuan(@PathVariable long orderId) {
		List<Orderline> listOrderLineOfOrder = orderlineRepository.findByOrderID(orderId);
		List<MInout> listInoutOfOrder = inoutRepository.findByOrderId(orderId);
		List<Orderline> result = new ArrayList<Orderline>();
		for (MInout inout : listInoutOfOrder) {
			for (Orderline orderLine : listOrderLineOfOrder) {
				try {
					Double quan = orderLine.getSoLuong() - inoutLineRepository
							.findByProductIDAndMaterialID(orderLine.getSanPham(), inout.getMaterialID()).get(0)
							.getQuantity();
					orderLine.setSoLuong(quan);
					result.add(orderLine);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		if (result.isEmpty()) {
			return orderlineRepository.findByOrderID(orderId);
		} else
			return result;
	}

	@GetMapping
	@RequestMapping("/current/{orderId}")
	public List<Orderline> findByOrderCurrent(@PathVariable long orderId) {
		List<Orderline> listOrderLineOfOrder = orderlineRepository.findByOrderID(orderId);
		List<MInout> listInoutOfOrder = inoutRepository.findByOrderId(orderId);
		List<Orderline> result = new ArrayList<Orderline>();
		for (MInout inout : listInoutOfOrder) {
			for (Orderline orderLine : listOrderLineOfOrder) {
				try {
					Double quan = inoutLineRepository
							.findByProductIDAndMaterialID(orderLine.getSanPham(), inout.getMaterialID()).get(0)
							.getQuantity();
					orderLine.setSoLuong(quan);
					result.add(orderLine);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		if (result.isEmpty()) {
			return orderlineRepository.findByOrderID(orderId);
		} else
			return result;
	}

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<Orderline> findByOrder(@PathVariable long orderId) {
		return orderlineRepository.findByOrderID(orderId);
	}
	
	
	@GetMapping
	@RequestMapping("/getbyneworder")
	public List<Orderline> findByOrderAndProduct(@RequestParam long orderId, @RequestParam long productId) {
		return orderlineRepository.findByOrderIDAndSanPham(orderId, productId);
	}

	////////////////////Long Zen Nguyen Yazaki API/////////////////////
	@GetMapping
	@RequestMapping("/findbyinvoicelot")
	public List<Orderline> findByInvoicenoAndOrdernoAndLot(@RequestParam String invoiceno,@RequestParam String lot,@RequestParam long orderID){
		System.out.println("findByInvoicenoAndOrdernoAndLot");
		return orderlineRepository.findByInvoicenoAndLotAndOrderID(invoiceno,lot,orderID);
	}
	
	@GetMapping
	@RequestMapping("/findbyinvoiceordernosanpham")
	public List<Orderline> findByInvoicenoAndOrdernoAndSanPham(@RequestParam String invoiceno, @RequestParam long sanPham,@RequestParam long orderID){
		return orderlineRepository.findByInvoicenoAndSanPhamAndOrderID(invoiceno, sanPham,orderID);
	}
	
	////////////////////////////////////////
}
