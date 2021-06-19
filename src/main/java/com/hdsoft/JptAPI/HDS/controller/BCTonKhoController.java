package com.hdsoft.JptAPI.HDS.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.Size;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.KebabCaseStrategy;
import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_WarehouseRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutlineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_transactionRepository;
import com.hdsoft.JptAPI.HDS.model.TonKhoModel;
import com.hdsoft.JptAPI.HDS.model.m_locator;
import com.hdsoft.JptAPI.HDS.model.m_storageonehand;
import com.hdsoft.JptAPI.Models.Locator;
import com.hdsoft.JptAPI.Models.Product;
import com.hdsoft.JptAPI.Repositories.ProductRepository;

@RestController
@RequestMapping("api/v1/baocaotonkho")
public class BCTonKhoController {
	@Autowired
	ProductRepository productRep;
	@Autowired
	m_locatorRepository locatorRep;
	@Autowired
	m_storageonhandRepository storageRep;
	@Autowired
	m_attributesetinstanceRepository asiRep;
	@Autowired
	C_Uom_ConversionRepository cucr;
	@Autowired
	M_WarehouseRepository mw;
	@Autowired
	m_inoutlineRepository miol1;
	@Autowired
	m_transactionRepository mtr;

//	===================GET===================
	@GetMapping
	public List<m_storageonehand> KebabCaseStrategy() {
		return storageRep.findByAdclientidAndQtyonhandGreaterThan(1000000, 0.0);
	}

