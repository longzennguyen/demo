package com.hdsoft.JptAPI.HDS.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.JptAPI.HDS.Repositories.C_bPartnerRepository;
import com.hdsoft.JptAPI.HDS.Repositories.M_ProductPriceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_attributesetinstanceRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_inoutlineRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_locatorRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_productRepository;
import com.hdsoft.JptAPI.HDS.Repositories.m_storageonhandRepository;
import com.hdsoft.JptAPI.HDS.model.TonKhoModel;
import com.hdsoft.JptAPI.HDS.model.m_inout;
import com.hdsoft.JptAPI.HDS.model.m_inoutline;
import com.hdsoft.JptAPI.HDS.model.m_productprice;

@RestController
@RequestMapping("api/v1/baocaonhapkho")
public class BaoCaoNhapKho {
	@Autowired
	m_productRepository productRep;
	@Autowired
	m_locatorRepository locatorRep;
	@Autowired
	m_storageonhandRepository storageRep;
	@Autowired
	m_attributesetinstanceRepository asiRep;
	@Autowired
	m_inoutRepository mir;
	@Autowired
	m_inoutlineRepository mil;
	@Autowired
	M_ProductPriceRepository mppr;
	@Autowired
	C_bPartnerRepository cbr;
	
	//====HDS Base App===========
	//===============GET=====================
	//movement type V+ nhập kho
	//movement type C- xuất kho
	
	//Nhập kho
	@GetMapping
	@RequestMapping("timkiemtheongay")
	public List<TonKhoModel> searchByDate(@RequestParam String date1,@RequestParam String date2,@RequestParam long ad_org_id){
		//Get All kế hoạch trong 2 date trong m_inout
		List<m_inout> list = new ArrayList<m_inout>();
		list = mir.findByUpdatedBetween(Timestamp.valueOf(date1+" 00:00:00"), Timestamp.valueOf(date2+" 23:59:00"));
		List<m_inout> list1 = new ArrayList<m_inout>();
		ArrayList<Long> listM_Inout_ID = new ArrayList<Long>(); 
		for (m_inout m : list) {
			if(m.getAd_client_id()==1000003 && m.getAd_org_id()==ad_org_id && m.getMovementtype().equals("V+")) {
				System.out.println("Add : "+m.getDocumentno());
				listM_Inout_ID.add( m.getId());
				list1.add(m);
			}
				
		}
		//get All m_inoutLine
		List<m_inoutline> listS = new ArrayList<m_inoutline>();
		listS = mil.findByMinoutidIn(listM_Inout_ID);
		//Set gtri để hiển thị 
		List<TonKhoModel> listShow = new ArrayList<TonKhoModel>();
		for (m_inoutline m : listS) {
			TonKhoModel t = new TonKhoModel();
			t.setASIID(m.getM_attributesetinstance_id());
			t.setLocatorid(m.getM_locator_id());
			t.setNgaySX(m.getUpdated().toString());// Updated trong m_inoutline
			t.setProductID(m.getM_product_id());
			t.setSanPham(productRep.findByIdAndAdorgid(m.getM_product_id(),ad_org_id).getValue());
			t.setSoLuong(m.getQtyentered());
			t.setViTri(null);
			String documentno="";
			for (m_inout min : list1) {
				if(min.getId() == m.getM_inout_id()) {
					documentno=min.getDocumentno();
					break;
				}
			}
			t.setDoitac(cbr.getOne(mir.getOne(m.getM_inout_id()).getC_bpartner_id()).getValue());
			t.setDocumentno(documentno);
		
			listShow.add(t);
		}
		return listShow;
	}
	@GetMapping
	@RequestMapping("timkiemtheodoitac")
	public List<TonKhoModel> SearchByCBPartner(@RequestParam String date1,@RequestParam String date2,@RequestParam long ad_org_id){
		//Get All kế hoạch trong 2 date trong m_inout
		List<m_inout> list = new ArrayList<m_inout>();
		list = mir.findByUpdatedBetween(Timestamp.valueOf(date1+" 00:00:00"), Timestamp.valueOf(date2+" 23:59:00"));
		List<m_inout> list1 = new ArrayList<m_inout>();
		ArrayList<Long> listM_Inout_ID = new ArrayList<Long>(); 
		for (m_inout m : list) {
			if(m.getAd_client_id()==1000003 && m.getAd_org_id()==ad_org_id && m.getMovementtype().equals("V+")) {
				System.out.println("Add : "+m.getDocumentno());
				listM_Inout_ID.add( m.getId());
				list1.add(m);
			}
				
		}
		//get All m_inoutLine
		List<m_inoutline> listS = new ArrayList<m_inoutline>();
		listS = mil.findByMinoutidIn(listM_Inout_ID);
		//Set gtri để hiển thị 
		List<TonKhoModel> listShow = new ArrayList<TonKhoModel>();
		for (m_inoutline m : listS) {
			TonKhoModel t = new TonKhoModel();
			t.setASIID(m.getM_attributesetinstance_id());
			t.setLocatorid(m.getM_locator_id());
			t.setNgaySX(m.getUpdated().toString());// Updated trong m_inoutline
			t.setProductID(m.getM_product_id());
			t.setSanPham(productRep.findByIdAndAdorgid(m.getM_product_id(),ad_org_id).getValue());
			t.setSoLuong( m.getQtyentered());
			t.setViTri(null);
			String documentno="";
			for (m_inout min : list1) {
				if(min.getId() == m.getM_inout_id()) {
					documentno=min.getDocumentno();
					break;
				}
			}
			t.setDocumentno(documentno);
			t.setDoitac(cbr.getOne(mir.getOne(m.getM_inout_id()).getC_bpartner_id()).getValue());
			listShow.add(t);
		}
		return listShow;
	}
	
