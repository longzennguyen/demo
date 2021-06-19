package com.hdsoft.ConvertCode;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsoft.ConnectDB;
import com.hdsoft.JptAPI.Controllers.M_InOutService;
import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;

@RestController
@RequestMapping("api/v1/materialreceiptupdate")
public class M_InoutlineUpdateResource {
	@Autowired
	C_Uom_ConversionRepository cucr;
	
	@PostMapping
	public void addMaterialReceipt(@RequestParam("documentNo") String documentNo,
			@RequestParam("c_Bpartner_ID") long c_Bpartner_ID, @RequestParam("movenmentDate") Date movenmentDate,
			@RequestParam("C_Doctype_ID") Long C_Doctype_ID, @RequestParam("C_Order_ID") Long C_Order_ID) {
		M_InOutService.completeOrder(documentNo, c_Bpartner_ID, movenmentDate, C_Doctype_ID, C_Order_ID);
		System.out.println("Successfully !!!!!!!");
	}

	@PostMapping
	@RequestMapping("/demo")
	public void addMaterialReceiptDemo(@RequestParam("documentNo") String documentNo,
			@RequestParam("c_Bpartner_ID") long c_Bpartner_ID, @RequestParam("movenmentDate") Date movenmentDate,
			@RequestParam("C_Doctype_ID") long C_Doctype_ID, @RequestParam("C_Order_ID") Long C_Order_ID,
			@RequestParam("ad_client_id") Long ad_client_id, @RequestParam("ad_org_id") Long ad_org_id,
			@RequestParam("ad_user_id") Long ad_user_id) {
		M_InOutService.completeOrderDemo(documentNo, c_Bpartner_ID, movenmentDate, C_Doctype_ID, C_Order_ID,
				ad_client_id, ad_org_id, ad_user_id);
		System.out.println("Successfully !!!!!!!");
	}

	@PostMapping
	@RequestMapping("/line")
	public void addMaterialReceiptLine(@RequestParam("locatorID") Long locatorID, @RequestParam("productID") Long productID,
			@RequestParam("quantity") Double quantity,
			@RequestParam("m_attributesetinstance_id") Integer m_attributesetinstance_id, @RequestParam("uomID") Long uomID,
			@RequestParam("m_inout_id") Long m_inout_id, @RequestParam("c_orderline_id") Long c_orderline_id,
			@RequestParam("qtyover") int qtyover) {
		M_InoutlineUpdateService.addM_InoutLine(locatorID, productID, quantity, uomID, m_inout_id, c_orderline_id,
				m_attributesetinstance_id, qtyover);
		System.out.println("Successfully !!!!!!!!");
	}


//	@PostMapping
//	@RequestMapping("/lineyazaki")
//	public void addMaterialReceiptLineYazaki(@RequestParam("locatorID") Long locatorID, @RequestParam("productID") Long productID,
//			@RequestParam("quantity") Double quantity,
//			@RequestParam("m_attributesetinstance_id") Integer m_attributesetinstance_id, @RequestParam("uomID") Long uomID,
//			@RequestParam("m_inout_id") Long m_inout_id, @RequestParam("c_orderline_id") Long c_orderline_id,
//			@RequestParam("qtyover") int qtyover) {
//		M_InoutlineUpdateService.addM_InoutLine(locatorID, productID, quantity, uomID, m_inout_id, c_orderline_id,
//				m_attributesetinstance_id, qtyover);
//		System.out.println("Successfully !!!!!!!!");
//	}
	
	@PostMapping
	@RequestMapping("/linedemo")
	public void addMaterialReceiptLineDemo(@RequestParam("locatorID") Long locatorID,
			@RequestParam("productID") Long productID, @RequestParam("quantity") Double quantity,
			@RequestParam("asiInfo") String asiInfo, @RequestParam("uomID") Long uomID,
			@RequestParam("m_inout_id") Long m_inout_id, @RequestParam("c_orderline_id") Long c_orderline_id,
			@RequestParam("qtyover") Double qtyover, @RequestParam("ad_client_id") Long ad_client_id,
			@RequestParam("ad_org_id") Long ad_org_id, @RequestParam("ad_user_id") Long ad_user_id) {
		M_InoutlineUpdateService.addM_InoutLineDemo(locatorID, productID, quantity, uomID, m_inout_id, c_orderline_id,
				asiInfo, qtyover, ad_client_id, ad_org_id, ad_user_id);
		System.out.println("Successfully !!!!!!!!");
	}