	@GetMapping
	@RequestMapping("alltonkhoold")
	public List<TonKhoModel> showBCTonKho() {
		List<TonKhoModel> ListShow = new ArrayList<TonKhoModel>();
		List<m_storageonehand> l1 = new ArrayList<m_storageonehand>();
//		l1.addAll(storageRep.findByAdclientidAndProductidAndQtyonhandGreaterThan(1000000,1242259, 0.0));
		// storageRep.findByAdclientidAndQtyonhandGreaterThan(1000000, 0.0)
		for (m_storageonehand m : storageRep.findByAdclientidAndQtyonhandGreaterThanOrderByUpdatedDesc(1000000, 0.0)) {
			if (("" + m.getAsiid()).length() != 0) {
				TonKhoModel tk = new TonKhoModel();
				tk.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
				Product product = new Product();
				product = productRep.findById(m.getProductid());
				tk.setSanPham(product.getValue());
				double q1 = m.getQtyonhand();
				// ngay sx = ngay cua giao dich moi nhat
				// tk.setNgaySX(mtr.getMaxUpdated(m.getProductid(),m.getLocatorid()).toString().substring(0,
				// 10));
				tk.setNgaySX(m.getUpdated().toString().substring(0, 10));

				tk.setMaPhu(product.getDescription());
				DecimalFormat df = new DecimalFormat("#.###");
				double qtyonhand = Double.parseDouble(df.format(m.getQtyonhand())); // dvt gốc là m2
				// convert ke - vien
				double convertKeVien;
				double dividerate = 1;
				int kepart = 0;
				try {
					dividerate = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), 1000046, 1000063)
							.getDividerate();
//					System.out.println("Convert ke: "+dividerate);
					kepart = (int) ((qtyonhand) / dividerate);// lấy phần nguyên
					tk.setKe((double) Math.round(Double.parseDouble(df.format(kepart))));
					qtyonhand = Double.parseDouble(df.format(qtyonhand - (kepart * dividerate)));// refresh qtyonhand
				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println("bcd");
					tk.setKe(0.0);

				}

				// lấy số hộp
				double convertHopVien;
				double diverateHopVien = 1;
				int hoppart = 0;
				try {
					diverateHopVien = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), 1000046, 1000045)
							.getDividerate();
//					if(m.getProductid()==1258534) {
//						System.out.println("qtyonhand: "+qtyonhand+" mul: "+diverateHopVien);
//					}
					hoppart = (int) (qtyonhand / diverateHopVien);
					tk.setHop((double) Math.round(Double.parseDouble(df.format(hoppart))));
					qtyonhand = Double.parseDouble(df.format(qtyonhand - (hoppart) * dividerate));
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("def");
					tk.setHop(0.0);
				}

				double m2Convert = 0.0;
				try {

//					m2Convert = q1*multiplyrate;
					tk.setM2(q1);
				} catch (Exception e) {
					// TODO: handle exception
					tk.setM2(0.0);
					tk.setSoLuong(qtyonhand);
				}
				tk.setSoLuong(qtyonhand);
				tk.setWarehouseValue(mw.getOne(locatorRep.getOne(m.getLocatorid()).getM_warehouse_id()).getName());
				try {
					tk.setNote(asiRep.getOne(m.getAsiid()).getAsinote());
				} catch (Exception e) {
					tk.setNote(null);
				}
				ListShow.add(tk);
			}
		}
		return ListShow;
	}

	@GetMapping
	@RequestMapping("alltonkho")
	public List<TonKhoModel> showBCTonKhoUpdate() {
		List<TonKhoModel> ListShow = new ArrayList<TonKhoModel>();
		List<m_storageonehand> l1 = new ArrayList<m_storageonehand>();
		// cache lưu trữ các giá trị đã add vào
		HashMap<Long, String> map = new HashMap<Long, String>();
		for (m_storageonehand m : storageRep.findByAdclientidAndQtyonhandGreaterThan(1000000, 0.0)) {

			if ((m.getAsiid()).toString().length() != 0) {

				if (productRep.getOne(m.getProductid()).getValue().equals("S1"))
					System.out.println("add : " + m.getQtyonhand() + "info: " + m.getProductid() + "-" + m.getAsiid()
							+ "-" + m.getLocatorid());
				TonKhoModel tk = new TonKhoModel();
				tk.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
				Product product = new Product();
				product = productRep.findById(m.getProductid());
				tk.setSanPham(product.getValue());
				double q1 = m.getQtyonhand();
				// ngay sx = ngay cua giao dich moi nhat
				tk.setNgaySX(mtr.getMaxUpdated(m.getProductid(), m.getLocatorid()).toString().substring(0, 10));
				tk.setMaPhu(product.getDescription());
				DecimalFormat df = new DecimalFormat("#.###");
				double qtyonhand = 0;
				if (storageRep.countProductInLocator(m.getLocatorid(), m.getProductid(), m.getAsiid()) > 1
						&& !map.containsValue((m.getProductid() + "-" + m.getAsiid() + "-" + m.getLocatorid()))) {// &&
					// !map.containsValue((m.getProductid()+"-"+m.getAsiid()+"-"+m.getLocatorid()))

					qtyonhand = Double.parseDouble(df.format(storageRep
							.sumQtyonhanFocusLocatorAndProuct(m.getLocatorid(), m.getProductid(), m.getAsiid()))); // dvt																						// gốc
																													// là
																													// m2
					tk.setSoLuong(qtyonhand);
					q1=qtyonhand;
					// convert ke - vien
				} else {
					qtyonhand = Double.parseDouble(df.format(m.getQtyonhand()));
				}
				double convertKeVien;
				double dividerate = 1;
				int kepart = 0;
				try {
					dividerate = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), 1000046, 1000063)
							.getDividerate();
//					System.out.println("Convert ke: "+dividerate);
					kepart = (int) ((qtyonhand) / dividerate);// lấy phần nguyên
					tk.setKe((double) Math.round(Double.parseDouble(df.format(kepart))));
					qtyonhand = Double.parseDouble(df.format(qtyonhand - (kepart * dividerate)));// refresh
																									// qtyonhand
				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println("bcd");
					tk.setKe(0.0);

				}

				// lấy số hộp
				double convertHopVien;
				double diverateHopVien = 1;
				int hoppart = 0;
				try {
					diverateHopVien = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), 1000046, 1000045)
							.getDividerate();
