package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Order;
import com.hdsoft.JptAPI.Repositories.OrderRepository;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public List<Order> listAll() {
		return orderRepository.findAll();
	}

	@GetMapping
	@RequestMapping("/{khoHang}")
	public List<Order> findByID(@PathVariable int khoHang) {
		List<Order> result = new ArrayList<>();
		List<Order> findByKhoHang = orderRepository.findByKhoHang(khoHang);
		for (Order order : findByKhoHang) {
			if (order.getDocStatus().equalsIgnoreCase("CO") && order.getDoctypeId() == 1000658 && !order.getDocStatus().equalsIgnoreCase("CL")) {
				result.add(order);
			}
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/demo/{khoHang}")
	public List<Order> findByIDDemo(@PathVariable int khoHang) {
		List<Order> result = new ArrayList<>();
		List<Order> findByKhoHang = orderRepository.findByKhoHang(khoHang);
		for (Order order : findByKhoHang) {
			if (order.getDocStatus().equalsIgnoreCase("CO") && order.getDoctypeId() == 1000016 && !order.getDocStatus().equalsIgnoreCase("CL")) {
				result.add(order);
			}
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/demo/getorderid/{soChungTu}")
	public Order findDemoByDocumentNo(@PathVariable String soChungTu) {
		return orderRepository.findBySoChungTu(soChungTu);
	}

	@GetMapping
	@RequestMapping("search/backorder")
	public List<Order> findBackOrder() {
		List<Order> result = new ArrayList<>();
		List<Order> findByKhoHang = orderRepository.findByKhoHang(1000034);
		for (Order order : findByKhoHang) {
			try {
				if (order.getIsback().equalsIgnoreCase("Y") && !order.getDocStatus().equalsIgnoreCase("CL")) {
					result.add(order);
				}
			} catch (Exception e) {
				
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("search/closeorder/")
	public List<Order> findByID() {
		List<Order> result = new ArrayList<>();
		List<Order> findByKhoHang = orderRepository.findByKhoHang(1000034);
		for (Order order : findByKhoHang) {
			if (order.getDocStatus().equalsIgnoreCase("CL") && order.getDoctypeId() == 1000658) {
				result.add(order);
			}
		}
		return result;
	}
	@GetMapping
	@RequestMapping("/listnh/")
	public List<Order> ListOrderNH(){
		List<Order> listAll = new ArrayList<Order>();
		for(Order order : orderRepository.findAll()) {
			if(order.getAd_client_id()==1000014 && order.getDoctypeId()==1000858 && order.getDocStatus().equals("CO")) {
				listAll.add(order);
			}
		}
		return listAll;
	}
	
	//List all kế hoạch xuất hàng( khxh cos doctypeID = 0) docstatus DR là nháp CO là hoàn thành CL là đóng
		@GetMapping
		@RequestMapping("listxh/")
		public List<Order> ListOrderXH(){
			List<Order> listAll = new ArrayList<Order>();
			for(Order order : orderRepository.findAll()) {
				if(order.getAd_client_id()==1000014 && order.getDoctypeId()==0 && order.getDocStatus().equals("CO")) {
					listAll.add(order);
				}
			}
			return listAll;
		}
}
