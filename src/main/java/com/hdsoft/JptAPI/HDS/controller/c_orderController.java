package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_orderReposotory;
import com.hdsoft.JptAPI.Models.Order;
@RestController
@RequestMapping("api/v1/c_order")
public class c_orderController {
	@Autowired
	C_orderReposotory cor;
	//Get
	
	//POST
	@RequestMapping(method = RequestMethod.POST,value="/updatecloseorder")
	public Order closeOrder(@RequestParam long order_id) {
		Order o = new Order();
		o = cor.findById(order_id);
		o.setDocStatus("CL");
		return cor.saveAndFlush(o);
	}
	@GetMapping
	@RequestMapping("getallkhxh")
	public List<Order> listkhget(@RequestParam long ad_client_id,@RequestParam String issotrx){
		return cor.listKH(ad_client_id, issotrx);
	}
	
}