//					if(m.getProductid()==1258534) {
//						System.out.println("qtyonhand: "+qtyonhand+" mul: "+diverateHopVien);
//					}
					hoppart = (int) (qtyonhand / diverateHopVien);
					tk.setHop((double) Math.round(Double.parseDouble(df.format(hoppart))));
					qtyonhand = Double.parseDouble(df.format(qtyonhand - (hoppart) * dividerate));
				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println("def");
					tk.setHop(0.0);
				}

				double m2Convert = 0.0;
				try {

//					m2Convert = q1*multiplyrate;
					tk.setM2(q1);
				} catch (Exception e) {
					// TODO: handle exception
					tk.setM2(0.0);
					tk.setSoLuong(qtyonhand);
				}
				tk.setSoLuong(qtyonhand);
				tk.setWarehouseValue(mw.getOne(locatorRep.getOne(m.getLocatorid()).getM_warehouse_id()).getName());
				try {
					tk.setNote(asiRep.getOne(m.getAsiid()).getAsinote());
				} catch (Exception e) {
					tk.setNote(null);
				}

				if (!map.containsValue((m.getProductid() + "-" + m.getAsiid() + "-" + m.getLocatorid()))) { // &&
					ListShow.add(tk);
					map.put((long) map.size(), (m.getProductid() + "-" + m.getAsiid() + "-" + m.getLocatorid()));
				
				}else {
					System.out.println("remove : "+m.getAsiid()+" - "+tk.getSanPham()+"-"+tk.getViTri()+"-"+tk.getWarehouseValue());
					
				}
			} else {

			}

		}
		return ListShow;
	}

	//BC ton kho all kho
	@GetMapping
	@RequestMapping("alltonkhobyclient")
	public List<TonKhoModel> showBCTonKhoUpdateByClient(@RequestParam long adclientid,@RequestParam long uomM2,@RequestParam long uomH,@RequestParam long uomK) {
		List<TonKhoModel> ListShow = new ArrayList<TonKhoModel>();
		List<m_storageonehand> l1 = new ArrayList<m_storageonehand>();
		// cache lưu trữ các giá trị đã add vào
		HashMap<Long, String> map = new HashMap<Long, String>();
		for (m_storageonehand m : storageRep.findByAdclientidAndQtyonhandGreaterThan(adclientid, 0.0)) {

			if ((m.getAsiid()).toString().length() != 0) {

				if (productRep.getOne(m.getProductid()).getValue().equals("S1"))
					System.out.println("add : " + m.getQtyonhand() + "info: " + m.getProductid() + "-" + m.getAsiid()
							+ "-" + m.getLocatorid());
				TonKhoModel tk = new TonKhoModel();
				tk.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
				Product product = new Product();
				product = productRep.findById(m.getProductid());
				tk.setSanPham(product.getValue());
				double q1 = m.getQtyonhand();
				// ngay sx = ngay cua giao dich moi nhat
				tk.setNgaySX(mtr.getMaxUpdated(m.getProductid(), m.getLocatorid()).toString().substring(0, 10));
				tk.setMaPhu(product.getDescription());
				DecimalFormat df = new DecimalFormat("#.###");
				double qtyonhand = 0;
				if (storageRep.countProductInLocator(m.getLocatorid(), m.getProductid(), m.getAsiid()) > 1
						&& !map.containsValue((m.getProductid() + "-" + m.getAsiid() + "-" + m.getLocatorid()))) {// &&
					// !map.containsValue((m.getProductid()+"-"+m.getAsiid()+"-"+m.getLocatorid()))

					qtyonhand = Double.parseDouble(df.format(storageRep
							.sumQtyonhanFocusLocatorAndProuct(m.getLocatorid(), m.getProductid(), m.getAsiid()))); // dvt																						// gốc
																													// là
																													// m2
					tk.setSoLuong(qtyonhand);
					q1=qtyonhand;
					// convert ke - vien
				} else {
					qtyonhand = Double.parseDouble(df.format(m.getQtyonhand()));
				}
				double convertKeVien;
				double dividerate = 1;
				int kepart = 0;
				try {
					dividerate = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), uomM2, uomK)
							.getDividerate();
//					System.out.println("Convert ke: "+dividerate);
					kepart = (int) ((qtyonhand) / dividerate);// lấy phần nguyên
					tk.setKe((double) Math.round(Double.parseDouble(df.format(kepart))));
					qtyonhand = Double.parseDouble(df.format(qtyonhand - (kepart * dividerate)));// refresh
																									// qtyonhand
				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println("bcd");
					tk.setKe(0.0);

				}

				// lấy số hộp
				double convertHopVien;
				double diverateHopVien = 1;
				int hoppart = 0;
				try {
					diverateHopVien = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), uomM2, uomH)
							.getDividerate();
