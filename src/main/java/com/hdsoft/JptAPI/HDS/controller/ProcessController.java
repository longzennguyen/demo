package com.hdsoft.JptAPI.HDS.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hdsoft.JptAPI.HDS.Repositories.M_MovementRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_transactionRepository;
import com.hdsoft.JptAPI.HDS.model.ProductInfomation;
import com.hdsoft.JptAPI.HDS.model.m_attributesetinstance;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.HDS.model.m_storageonehand;
import com.hdsoft.JptAPI.HDS.model.m_transaction;

@RestController
@RequestMapping("api/v1/movementprocess")
public class ProcessController {
	@Autowired
	m_storageonhandRepository ms;
	@Autowired
	m_transactionRepository mt;
	@Autowired
	M_MovementRepository mm;
	@Autowired
	m_locatorRepository mlr;
	@Autowired
	m_attributesetinstanceRepository ma;

	GetIDUUDate g = new GetIDUUDate();
	// HDS Base App

//	@PostMapping
//	@RequestMapping("createtran")
	public String createTransaction(long m_product_id, long locatorid, double qty, long adorgid, String movementtype,long asiid) {
		
		m_transaction m_transaction = new m_transaction();
		m_transaction.setAd_client_id((long) 1000000);
		m_transaction.setAd_org_id(adorgid);
		m_transaction.setCreated(g.getDate());
		m_transaction.setCreatedby((long) 100);
		m_transaction.setId(g.getNextID("M_Transaction"));
		m_transaction.setM_attributesetinstance_id(asiid);
		m_transaction.setM_inoutline_id(null);
		m_transaction.setM_locator_id(locatorid);
		m_transaction.setM_product_id(m_product_id);
		m_transaction.setM_transaction_uu(g.getUUID());
		m_transaction.setMovementdate(g.getDate());
		m_transaction.setMovementqty(qty);
		m_transaction.setMovementtype(movementtype);
		m_transaction.setUpdated(g.getDate());
		m_transaction.setUpdatedby((long) 100);
		mt.save(m_transaction);
		return "Sucessful!";
	}

	@GetMapping
	@RequestMapping("abc")
	public int a() {
		List<m_storageonehand> list = new ArrayList<m_storageonehand>();
		list.add(ms.findByLocatoridAndProductid(1033883, 1237947));
		if (ms.findByLocatoridAndProductid(1033883, 1237947) == null) {
			System.out.println("Null");
		}
		return list.size();
	}

//	@PostMapping
//	@RequestMapping("processqty")
	public String processStorage(long adorgid, long locatorid, long productid, double qty,long asiid) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
// trừ slg từ vị trí cũ
		s1 = ms.findByLocatoridAndProductidAndAsiid(locatorid, productid, asiid);
		oldqty = s1.getQtyonhand();
		s1.setQtyonhand(oldqty - qty);
		ms.save(s1);
		System.out.println("Trừ số liệu thành công!");
		return "Sucessful!";
	}

	@PostMapping
	@RequestMapping("/process")
	public String processFunc(@RequestParam long locatorid, @RequestParam long locatortoid,
			@RequestParam long productid, @RequestParam long adorgid, @RequestParam long qty,@RequestParam long asiid) {
//		
		try {
			processStorage(adorgid, locatorid, productid, qty,asiid);
			System.out.println("Xu ly so lieu xong");
			createTransaction(productid, locatorid, (qty * (-1)), adorgid, "C-",asiid);
			System.out.println("tran 1");
		} catch (Exception e) {
			System.out.println("Rollback!");
			System.out.println("error:" + e);
		}
		return "Successfully!";
	}

//	NH
	@PostMapping
	@RequestMapping("processqty")
	public String processStorageNH(long adorgid,  long locatortoid, long productid, double qty,long asiid) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
