package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.StorageOnHand;
import com.hdsoft.JptAPI.Models.StorageOnHandNoAttribute;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;
import com.hdsoft.JptAPI.Repositories.StorageOnHandRepository;

@RestController
@RequestMapping("/api/v1/storageonhandnoattribute")
public class StorageOnHandNoAttributeController {

	@Autowired
	StorageOnHandRepository storageOnHandRepo;

	@Autowired
	LocatorRepository locatorRepo;

	@Autowired
	ProductRepository productRepo;

	@GetMapping
	@RequestMapping("/{locatorId}")
	public List<StorageOnHandNoAttribute> findByLocatorId(@PathVariable long locatorId) {
		List<StorageOnHandNoAttribute> result = new ArrayList<StorageOnHandNoAttribute>();
		List<StorageOnHand> listStorageOnHandByLocatorId = storageOnHandRepo.findByLocatorId(locatorId);
		Set<Long> listProductId = new HashSet<Long>();
		for (StorageOnHand storageOnHand : listStorageOnHandByLocatorId) {
			listProductId.add(storageOnHand.getProductId());
		}
		for (Long productId : listProductId) {
			List<StorageOnHand> storageOnHandByProductId = storageOnHandRepo.findByProductId(productId);
			StorageOnHandNoAttribute storageOnHandNoAttribute = new StorageOnHandNoAttribute();
			double quan = 0.0;
			for (StorageOnHand storageOnHand : storageOnHandByProductId) {
				long locatorIdCheck = storageOnHand.getLocatorId();
				long productIdCheck = storageOnHand.getProductId();
				storageOnHandNoAttribute.setLocatorId(storageOnHand.getLocatorId());
				storageOnHandNoAttribute.setLocatorName(locatorRepo.getOne(locatorIdCheck).getName());
				storageOnHandNoAttribute.setProductId(storageOnHand.getProductId());
				storageOnHandNoAttribute.setProductName(productRepo.getOne(productIdCheck).getName());
				quan = quan + storageOnHand.getQuantityOnHand();
			}
			storageOnHandNoAttribute.setSumQty(quan);
			result.add(storageOnHandNoAttribute);
		}
		return result;
	}

}
