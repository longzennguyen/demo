package com.hdsoft.JptAPI.HDS.controller;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_UomRepository;
import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_AttributesetRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_ProductPriceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_Product_CategoryCRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_WarehouseRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutlineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_transactionRepository;
import com.hdsoft.JptAPI.HDS.model.C_UOM;
import com.hdsoft.JptAPI.HDS.model.ProductInfomation;
import com.hdsoft.JptAPI.HDS.model.m_inout;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.HDS.model.m_locator;
import com.hdsoft.JptAPI.HDS.model.m_product;
import com.hdsoft.JptAPI.HDS.model.m_productprice;
import com.hdsoft.JptAPI.HDS.model.m_storageonehand;
import com.hdsoft.JptAPI.Models.Locator;
import com.hdsoft.JptAPI.Repositories.OrderlineRepository;

@RestController
@RequestMapping("api/v1/sanpham")
public class ProductInformationController {
	@Autowired
	m_productRepository mp;
	@Autowired
	C_UomRepository cur;
	@Autowired
	M_Product_CategoryCRepository mrcr;
	@Autowired
	M_AttributesetRepository mar;
	@Autowired
	M_ProductPriceRepository mppr;
	@Autowired
	m_storageonhandRepository msr;
	@Autowired
	m_inoutRepository mio;
	@Autowired
	m_inoutlineRepository miol;
	@Autowired
	m_locatorRepository ml;
	@Autowired
	OrderlineRepository or;
	@Autowired
	m_transactionRepository mt;
	@Autowired
	m_attributesetinstanceRepository mair;
	@Autowired
	M_WarehouseRepository mwr;
	@Autowired 
	C_Uom_ConversionRepository cucr;
	GetIDUUDate g = new GetIDUUDate();

	// HDS Base App
	// GET
	@GetMapping
	@RequestMapping("/thongtin")
	public ProductInfomation ThongTinSP(@RequestParam long productID) {
		ProductInfomation p = new ProductInfomation();
		m_product mpr = new m_product();
		mpr = mp.findById(productID);
		p.setClientid(mpr.getClientId());
		p.setDvt(cur.getOne(mpr.getC_uom_id()).getName());
		p.setM_attributeset_id(mpr.getM_attributeset_id());
		p.setThuoctinh(mar.getOne(mpr.getM_attributeset_id()).getName());
		p.setOrgid(mpr.getAd_org_id());
		p.setProductID(mpr.getId());
		p.setProductName(mpr.getName());
		p.setMaPhu(mpr.getDescription());
		p.setProductValue(mpr.getValue());
		p.setUnisperpack(mpr.getUnitsperpack());
		p.setUomID(mpr.getC_uom_id());
		p.setProductCategoryid(mpr.getM_product_category());
		m_productprice mProductprice = new m_productprice();
		try {
			mProductprice = mppr.findByProductid(mpr.getId()).get(0);
		} catch (Exception e) {
			mProductprice.setPricelist(0);
			mProductprice.setPricestd(0);
		}
		p.setPricesale(mProductprice.getPricelist());
		p.setPurprice(mProductprice.getPricestd());
		p.setProductCategoryName(mrcr.getOne(mpr.getM_product_category()).getValue());
		return p;
	}

	@GetMapping
	@RequestMapping("1")
	public C_UOM aj(@RequestParam long id) {
		return cur.getOne(id);
	}

