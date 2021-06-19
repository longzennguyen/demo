package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.StorageOnHand;
import com.hdsoft.JptAPI.Models.WarehouseMovement;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;
import com.hdsoft.JptAPI.Repositories.StorageOnHandRepository;

@RestController
@RequestMapping("/api/v1/warehousemovement")
public class WarhouseMovementController {

	@Autowired
	private StorageOnHandRepository storageOnHandRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private MAttributeSetInstanceRepository attributeSetRepo;

	@GetMapping
	@RequestMapping("/{locatorId}")
	public List<WarehouseMovement> listProductOnHandByLocator(@PathVariable long locatorId) {
		List<WarehouseMovement> result = new ArrayList<>();
		List<StorageOnHand> listStorageByLocatorId = storageOnHandRepository.findByLocatorId(locatorId);
		for (StorageOnHand storageOnHand : listStorageByLocatorId) {
			long productId = storageOnHand.getProductId();
			long attributeId = storageOnHand.getAttributeSetInstanceId();
			WarehouseMovement warehouseMovement = new WarehouseMovement();
			warehouseMovement.setProductId(productId);
			warehouseMovement.setProductName(productRepository.getOne(productId).getName());
			warehouseMovement.setQuantityOnHand(storageOnHand.getQuantityOnHand());
			warehouseMovement.setDateMaterialPolicy(storageOnHand.getDateMaterialPolicy());
			warehouseMovement.setAttributeSetInstanceId(attributeId);
			if (attributeId != 0) {
				String value = attributeSetRepo.getOne(attributeId).getValue();
				String valueDate = value.substring(5,8).concat(value.substring(10));
				warehouseMovement.setValue(valueDate);
			}
			result.add(warehouseMovement);
		}
		return result;
	}

}
