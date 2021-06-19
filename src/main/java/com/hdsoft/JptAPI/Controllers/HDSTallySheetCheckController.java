package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.HDSTallySheet;
import com.hdsoft.JptAPI.Models.HDSTallySheetCheck;
import com.hdsoft.JptAPI.Repositories.HDSTallySheetRepository;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/tally")
public class HDSTallySheetCheckController {

	@Autowired
	HDSTallySheetRepository tallyRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	OrderlineRepository orderLineRepo;

	@GetMapping
	@RequestMapping("/testa/{orderId}")
	public List<HDSTallySheet> test(@PathVariable long orderId) {
		return tallyRepo.findByOrderId(orderId);
	}

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<HDSTallySheetCheck> findAllByOrderId(@PathVariable long orderId) {
		List<HDSTallySheetCheck> listTallyCheck = new ArrayList<>();
		List<HDSTallySheet> listTallySheetGroupByModel = getListTallySheetGroupByModel(orderId);
		for (HDSTallySheet tally : listTallySheetGroupByModel) {
			System.out.println("Lengh: "+listTallySheetGroupByModel.size());
			HDSTallySheetCheck tallyCheck = new HDSTallySheetCheck();
			long productId = tally.getProductId();
			tallyCheck.setIn(productRepo.getOne(productId).getUnitsperpack());
			tallyCheck.setProductName(productRepo.getOne(productId).getName());
			tallyCheck.setCtn(tally.getCtn());
			double qtyKH = orderLineRepo.findByOrderIDAndSanPham(orderId, productId).get(0).getSoLuong();
			int qtyTallyCheck = tally.getQty();
			tallyCheck.setQtyKH(qtyKH);
			tallyCheck.setQtyTallyCheck(qtyTallyCheck);
			tallyCheck.setThieu(qtyKH - qtyTallyCheck);
			listTallyCheck.add(tallyCheck);
		}
		return listTallyCheck;
	}

	public List<HDSTallySheet> getListTallySheetGroupByModel(@PathVariable long orderId) {
		List<HDSTallySheet> listTallySheetGroupByModel = new ArrayList<>();
		List<HDSTallySheet> listTallySheet = tallyRepo.findByOrderId(orderId);
		Set<Long> setProduct = new HashSet<>();
		for (HDSTallySheet tally : listTallySheet) {
			setProduct.add(tally.getProductId());
		}
		for (Long productId : setProduct) {
			HDSTallySheet tallySheetModel = new HDSTallySheet();
			int ctn = 0;
			int qty = 0;
			for (HDSTallySheet tally : listTallySheet) {
				long productIdTally = tally.getProductId();
				if (productIdTally == productId) {
					ctn = ctn + tally.getCtn();
					qty = qty + tally.getQty();
				}
			}
			tallySheetModel.setCtn(ctn);
			tallySheetModel.setOrderId(orderId);
			tallySheetModel.setProductId(productId);
			tallySheetModel.setQty(qty);
			listTallySheetGroupByModel.add(tallySheetModel);
		}
		return listTallySheetGroupByModel;
	}

}
