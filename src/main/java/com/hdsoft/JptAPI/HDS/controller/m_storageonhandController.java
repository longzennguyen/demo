package com.hdsoft.JptAPI.HDS.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.LongHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.ConnectDB;
import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutlineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.model.ProductInfomation;
import com.hdsoft.JptAPI.HDS.model.m_attributesetinstance;
import com.hdsoft.JptAPI.HDS.model.m_storageonehand;
import com.hdsoft.JptAPI.HDS.model.m_storageonehandHaveProductName;

@RestController
@RequestMapping("api/v1/storageonhand")
public class m_storageonhandController {
	GetIDUUDate g = new GetIDUUDate();
	@Autowired
	m_storageonhandRepository ms;
	@Autowired
	m_productRepository mp;
	@Autowired
	m_attributesetinstanceRepository ma;
	@Autowired
	m_locatorRepository ml;
	@Autowired
	C_Uom_ConversionRepository cucr;
	@Autowired
	m_inoutlineRepository miol1;

	// GET
	@GetMapping
	@RequestMapping("/find")
	public m_storageonehand findByAsiidAndByLocatoridAndByProductid(@RequestParam long asiid,
			@RequestParam long locatorid, @RequestParam long productid) {
		return ms.findByAsiidAndLocatoridAndProductidAndAdclientid(asiid, locatorid, productid, 1000014);
	}

	// Vào kalipso và sử dụng tick replace trong json import table để lấy distinct
	// asiid
	@GetMapping
	@RequestMapping("/listasi")
	public List<m_storageonehand> findDistinctByAsiidAndId(@RequestParam long productid, @RequestParam long id) {
		return ms.findDistinctByProductidAndAdclientid(productid, id);
	}

	@GetMapping
	@RequestMapping("/getsumqty")
	public Double getSumQty(@RequestParam long asiid, @RequestParam long locatorid, @RequestParam long productid) {
		return ms.sumQtyonhanFocusLocatorAndProuct(locatorid, productid, asiid);
	}

	// lấy tất cả record để coi product đang trong những pallet nào
	@GetMapping
	@RequestMapping("/findbyproduct")
	public List<m_storageonehand> findByProduct(@RequestParam long productid) {
		return ms.findByProductid(productid);
	}

	// Lấy tất cả product đang có trong pallet id có sẵn
	@GetMapping
	@RequestMapping("/findbypallet")
	public List<m_storageonehand> findByPallet(@RequestParam long asiid, @RequestParam long locatorid) {
		System.out.println("Size Product on Pallet: ");
		return ms.findByAsiidAndAdclientidAndLocatorid(asiid, (long) 1000014, locatorid);
	}

	@GetMapping
	@RequestMapping("/findbypalletno")
	public List<m_storageonehand> findByPalletno(@RequestParam String lot, @RequestParam long locatorid) {
		System.out.println("Size Product on Pallet: ");
		List<Long> listAsi = new ArrayList<Long>();
		for (m_attributesetinstance m1 : ma.findByLotAndAdclient(lot, 1000014)) {
			listAsi.add(m1.getId());
		}
		List<m_storageonehand> m = new ArrayList<m_storageonehand>();
		m = ms.findByAdclientidAndLocatoridAndAsiidIn((long) 1000014, locatorid, listAsi);
		for (m_storageonehand m_storageonehand : m) {
			System.out.println("QtyOnHan: " + m_storageonehand.getQtyonhand());
			if (m_storageonehand.getQtyonhand() == 0) {
				System.out.println("Remove");
				m.remove(m_storageonehand);
			}
		}
		return m;
	}

	@GetMapping
	@RequestMapping("/findbylocator")
	public List<m_storageonehand> findbyLocatorID(@RequestParam long locatorid) {
		System.out.println("Find by locator ID");
		return ms.findByLocatorid(locatorid);
	}

	@GetMapping
	@RequestMapping("/findbylocatorproductasi")
	public m_storageonehand findByLocatoridAndProductidAndAsiid(@RequestParam long locatorid,
			@RequestParam long productid, @RequestParam long asiid) {
		return ms.findByLocatoridAndProductidAndAsiid(locatorid, productid, asiid);
	}

