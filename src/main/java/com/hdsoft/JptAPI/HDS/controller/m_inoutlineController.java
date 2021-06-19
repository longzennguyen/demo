package com.hdsoft.JptAPI.HDS.controller;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.model.M_InoutLineHoanThanh;
import com.hdsoft.JptAPI.HDS.model.M_InoutLineInforChiThiXuatKhoTB;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.HDS.Repositories.C_UomRepository;
import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutlineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;

@RestController
@RequestMapping("api/v1/lm_inoutline")
public class m_inoutlineController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	m_inoutlineRepository mLineRepository;
	@Autowired
	m_attributesetinstanceRepository mab;
	@Autowired
	m_locatorRepository ml;
	@Autowired
	m_inoutRepository inoutRepo;
	@Autowired
	m_productRepository productRepo;
	@Autowired
	C_Uom_ConversionRepository cucr;
	@Autowired
	C_UomRepository cur1;

	// GET
	@GetMapping
	@RequestMapping(value = "/findisdisplay/{m_inout_id}")
	public List<m_inoutline> getDetailOfMInOut(@PathVariable long m_inout_id) {
		List<m_inoutline> listFocusMInOutID = new ArrayList<m_inoutline>();
		for (m_inoutline m : mLineRepository.findAll()) {
			if (m.getAd_client_id() == 1000014 && m.getM_inout_id() == m_inout_id) {
				listFocusMInOutID.add(m);
			}
		}
		return listFocusMInOutID;

	}

	@GetMapping
	public m_inoutline TopID() {
		return mLineRepository.findTopByOrderByIdDesc();
	}

	@GetMapping
	@RequestMapping(value = "/findmaxnumbergen/")
	public String findTopByOrderNumbergenByDesc1() {
		long numbermax = 0;
		long number;
		String pattern = "";
		for (m_inoutline m : mLineRepository.findByNumbergenIsNotNullAndAdclientid(1000014)) {
			System.out.println("Check : " + m.getAttributeinfor());
			number = Long.parseLong(m.getNumbergen().replace("'", ""));
			if (number > numbermax)
				numbermax = number;
		}
		System.out.println("Number Max: " + numbermax);
		return "" + numbermax;
	}

	@GetMapping
	@RequestMapping(value = "/findmaxnumbergen1/")
	public List<m_inoutline> findTopByOrderNumbergenByDesc2() {
		return mLineRepository.findByNumbergenIsNotNullAndAdclientid(1000014);
	}

	// POST
	@RequestMapping(method = RequestMethod.POST, value = "/nhapkho")
	public m_inoutline insertNewDetailForMInOut(@RequestParam long m_inout_id, @RequestParam long m_product_id,
			@RequestParam long m_attributesetinstance_id, @RequestParam String attributeinfor,
			@RequestParam long qtyentered, @RequestParam long movementqty, @RequestParam long line,
			@RequestParam long c_orderline_id, @RequestParam String palletfrelix, @RequestParam String invoiceno,
			@RequestParam String numbergen, @RequestParam long locatorid, @RequestParam String carton,
			@RequestParam String orderno) {
		m_inoutline m = new m_inoutline();
		m.setId(g.getNextID("M_InOutLine"));
		m.setAd_client_id((long) 1000014);
		m.setOrderno(orderno);
		m.setAd_org_id(1000039);
		m.setM_locator_id(locatorid);
		m.setCreated(g.getDate());
		m.setCreatedby((long) 1000080);
		m.setUpdated(g.getDate());
		m.setUpdatedby(1000080);
		m.setC_orderline_id(c_orderline_id);
		m.setM_inoutline_uu(g.getUUID());
		m.setLine(line);
		m.setDescription(null);
		m.setM_inout_id(m_inout_id);
		m.setM_product_id(m_product_id);
		m.setC_uom_id(100);
		m.setAttributeinfor(attributeinfor);
		m.setM_attributesetinstance_id(m_attributesetinstance_id);
		m.setQtyentered(qtyentered);
		m.setMovementqty(movementqty);
		m.setPalletfrelix(palletfrelix);
		m.setInvoiceno(invoiceno);
		m.setQtyctn(carton);
		m.setNumbergen(numbergen);
		return mLineRepository.saveAndFlush(m);
	}

	// Thạch Bàn
	// GET
	@GetMapping
	@RequestMapping
	public List<M_InoutLineHoanThanh> M_InouLineInformation(@RequestParam long m_inout_id) {
		List<m_inoutline> listm1 = new ArrayList<m_inoutline>();
		List<M_InoutLineHoanThanh> listshow = new ArrayList<M_InoutLineHoanThanh>();
		for (m_inoutline m1 : mLineRepository.findByMinoutid(m_inout_id)) {
			M_InoutLineHoanThanh m2 = new M_InoutLineHoanThanh();
			m2.setDocumentno(null);
			m2.setM_inout_id(m1.getM_inout_id());
			m2.setProductID(m1.getM_product_id());
			m2.setProductName(productRepo.getOne(m1.getM_product_id()).getValue());
			// process m2
			// qty = m2
			// id dvt: m2 = 1000046,viên = 1000047,hộp=1000045,kệ=1000063
			double quydoi;
			int ke = 0, hop = 0, vien = 0;
			// quy đổi m2-kệ
			quydoi = cucr.findByProductidAndUomidAndUomtoid(m1.getM_product_id(), 1000046, 1000063).getDividerate();
			// Tiếp tục quy đổi
			long qty = 0;
			qty = (long) m1.getQtyentered();
			ke = (int) (qty / quydoi);
			qty -= ke * quydoi;
			if (quydoi > 0) {
				quydoi = cucr.findByProductidAndUomidAndUomtoid(m1.getM_product_id(), 1000046, 1000045).getDividerate();

			}
		}
		return null;
	}

	// POST
	@RequestMapping(method = RequestMethod.POST, value = "/nhapkhoThachBan")
	public m_inoutline createDetailThachBan(@RequestParam long m_inout_id, @RequestParam long m_product_id,
			@RequestParam String attributeinfor, @RequestParam double qtyentered, @RequestParam double movementqty,
			@RequestParam long line, @RequestParam long c_orderline_id, @RequestParam long locatorid) {
		// locatorID=&productID=&quantity=&asiInfo=&uomID=m_inout_id=&c_orderline_id=&qtyover=&ad_client_id=ad_org_idad_user_id=
		m_inoutline m = new m_inoutline();
		m.setId(g.getNextID("M_InOutLine"));
		m.setAd_client_id((long) 1000000);
		m.setAd_org_id(1000000);
		m.setM_locator_id(locatorid);
		m.setCreated(g.getDate());
		m.setCreatedby((long) 1000005);
		m.setUpdated(g.getDate());
		m.setUpdatedby(1000005);
		m.setC_orderline_id(c_orderline_id);
		m.setM_inoutline_uu(g.getUUID());
		m.setLine(line);
		m.setDescription(null);
		m.setM_inout_id(m_inout_id);
		m.setM_product_id(m_product_id);
		m.setC_uom_id(100);
		m.setAttributeinfor(attributeinfor);
//		m.setM_attributesetinstance_id(m_attributesetinstance_id);
		m.setQtyentered(qtyentered);
		m.setMovementqty(movementqty);
		return mLineRepository.saveAndFlush(m);
	}

