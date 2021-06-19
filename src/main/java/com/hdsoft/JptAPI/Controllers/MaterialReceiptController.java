
package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.MInout;
import com.hdsoft.JptAPI.Models.MaterialReceipt;
import com.hdsoft.JptAPI.Models.Orderline;
import com.hdsoft.JptAPI.Models.Product;
import com.hdsoft.JptAPI.Repositories.MInoutLineRepository;
import com.hdsoft.JptAPI.Repositories.MInoutRepository;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/materialreceipt")
public class MaterialReceiptController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderlineRepository orderlineRepository;

	@Autowired
	private MInoutRepository inoutRepository;

	@Autowired
	private MInoutLineRepository inoutLineRepository;

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<MaterialReceipt> findByOrderCheckQuan(@PathVariable long orderId) {
		List<Orderline> listOrderLineOfOrder = orderlineRepository.findByOrderID(orderId);
		List<MInout> listInoutOfOrder = inoutRepository.findByOrderId(orderId);
		List<MaterialReceipt> result = new ArrayList<>();
		if (!listInoutOfOrder.isEmpty()) {
			for (MInout inout : listInoutOfOrder) {
				for (Orderline orderLine : listOrderLineOfOrder) {
					try {
						Double current = inoutLineRepository
								.findByProductIDAndMaterialID(orderLine.getSanPham(), inout.getMaterialID()).get(0)
								.getQuantity();
						Double quan = current - orderLine.getSoLuong();
						long productId = orderLine.getSanPham();
						Product product = productRepository.getOne(productId);
						MaterialReceipt materialReceipt = new MaterialReceipt();
						materialReceipt.setOrderlineId(orderLine.getId());
						materialReceipt.setProductId(productId);
						materialReceipt.setProductName(product.getValue());
						materialReceipt.setQtyOrder(orderLine.getSoLuong());
						materialReceipt.setQtyCurrent(current);
						materialReceipt.setQtyCheck(quan);
						materialReceipt.setUnitsperpack(product.getUnitsperpack());
						result.add(materialReceipt);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			for (Orderline orderLine : listOrderLineOfOrder) {
				long productId = orderLine.getSanPham();
				Product product = productRepository.getOne(productId);
				MaterialReceipt materialReceipt = new MaterialReceipt();
				materialReceipt.setOrderlineId(orderLine.getId());
				materialReceipt.setProductId(productId);
				materialReceipt.setProductName(product.getValue());
				materialReceipt.setQtyCheck(0.00);
				materialReceipt.setQtyCurrent(0.00);
				materialReceipt.setQtyOrder(orderLine.getSoLuong());
				materialReceipt.setUnitsperpack(product.getUnitsperpack());
				result.add(materialReceipt);
			}
		}
		return result;
	}
	

}
