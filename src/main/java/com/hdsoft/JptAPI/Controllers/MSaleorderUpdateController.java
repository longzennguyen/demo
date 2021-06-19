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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MSaleorder;
import com.hdsoft.JptAPI.Models.MSaleorderDetail;
import com.hdsoft.JptAPI.Models.MSaleorderUpdate;
import com.hdsoft.JptAPI.Models.ProductThuaThieu;
import com.hdsoft.JptAPI.Repositories.MSaleorderDetailRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/saleorderline")
public class MSaleorderUpdateController {

	@Autowired
	MSaleorderRepository saleorderRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	MSaleorderDetailRepository saleorderDetailRepo;

	@GetMapping
	public MSaleorderUpdate getSaleorderdetail(@RequestParam long orderId, @RequestParam long productId,
			@RequestParam long locatorId, @RequestParam long asiId) {
		MSaleorder saleorder = saleorderRepo.findByOrderId(orderId);
		MSaleorderUpdate saleorderUpdate = new MSaleorderUpdate();
		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo.findBySaleOrderId(saleorder.getSaleOrderId());
		for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
			if (saleorderDetail.getProductId() == productId && saleorderDetail.getLocatorId() == locatorId
					&& saleorderDetail.getAsiId() == asiId) {
				saleorderUpdate.setSaleorderlineId(saleorderDetail.getSaleOrderDetailId());
			}
		}
		return saleorderUpdate;
	}

	@GetMapping
	@RequestMapping("/check/{orderId}")
	public List<ProductThuaThieu> getProductThuaThieu(@PathVariable long orderId) {
		List<ProductThuaThieu> result = new ArrayList<ProductThuaThieu>();
		List<ProductThuaThieu> productKehoach = new ArrayList<ProductThuaThieu>();
		List<ProductThuaThieu> productThucte = new ArrayList<ProductThuaThieu>();
		MSaleorder saleorder = saleorderRepo.findByOrderId(orderId);
		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo.findBySaleOrderId(saleorder.getSaleOrderId());
		for (MSaleorderDetail mSaleorderDetail : listSaleorderDetail) {
			ProductThuaThieu product = new ProductThuaThieu();
			product.setProductId(mSaleorderDetail.getProductId());
			product.setProductName(productRepo.getOne(mSaleorderDetail.getProductId()).getName());
			product.setQty(mSaleorderDetail.getQty() - mSaleorderDetail.getCheckqty());
			productKehoach.add(product);
		}
		productKehoach = getListProductById(productKehoach);
		for (MSaleorderDetail mSaleorderDetail : listSaleorderDetail) {
			ProductThuaThieu product = new ProductThuaThieu();
			product.setProductId(mSaleorderDetail.getProductId());
			product.setProductName(productRepo.getOne(mSaleorderDetail.getProductId()).getName());
			if (mSaleorderDetail.getQtyentered() == null) {
				product.setQty(0);
			} else {
				product.setQty(mSaleorderDetail.getQtyentered());
			}
			productThucte.add(product);
		}
		productThucte = getListProductById(productThucte);
		for (ProductThuaThieu productK : productKehoach) {
			for (ProductThuaThieu productT : productThucte) {
				if (productK.getProductId() == productT.getProductId()) {
					ProductThuaThieu productThuaThieu = new ProductThuaThieu();
					productThuaThieu.setProductId(productK.getProductId());
					productThuaThieu.setProductName(productK.getProductName());
					productThuaThieu.setQty(productK.getQty() - productT.getQty());
					result.add(productThuaThieu);
					break;
				}
			}
		}
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
