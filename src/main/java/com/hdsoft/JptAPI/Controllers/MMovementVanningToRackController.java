package com.hdsoft.JptAPI.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.Models.HDSerialProductMovement;
import com.hdsoft.JptAPI.Models.MMovement;
import com.hdsoft.JptAPI.Models.MMovementLine;
import com.hdsoft.JptAPI.Models.MMovementVanningToRack;
import com.hdsoft.JptAPI.Models.MSaleorder;
import com.hdsoft.JptAPI.Models.MSaleorderDetail;
import com.hdsoft.JptAPI.Models.ProductCheck;
import com.hdsoft.JptAPI.Repositories.LocatorRepository;
import com.hdsoft.JptAPI.Repositories.MAttributeSetInstanceRepository;
import com.hdsoft.JptAPI.Repositories.MMovementLineRepository;
import com.hdsoft.JptAPI.Repositories.MMovementRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderDetailRepository;
import com.hdsoft.JptAPI.Repositories.MSaleorderRepository;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;
import com.hdsoft.JptAPI.Repositories.ProductRepository;
import com.hdsoft.JptAPI.Repositories.StorageOnHandRepository;

@RestController
@RequestMapping("/api/v1/vanningtorack")
public class MMovementVanningToRackController {

	@Autowired
	MSaleorderRepository saleorderRepo;

	@Autowired
	MSaleorderDetailRepository saleorderDetailRepo;

	@Autowired
	StorageOnHandRepository storageonhandRepo;

	@Autowired
	OrderlineRepository orderlineRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	LocatorRepository locatorRepo;

	@Autowired
	MAttributeSetInstanceRepository attributeRepo;

	@Autowired
	MMovementRepository movementRepo;

	@Autowired
	MMovementLineRepository movementlineRepo;

//	@GetMapping
//	@RequestMapping("/{orderId}")
//	public List<MMovementVanningToRack> listByOrderId(@PathVariable long orderId) {
//		List<ProductCheck> listProduct = listProductCheck(orderId);
//		List<MMovementVanningToRack> result = new ArrayList<MMovementVanningToRack>();
//		List<Orderline> listOrderline = orderlineRepo.findByOrderID(orderId);
//		for (Orderline orderline : listOrderline) {
//			ProductCheck product = findProductByProductId(listProduct, orderline.getSanPham());
//			if (product != null) {
//				if (product.getQty() > orderline.getSoLuong()) {
//					MMovementVanningToRack movementBack = new MMovementVanningToRack();
//					List<StorageOnHand> listStorage = storageonhandRepo
//							.findByProductIdAndLocatorIdOrderByAttributeSetInstanceIdDesc(product.getProductId(),
//									1028787);
//					double backQty = product.getQty() - orderline.getSoLuong();
//					for (StorageOnHand storageonhand : listStorage) {
//						double asiQty = storageonhand.getQuantityOnHand();
//						movementBack.setOrderlineId(orderline.getId());
//						movementBack.setProductId(product.getProductId());
//						movementBack.setProductName(productRepo.getOne(product.getProductId()).getName());
//						if (backQty > asiQty) {
//							movementBack.setBackQty(asiQty);
//							backQty = backQty - asiQty;
//						} else {
//							movementBack.setBackQty(backQty);
//						}
//						movementBack.setAsiId(storageonhand.getAttributeSetInstanceId());
//						movementBack.setAsiQty(asiQty);
//						movementBack.setAsiName(getValueDate(
//								attributeRepo.getOne(storageonhand.getAttributeSetInstanceId()).getValue()));
//						result.add(movementBack);
//					}
//				}
//			}
//		}
//		return result;
//	}

	@GetMapping
	@RequestMapping("/{orderId}")
	public List<MMovementVanningToRack> listByOrderId(@PathVariable long orderId) {
		List<MMovementVanningToRack> result = new ArrayList<MMovementVanningToRack>();
		MSaleorder saleorder = saleorderRepo.findByOrderId(orderId);
		List<MSaleorderDetail> listSaleorderDetail = saleorderDetailRepo.findBySaleOrderId(saleorder.getSaleOrderId());
		List<HDSerialProductMovement> listMove = getMovementTT(orderId);
		for (MSaleorderDetail saleorderDetail : listSaleorderDetail) {
			if (saleorderDetail.getCheckqty() > 0) {
				long productId = saleorderDetail.getProductId();
				double quanMove = 0;
				for (HDSerialProductMovement productMove : listMove) {
					if (productId == productMove.getProductId()) {
						quanMove += productMove.getQtyMovement();
					}
				}
				MMovementVanningToRack movement = new MMovementVanningToRack();
				long locatorId = saleorderDetail.getLocatorId();
				long asiId = saleorderDetail.getAsiId();
				movement.setAsiId(asiId);
				movement.setAsiName("--");
				double backQty = saleorderDetail.getCheckqty() - quanMove;
				if (backQty != 0) {
					movement.setBackQty(saleorderDetail.getCheckqty());
				} else {
					movement.setBackQty(0);
				}
				movement.setM_locator_id(locatorId);
				movement.setProductId(productId);
				movement.setProductName(productRepo.getOne(productId).getName());
				result.add(movement);
			}
		}
		return result;
	}