	@PostMapping
	@RequestMapping("/linedemo1")
	public void addMaterialReceiptLineDemo1(@RequestParam("locatorID") Long locatorID,
			@RequestParam("productID") Long productID, @RequestParam("quantity") Double quantity,
			@RequestParam("asiInfo") String asiInfo, @RequestParam("uomID") Long uomID,
			@RequestParam("m_inout_id") Long m_inout_id, @RequestParam("c_orderline_id") Long c_orderline_id,
			@RequestParam("qtyover") Double qtyover, @RequestParam("ad_client_id") Long ad_client_id,
			@RequestParam("ad_org_id") Long ad_org_id, @RequestParam("ad_user_id") Long ad_user_id,@RequestParam("note") String note,
			@RequestParam("guaranteedate") String guaranteedate) {
		double conversion;
//		conversion =  cucr.findByProductidAndUomidAndUomtoid(productID, 1000047	, 1000046).getMultiplyrate();
		M_InoutlineUpdateService.addM_InoutLineDemo1(locatorID, productID, quantity, uomID, m_inout_id, c_orderline_id,
				asiInfo, qtyover, ad_client_id, ad_org_id, ad_user_id,uomID,note,guaranteedate);
		System.out.println("Successfully !!!!!!!!");
	}

	
	@PostMapping
	@RequestMapping("/linelongdemo")
	public void addMaterialReceiptLineLong(@RequestParam("locatorID") Long locatorID,
			@RequestParam("productID") Long productID, @RequestParam("quantity") Double quantity,
			@RequestParam("asiInfo") String asiInfo, @RequestParam("uomID") Long uomID,
			@RequestParam("m_inout_id") Long m_inout_id, @RequestParam("c_orderline_id") Long c_orderline_id,
			@RequestParam("qtyover") int qtyover, @RequestParam("ad_client_id") Long ad_client_id,
			@RequestParam("ad_org_id") Long ad_org_id, @RequestParam("ad_user_id") Long ad_user_id) {
		M_InoutlineUpdateService.addM_InoutLineLong(locatorID, productID, quantity, uomID, m_inout_id, c_orderline_id,
				asiInfo, qtyover, ad_client_id, ad_org_id, ad_user_id);
		System.out.println("Successfully !!!!!!!!");
	}

	
	@PostMapping
	@RequestMapping("/confirm")
	public void confirmMaterialReceipt(@RequestParam("m_inoutline_id") Long m_inoutline_id,
			@RequestParam("m_locator_id") Long m_locator_id, @RequestParam("m_product_id") Long m_product_id,
			@RequestParam("quantity") Double quantity, @RequestParam("m_inout_id") Long m_inout_id,
			@RequestParam("c_orderline_id") Long c_orderline_id,
			@RequestParam("m_attributesetinstance_id") Long m_attributesetinstance_id) {
		M_InoutlineUpdateService.updateQuantityOnHandNK(m_locator_id, m_product_id, m_attributesetinstance_id,
				quantity);
		M_InoutlineUpdateService.updateTransaction(m_locator_id, m_product_id, quantity, m_inoutline_id,
				m_attributesetinstance_id);
		M_InoutlineUpdateService.updateInoutLineMA(m_inoutline_id, quantity, m_attributesetinstance_id);
		M_InoutlineUpdateService.updateMatchPO(c_orderline_id, m_product_id, m_inoutline_id, quantity,
				M_InoutLineService.getDocumentNo(m_inout_id), m_attributesetinstance_id);
		M_InoutlineUpdateService.updateInout(m_inout_id);
		M_InoutlineUpdateService.updateM_Inoutline(m_inout_id, m_product_id);
	}

	public static boolean checkOrder(int c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		boolean check = true;
		try {
			con = ConnectDB.conHD();
			String sql = "Select docstatus from c_order where c_order_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (!rs.getString(1).equalsIgnoreCase("CO")) {
					check = false;
				}
			}
		} catch (SQLException e) {
			System.err.println("Only one order is closed");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return check;
	}

	@PutMapping
	public void updateMaterialReceipt(@RequestParam("c_order_id") long c_order_id) {
		M_InOutService.updateOrderDocStatus(c_order_id);
	}

}
