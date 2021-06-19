package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MSaleorder;
import com.hdsoft.JptAPI.Models.MSaleorderDetail;
import com.hdsoft.JptAPI.Models.Order;
import com.hdsoft.JptAPI.Models.ProductThuaThieu;
import com.hdsoft.JptAPI.Repositories.MSaleorderDetailRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderRepository;
import com.hdsoft.JptAPI.Repositories.OrderRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RequestMapping("/api/v1/checkproduct")
@RestController
public class ProductThuaThieuController {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	MSaleorderRepository saleorderRepo;

	@Autowired
	MSaleorderDetailRepository saleorderDetailRepo;

	@GetMapping
	public List<ProductThuaThieu> getProductThuaThieu() {
		List<ProductThuaThieu> result = new ArrayList<ProductThuaThieu>();
		List<MSaleorder> listSaleorder = saleorderRepo.findAll();
		for (MSaleorder saleorder : listSaleorder) {
			long orderId = saleorder.getOrderId();
			Order order = orderRepo.getOne(orderId);
			if (!order.getDocStatus().equalsIgnoreCase("CL")) {
				List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo
						.findBySaleOrderId(saleorder.getSaleOrderId());
				for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
					Integer thieu = saleorderDetail.getCheckqty();
					if (thieu < 0) {
						ProductThuaThieu productThuaThieu = new ProductThuaThieu();
						productThuaThieu.setProductId(saleorderDetail.getProductId());
						productThuaThieu.setProductName(productRepo.getOne(saleorderDetail.getProductId()).getName());
						productThuaThieu.setQty(thieu);
						result.add(productThuaThieu);
					}
				}
			}
		}
		result = getListProductById(result);
		return result;
	}

	public Set<Long> filterListById(List<ProductThuaThieu> listProduct) {
		Set<Long> result = new HashSet<Long>();
		Iterator<ProductThuaThieu> itr = listProduct.iterator();
		while (itr.hasNext()) {
			ProductThuaThieu product = itr.next();
			result.add(product.getProductId());
		}
		return result;
	}

	public List<ProductThuaThieu> getListProductById(List<ProductThuaThieu> listProduct) {
		List<ProductThuaThieu> result = new ArrayList<ProductThuaThieu>();
		Set<Long> setId = filterListById(listProduct);
		for (Long id : setId) {
			ProductThuaThieu productThuaThieu = new ProductThuaThieu();
			Integer qty = 0;
			for (ProductThuaThieu product : listProduct) {
				if (id == product.getProductId()) {
					qty = qty + product.getQty();
				}
			}
			productThuaThieu.setProductId(id);
			productThuaThieu.setProductName(productRepo.getOne(id).getName());
			productThuaThieu.setQty(qty);
			result.add(productThuaThieu);
		}
		return result;
	}

}
