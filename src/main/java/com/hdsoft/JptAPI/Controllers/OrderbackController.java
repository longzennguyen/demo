package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.Orderback;
import com.hdsoft.JptAPI.Models.Orderline;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/backorder")
public class OrderbackController {

	@Autowired
	OrderlineRepository orderlineRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping
	@RequestMapping("/{orderId}")
	public List<Orderback> findOrderback(@PathVariable long orderId) {
		List<Orderback> result = new ArrayList<Orderback>();
		List<Orderline> listOrderline = orderlineRepo.findByOrderID(orderId);
		for (Orderline orderline : listOrderline) {
			long productId = orderline.getSanPham();
			Orderback orderback = new Orderback();
			orderback.setOrderId(orderId);
			orderback.setOrderlineId(orderline.getId());
			orderback.setProductId(productId);
			orderback.setProductName(productRepo.getOne(productId).getName());
			orderback.setQty(orderline.getSoLuong());
			result.add(orderback);
		}
		return result;
	}
}