//	@RequestMapping(method = RequestMethod.POST,value="/nhapkhoThachBan")
	@RequestMapping(method = RequestMethod.POST, value = "/nhapkhotb")
	public m_inoutline createNH(@RequestParam long m_inout_id, @RequestParam long m_product_id,
			@RequestParam String attributeinfor, @RequestParam double qtyentered, @RequestParam long line,
			@RequestParam long c_orderline_id, @RequestParam long locatorid, @RequestParam double qtyover,
			@RequestParam long uomID) {
		m_inoutline m = new m_inoutline();
		m.setId(g.getNextID("M_InOutLine"));
		m.setAd_client_id((long) 1000000);
		m.setAd_org_id(1000000);
		m.setM_locator_id(locatorid);
		m.setCreated(g.getDate());
		m.setCreatedby((long) 1000005);
		m.setUpdated(g.getDate());
		m.setUpdatedby(1000005);
		if (c_orderline_id == 0)
			m.setC_orderline_id(null);
		else
			m.setC_orderline_id(c_orderline_id);
		m.setM_inoutline_uu(g.getUUID());
		m.setLine(line);
		m.setDescription(null);
		// ====================
		double conversion;
		conversion = cucr.findByProductidAndUomidAndUomtoid(m_product_id, 1000047, 1000046).getMultiplyrate();
		System.out.println("COnversion: " + conversion + " qtyentered: " + qtyentered + " movementqty: "
				+ (qtyentered / conversion));
		double movementqtyFInal = qtyentered / conversion;
		m.setMovementqty(movementqtyFInal);
		// ====================
		m.setM_inout_id(m_inout_id);
		m.setM_product_id(m_product_id);
		m.setQtyoverreceipt(qtyover);
		m.setC_uom_id(uomID);
		m.setAttributeinfor(attributeinfor);
//		m.setM_attributesetinstance_id(m_attributesetinstance_id);
		m.setQtyentered(qtyentered);
		return mLineRepository.saveAndFlush(m);
	}

	@GetMapping
	@RequestMapping("/demo/{minoutId}")
	public List<M_InoutLineInforChiThiXuatKhoTB> findByOrderIdDemo(@PathVariable long minoutId) {
		List<M_InoutLineInforChiThiXuatKhoTB> list = new ArrayList<M_InoutLineInforChiThiXuatKhoTB>();
		System.out.println("Size: " + mLineRepository.findByMinoutid(minoutId).size());
		for (m_inoutline m1 : mLineRepository.findByMinoutid(minoutId)) {
			M_InoutLineInforChiThiXuatKhoTB m2 = new M_InoutLineInforChiThiXuatKhoTB();
			m2.setLocatorId(m1.getM_locator_id());
			m2.setLocatorName(ml.getOne(m1.getM_locator_id()).getValue());
			m2.setMaLineId(m1.getId());
			m2.setMaterialId(m1.getM_inout_id());
//			m2.setOrderId(inoutRepo.getOne(minoutId).getC_order_id());
			m2.setProductId(m1.getM_product_id());
			m2.setProductDescription(productRepo.getOne(m1.getM_product_id()).getDescription());
			m2.setProductName(productRepo.getOne(m1.getM_product_id()).getValue());
			m2.setQty(m1.getQtyentered());
			m2.setUomId(m1.getC_uom_id());
			m2.setUomName(cur1.getOne(m1.getC_uom_id()).getName());
//			m2.setUnitperpack(productRepo.getOne(m1.getM_product_id()).getUnitsperpack());
//			m2.setOrderlineId(m1.getC_orderline_id());
			if (m1.getHds_qtycheckdemo() == null) {
				m1.setHds_qtycheckdemo((long) 0);
			}
			m2.setQtyCheck(m1.getMovementqty());
			m2.setAsiId(m1.getM_attributesetinstance_id());
			m2.setAsiValue(mab.getOne(m1.getM_attributesetinstance_id()).getDescription());

			list.add(m2);
		}

		return list;
	}

	@GetMapping
	@RequestMapping("/demo1/{minoutId}")
	public List<M_InoutLineInforChiThiXuatKhoTB> findByOrderIdDemo1(@PathVariable long minoutId) {
		List<M_InoutLineInforChiThiXuatKhoTB> list = new ArrayList<M_InoutLineInforChiThiXuatKhoTB>();
//		System.out.println("Size: " + mLineRepository.findByMinoutid(minoutId).size());
		List<m_inoutline> list11 = new ArrayList<m_inoutline>();
		list11 = mLineRepository.findByMinoutid(minoutId);
		List<m_inoutline> list12 = new ArrayList<m_inoutline>();
		list12.addAll(list11);
		for (m_inoutline m1 : list11) {
			int count = 0;
			for (m_inoutline m12 : list12) {
				if (m1.getId() == m12.getId()) {
					count++;
					break;
				}
			}
			if (count >0) {
				M_InoutLineInforChiThiXuatKhoTB m2 = new M_InoutLineInforChiThiXuatKhoTB();
				m2.setLocatorId(m1.getM_locator_id());
				m2.setLocatorName(ml.getOne(m1.getM_locator_id()).getValue());
				m2.setMaLineId(m1.getId());
				m2.setMaterialId(m1.getM_inout_id());
//			m2.setOrderId(inoutRepo.getOne(minoutId).getC_order_id());
				m2.setProductId(m1.getM_product_id());
				m2.setProductDescription(productRepo.getOne(m1.getM_product_id()).getDescription());
				m2.setProductName(productRepo.getOne(m1.getM_product_id()).getValue());
				m2.setQty(m1.getQtyentered());
				m2.setUomId(m1.getC_uom_id());
				m2.setUomName(cur1.getOne(m1.getC_uom_id()).getName());
//			m2.setUnitperpack(productRepo.getOne(m1.getM_product_id()).getUnitsperpack());
//			m2.setOrderlineId(m1.getC_orderline_id());
				if (m1.getHds_qtycheckdemo() == null) {
					m1.setHds_qtycheckdemo((long) 0);
				}
				m2.setQtyCheck(m1.getMovementqty());
				m2.setAsiId(m1.getM_attributesetinstance_id());
				m2.setAsiValue(mab.getOne(m1.getM_attributesetinstance_id()).getDescription());

				// ==============
				try {
					List<m_inoutline> listFor1 = new ArrayList<m_inoutline>();
					listFor1 = mLineRepository.getAllDetailFocusByUOM(minoutId, m1.getM_product_id(),
							m1.getM_attributesetinstance_id(), m1.getM_locator_id());
					for (m_inoutline m11 : listFor1) {
						if (m11.getC_uom_id() == 1000046) {
								try {
									m2.setM2(m11.getQtyentered()+m2.getM2());
								} catch (Exception e) {
									m2.setM2(m11.getQtyentered());
								}
							
						} else if (m11.getC_uom_id() == 1000063) {
							try {
								m2.setKe(m11.getQtyentered()+m2.getKe());
							} catch (Exception e) {
								m2.setKe(m11.getQtyentered());
							}
							
						} else if (m11.getC_uom_id() == 1000045) {
							try {
								m2.setHop(m11.getQtyentered()+m2.getHop());
							} catch (Exception e) {
								m2.setHop(m11.getQtyentered());
							}
						} else if (m11.getC_uom_id() == 1000047) {
							try {
								m2.setVien(m11.getQtyentered()+m2.getVien());
							} catch (Exception e) {
								m2.setVien(m11.getQtyentered());
							}
						}
						list12.remove(m11);

					}
				} catch (Exception e) {
					// không có dữ liệu theo sp
					m2.setM2(0.0);
					m2.setKe(0.0);
					m2.setHop(0.0);
					m2.setVien(0.0);
				}
				// =============
				list.add(m2);
			}
		}

		return list;
	}

	// gán số liệu theo UOM
	@GetMapping
	@RequestMapping("/chitietgopdong/{minoutId}")
	public List<M_InoutLineInforChiThiXuatKhoTB> findByOrderIdDemoFocusUOM(@PathVariable long minoutId) {
		List<M_InoutLineInforChiThiXuatKhoTB> list = new ArrayList<M_InoutLineInforChiThiXuatKhoTB>();
		List<m_inoutline> list11 = new ArrayList<m_inoutline>();
		list11 = mLineRepository.findByMinoutid(minoutId);
		System.out.println("Size : " + list11.size());
		for (m_inoutline m1 : list11) {
			M_InoutLineInforChiThiXuatKhoTB m2 = new M_InoutLineInforChiThiXuatKhoTB();
			m2.setLocatorId(m1.getM_locator_id());
			m2.setLocatorName(ml.getOne(m1.getM_locator_id()).getValue());
			m2.setMaLineId(m1.getId());
			m2.setM2(0.0);
			m2.setKe(0.0);
			m2.setHop(0.0);
			m2.setVien(0.0);
			m2.setMaterialId(m1.getM_inout_id());
			m2.setProductId(m1.getM_product_id());
			m2.setProductDescription(productRepo.getOne(m1.getM_product_id()).getDescription());
			m2.setProductName(productRepo.getOne(m1.getM_product_id()).getValue());
			// phan chia ke hop
			try {
				List<m_inoutline> listFor1 = new ArrayList<m_inoutline>();
				listFor1 = mLineRepository.getAllDetailFocusByUOM(minoutId, m1.getM_product_id(),
						m1.getM_attributesetinstance_id(), m1.getM_locator_id());
				for (m_inoutline m11 : listFor1) {
					if (m11.getC_uom_id() == 1000046) {
						m2.setM2(m1.getQtyentered());
					} else if (m11.getC_uom_id() == 1000063) {
						m2.setKe(m1.getQtyentered());
					} else if (m11.getC_uom_id() == 1000045) {
						m2.setHop(m1.getQtyentered());
					} else if (m11.getC_uom_id() == 1000047) {
						m2.setVien(m1.getQtyentered());
					}
					if (m11.getM_inoutline_uu().equals(m1.getM_inoutline_uu())) {
					} else {
						list11.remove(m11);
					}

				}
			} catch (Exception e) {
				// không có dữ liệu theo sp
				m2.setM2(0.0);
				m2.setKe(0.0);
				m2.setHop(0.0);
				m2.setVien(0.0);
			}
			m2.setQty(m1.getQtyentered());
			m2.setUomId(m1.getC_uom_id());
			// ket thuc
			m2.setUomName(cur1.getOne(m1.getC_uom_id()).getName());
			if (m1.getHds_qtycheckdemo() == null) {
				m1.setHds_qtycheckdemo((long) 0);
			}
			m2.setQtyCheck(m1.getMovementqty());
			m2.setAsiId(m1.getM_attributesetinstance_id());

			m2.setAsiValue(mab.getOne(m2.getAsiId()).getDescription());
			list.add(m2);
		}

		return list;
	}

	// HDS TB
	@RequestMapping(method = RequestMethod.POST, value = "/detail")
	public m_inoutline create(@RequestParam long m_inout_id, @RequestParam long m_product_id,
			@RequestParam double qtyentered, @RequestParam double movementqty, @RequestParam long line,
			@RequestParam long locatorid, @RequestParam long adorgid, @RequestParam long asiid,
			@RequestParam long uomid,@RequestParam String note) {
		m_inoutline m = new m_inoutline();
		m.setId(g.getNextID("M_InOutLine"));
		m.setAd_client_id((long) inoutRepo.getOne(m_inout_id).getAd_client_id());
		m.setOrderno(null);
		m.setAd_org_id(adorgid);
		m.setM_locator_id(locatorid);
		m.setCreated(g.getDate());
		m.setCreatedby((long) 100);
		m.setUpdated(g.getDate());
		m.setUpdatedby(100);
		m.setC_orderline_id(null);
		m.setM_inoutline_uu(g.getUUID());
		m.setLine(line);
		m.setDescription(note);
		m.setM_inout_id(m_inout_id);
		m.setM_product_id(m_product_id);
		m.setC_uom_id(uomid);
		m.setAttributeinfor(null);
		m.setM_attributesetinstance_id(asiid);
		m.setQtyentered(qtyentered);
		m.setMovementqty(movementqty);
		m.setPalletfrelix(null);
		m.setInvoiceno(null);
		m.setQtyctn(null);
		m.setNumbergen(null);
		m.setM_linewarehouse_id(ml.getOne(locatorid).getM_warehouse_id());
		return mLineRepository.saveAndFlush(m);
	}

}