//		System.out.println(s1.getLocatorid()+"");
		// check vị trí tới đã có chứa sp và slg hay chưa để lựa chọn update hay insert
		if (ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid) != null) {
			// đã có record
			// cộng slg vào vị trí mới
			storageonehand = ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid);
			oldqty = storageonehand.getQtyonhand();
			storageonehand.setQtyonhand((oldqty + qty));
			System.out.println("before  save");
			ms.save(storageonehand);
			System.out.println("After save");
			System.out.println("Cộng số liệu thành công!");

		} else {
			// Không có record
			// Tạo record và cộng slg vị trí mới
			storageonehand.setAd_org_id(adorgid);
			storageonehand.setAsiid((long) 0);
			storageonehand.setCreated(g.getDate());
			storageonehand.setCreatedby(100);
			storageonehand.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
			storageonehand.setId(1000000);
			storageonehand.setLocatorid(locatortoid);
			storageonehand.setM_storageonhand_uu(g.getUUID());
			storageonehand.setProductid(productid);
			storageonehand.setQtyonhand(qty);
			storageonehand.setUpdated(g.getDate());
			storageonehand.setUpdatedby(100);
			ms.save(storageonehand);
			System.out.println("Tạo record thành công!");
		} 
		return "Sucessful!";
	}

	//Process NH
	public String processStoragenh(long adorgid, long locatorid, long locatortoid, long productid, double qty,long asiid) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
		if (ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid) != null) {
			storageonehand = ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid);
			oldqty = storageonehand.getQtyonhand();
			storageonehand.setQtyonhand((oldqty + qty));
			System.out.println("before  save");
			ms.save(storageonehand);
			System.out.println("After save");
			System.out.println("Cộng số liệu thành công!");

		} else {
			// Không có record
			// Tạo record và cộng slg vị trí mới
			storageonehand.setAd_org_id(adorgid);
			storageonehand.setAsiid((long) 0);
			storageonehand.setCreated(g.getDate());
			storageonehand.setCreatedby(100);
			storageonehand.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
			storageonehand.setId(1000000);
			storageonehand.setLocatorid(locatortoid);
			storageonehand.setM_storageonhand_uu(g.getUUID());
			storageonehand.setProductid(productid);
			storageonehand.setQtyonhand(qty);
			storageonehand.setUpdated(g.getDate());
			storageonehand.setUpdatedby(100);
			ms.save(storageonehand);
			System.out.println("Tạo record thành công!");
		} // trừ slg từ vị trí cũ
//		s1 = ms.findByLocatoridAndProductid(locatorid, productid);
//		oldqty = s1.getQtyonhand();
//		s1.setQtyonhand(oldqty - qty);
//		ms.save(s1);
//		System.out.println("Trừ số liệu thành công!");
		return "Sucessful!";
	}

	@PostMapping
	@RequestMapping("/processnh")
	public String processFuncNhapHang(  @RequestParam long locatortoid,
			@RequestParam long productid, @RequestParam long adorgid, @RequestParam long qty,@RequestParam long asiid) {
//		
		try {
			long NHLocator =mlr.findByAdorgidAndValue(adorgid, "Nhận hàng").getId();
			System.out.println("ID NH: "+NHLocator);
			System.out.println("1");
			processStoragenh(adorgid,NHLocator,  locatortoid, productid, qty,asiid);
			System.out.println("Xu ly so lieu xong");
			createTransaction(productid, 1033888, qty*(-1), adorgid, "M-",asiid);
			System.out.println("tran 1");
			createTransaction(productid, locatortoid, qty, adorgid, "M+",asiid);
			System.out.println("tran 2");
		} catch (Exception e) {
			System.out.println("error:" + e);
		}
		return "Successfully!";
	}
	@PostMapping
	@RequestMapping("/processxh")
	public String processFuncXuatHang(@RequestParam long locatorid,@RequestParam long productid, @RequestParam long adorgid, @RequestParam double qty,@RequestParam long asiid) {
//		1033887 là id của vị trí xuất hàng
		try {
//			long XHLocator=mlr.findByAdorgidAndValue(adorgid, "Xuất hàng").getId();
			processStorage(adorgid,locatorid, productid, qty,asiid);
			System.out.println("Xu ly so lieu xong");
			createTransaction(productid, locatorid, qty*(-1), adorgid, "C-",asiid);
//			createTransaction(productid, 1033887, qty, adorgid, "M+");
//			System.out.println("tran 2");
		} catch (Exception e) {
			System.out.println("error:" + e);
		}
		return "Successfully!";
	}
	@PostMapping
	@RequestMapping("processctxk")
	public String processStorageonhand(@RequestParam long locatorid,@RequestParam long productid,@RequestParam long adorgid,@RequestParam double qty,@RequestParam long asiid) {
			processFuncXuatHang(locatorid,productid,adorgid,qty,asiid);
		return "Successful!";
	}

	// ===============================
	public String processFuncXuatHang(@RequestParam long locatorid, @RequestParam long productid,
			@RequestParam long adorgid, @RequestParam long qty,@RequestParam long asiid) {
		try {
			processStorage(adorgid, locatorid,  productid, qty,asiid);
			System.out.println("Xu ly so lieu xong");
			createTransaction(productid, locatorid, qty * (-1), adorgid, "C-",asiid);
//			createTransaction(productid, qty, adorgid, "M+");
//			System.out.println("tran 2");
		} catch (Exception e) {
			System.out.println("error:" + e);
		}
		return "Successfully!";
	}
	//Process nhập hàng cộng qty
	public String CongSoLieu(long adorgid,  long locatortoid, long productid, double qty,long asiid) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
