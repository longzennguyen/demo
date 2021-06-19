package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MSaleorderNew;
import com.hdsoft.JptAPI.Models.Orderline;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/saleordernew")
public class MSaleorderNewController {

	@Autowired 
	private ProductRepository productRepo;
	
	@Autowired
	private OrderlineRepository orderlineRepo;
	
	

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<MSaleorderNew> getListOrderNew(@PathVariable long orderId) {
		List<MSaleorderNew> result = new ArrayList<>();
		List<Orderline> listOrderline = orderlineRepo.findByOrderID(orderId);
		int no = 0;
		for (Orderline orderline : listOrderline) {
			MSaleorderNew orderNew = new MSaleorderNew();
			orderNew.setOrderId(orderId);
			orderNew.setProductId(orderline.getSanPham());
			orderNew.setProductName(productRepo.getOne(orderline.getSanPham()).getName());
			orderNew.setQuantityKH(orderline.getSoLuong());
			orderNew.setQuantityThucte(orderline.getSoLuongThucTe());
			double check = orderline.getSoLuong() - orderline.getSoLuongThucTe();
			orderNew.setQuantityThieu(check);
			if (check == 0) {
				orderNew.setNote("Đủ");
			} else if (check > 0) {
				orderNew.setNote("Thiếu: " + check);
			} else {
				orderNew.setNote("Thừa: -" + check);
			}
			no = no + 1;
			orderNew.setNo(no);
			orderNew.setQuantitySlc2(orderline.getQtyslc());
			orderNew.setCtnTally(orderline.getCtntally());
			orderNew.setQtyPalet(orderline.getQtypallet());
			orderNew.setCtnPallet(orderline.getCtnpallet());
			result.add(orderNew);
		}
		return result;
	}
	

//	@GetMapping
//	@RequestMapping("/detail/")
//	public List<MSaleorderNew> getDetailByProductIdAndAsiId(@RequestParam long orderId, @RequestParam long productId,
//			@RequestParam long asiId) {
//		List<MSaleorderNew> listDetail = new ArrayList<>();
//		List<MSaleorderNew> listSaleorderNew = listSaleorderNew(orderId);
//		for (MSaleorderNew saleorderNew : listSaleorderNew) {
//			if (productId == saleorderNew.getProductId() & asiId == saleorderNew.getAsi()
//					&& saleorderNew.getQuantityThucte() > 0) {
//				int check = saleorderNew.getQuantityKH() - saleorderNew.getQuantityThucte();
//				if (check > 0) {
//					saleorderNew.setNote("Thiếu: -" + check);
//				} else if (check == 0) {
//					saleorderNew.setNote("Đủ");
//				} else
//					saleorderNew.setNote("Thừa: " + check);
//				listDetail.add(saleorderNew);
//			}
//		}
//		return listDetail;
//	}
//
//	@GetMapping
//	@RequestMapping("/{orderId}")
//	public List<MSaleorderNew> listSaleorderNew(@PathVariable long orderId) {
//		List<MSaleorderNew> listSaleorderNewByProductIdAndAsiId = new ArrayList<MSaleorderNew>();
//		List<MSaleorderNew> listSaleorderNew = findByOrderId(orderId);
//		Set<MSaleorderNewProduct> setProduct = setProductWithoutLocator(listSaleorderNew);
//		int no = 0;
//		for (MSaleorderNewProduct product : setProduct) {
//			no = no + 1;
//			MSaleorderNew saleorderNew = new MSaleorderNew();
//			Long productId = product.getProductId();
//			Long asiId = product.getAsiId();
//			saleorderNew.setAsi(asiId);
//			saleorderNew.setAsiName(getValueDate(attributeRepo.getOne(asiId).getValue()));
//			saleorderNew.setOrderId(orderId);
//			saleorderNew.setProductId(productId);
//			saleorderNew.setProductName(productRepo.getOne(productId).getName());
//			List<MSaleorderNew> listFindByProductidAndAsiId = findByProductIdAndAsiId(listSaleorderNew, productId,
//					asiId);
//			int quanKH = 0;
//			int quanTT = 0;
//			int quanThieu = 0;
//			for (MSaleorderNew saleorderNewQuan : listFindByProductidAndAsiId) {
//				saleorderNew.setSaleorderDetailId(saleorderNewQuan.getSaleorderDetailId());
//				quanKH = quanKH + saleorderNewQuan.getQuantityKH();
//				quanTT = quanTT + saleorderNewQuan.getQuantityThucte();
//				quanThieu = quanThieu + saleorderNewQuan.getQuantityThieu();
//			}
//			saleorderNew.setQuantityKH(quanKH);
//			saleorderNew.setQuantityThucte(quanTT);
//			saleorderNew.setQuantityThieu(quanThieu);
//			saleorderNew.setNo(no);
//			int check = quanKH - quanTT;
//			if (check > 0) {
//				saleorderNew.setNote("Thiếu: -" + check);
//			} else if (check == 0) {
//				saleorderNew.setNote("Đủ");
//			} else
//				saleorderNew.setNote("Thừa: " + check);
//			listSaleorderNewByProductIdAndAsiId.add(saleorderNew);
//		}
//		return listSaleorderNewByProductIdAndAsiId;
//	}
//
//	public List<MSaleorderNew> findByOrderId(long orderId) {
//		List<MSaleorderNew> result = new ArrayList<>();
//		MSaleorder listSaleorder = saleorderRepo.findByOrderId(orderId);
//		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo
//				.findBySaleOrderId(listSaleorder.getSaleOrderId());
//		for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
//			MSaleorderNew saleorderNew = new MSaleorderNew();
//			Long productId = saleorderDetail.getProductId();
//			Long asiId = saleorderDetail.getAsiId();
//			saleorderNew.setSaleorderDetailId(saleorderDetail.getSaleOrderDetailId());
//			saleorderNew.setAsi(asiId);
//			saleorderNew.setAsiName(getValueDate(attributeRepo.getOne(asiId).getValue()));
//			saleorderNew.setOrderId(orderId);
//			saleorderNew.setProductId(productId);
//			saleorderNew.setProductName(productRepo.getOne(productId).getName());
//			saleorderNew.setQuantityKH(saleorderDetail.getQty());
//			if (saleorderDetail.getQtyentered() == null) {
//				saleorderNew.setQuantityThucte(0);
//			} else {
//				saleorderNew.setQuantityThucte(saleorderDetail.getQtyentered());
//			}
//			saleorderNew.setQuantityThieu(saleorderDetail.getCheckqty());
//			result.add(saleorderNew);
//		}
//		return result;
//	}
//
//	public List<MSaleorderNew> findByProductIdAndAsiId(List<MSaleorderNew> listSaleorderNew, long productId,
//			long asiId) {
//		List<MSaleorderNew> listSaleorderNewFilterByProductIdAndAsiId = new ArrayList<MSaleorderNew>();
//		for (MSaleorderNew saleorder : listSaleorderNew) {
//			if (saleorder.getAsi() == asiId && saleorder.getProductId() == productId) {
//				listSaleorderNewFilterByProductIdAndAsiId.add(saleorder);
//			}
//		}
//		return listSaleorderNewFilterByProductIdAndAsiId;
//	}
//
//	public Set<MSaleorderNewProduct> setProductWithoutLocator(List<MSaleorderNew> listSaleorderNew) {
//		Set<MSaleorderNewProduct> setProduct = new HashSet<>();
//		for (MSaleorderNew saleorder : listSaleorderNew) {
//			MSaleorderNewProduct product = new MSaleorderNewProduct();
//			product.setAsiId(saleorder.getAsi());
//			product.setProductId(saleorder.getProductId());
//			setProduct.add(product);
//		}
//		return setProduct;
//	}
	
	

	public static String getValueDate(String date) {
		if (date.length() == 12)
			return date.substring(5, 8).concat(date.substring(10));
		else
			return "--";
	}

}
