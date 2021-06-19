package com.hdsoft.JptAPI.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;

//import com.hdsoft.JptAPI.controllers.M_MovementLineService;
//import com.hdsoft.webapi.bubbleapi.webservice.M_MovementService;

//@Path("/movementline")
@RestController
@RequestMapping("api/v2/movementline")
public class M_MovementLineResource {
	
//	public static void main(String[] args) {
//		M_MovementLineService.addMovementLine(1038710, 1028787, 1029940, 1227875, 84.0, 1258886, 1251584);
//	}
	@Autowired
	m_locatorRepository ml1;
	@PostMapping
	public void addMovementLine(@RequestParam Integer m_movement_id,
			@RequestParam Integer m_locator_id, @RequestParam Integer m_locatorto_id,
			@RequestParam Integer m_product_id, @RequestParam Double movementQty,
			@RequestParam Integer m_attributeSetInstance_id,
			@RequestParam Integer m_attributeSetInstanceTo_id) {
		M_MovementLineService.addMovementLine(m_movement_id, m_locator_id, m_locatorto_id, m_product_id, movementQty,
				m_attributeSetInstance_id, m_attributeSetInstanceTo_id);
		System.out.println("Successfully");
	}
	@PostMapping
	@RequestMapping("/demo")
	public void addMovementLineDemo(@RequestParam Integer m_movement_id,
			@RequestParam Integer m_locator_id, @RequestParam Integer m_locatorto_id,
			@RequestParam Integer m_product_id, @RequestParam Double movementQty,
			@RequestParam Integer m_attributeSetInstance_id,
			@RequestParam Integer m_attributeSetInstanceTo_id,
			@RequestParam Long ad_client_id, @RequestParam Long ad_org_id,
			@RequestParam Long ad_user_id) {
		M_MovementLineService.addMovementLineDemo(m_movement_id, m_locator_id, m_locatorto_id, m_product_id, movementQty, m_attributeSetInstance_id, m_attributeSetInstanceTo_id, ad_client_id, ad_org_id, ad_user_id);;
		System.out.println("Successfully");
	}
	
	@PostMapping
	@RequestMapping("/demo1")
	public void addMovementLineDemo1(@RequestParam Integer m_movement_id,
			@RequestParam Integer m_locator_id, @RequestParam Integer m_locatorto_id,
			@RequestParam Integer m_product_id, @RequestParam Double movementQty,
			@RequestParam Integer m_attributeSetInstance_id,
			@RequestParam Integer m_attributeSetInstanceTo_id,
			@RequestParam Long ad_client_id, @RequestParam Long ad_org_id,
			@RequestParam Long ad_user_id,@RequestParam Integer uomid,@RequestParam Double qtyentered,@RequestParam String uu) {
		M_MovementLineService.addMovementLineDemo1(m_movement_id, m_locator_id, m_locatorto_id, m_product_id, movementQty, m_attributeSetInstance_id, m_attributeSetInstanceTo_id, ad_client_id, ad_org_id, ad_user_id,uomid,qtyentered,ml1.getOne((long)m_locator_id).getM_warehouse_id(),uu);
		System.out.println("Successfully");
	}
	

}
