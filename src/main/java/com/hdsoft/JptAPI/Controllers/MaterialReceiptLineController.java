package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MInout;
import com.hdsoft.JptAPI.Models.MInoutLine;
import com.hdsoft.JptAPI.Models.MaterialReceiptLine;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.MInoutLineRepository;
import com.hdsoft.JptAPI.Repositories.MInoutRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/maline")
public class MaterialReceiptLineController {

	@Autowired
	MInoutRepository inoutRepo;

	@Autowired
	MInoutLineRepository inoutLineRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	LocatorRepository locatorRepo;
	
	@Autowired
	MAttributeSetInstanceRepository attributeRepo;

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<MaterialReceiptLine> findByOrderId(@PathVariable long orderId) {
		List<MaterialReceiptLine> result = new ArrayList<MaterialReceiptLine>();
		List<MInout> listInout = inoutRepo.findByOrderId(orderId);
		for (MInout inout : listInout) {
			List<MInoutLine> listInoutLine = new ArrayList<MInoutLine>();
			listInoutLine = inoutLineRepo.findAllByMaterialID(inout.getMaterialID());
			for (MInoutLine inoutLine : listInoutLine) {
				MaterialReceiptLine maLine = new MaterialReceiptLine();
				long productId = inoutLine.getProductID();
				maLine.setLocatorId(1025321);
				maLine.setLocatorName("Receiving");
				maLine.setMaLineId(inoutLine.getMaterialLineID());
				maLine.setMaterialId(inoutLine.getMaterialID());
				maLine.setOrderId(orderId);
				maLine.setProductId(inoutLine.getProductID());
				maLine.setProductName(productRepo.getOne(productId).getName());
				maLine.setQty(inoutLine.getQuantity());
				maLine.setUomId(1000028);
				maLine.setUomName("pcs");
				maLine.setUnitperpack(productRepo.getOne(productId).getUnitsperpack());
				maLine.setOrderlineId(inoutLine.getOrderlineID());
				result.add(maLine);
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/demo/{minoutId}")
	public List<MaterialReceiptLine> findByOrderIdDemo(@PathVariable long minoutId) {
		List<MaterialReceiptLine> result = new ArrayList<MaterialReceiptLine>();
		List<MInoutLine> listInoutLine = inoutLineRepo.findAllByMaterialID(minoutId);
		for (MInoutLine inoutLine : listInoutLine) {
			MaterialReceiptLine maLine = new MaterialReceiptLine();
			long productId = inoutLine.getProductID();
			maLine.setLocatorId(inoutLine.getLocatorID());
			maLine.setLocatorName(locatorRepo.getOne(inoutLine.getLocatorID()).getName());
			maLine.setMaLineId(inoutLine.getMaterialLineID());
			maLine.setMaterialId(inoutLine.getMaterialID());
			try {
				maLine.setOrderId(inoutRepo.getOne(minoutId).getOrderId());
				
			} catch (Exception e) {
				maLine.setOrderId(null);
				
				// TODO: handle exception
			}
			maLine.setProductId(inoutLine.getProductID());
			maLine.setProductName(productRepo.getOne(productId).getValue());
			maLine.setQty(inoutLine.getQuantity());
			maLine.setUomId(1000028);
			maLine.setUomName("pcs");
			maLine.setUnitperpack(productRepo.getOne(productId).getUnitsperpack());
			maLine.setOrderlineId(inoutLine.getOrderlineID());
			if (inoutLine.getQtyCheck()==null) {
					inoutLine.setQtyCheck(0.0);
			}
			maLine.setQtyCheck(inoutLine.getQuantity() - inoutLine.getQtyCheck());
			maLine.setAsiId(inoutLine.getAsiId());
			maLine.setAsiValue(attributeRepo.getOne(inoutLine.getAsiId()).getValue());
			result.add(maLine);
		}

		return result;
	}

	@GetMapping
	@RequestMapping("/findbyminout/{inoutId}")
	public List<MaterialReceiptLine> findByInoutId(@PathVariable long inoutId) {
		long orderId = inoutRepo.getOne(inoutId).getOrderId();
		List<MaterialReceiptLine> result = new ArrayList<MaterialReceiptLine>();
		List<MInoutLine> listInoutLine = inoutLineRepo.findAllByMaterialID(inoutId);
		for (MInoutLine inoutLine : listInoutLine) {
			MaterialReceiptLine maLine = new MaterialReceiptLine();
			long productId = inoutLine.getProductID();
			maLine.setLocatorId(1025321);
			maLine.setLocatorName("Receiving");
			maLine.setMaLineId(inoutLine.getMaterialLineID());
			maLine.setMaterialId(inoutLine.getMaterialID());
			maLine.setProductId(inoutLine.getProductID());
			maLine.setProductName(productRepo.getOne(productId).getName());
			maLine.setQty(inoutLine.getQuantity());
			maLine.setUomId(1000028);
			maLine.setUomName("pcs");
			maLine.setOrderId(orderId);
			maLine.setUnitperpack(productRepo.getOne(productId).getUnitsperpack());
			maLine.setOrderlineId(inoutLine.getOrderlineID());
			maLine.setAsiId(inoutLine.getAsiId());
			result.add(maLine);

		}
		return result;
	}

}
