package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.HDSCheckSerial;
import com.hdsoft.JptAPI.Models.HDSerial;
import com.hdsoft.JptAPI.Models.HDSerialBack;
import com.hdsoft.JptAPI.Models.HDSerialCustom;
import com.hdsoft.JptAPI.Models.MSaleorder;
import com.hdsoft.JptAPI.Models.MSaleorderDetail;
import com.hdsoft.JptAPI.Models.Orderline;
import com.hdsoft.JptAPI.Models.SaleOrder;
import com.hdsoft.JptAPI.Repositories.HDSerialRepository;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderDetailRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderRepository;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1/checkserial")
public class HDSCheckSerialController {

	@Autowired
	private MSaleorderRepository saleorderRepo;

	@Autowired
	private MSaleorderDetailRepository saleorderDetailRepo;

	@Autowired
	private MAttributeSetInstanceRepository attributeRepo;

	@Autowired
	private LocatorRepository locatorRepo;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderlineRepository orderlineRepository;

	@Autowired
	private HDSerialRepository serialRepo;


	@GetMapping
	@RequestMapping("/{orderId}")
	public List<HDSCheckSerial> findByOrderCheckQuan(@PathVariable long orderId) {
		List<Orderline> listOrderLineOfOrder = orderlineRepository.findByOrderID(orderId);
		List<HDSCheckSerial> result = new ArrayList<HDSCheckSerial>();
		for (Orderline orderline : listOrderLineOfOrder) {
			HDSCheckSerial hdsCheck = new HDSCheckSerial();
			long orderlineId = orderline.getId();
			long productId = orderline.getSanPham();
			List<HDSerial> listHDSerial = serialRepo.findByOrderlineIdAndProductId(orderlineId, productId);
			double qtyCurrent = 0;
			for (HDSerial serial : listHDSerial) {
				qtyCurrent = qtyCurrent + serial.getQtyentered();
			}
			double qty = orderline.getSoLuong();
			hdsCheck.setOrderlineId(orderlineId);
			hdsCheck.setProductId(productId);
			hdsCheck.setProductName(productRepository.getOne(productId).getName());
			hdsCheck.setQtyOrder(qty);
			hdsCheck.setQtyCurrent(qtyCurrent);
			hdsCheck.setQtyCheck(qty - qtyCurrent);
			hdsCheck.setUnitsperpack(orderline.getDvt());
			result.add(hdsCheck);
		}
		return result;
	}

	
	@GetMapping
	@RequestMapping("/checkqty/")
	public Integer getQtyScanned(@RequestParam long orderlineId, @RequestParam long productId) {
		List<HDSerial> listHDSerial = serialRepo.findByOrderlineIdAndProductId(orderlineId, productId);
		Integer check = 0;
		for (HDSerial serial : listHDSerial) {
			check = check + serial.getQtyentered();
		}
		return check;
	}
	
