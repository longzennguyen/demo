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

import com.hdsoft.JptAPI.Models.ProductOnHand;
import com.hdsoft.JptAPI.Models.ProductThuaThieu;
import com.hdsoft.JptAPI.Models.StorageOnHand;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;
import com.hdsoft.JptAPI.Repositories.StorageOnHandRepository;

@RestController
@RequestMapping("/api/v1/productonhand")
public class ProductOnHandController {

	@Autowired
	StorageOnHandRepository storageOnHandRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	LocatorRepository locatorRepo;

	@Autowired
	MAttributeSetInstanceRepository attributeSetInstanceRepo;

	@GetMapping
	@RequestMapping("/findalldemo")
	public List<ProductThuaThieu> listAllProductDemo() {
		List<ProductThuaThieu> result = new ArrayList<ProductThuaThieu>();
		List<StorageOnHand> listStorageOnHand = storageOnHandRepo.findByClientIdAndQuantityOnHandGreaterThan(1000000, 0.0);
		Set<Long> setProductIdDemo	= setProductIdDemoCheck();
		for (Long productIdDemo : setProductIdDemo) {
			ProductThuaThieu productThuaThieu = new ProductThuaThieu();
			double qtyonhand = 0;
			for (StorageOnHand storageOnHand : listStorageOnHand) {
				if (storageOnHand.getProductId() == productIdDemo) {
					qtyonhand = qtyonhand + storageOnHand.getQuantityOnHand();
				}
			}
			productThuaThieu.setProductId(productIdDemo);
			productThuaThieu.setProductName(productRepo.getOne(productIdDemo).getName());
			productThuaThieu.setQty((int)qtyonhand);
			result.add(productThuaThieu);
		}
		return result;
	}
	
	
	@GetMapping
	@RequestMapping("/{locatorId}")
	public List<ProductOnHand> findProductByLocatorId(@PathVariable long locatorId) {
		List<ProductOnHand> result = new ArrayList<ProductOnHand>();
		List<StorageOnHand> listStorageOnHand = storageOnHandRepo.findByLocatorId(locatorId);
		for (StorageOnHand storageOnHand : listStorageOnHand) {
			if (storageOnHand.getQuantityOnHand() == 0) {
				continue;
			}
			ProductOnHand productOnHand = new ProductOnHand();
			long productId = storageOnHand.getProductId();
			long attributeSetId = storageOnHand.getAttributeSetInstanceId();
			String valueDate = attributeSetInstanceRepo.getOne(attributeSetId).getValue();
			productOnHand.setAttributeSetInstanceId(attributeSetId);
			if (valueDate.length() > 5) {
				productOnHand.setASI(getValueDate(valueDate));
			} else
				productOnHand.setASI(valueDate);
			productOnHand.setLocatorId(locatorId);
			productOnHand.setLocatorName(locatorRepo.getOne(locatorId).getName());
			productOnHand.setProductId(productId);
			productOnHand.setProductName(productRepo.getOne(productId).getName());
			productOnHand.setQuantityOnHand(storageOnHand.getQuantityOnHand());
			result.add(productOnHand);
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/demo/{locatorId}")
	public List<ProductOnHand> findProductByLocatorIdDemo(@PathVariable long locatorId) {
		List<ProductOnHand> result = new ArrayList<ProductOnHand>();
		List<StorageOnHand> listStorageOnHand = storageOnHandRepo.findByLocatorId(locatorId);
		for (StorageOnHand storageOnHand : listStorageOnHand) {
			if (storageOnHand.getQuantityOnHand() == 0) {
				continue;
			}
			ProductOnHand productOnHand = new ProductOnHand();
			long productId = storageOnHand.getProductId();
			long attributeSetId = storageOnHand.getAttributeSetInstanceId();
			String valueDate = attributeSetInstanceRepo.getOne(attributeSetId).getValue();
			productOnHand.setAttributeSetInstanceId(attributeSetId);
			productOnHand.setASI(valueDate);
			productOnHand.setLocatorId(locatorId);
			productOnHand.setLocatorName(locatorRepo.getOne(locatorId).getName());
			productOnHand.setProductId(productId);
			productOnHand.setProductName(productRepo.getOne(productId).getValue());
			productOnHand.setQuantityOnHand(storageOnHand.getQuantityOnHand());
			result.add(productOnHand);
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/findallproduct/{productId}")
	public List<ProductOnHand> findAllProductInLocator(@PathVariable long productId) {
		List<ProductOnHand> result = new ArrayList<ProductOnHand>();
		List<StorageOnHand> listStorage = storageOnHandRepo.findByProductId(productId);
		for (StorageOnHand storageOnHand : listStorage) {
			ProductOnHand productOnHand = new ProductOnHand();
			long attributeSetId = storageOnHand.getAttributeSetInstanceId();
			long locatorId = storageOnHand.getLocatorId();
			productOnHand.setLocatorId(locatorId);
			productOnHand.setLocatorName(locatorRepo.getOne(locatorId).getName());
			productOnHand.setProductId(productId);
			productOnHand.setProductName(productRepo.getOne(productId).getValue());
			productOnHand.setQuantityOnHand(storageOnHand.getQuantityOnHand());
			productOnHand.setAttributeSetInstanceId(attributeSetId);
			String valueDate = attributeSetInstanceRepo.getOne(attributeSetId).getValue();
			if (valueDate.length() == 12) {
				productOnHand.setASI(getValueDate(valueDate));
			} else {
				productOnHand.setASI(valueDate);
			}
			result.add(productOnHand);
		}
		return result;
	}
	
	public Set<Long> setProductIdDemoCheck() {
		Set<Long> setProductId = new HashSet<>();
		List<StorageOnHand> listStorage = storageOnHandRepo.findByClientIdAndQuantityOnHandGreaterThan(1000000, 0.0);
		for (StorageOnHand product : listStorage) {
			setProductId.add(product.getProductId());
		}
		return setProductId;
	}

	@GetMapping
	@RequestMapping("/storage/{productId}")
	public List<StorageOnHand> findByProductId(@PathVariable long productId) {
		return storageOnHandRepo.findByProductId(productId);
	}

	public static String getValueDate(String date) {
		return date.substring(5, 8).concat(date.substring(10));
	}

}