	@GetMapping
	@RequestMapping("findbyvalueandorg")
	public ProductInfomation findbyvalueandorg(@RequestParam String value, @RequestParam long orgid) {
		ProductInfomation p = new ProductInfomation();
		m_product m = new m_product();
		m = mp.findByValueAndAdorgid(value, orgid);
		try {

			System.out.println("Client: " + m.getAd_org_id());
			if (m.getAd_org_id() == null) {
				System.out.println("null");
				return null;
			} else {
				p.setClientid(1000003);
				p.setDvt(cur.findById(m.getC_uom_id()).get().getName());
				p.setM_attributeset_id(m.getM_attributeset_id());
				p.setOrgid(orgid);
				p.setProductCategoryid(m.getM_product_category());
				p.setProductCategoryName(mrcr.getOne(m.getM_product_category()).getValue());
				p.setProductID(m.getId());
				p.setProductName(m.getName());
				p.setProductValue(m.getValue());
				p.setThuoctinh(mar.getOne(m.getM_attributeset_id()).getName());
				p.setUnisperpack(1);
				p.setUomID(m.getC_uom_id());
				m_productprice mProductprice = new m_productprice();
				try {
					mProductprice = mppr.findByProductid(m.getId()).get(0);
				} catch (Exception e) {
					mProductprice.setPricelist(0);
					mProductprice.setPricestd(0);
				}
				p.setPricesale(mProductprice.getPricelist());
				p.setPurprice(mProductprice.getPricestd());
				return p;
			}
		} catch (Exception e) {
			return null;
		}
	}

	@GetMapping
	@RequestMapping("testz")
	public m_productprice a() {
		return mppr.findByProductid(1237939).get(0);
	}

	@GetMapping
	@RequestMapping("thongtintatcasanpham")
	public List<ProductInfomation> listAll(@RequestParam long adorgid) {
		List<ProductInfomation> list = new ArrayList<ProductInfomation>();
		for (m_product m : mp.findByAdorgid(adorgid)) {
			ProductInfomation p = new ProductInfomation();
			p.setDvt(cur.getOne(m.getC_uom_id()).getName());
			p.setM_attributeset_id(m.getM_attributeset_id());
			p.setProductCategoryid(m.getM_product_category());
			p.setProductID(m.getId());
			p.setProductName(m.getName());
			p.setProductValue(m.getValue());
			p.setUomID(m.getC_uom_id());
			p.setThuoctinh(mar.getOne(m.getM_attributeset_id()).getName());
			p.setProductCategoryName(mrcr.getOne(m.getM_product_category()).getValue());
			m_productprice mProductprice = new m_productprice();
			System.out.println("AHAHAHA " + m.getId());
			try {
				mProductprice = mppr.findByProductid(m.getId()).get(0);
			} catch (Exception e) {
				mProductprice.setPricelist(0);
				mProductprice.setPricestd(0);
			}

			p.setPricesale(mProductprice.getPricelist());
			p.setPurprice(mProductprice.getPricestd());
			list.add(p);

		}
		return list;
	}
	//Thạch Bàn
	@GetMapping
	@RequestMapping("bet")
	public List<m_inout> getmInOutBetween(long adclientid, String dateFrom, String dateTo, String movementtype) {
		List<m_inout> list = new ArrayList<m_inout>();
		System.out.println("Size mio.findAdClient: "+mio.findByAdclientidAndMovementtypeAndDocstatus(adclientid, "C-", "CO").size());
		for (m_inout m1 : mio.findByAdclientidAndMovementtypeAndDocstatus(adclientid, movementtype, "CO")) {

			if (m1.getCreated().after(Timestamp.valueOf(dateFrom + " 00:00:00"))
					&& m1.getCreated().before(Timestamp.valueOf(dateTo + " 23:59:59"))) {
				System.out.println(m1.getCreated());
				list.add(m1);
			} else {
			}
		}
		return list;
	}