//					if(m.getProductid()==1258534) {
//						System.out.println("qtyonhand: "+qtyonhand+" mul: "+diverateHopVien);
//					}
					hoppart = (int) (qtyonhand / diverateHopVien);
					tk.setHop((double) Math.round(Double.parseDouble(df.format(hoppart))));
					qtyonhand = Double.parseDouble(df.format(qtyonhand - (hoppart) * dividerate));
				} catch (Exception e) {
					// TODO: handle exception
					// System.out.println("def");
					tk.setHop(0.0);
				}

				double m2Convert = 0.0;
				try {

//					m2Convert = q1*multiplyrate;
					tk.setM2(q1);
				} catch (Exception e) {
					// TODO: handle exception
					tk.setM2(0.0);
					tk.setSoLuong(qtyonhand);
				}
				tk.setSoLuong(qtyonhand);
				tk.setWarehouseValue(mw.getOne(locatorRep.getOne(m.getLocatorid()).getM_warehouse_id()).getName());
				try {
					tk.setNote(asiRep.getOne(m.getAsiid()).getAsinote());
				} catch (Exception e) {
					tk.setNote(null);
				}

				if (!map.containsValue((m.getProductid() + "-" + m.getAsiid() + "-" + m.getLocatorid()))) { // &&
					ListShow.add(tk);
					map.put((long) map.size(), (m.getProductid() + "-" + m.getAsiid() + "-" + m.getLocatorid()));
				
				}else {
					System.out.println("remove : "+m.getAsiid()+" - "+tk.getSanPham()+"-"+tk.getViTri()+"-"+tk.getWarehouseValue());
					
				}
			} else {

			}

		}
		return ListShow;
	}
	
	
	
	
	/*
	 * @GetMapping
	 * 
	 * @RequestMapping("/baocaovitritrong") public List<m_locator>
	 * showBCViTriTrong() { // List<TonKhoModel> showList = new
	 * ArrayList<TonKhoModel>(); // List<m_storageonehand> listStorageonHand = new
	 * ArrayList<m_storageonehand>(); List<m_locator> listLocator = new
	 * ArrayList<m_locator>(); listLocator =
	 * locatorRep.findAllByAdclientid(1000000); List<m_locator> showL = new
	 * ArrayList<m_locator>(); showL = locatorRep.findAllByAdclientid(1000000); for
	 * (m_storageonehand m :
	 * storageRep.findByAdclientidAndQtyonhandGreaterThan(1000000, 0)) { for
	 * (m_locator ml : listLocator) { if (m.getLocatorid() == ml.getId()) {
	 * showL.remove(ml); } } } System.out.println("Size old link: "+showL.size());
	 * return showL; }
	 */
	@GetMapping
	@RequestMapping("/baocaovitritrong")
	public List<m_locator> showBCViTriTrong1() {
//		List<m_locator> listLocator = new ArrayList<m_locator>();
//		listLocator = locatorRep.findAllByAdclientid(1000000);
//		System.out.println(listLocator.size());
//		List<m_locator> listremoveList = new ArrayList<>();
//		for (m_locator m_locator : listLocator) {
//			int a;
//			try {
//				a = locatorRep.countTK(m_locator.getId());
//			} catch (Exception e) {
//				break;
//			}
//			if (a == 0) {
//				listremoveList.add(m_locator);
//			}
//		}
//		for (m_locator m_locator : listremoveList) {
//			listLocator.remove(m_locator);
//		}
		return locatorRep.listAllVTT(1000000);
	}//
	@GetMapping
	@RequestMapping("/baocaovitritrongallclient")
	public List<m_locator> showBCViTriTrongbyClient(@RequestParam long client) {
		List<m_locator> listLocator = new ArrayList<m_locator>();
		listLocator = locatorRep.findAllByAdclientid(client);
		System.out.println(listLocator.size());
		List<m_locator> listremoveList = new ArrayList<>();
		for (m_locator m_locator : listLocator) {
			int a;
			try {
				a = locatorRep.countTK(m_locator.getId());
			} catch (Exception e) {
				break;
			}
			if (a == 0) {
				listremoveList.add(m_locator);
			}
		}
		for (m_locator m_locator : listremoveList) {
			listLocator.remove(m_locator);
		}
		return listLocator;
	}
	//bc vi tri trong all client
	@GetMapping
	@RequestMapping("/baocaovitritrongbyclient")
	public List<m_locator> showBCViTriTrongbyclient(@RequestParam long clientid) {
		List<m_locator> listLocator = new ArrayList<m_locator>();
//		listLocator = locatorRep.findAllByAdclientid(clientid);
//		System.out.println(listLocator.size());
		List<m_locator> listremoveList = new ArrayList<>();
		for (m_locator m_locator : listLocator) {
			int a;
			try {
				a = locatorRep.countTK(m_locator.getId());
				System.out.println(m_locator.getValue()+ " - " + a);
			} catch (Exception e) {
				break;
			}
			if (a == 0) {
				System.out.println(m_locator.getValue() +" - have product" );
				listremoveList.add(m_locator);
			}
		}

//		System.out.println("Size of list have store: "+listremoveList.size()+"\n size of storage: "+listLocator.size());
////		for (m_locator m_locator : listremoveList) {
////			listLocator.remove(m_locator);
////		}
//		listLocator.removeAll(listremoveList);
		System.out.println("Size of list : "+listremoveList.size());
		return listremoveList;
	}

	@GetMapping
	@RequestMapping("listvtt")
	public List<m_locator> listVTT(@RequestParam long ad_client_id){
		return locatorRep.listAllVTT(ad_client_id);
	}
	// Thạch Bàn
	@GetMapping
	@RequestMapping("/findtest")
	public List<m_storageonehand> fi() {
		return storageRep.findByAdclientidAndQtyonhandGreaterThan(1000000, 0);
	}

	@GetMapping
	@RequestMapping("/findbylocator")
	public List<TonKhoModel> FindByLocator(@RequestParam long locatorid) {
		List<TonKhoModel> listshowKhoModels = new ArrayList<TonKhoModel>();
		List<Locator> locatorList = new ArrayList<Locator>();
		System.out.println("Size find : "
				+ storageRep.findByAdclientidAndLocatoridAndQtyonhandGreaterThan(1000000, locatorid, 0).size());
		for (m_storageonehand m : storageRep.findByAdclientidAndLocatoridAndQtyonhandGreaterThan(1000000, locatorid,
				0)) {

			TonKhoModel tKhoModel = new TonKhoModel();
			tKhoModel.setNgaySX(asiRep.findById(m.getAsiid()).get().getDescription());
			tKhoModel.setASIID(m.getAsiid());
			tKhoModel.setLocatorid(m.getLocatorid());
			tKhoModel.setProductID(m.getProductid());
			tKhoModel.setSanPham(productRep.findById(m.getProductid()).getValue());
			tKhoModel.setSoLuong(m.getQtyonhand());

			double multiplyrate = 1;
			try {
				multiplyrate = cucr.findByProductidAndUomidAndUomtoid(m.getProductid(), 1000047, 1000046)
						.getMultiplyrate();// lấy ra tỷ số nhân
			} catch (Exception e) {
				// TODO: handle exception
			}
			tKhoModel.setM2(m.getQtyonhand() * multiplyrate);
			tKhoModel.setDocumentno(tKhoModel.getNgaySX() + "(" + tKhoModel.getM2() + ")");
			tKhoModel.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
			listshowKhoModels.add(tKhoModel);
		}
		return listshowKhoModels;
	}

	// Thach ban
	@GetMapping
	@RequestMapping("/findbylocatorid")
	public List<TonKhoModel> FindByLocatorid(@RequestParam long locatorid) {
		List<TonKhoModel> listshowKhoModels = new ArrayList<TonKhoModel>();
		List<Locator> locatorList = new ArrayList<Locator>();
		for (m_storageonehand m : storageRep.findByAdclientidAndLocatoridAndQtyonhandGreaterThan(1000000, locatorid,
				0.0)) {
			TonKhoModel tKhoModel = new TonKhoModel();
			tKhoModel.setNgaySX(asiRep.findById(m.getAsiid()).get().getDescription());
			tKhoModel.setASIID(m.getAsiid());
			tKhoModel.setLocatorid(m.getLocatorid());
			tKhoModel.setProductID(m.getProductid());
			tKhoModel.setSanPham(productRep.findById(m.getProductid()).getValue());
			tKhoModel.setSoLuong(m.getQtyonhand());
			tKhoModel.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
			tKhoModel.setWarehouseValue(mw.getOne(locatorRep.getOne(m.getLocatorid()).getM_warehouse_id()).getName());
			listshowKhoModels.add(tKhoModel);
		}
		return listshowKhoModels;
	}
	@GetMapping
	@RequestMapping("/findbylocatoridbyclient")
	public List<TonKhoModel> FindByLocatoridbyclient(@RequestParam long locatorid,@RequestParam long  clientid) {
		List<TonKhoModel> listshowKhoModels = new ArrayList<TonKhoModel>();
		List<Locator> locatorList = new ArrayList<Locator>();
		for (m_storageonehand m : storageRep.findByAdclientidAndLocatoridAndQtyonhandGreaterThan(clientid, locatorid,
				0.0)) {
			TonKhoModel tKhoModel = new TonKhoModel();
			tKhoModel.setNgaySX(asiRep.findById(m.getAsiid()).get().getDescription());
			tKhoModel.setASIID(m.getAsiid());
			tKhoModel.setLocatorid(m.getLocatorid());
			tKhoModel.setProductID(m.getProductid());
			tKhoModel.setSanPham(productRep.findById(m.getProductid()).getValue());
			tKhoModel.setSoLuong(m.getQtyonhand());
			tKhoModel.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
			tKhoModel.setWarehouseValue(mw.getOne(locatorRep.getOne(m.getLocatorid()).getM_warehouse_id()).getName());
			listshowKhoModels.add(tKhoModel);
		}
		return listshowKhoModels;
	}

	// HDS Base APP
	@GetMapping
	@RequestMapping("/timkiemtheosanphamvachinhanh")
	public List<TonKhoModel> timkiemtheoSPAndChiNhanh(@RequestParam long ad_org_id) {
		List<TonKhoModel> listShow = new ArrayList<TonKhoModel>();
		for (m_storageonehand st : storageRep.findByAdorgidAndAdclientidAndQtyonhandGreaterThan(ad_org_id, 1000003,
				0)) {
			TonKhoModel tk = new TonKhoModel();
			tk.setASIID(st.getAsiid());
			tk.setLocatorid(st.getLocatorid());
			tk.setNgaySX(asiRep.findById(st.getAsiid()).get().getLot());
			tk.setProductID(st.getProductid());
			tk.setSanPham(productRep.findById(st.getProductid()).getValue());
			tk.setSoLuong(st.getQtyonhand());
			tk.setViTri(locatorRep.findById(st.getLocatorid()).getValue());
			listShow.add(tk);
		}
		return listShow;
	}

	@GetMapping
	@RequestMapping("/tonkhosanpham")
	public List<TonKhoModel> timkiemtheoSPTK(@RequestParam long productid) {
		List<TonKhoModel> listShow = new ArrayList<TonKhoModel>();
		for (m_storageonehand st : storageRep.findByProductidAndQtyonhandGreaterThan(productid, 0)) {
			TonKhoModel tk = new TonKhoModel();
			tk.setASIID(st.getAsiid());
			tk.setLocatorid(st.getLocatorid());
			tk.setNgaySX(asiRep.findById(st.getAsiid()).get().getLot());
			tk.setProductID(st.getProductid());
			tk.setSanPham(productRep.findById(st.getProductid()).getValue());
			tk.setSoLuong(st.getQtyonhand());
			tk.setViTri(locatorRep.findById(st.getLocatorid()).getValue());
			listShow.add(tk);
		}
		return listShow;
	}

	@GetMapping
	@RequestMapping("/findbylocator1")
	public List<TonKhoModel> FindByLocato1r(@RequestParam long locatorid) {
		List<TonKhoModel> listshowKhoModels = new ArrayList<TonKhoModel>();
		List<Locator> locatorList = new ArrayList<Locator>();
		for (m_storageonehand m : storageRep.findByAdclientidAndLocatoridAndQtyonhandGreaterThan(1000003, locatorid,
				0)) {
			TonKhoModel tKhoModel = new TonKhoModel();
			tKhoModel.setNgaySX(asiRep.findById(m.getAsiid()).get().getLot());
			tKhoModel.setASIID(m.getAsiid());
			tKhoModel.setLocatorid(m.getLocatorid());
			tKhoModel.setProductID(m.getProductid());
			tKhoModel.setSanPham(productRep.findById(m.getProductid()).getValue());
			tKhoModel.setSoLuong(m.getQtyonhand());
			tKhoModel.setViTri(locatorRep.findById(m.getLocatorid()).getValue());
			listshowKhoModels.add(tKhoModel);
		}

		return listshowKhoModels;
	}

	//
}