	//Xuất kho
	@GetMapping
	@RequestMapping("timkiemtheongayxk")
	public List<TonKhoModel> searchByDateXK(@RequestParam String date1,@RequestParam String date2,@RequestParam long ad_org_id){
		//Get All kế hoạch trong 2 date trong m_inout
		List<m_inout> list = new ArrayList<m_inout>();
		list = mir.findByUpdatedBetween(Timestamp.valueOf(date1+" 00:00:00"), Timestamp.valueOf(date2+" 23:59:00"));
		List<m_inout> list1 = new ArrayList<m_inout>();
		ArrayList<Long> listM_Inout_ID = new ArrayList<Long>(); 
		for (m_inout m : list) {
			if(m.getAd_client_id()==1000003 && m.getAd_org_id()==ad_org_id && m.getMovementtype().equals("C-")) {
				System.out.println("Add : "+m.getDocumentno());
				listM_Inout_ID.add( m.getId());
				list1.add(m);
			}
				
		}
		//get All m_inoutLine
		List<m_inoutline> listS = new ArrayList<m_inoutline>();
		listS = mil.findByMinoutidIn(listM_Inout_ID);
		//Set gtri để hiển thị 
		List<TonKhoModel> listShow = new ArrayList<TonKhoModel>();
		for (m_inoutline m : listS) {
			TonKhoModel t = new TonKhoModel();
			t.setASIID(m.getM_attributesetinstance_id());
			t.setLocatorid(m.getM_locator_id());
			t.setNgaySX(m.getUpdated().toString());// Updated trong m_inoutline
			t.setProductID(m.getM_product_id());
			t.setSanPham(productRep.findByIdAndAdorgid(m.getM_product_id(),ad_org_id).getValue());
			t.setSoLuong( m.getQtyentered());
			t.setViTri(null);
			String documentno="";
			for (m_inout min : list1) {
				if(min.getId() == m.getM_inout_id()) {
					documentno=min.getDocumentno();
					break;
				}
			}
			t.setDocumentno(documentno);
			t.setDoitac(cbr.getOne(mir.getOne(m.getM_inout_id()).getC_bpartner_id()).getValue());
			
			listShow.add(t);
		}
		return listShow;
	}
	@GetMapping
	@RequestMapping("timkiemtheodoitacxk")
	public List<TonKhoModel> SearchByCBPartnerXK(@RequestParam String date1,@RequestParam String date2,@RequestParam long ad_org_id){
		//Get All kế hoạch trong 2 date trong m_inout
		List<m_inout> list = new ArrayList<m_inout>();
		list = mir.findByUpdatedBetween(Timestamp.valueOf(date1+" 00:00:00"), Timestamp.valueOf(date2+" 23:59:00"));
		List<m_inout> list1 = new ArrayList<m_inout>();
		ArrayList<Long> listM_Inout_ID = new ArrayList<Long>(); 
		for (m_inout m : list) {
			if(m.getAd_client_id()==1000003 && m.getAd_org_id()==ad_org_id && m.getMovementtype().equals("C-")) {
				System.out.println("Add : "+m.getDocumentno());
				listM_Inout_ID.add( m.getId());
				list1.add(m);
			}
				
		}
		//get All m_inoutLine
		List<m_inoutline> listS = new ArrayList<m_inoutline>();
		listS = mil.findByMinoutidIn(listM_Inout_ID);
		//Set gtri để hiển thị 
		List<TonKhoModel> listShow = new ArrayList<TonKhoModel>();
		for (m_inoutline m : listS) {
			TonKhoModel t = new TonKhoModel();
			t.setASIID(m.getM_attributesetinstance_id());
			t.setLocatorid(m.getM_locator_id());
			t.setNgaySX(m.getUpdated().toString());// Updated trong m_inoutline
			t.setProductID(m.getM_product_id());
			t.setSanPham(productRep.findByIdAndAdorgid(m.getM_product_id(),ad_org_id).getValue());
			t.setSoLuong( m.getQtyentered());
			t.setViTri(null);
			String documentno="";
			
			for (m_inout min : list1) {
				if(min.getId() == m.getM_inout_id()) {
					documentno=min.getDocumentno();
					break;
				}
			}
			t.setDocumentno(documentno);
			m_productprice pprice = new m_productprice();
			pprice = mppr.findByProductid(m.getM_product_id()).get(0);
			t.setPricebuy(pprice.getPricelist());
			t.setPurchaseprice(pprice.getPricestd());
			t.setDoitac(cbr.getOne(mir.getOne(m.getM_inout_id()).getC_bpartner_id()).getValue());
			listShow.add(t);
		}
		return listShow;
	}
}
