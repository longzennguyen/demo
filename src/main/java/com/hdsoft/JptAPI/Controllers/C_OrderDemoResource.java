package com.hdsoft.JptAPI.Controllers;

import java.sql.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v2/orderdemo")
public class C_OrderDemoResource {

	
	@PostMapping
	public void insertOrder(@RequestParam String documentNo,
			@RequestParam String description,@RequestParam  long c_bpartner_id, 
			@RequestParam Date dateOrder,@RequestParam  Date datePromised, 
			@RequestParam long ad_client_id, @RequestParam long ad_org_id, 
			@RequestParam long ad_user_id) {
		new OrderDAO().addOrderDemo(documentNo, description, c_bpartner_id, dateOrder, datePromised, ad_client_id, ad_org_id, ad_user_id);
	}
	
	@PostMapping
	@RequestMapping("/line")
	public void insertOrderline(@RequestParam long c_order_id, 
			@RequestParam long m_product_id,@RequestParam  double qty, 
			@RequestParam long ad_client_id,@RequestParam  long ad_org_id, 
			@RequestParam long ad_user_id,@RequestParam Date dateOrder,
			@RequestParam Date datePromised) {
		new OrderlineDAO().addOrderline(c_order_id, m_product_id, qty, ad_client_id, ad_org_id, ad_user_id, dateOrder, datePromised);
	}
	
}