	@GetMapping
	@RequestMapping("/getdetail/")
	public List<HDSerialCustom> getDetail(@RequestParam long orderlineId, @RequestParam long productId) {
		List<HDSerialCustom> result = new ArrayList<HDSerialCustom>();
		List<HDSerial> listHDSerial = serialRepo.findByOrderlineIdAndProductId(orderlineId, productId);
		for (int i = 1; i <= listHDSerial.size(); i++) {
			HDSerialCustom serialCustome = new HDSerialCustom();
			serialCustome.setNo(i);
			serialCustome.setOrderlineId(listHDSerial.get(i-1).getOrderlineId());
			serialCustome.setProductId((listHDSerial.get(i-1).getProductId()));
			serialCustome.setSerial(listHDSerial.get(i-1).getSerial());
			serialCustome.setSerialId(listHDSerial.get(i-1).getSerialId());
			serialCustome.setQtyentered(listHDSerial.get(i-1).getQtyentered());
			result.add(serialCustome);
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/getdetailpana/")
	public List<HDSerialCustom> getDetailPana(@RequestParam long orderlineId, @RequestParam long productId) {
		List<HDSerialCustom> result = new ArrayList<HDSerialCustom>();
		List<HDSerial> listHDSerial = serialRepo.findByOrderlineIdAndProductId(orderlineId, productId);
		for (int i = 1; i <= listHDSerial.size(); i++) {
			HDSerialCustom serialCustome = new HDSerialCustom();
			serialCustome.setNo(i);
			serialCustome.setOrderlineId(listHDSerial.get(i-1).getOrderlineId());
			serialCustome.setProductId((listHDSerial.get(i-1).getProductId()));
			serialCustome.setSerial(listHDSerial.get(i-1).getSerial());
			serialCustome.setSerialId(listHDSerial.get(i-1).getSerialId());
			serialCustome.setQtyentered(listHDSerial.get(i-1).getQtyentered());
			serialCustome.setSubSerial(listHDSerial.get(i-1).getSubserial());
			result.add(serialCustome);
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/back/{orderId}")
	public List<HDSerialBack> listSerialBackQty(@PathVariable long orderId) {
		List<HDSerialBack> result = new ArrayList<HDSerialBack>();
		List<Orderline> listOrderLineOfOrder = orderlineRepository.findByOrderID(orderId);
		for (Orderline orderline : listOrderLineOfOrder) {
			HDSerialBack hdserialBack = new HDSerialBack();
			long orderlineId = orderline.getId();
			long productId = orderline.getSanPham();
			List<HDSerial> listHDSerial = serialRepo.findByOrderlineIdAndProductId(orderlineId, productId);
			double qtySerialCurrent = listHDSerial.size();
			List<SaleOrder> listSaleOrderBackQty = findByOrderId(orderId);
			for (SaleOrder saleorder : listSaleOrderBackQty) {
				if (saleorder.getProductId() == productId) {
					if (qtySerialCurrent >= orderline.getSoLuong()) {
						double qtyBack = qtySerialCurrent - orderline.getSoLuong();
						hdserialBack.setOrderlineId(orderlineId);
						hdserialBack.setProductId(productId);
						hdserialBack.setProductName(productRepository.getOne(productId).getName());
						hdserialBack.setQtyBack(qtyBack);
						hdserialBack.setQtyScanned(qtySerialCurrent);
						hdserialBack.setQty(orderline.getSoLuong());
						result.add(hdserialBack);
						break;
					}
				}
			}
		}
		return result;
	}
	
	@GetMapping
	@RequestMapping("/checkorder/{orderId}")
	public String checkOrder(@PathVariable long orderId) {
		List<Orderline> listOrderlineSerial = orderlineRepository.findByOrderID(orderId);
		String check = "Y";
		for (Orderline orderline : listOrderlineSerial) {
			List<HDSerial> listSerialOfOrderline = serialRepo.findByOrderlineIdAndProductId(orderline.getId(), orderline.getSanPham());
			if (!(orderline.getSoLuong() == listSerialOfOrderline.size())) {
				check = "N";
			}
		}
		return check;
	}

	public List<SaleOrder> findByOrderId( long orderId) {
		List<SaleOrder> result = new ArrayList<SaleOrder>();
		MSaleorder listSaleorder = saleorderRepo.findByOrderId(orderId);
		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo
				.findBySaleOrderId(listSaleorder.getSaleOrderId());
		for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
			if (saleorderDetail.getCheckqty() > 0) {
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
				result.add(saleorder);
			}
		}
		return result;
	}

	public static String getValueDate(String date) {
		if (date.length() == 12)
			return date.substring(5, 8).concat(date.substring(10));
		else
			return "--";
	}

//	public List<Orderline> findCurrentQty(long orderId) {
//		List<Orderline> listOrderlineCheck = new ArrayList<>();
//
//		List<HDSerialProductMovement> listHDSerialProductMovement = new ArrayList<>();
//
//		List<MMovement> listMovement = movementRepo.findByOrderId(orderId);
//		List<MMovementLine> listMovementLine = new ArrayList<MMovementLine>();
//		
//		// Find Set Product
//		Set<Long> setProductId = new HashSet<>();
//		for (MMovement movement : listMovement) {
//			listMovementLine = movementlineRepo.findByMovementId(movement.getMovementID());
//			for (MMovementLine movementline : listMovementLine) {
//				setProductId.add(movementline.getProductId());
//			}
//		}
//
//		for (Long productId : setProductId) {
//			HDSerialProductMovement productMovement = new HDSerialProductMovement();
//			double quanMove = 0;
//			for (MMovementLine movementline : listMovementLine) {
//				if (productId == movementline.getProductId() && movementline.getCurrentLocatorId() != 1028787) {
//					quanMove = quanMove + movementline.getQuantity();
//				}
//			}
//			productMovement.setProductId(productId);
//			productMovement.setQtyMovement(quanMove);
//			listHDSerialProductMovement.add(productMovement);
//		}
//
//		// Check Orderline VS productMovement
//		List<Orderline> listOrderLineOfOrder = orderlineRepository.findByOrderID(orderId);
//		for (HDSerialProductMovement productMovement : listHDSerialProductMovement) {
//			Orderline orderlineCheck = new Orderline();
//			for (Orderline orderline : listOrderLineOfOrder) {
//				if (productMovement.getProductId() == orderline.getSanPham()) {
//					if (productMovement.getQtyMovement() >= orderline.getSoLuong()) {
//						orderlineCheck.setId(orderline.getId());
//						orderlineCheck.setDvt(orderline.getDvt());
//						orderlineCheck.setOrderID(orderline.getOrderID());
//						orderlineCheck.setSanPham(orderline.getSanPham());
//						orderlineCheck.setSoLuong(orderline.getSoLuong());
//					} else {
//						orderlineCheck.setId(orderline.getId());
//						orderlineCheck.setDvt(orderline.getDvt());
//						orderlineCheck.setOrderID(orderline.getOrderID());
//						orderlineCheck.setSanPham(orderline.getSanPham());
//						orderlineCheck.setSoLuong(productMovement.getQtyMovement());
//					}
//				}
//			}
//			listOrderlineCheck.add(orderlineCheck);
//		}
//		return listOrderlineCheck;
//	}

}