	// lấy dữ liệu tồn kho
	@GetMapping
	@RequestMapping("/tonkho")
	public List<m_storageonehand> tonkho() {
		return ms.findByAdclientidAndQtyonhandGreaterThan(1000000, 0);
	}

	// Lấy tồn theo vị trí và client\
	@GetMapping
	@RequestMapping("laytonkho")
	public List<m_storageonehand> laytonkho(@RequestParam long locatorid) {
		return ms.findByAdclientidAndLocatoridAndQtyonhandGreaterThan(1000000, locatorid, 0);
	}

	// POST
	@PostMapping
	@RequestMapping("insert")
	public m_storageonehand createnewStorageonhand(@RequestParam long locatorid, @RequestParam long productid,
			@RequestParam long asiid, @RequestParam long qty) {
		m_storageonehand m = new m_storageonehand();
		m.setId(1000014); // ad_client_id
		m.setCreated(g.getDate());
		m.setCreatedby(1000080);
		m.setAd_org_id(1000039);
		m.setUpdated(g.getDate());
		m.setUpdatedby(1000080);
		m.setAsiid(asiid);
		m.setLocatorid(locatorid);
		m.setM_storageonhand_uu(g.getUUID());
		m.setProductid(productid);
		m.setQtyonhand((double) qty);
		m.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
		System.out.println("Giờ Convert: " + m.getDatematerialpolicy());
		return ms.saveAndFlush(m);
	}

