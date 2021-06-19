 package com.hdsoft.JptAPI.Controllers;

import java.sql.Date;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Controllers.M_MovementService;

@RestController
@RequestMapping("api/v2/movement")
public class M_MovementResource {
	

	@PutMapping
	public void updateMovementSuccessfully(@RequestParam String documentNo, @RequestParam long m_movement_id) {
		M_MovementService.updateMovementSuccessfully(documentNo, m_movement_id);
		System.out.println("Succesfully !!!!!!");
	}
	
	@PostMapping
	@RequestMapping("/insertmovement")
	public void insertMovement(@RequestParam String documentNo, @RequestParam Date movementDate) {
		M_MovementService.createMovement(documentNo, movementDate);
		System.out.println("Succesfully !!!!!!");
	}
	
	@PostMapping
	@RequestMapping("/demo/insertmovement")
	public void insertMovement(@RequestParam String documentNo, @RequestParam Date movementDate,
			@RequestParam Long ad_client_id, @RequestParam Long ad_org_id, @RequestParam Long ad_user_id,@RequestParam long m_warehouse_id) {
		M_MovementService.createMovementDemo(documentNo, movementDate, ad_client_id, ad_org_id, ad_user_id,m_warehouse_id);;
		System.out.println("Succesfully !!!!!!");
	}
	
	@PostMapping
	@RequestMapping("/insertrack")
	public void insertMovementRack(@RequestParam Date movementDate) {
		M_MovementService.createMovementRack(movementDate);
		System.out.println("Succesfully !!!!!!");
	}
	
	@PostMapping
	@RequestMapping("/insertreceiving")
	public void insertMovementReceiving(@RequestParam Date movementDate) {
		M_MovementService.createMovementReceiving(movementDate);
		System.out.println("Succesfully !!!!!!");
	}
	
	@PostMapping
	@RequestMapping("/insertvanning")
	public void insertMovementVanning(@RequestParam int c_order_id, @RequestParam String documentNo
			, @RequestParam Date movementDate) {
		M_MovementService.createMovementVanning(c_order_id, documentNo, movementDate);
	}
	
	@PostMapping
	@RequestMapping("/insertvanningtorack")
	public void insertMovementVanningToRack(@RequestParam int c_order_id, @RequestParam String documentNo
			, @RequestParam Date movementDate) {
		M_MovementService.createMovementVanningToRack(c_order_id, documentNo, movementDate);
	}
	
}
