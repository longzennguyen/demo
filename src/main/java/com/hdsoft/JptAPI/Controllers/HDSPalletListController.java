package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.KebabCaseStrategy;
import com.hdsoft.JptAPI.Models.HDSPalletList;
import com.hdsoft.JptAPI.Models.HDSPalletListCheck;
import com.hdsoft.JptAPI.Repositories.HDSPalletListRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("api/v1/palletlist")
public class HDSPalletListController {

	@Autowired
	ProductRepository productRepo;
	
	@Autowired
	HDSPalletListRepository palletListRepo;
	@GetMapping
	@RequestMapping("abc")
	public List<HDSPalletList> ac() {
		return palletListRepo.findByOrderid(1038845);
	}
	@GetMapping
	@RequestMapping("/{orderId}")
	public List<HDSPalletListCheck> findByOrderid(@PathVariable long orderId) {
		List<HDSPalletListCheck> result = new ArrayList<HDSPalletListCheck>();
		List<HDSPalletList> listByOrderId = palletListRepo.findByOrderidOrderByPalletNo(orderId);
		for (HDSPalletList pallet : listByOrderId) {
			HDSPalletListCheck palletCheck = new HDSPalletListCheck();
			long productId = pallet.getProductId();
			palletCheck.setOrderId(pallet.getOrderId());
			palletCheck.setProductId(productId);
			palletCheck.setProductName(productRepo.getOne(productId).getName());
			palletCheck.setQty(pallet.getQty());
			palletCheck.setCtn(pallet.getCtn());
			palletCheck.setHeight(pallet.getHeight());
			palletCheck.setLength(pallet.getLength());
			palletCheck.setWeight(pallet.getWeight());
			palletCheck.setWidth(pallet.getWidth());
			palletCheck.setPalletNo(pallet.getPalletNo());
			result.add(palletCheck);
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/check/{orderId}")
	public List<HDSPalletList> findByOrderidCheck(@PathVariable long orderId) {
		return palletListRepo.findByOrderid(orderId);
	}
}