//		System.out.println(s1.getLocatorid()+"");
		// check vị trí tới đã có chứa sp và slg hay chưa để lựa chọn update hay insert
		if (ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid) != null) {
			// đã có record
			// cộng slg vào vị trí mới
			storageonehand = ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid);
			oldqty = storageonehand.getQtyonhand();
			storageonehand.setQtyonhand((oldqty + qty));
			System.out.println("before  save");
			ms.save(storageonehand);
			System.out.println("After save");
			System.out.println("Cộng số liệu thành công!");

		} else {
			// Không có record
			// Tạo record và cộng slg vị trí mới
			storageonehand.setAd_org_id(adorgid);
			storageonehand.setAsiid(asiid);
			storageonehand.setCreated(g.getDate());
			storageonehand.setCreatedby(100);
			storageonehand.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
			storageonehand.setId(mlr.getOne(locatortoid).getAd_client_id());
			storageonehand.setLocatorid(locatortoid);
			storageonehand.setM_storageonhand_uu(g.getUUID());
			storageonehand.setProductid(productid);
			storageonehand.setQtyonhand(qty);
			storageonehand.setUpdated(g.getDate());
			storageonehand.setUpdatedby(100);
			ms.save(storageonehand);
			System.out.println("Tạo record thành công cong so lieu!");
		} 
		return "Sucessful!";
	}
	@PostMapping
	@RequestMapping("nh")
	public String process(@RequestParam long adorgid,@RequestParam long locatorid,@RequestParam long productid,@RequestParam double m2,@RequestParam String descriptionasi,@RequestParam String asinote,@RequestParam String date) {
		//create asi
		m_attributesetinstance m1 = new m_attributesetinstance();
		try {
			m1 = ma.findByAsinoteAndReuselevelAndAdorgid(asinote, descriptionasi, adorgid).get(0);
		} catch (Exception e) {
			m1.setAd_org_id(adorgid);
			m1.setAdclient(1000000);
			m1.setAsinote(asinote);
			m1.setCreated(g.getDate());
			m1.setCreatedby(100);
			m1.setDescription(descriptionasi);
			m1.setId(g.getNextID("M_AttributeSetInstance"));
			m1.setLot(null);
			m1.setM_attributesetinstance_uu(g.getUUID());
			m1.setReuselevel(descriptionasi);
			m1.setUpdated(g.getDate());
			m1.setGuaranteedate(Date.valueOf(date));
			m1.setUpdatedby(100);
			ma.save(m1);
		}
		//=====================
		long asiid = m1.getId();
		CongSoLieu(adorgid, locatorid,  productid, m2,asiid);
		System.out.println("==========1===========");
		createTransaction(productid, locatorid, m2, adorgid, "V+", asiid);
		return "Successfully";
		
	}
	//chuyen kho
	public String processStorageCK(long adorgid, long locatorid, long locatortoid, long productid, double qty) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
		if (ms.findByLocatoridAndProductid(locatortoid, productid) != null) {
			storageonehand = ms.findByLocatoridAndProductid(locatortoid, productid);
			oldqty = storageonehand.getQtyonhand();
			storageonehand.setQtyonhand((oldqty + qty));
			System.out.println("before  save");
			ms.save(storageonehand);
			System.out.println("After save");
			System.out.println("Cộng số liệu thành công!");

		} else {
			// Không có record
			// Tạo record và cộng slg vị trí mới
			storageonehand.setAd_org_id(adorgid);
			storageonehand.setAsiid((long) 0);
			storageonehand.setCreated(g.getDate());
			storageonehand.setCreatedby(100);
			storageonehand.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
			storageonehand.setId(1000003);
			storageonehand.setLocatorid(locatortoid);
			storageonehand.setM_storageonhand_uu(g.getUUID());
			storageonehand.setProductid(productid);
			storageonehand.setQtyonhand(qty);
			storageonehand.setUpdated(g.getDate());
			storageonehand.setUpdatedby(100);
			ms.save(storageonehand);
			System.out.println("Tạo record thành công!");
		} // trừ slg từ vị trí cũ
		s1 = ms.findByLocatoridAndProductid(locatorid, productid);
		oldqty = s1.getQtyonhand();
		s1.setQtyonhand(oldqty - qty);
		ms.save(s1);
		System.out.println("Trừ số liệu thành công!");
		return "Sucessful!";
	}
	@PostMapping
	@RequestMapping("processqtyck")
	public String processStorageCK(long adorgid, long locatorid, long locatortoid, long productid, double qty,long asiid) {
		m_storageonehand storageonehand = new m_storageonehand();
		m_storageonehand s1 = new m_storageonehand();// chứa dữ liệu tồn cũ của sp
		double oldqty;
		if (ms.findByLocatoridAndProductid(locatortoid, productid) != null) {
			storageonehand = ms.findByLocatoridAndProductidAndAsiid(locatortoid, productid,asiid);
			oldqty = storageonehand.getQtyonhand();
			storageonehand.setQtyonhand((double) (Math.round((oldqty + qty)*1000)/1000));
			System.out.println("before  save");
			ms.save(storageonehand);
			System.out.println("After save");
			System.out.println("Cộng số liệu thành công!");

		} else {
			// Không có record
			// Tạo record và cộng slg vị trí mới
			storageonehand.setAd_org_id(adorgid);
			storageonehand.setAsiid((long) 0);
			storageonehand.setCreated(g.getDate());
			storageonehand.setCreatedby(100);
			storageonehand.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
			storageonehand.setId(1000003);
			storageonehand.setLocatorid(locatortoid);
			storageonehand.setM_storageonhand_uu(g.getUUID());
			storageonehand.setProductid(productid);
			storageonehand.setQtyonhand((double) (Math.round(qty*1000)/1000));
			storageonehand.setUpdated(g.getDate());
			storageonehand.setUpdatedby(100);
			ms.save(storageonehand);
			System.out.println("Tạo record thành công!");
		} // trừ slg từ vị trí cũ
		s1 = ms.findByLocatoridAndProductid(locatorid, productid);
		oldqty = s1.getQtyonhand();
		s1.setQtyonhand((double) (Math.round((oldqty - qty)*1000)/1000));
		ms.save(s1);
		System.out.println("Trừ số liệu thành công!");
		return "Sucessful!";
	}
}
