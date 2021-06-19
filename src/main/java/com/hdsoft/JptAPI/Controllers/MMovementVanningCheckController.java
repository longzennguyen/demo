package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MMovement;
import com.hdsoft.JptAPI.Models.MMovementLine;
import com.hdsoft.JptAPI.Models.MMovementVanningCheck;
import com.hdsoft.JptAPI.Models.Orderline;
import com.hdsoft.JptAPI.Models.ProductMovement;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.MMovementLineRepository;
import com.hdsoft.JptAPI.Repositories.MMovementRepository;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RequestMapping("/api/v1/movementvanning")
@RestController
public class MMovementVanningCheckController {

	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	MAttributeSetInstanceRepository attributeRepo;

	@Autowired
	OrderlineRepository orderlineRepo;

	@Autowired
	MMovementRepository movementRepo;

	@Autowired
	MMovementLineRepository movementlineRepo;

	
	@GetMapping
	@RequestMapping("/{orderId}")
	public List<MMovementVanningCheck> listVanningCheck(@PathVariable long orderId) {
		List<MMovementVanningCheck> result = new ArrayList<>();
		List<Orderline> listOrderline = orderlineRepo.findByOrderID(orderId);
		List<MMovement> listMovement = movementRepo.findByOrderId(orderId);
		List<ProductMovement> listProductMovement = new ArrayList<ProductMovement>();
		for (MMovement movement : listMovement) {
			List<MMovementLine> listMovementLine = movementlineRepo.findByMovementId(movement.getMovementID());
			for (MMovementLine movementLine : listMovementLine) {
				if (listProductMovement.isEmpty()) {
					ProductMovement productMovement = new ProductMovement();
					productMovement.setMovementId(movementLine.getMovementId());
					productMovement.setMovementlineId(movementLine.getMovementLineId());
					productMovement.setProductId(movementLine.getProductId());
					productMovement.setQty(movementLine.getQuantity());
					listProductMovement.add(productMovement);
				}
				else {
					ProductMovement productMovement = findByProductId(listProductMovement, movementLine.getProductId());
					if (productMovement == null) {
						productMovement = new ProductMovement();
						productMovement.setMovementId(movementLine.getMovementId());
						productMovement.setMovementlineId(movementLine.getMovementLineId());
						productMovement.setProductId(movementLine.getProductId());
						productMovement.setQty(movementLine.getQuantity());
						listProductMovement.add(productMovement);
					}
					else {
						productMovement.setQty(productMovement.getQty() + movementLine.getQuantity());
					}
				}
			}
		}
		for (Orderline orderline : listOrderline) {
			MMovementVanningCheck movementVanning = new MMovementVanningCheck();
			long productId = orderline.getSanPham();
			movementVanning.setOrderId(orderline.getOrderID());
			movementVanning.setOrderlineId(orderline.getId());
			movementVanning.setOrderQty(orderline.getSoLuong());
			movementVanning.setProductId(productId);
			movementVanning.setProductName(productRepo.getOne(productId).getName());
			ProductMovement productMovement = findByProductId(listProductMovement, productId);
			if (productMovement == null) {
				movementVanning.setMovementId(0);
				movementVanning.setMovementlineId(0);
				movementVanning.setMovementQty(0);
			}
			else {
				movementVanning.setMovementId(productMovement.getMovementId());
				movementVanning.setMovementlineId(productMovement.getMovementlineId());
				movementVanning.setMovementQty(productMovement.getQty());
			}
			movementVanning.setDiffQty(movementVanning.getOrderQty() - movementVanning.getMovementQty());
			result.add(movementVanning);
		}
		return result;
	}
	
	
	public ProductMovement findByProductId(List<ProductMovement> listProductMovement, long productId) {
		for (ProductMovement productmovement: listProductMovement) {
			if (productmovement.getProductId() == productId) {
				return productmovement;
			}
		}
		return null;
	}
	
}