	@GetMapping
	@RequestMapping("banchay")
	public List<ProductInfomation> banchay(@RequestParam long adclientid, @RequestParam String dateFrom,
			@RequestParam String dateTo, @RequestParam String movementtype) {
		List<ProductInfomation> list = new ArrayList<ProductInfomation>();
		List<m_inout> list2 = new ArrayList<m_inout>();
		list2 = getmInOutBetween(adclientid, dateFrom, dateTo, "C-");
		List<m_inoutline> list3 = new ArrayList<m_inoutline>();
		System.out.println("List 2 Size: "+list2.size());
		// get all inoutline
		for (m_inout miom : list2) {
			list3.addAll(miol.findByMinoutid(miom.getId()));
			System.out.println("Length "+list2.size());
		}
		System.out.println("Size list3: "+list3.size());
		// bắt đầu xử lý số liệu
		for (m_inoutline mi1 : list3) {
			int count = 0;
			int oldqty = 0;
			int location = 0;
			for (ProductInfomation p2 : list) {
				if (mi1.getM_product_id() == p2.getProductID()) {
					count++;
					break;
				} else {
					location++;
				}
			}
			if (count == 0) {
				ProductInfomation p1 = new ProductInfomation();
				p1.setClientid(adclientid);
				p1.setDvt(cur.getOne(mi1.getC_uom_id()).getName());
				try {
					p1.setM_attributeset_id(mp.getOne(mi1.getM_product_id()).getM_attributeset_id());
				} catch (Exception e) {
					p1.setM_attributeset_id(0);
					// TODO: handle exception
				}
				
				p1.setOrgid(mi1.getAd_org_id());
				p1.setPricesale(mppr.findByProductid(mi1.getM_product_id()).get(0).getPricelist());
				p1.setPurprice(mppr.findByProductid(mi1.getM_product_id()).get(0).getPricestd());
				p1.setProductID(mi1.getM_product_id());
				p1.setProductName(mp.getOne(mi1.getM_product_id()).getName());
				p1.setProductValue(mp.getOne(mi1.getM_product_id()).getValue());
				p1.setQty((double) mi1.getQtyentered());
				p1.setUomID(mp.getOne(mi1.getM_product_id()).getC_uom_id());
				p1.setMaPhu(mp.getOne(mi1.getM_product_id()).getDescription());
				list.add(p1);
			} else {
				list.get(location).setQty((double) (list.get(location).getQty() + mi1.getQtyentered()));
			}
		}
		return list;
	}
	//get all by product có thông tin kho
	@GetMapping
	@RequestMapping("findallinfobyproductid")
	public List<ProductInfomation> getAllInforHavWareouse(@RequestParam long productid){
		List<ProductInfomation> list = new ArrayList<ProductInfomation>();
		DecimalFormat df = new DecimalFormat("#.###");
		for (m_storageonehand	m1	 : msr.findByAdclientidAndProductidAndQtyonhandGreaterThan(mp.getOne(productid).getClientId(), productid, 0.0)) {
			ProductInfomation p1 = new ProductInfomation();
			p1.setLocatorid(m1.getLocatorid());
			m_locator l1 = new m_locator();
			l1 = ml.getOne(m1.getLocatorid());
			p1.setLocatorName(l1.getValue());
			p1.setM_attributesetinstance_id(m1.getAsiid());
//			p1.setM_attributesetinstance_value(mair.getOne(m1.getAsiid()).getDescription());
			p1.setM_warehouse_id(l1.getM_warehouse_id());
			p1.setM_warehouse_value(mwr.getOne(l1.getM_warehouse_id()).getValue());
			p1.setProductID(m1.getProductid());
			p1.setProductValue(mp.getOne(m1.getProductid()).getValue());
			p1.setQty(m1.getQtyonhand());
			System.out.println("ASI"+m1.getAsiid() );
			try {
				p1.setThuoctinh(miol.getCreatedInMaTable(m1.getAsiid()).toString().substring(0, 10)+"("+df.format(m1.getQtyonhand())+")");
				
			} catch (Exception e) {
				try {
					p1.setThuoctinh(mair.getOne(m1.getAsiid()).getGuaranteedate().toString().substring(0, 10)+"("+df.format(m1.getQtyonhand())+")");
				} catch (Exception e2) {
					p1.setThuoctinh("("+df.format(m1.getQtyonhand())+")");
				}
				
			}
			p1.setNote(mair.getOne(m1.getAsiid()).getAsinote());
			list.add(p1);
		}
		return list;
	}
	
}
