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
import com.hdsoft.JptAPI.Models.Order;
import com.hdsoft.JptAPI.Models.SaleOrder;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderDetailRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderRepository;
import com.hdsoft.JptAPI.Repositories.OrderRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/saleorder")
public class MSaleOrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MSaleorderRepository saleorderRepo;

	@Autowired
	private MSaleorderDetailRepository saleorderDetailRepo;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private LocatorRepository locatorRepo;

	@Autowired
	private MAttributeSetInstanceRepository attributeRepo;

	@GetMapping
	@RequestMapping("/ordervanning")
	public List<Order> listAllSaleOrderVanning() {
		List<Order> listAll = orderRepository.findByKhoHang(1000034);
		List<Order> result = new ArrayList<Order>();
		for (Order order : listAll) {
			try {
				if (order.getLoaiChungTu() == 1000674 && order.getDocStatus().equalsIgnoreCase("CO")) {
					result.add(order);
				}
			} catch (Exception e) {
				System.err.println("Null point");
			}

		}
		return result;
	}

	@GetMapping
	@RequestMapping("/orderscanning")
	public List<Order> listAllSaleOrderScanning() {
		List<Order> listAll = orderRepository.findByKhoHang(1000034);
		List<Order> result = new ArrayList<Order>();
		for (Order order : listAll) {
			try {
				if (order.getLoaiChungTu() == 1000674 && order.getDocStatus().equalsIgnoreCase("CO")
						&& order.getIsscanning().equalsIgnoreCase("N")) {
					result.add(order);
				}
			} catch (Exception e) {
				System.err.println("Null point");
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/ordervanningback")
	public List<Order> listAllSaleOrderVanningBack() {
		List<Order> listAll = orderRepository.findByKhoHang(1000034);
		List<Order> result = new ArrayList<Order>();
		for (Order order : listAll) {
			try {
				if (order.getLoaiChungTu() == 1000674 && order.getDocStatus().equalsIgnoreCase("CO")) {
					MSaleorder saleorder = saleorderRepo.findByOrderId(order.getId());
					List<MSaleorderDetail> listOrderDetail = saleorderDetailRepo
							.findBySaleOrderId(saleorder.getSaleOrderId());
					for (MSaleorderDetail saleorderDetail : listOrderDetail) {
						if (saleorderDetail.getQty() < 0) {
							result.add(order);
							break;
						}
					}
				}
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/orderscanningback")
	public List<Order> listAllSaleOrderScanningBack() {
		List<Order> listAll = orderRepository.findByKhoHang(1000034);
		List<Order> result = new ArrayList<Order>();
		for (Order order : listAll) {
			try {
				if (order.getLoaiChungTu() == 1000674 && order.getIsvanning().equalsIgnoreCase("Y")) {
					MSaleorder saleorder = saleorderRepo.findByOrderId(order.getId());
					List<MSaleorderDetail> listOrderDetail = saleorderDetailRepo
							.findBySaleOrderId(saleorder.getSaleOrderId());
					for (MSaleorderDetail saleorderDetail : listOrderDetail) {
						if (saleorderDetail.getCheckqty() > 0) {
							result.add(order);
							break;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<SaleOrder> findByOrderId(@PathVariable long orderId) {
		List<SaleOrder> result = new ArrayList<SaleOrder>();
		MSaleorder listSaleorder = saleorderRepo.findByOrderId(orderId);
		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo
				.findBySaleOrderId(listSaleorder.getSaleOrderId());
		for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
			SaleOrder saleorder = new SaleOrder();
			Long productId = saleorderDetail.getProductId();
			Long locatorId = saleorderDetail.getLocatorId();
			Long asiId = saleorderDetail.getAsiId();
			saleorder.setAsiId(asiId);
			saleorder.setAsiName(getValueDate(attributeRepo.getOne(asiId).getValue()));
			saleorder.setLocatorId(locatorId);
			saleorder.setLocatorName(locatorRepo.getOne(locatorId).getName());
			saleorder.setOrderId(orderId);
			saleorder.setProductId(productId);
			saleorder.setProductName(productRepository.getOne(productId).getName());
			saleorder.setQuantity(saleorderDetail.getQty());
			saleorder.setQuantityThucte(saleorderDetail.getQtyentered());
			result.add(saleorder);
		}
		return result;
	}

	public static String getValueDate(String date) {
		if (date.length() == 12)
			return date.substring(5, 8).concat(date.substring(10));
		else
			return "--";
	}

}