	// Kiểm tra hàng đã chuyển về Rack
	public List<HDSerialProductMovement> getMovementTT(long orderId) {

		List<HDSerialProductMovement> listMove = new ArrayList<HDSerialProductMovement>();

		// Get listmovementlineback
		List<MMovementLine> listMovementlineBack = new ArrayList<>();
		List<MMovement> listMovement = movementRepo.findByOrderId(orderId);
		for (MMovement movement : listMovement) {
			List<MMovementLine> listMovementline = movementlineRepo.findByMovementId(movement.getMovementID());
			for (MMovementLine movementline : listMovementline) {
				if (movementline.getCurrentLocatorId() == 1028787) {
					listMovementlineBack.add(movementline);
				}
			}
		}

		// Find set productId
		Set<Long> setProductId = new HashSet<Long>();
		for (MMovementLine movementline : listMovementlineBack) {
			setProductId.add(movementline.getProductId());
		}

		// Find qtyProduct
		for (long productId : setProductId) {
			HDSerialProductMovement productMove = new HDSerialProductMovement();
			double quanMove = 0;
			for (MMovementLine movementline : listMovementlineBack) {
				if (movementline.getProductId() == productId) {
					quanMove = quanMove + movementline.getQuantity();
				}
			}
			productMove.setProductId(productId);
			productMove.setQtyMovement(quanMove);
			listMove.add(productMove);
		}
		return listMove;
	}

	public ProductCheck findProductByProductId(List<ProductCheck> listProduct, long productId) {
		for (ProductCheck product : listProduct) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	public Integer findProduct(List<ProductCheck> listProduct, long productId) {
		int count = 0;
		for (ProductCheck product : listProduct) {
			if (product.getProductId() == productId) {
				return count;
			}
			count = count + 1;
		}
		return null;
	}

	public List<ProductCheck> listProductCheck(long orderId) {
		List<ProductCheck> result = new ArrayList<ProductCheck>();
		List<MMovement> listMovement = movementRepo.findByOrderId(orderId);
		for (MMovement movement : listMovement) {
			if (movement.getDoctypeId() == 1000987) {
				List<MMovementLine> listMovementLine = movementlineRepo.findByMovementId(movement.getMovementID());
				for (MMovementLine movementLine : listMovementLine) {
					if (result.isEmpty()) {
						ProductCheck product = new ProductCheck();
						long productId = movementLine.getProductId();
						product.setProductId(productId);
						product.setQty(movementLine.getQuantity());
						product.setAsiId(movementLine.getAttributeSetId());
						result.add(product);
					} else {
						Integer index = findProduct(result, movementLine.getProductId());
						if (index != null) {
							ProductCheck product = result.get(index);
							product.setQty(product.getQty() + movementLine.getQuantity());
							result.set(index, product);
						} else {
							ProductCheck product = new ProductCheck();
							long productId = movementLine.getProductId();
							product.setProductId(productId);
							product.setQty(movementLine.getQuantity());
							product.setAsiId(movementLine.getAttributeSetId());
							result.add(product);
						}
					}
				}
			}
		}
		for (MMovement movement : listMovement) {
			if (movement.getDoctypeId() == 1000988) {
				List<MMovementLine> listMovementLine = movementlineRepo.findByMovementId(movement.getMovementID());
				for (MMovementLine movementLine : listMovementLine) {
					Integer index = findProduct(result, movementLine.getProductId());
					if (index != null) {
						ProductCheck product = result.get(index);
						product.setQty(product.getQty() - movementLine.getQuantity());
						result.set(index, product);
					}
				}
			}
		}
		return result;
	}

	public static String getValueDate(String date) {
		if (date.length() > 2)
			return date.substring(5, 8).concat(date.substring(10));
		else
			return date;
	}

}
