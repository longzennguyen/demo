package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MSaleorder;
import com.hdsoft.JptAPI.Models.MSaleorderDetail;
import com.hdsoft.JptAPI.Models.MWarehouseShipment;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderDetailRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderRepository;
import com.hdsoft.JptAPI.Repositories.OrderRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/shipment")
public class MWarehouseShipmentController {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	LocatorRepository locaRepo;
	
	@Autowired
	MAttributeSetInstanceRepository asiRepo;
	
	@Autowired
	MSaleorderRepository saleorderRepo;
	
	@Autowired
	MSaleorderDetailRepository saleorderDetailRepo;
	
	@GetMapping
	@RequestMapping("/{orderId}")
	public List<MWarehouseShipment> getShipment(@PathVariable long orderId) {
		List<MWarehouseShipment> result = new ArrayList<MWarehouseShipment>();
		MSaleorder saleorder = saleorderRepo.findByOrderId(orderId);
		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo.findBySaleOrderId(saleorder.getSaleOrderId());
		for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
			long productId = saleorderDetail.getProductId();
			long locatorId = saleorderDetail.getLocatorId();
			long asiId = saleorderDetail.getAsiId();
			double qty = saleorderDetail.getQty();
			String asiValue = asiRepo.getOne(asiId).getValue();
			MWarehouseShipment shipment = new MWarehouseShipment();
			shipment.setOrderId(orderId);
			shipment.setDocumentNo(orderRepo.getOne(orderId).getSoChungTu());
			shipment.setProductId(productId);
			shipment.setProductName(productRepo.getOne(productId).getName());
			shipment.setLocatorId(locatorId);
			shipment.setLocatorName(locaRepo.getOne(locatorId).getName());
			shipment.setAsiId(asiId);
			if (asiValue.length() > 5) {
				shipment.setAsiName(getValueDate(asiValue));
			} else {
				shipment.setAsiName(asiValue);
			}
			shipment.setQty(qty); 
			result.add(shipment);
		}
		return result;
	}
	
	public static String getValueDate(String date) {
		return date.substring(5, 8).concat(date.substring(10));
	}
	
}