	// PUT
	// Cộng trừ số liệu trong m_storageonhand theo locatorid,productid,asiid
	@PutMapping("update")
	public void UpdateQtyInStorage2(@RequestParam long locatorid, @RequestParam long productid,
			@RequestParam long asiid, @RequestParam long qty, @RequestParam String status) {
		// Tìm record
		System.out.println("Get old Data");
		m_storageonehand mst = new m_storageonehand();
		mst = ms.findByLocatoridAndProductidAndAsiid(locatorid, productid, asiid);
		long newqty = 0;
		// tìm được m_storageonhand thỏa mãn param truyền vô
		if (status.equalsIgnoreCase("add")) {
			newqty = (long) (mst.getQtyonhand() + qty);
			System.out.println("Cộng số liệu: " + newqty);
			mst.setQtyonhand(mst.getQtyonhand() + qty);
		} else {
			System.out.println("Trừ số liệu");
			mst.setQtyonhand(mst.getQtyonhand() - qty);
		}

		System.out.println("Qty after process: " + mst.getQtyonhand());

		// Xử lý số liệu
		String query = "update m_storageonhand set qtyonhand= " + newqty + " where m_locator_id= " + locatorid
				+ " AND m_product_id = " + productid + " and m_attributesetinstance_id = " + asiid
				+ " and ad_client_id = 1000014";
		System.out.println(query);
		try {
			System.out.println("Done");
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
		}
		ConnectDB connectDB = new ConnectDB();
		Connection con = null;
		try {
			con = connectDB.conHD();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement sta = null;
		try {
			System.out.println("Create statement");
			sta = con.createStatement();
		} catch (SQLException e) {
		}
		try {
			System.out.println("execute query");
			sta.executeQuery(query);
		} catch (SQLException e) {
		}
		// xóa record có slg = 0

		System.out.println("Done");
	}

	// HDS Base
	// GET
	@GetMapping
	@RequestMapping("checkton")
	public m_storageonehand findcheck(@RequestParam long locatorid, @RequestParam long productid) {
		return ms.findByLocatoridAndProductid(locatorid, productid);
	}

	// POST
	@PostMapping
	@RequestMapping("create")
	public m_storageonehand createnew(@RequestParam long adorgid, @RequestParam long locatorid,
			@RequestParam long productid, @RequestParam long qty) {
		m_storageonehand m = new m_storageonehand();
		m.setId(1000003); // ad_client_id
		m.setCreated(g.getDate());
		m.setCreatedby(100);
		m.setAd_org_id(adorgid);
		m.setUpdated(g.getDate());
		m.setUpdatedby(100);
		m.setAsiid((long) 1354623);
		m.setLocatorid(locatorid);

		m.setM_storageonhand_uu(g.getUUID());
		m.setProductid(productid);
		m.setQtyonhand((double) qty);
		m.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
		System.out.println("Giờ Convert: " + m.getDatematerialpolicy());
		return ms.saveAndFlush(m);
	}

	@GetMapping
	@RequestMapping("demo")
	public m_storageonehand demo(@RequestParam long locatorid, long productid) {
		return ms.findByLocatoridAndProductid(locatorid, productid);
	}

	@PutMapping
	@RequestMapping("updateqty")
	public m_storageonehand updateqty(@RequestParam long locatorid, @RequestParam long productid,
			@RequestParam long qty, @RequestParam String status) {
		m_storageonehand m = new m_storageonehand();
		m = ms.findByLocatoridAndProductid(locatorid, productid);
		m_storageonehand m1 = new m_storageonehand();
		m1 = m;
		long qtynew = 0;
		Double oldqty = m1.getQtyonhand();
		System.out.println("AUAIKJMAOP:A: " + oldqty);
		if (status.equals("A")) {
			qtynew = (long) (oldqty + qty);
		} else {
			qtynew = (long) (oldqty - qty);
		}
		m.setQtyonhand((double) qtynew);
		m.setDatematerialpolicy(Timestamp.valueOf(java.time.LocalDate.now() + " 00:00:00"));
		m.setUpdated(g.getDate());
		m.setAsiid((long) 1354623);
		return ms.saveAndFlush(m);
	}

	// Thạch Bàn
	@GetMapping
	@RequestMapping("listtktb")
	public List<ProductInfomation> listTK(@RequestParam long adorgid) {
		List<ProductInfomation> list = new ArrayList<ProductInfomation>();
		for (m_storageonehand m1 : ms.findByAdorgidAndAdclientidAndQtyonhandGreaterThan(1000000, 1000000, 0.0)) {
			ProductInfomation p1 = new ProductInfomation();
			p1.setClientid(1000000);
			p1.setDvt("pcs");
			p1.setM_attributeset_id(100);
			p1.setM_attributesetinstance_id(m1.getAsiid());
			p1.setM_attributesetinstance_value(ma.getOne(m1.getAsiid()).getDescription());
			p1.setOrgid(1000000);
			p1.setPricesale(0);
			p1.setProductCategoryid(0);
			p1.setProductCategoryName("0");
			p1.setProductID(m1.getProductid());
			p1.setProductName(mp.getOne(m1.getProductid()).getName());
			p1.setProductValue(mp.getOne(m1.getProductid()).getValue());
			p1.setPurprice(0);
			p1.setQty((double) m1.getQtyonhand());
			p1.setThuoctinh(null);
			p1.setUnisperpack(1);
			p1.setUomID(100);
			p1.setLocatorid(m1.getLocatorid());
			p1.setLocatorName(ml.getOne(m1.getLocatorid()).getValue());
			list.add(p1);
		}
		return list;
	}

	// Lay ton theo productID
	@GetMapping
	@RequestMapping("findbyproductidtb")
	public List<m_storageonehandHaveProductName> listForcusProduct(@RequestParam long productid,
			@RequestParam long adclientid) {
		List<m_storageonehandHaveProductName> list1 = new ArrayList<m_storageonehandHaveProductName>();
		for (m_storageonehand m1 : ms.findByProductidAndAdclientidAndQtyonhandGreaterThan(productid, adclientid, 0.0)) {
			m_storageonehandHaveProductName m2 = new m_storageonehandHaveProductName();
			m2.setAsiid(m1.getAsiid());
			m2.setLocatorid(m1.getLocatorid());
			m2.setLocatorName(ml.getOne(m1.getLocatorid()).getValue());
			m2.setProductid(m1.getProductid());
			m2.setProductName(mp.getOne(m1.getProductid()).getValue());
			m2.setNote(ma.getOne(m1.getAsiid()).getAsinote());
			double multiplyrate = 1;

			m2.setQtyonhand(m1.getQtyonhand());
			if (ma.getOne(m1.getAsiid()).getDescription().length() > 13) {
				m2.setAsiName(
						ma.getOne(m1.getAsiid()).getDescription().substring(4, 14) + "(" + m2.getQtyonhand() + ")");
			} else {
				m2.setAsiName(ma.getOne(m1.getAsiid()).getDescription() + "(" + m2.getQtyonhand() + ")");
			}
			m2.setUu(m1.getM_storageonhand_uu());
			list1.add(m2);

		}
		return list1;
	}
}
