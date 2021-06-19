package com.hdsoft.ConvertCode;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;

import com.hdsoft.ConnectDB;
import com.hdsoft.JptAPI.HDS.Repositories.C_UomRepository;
import com.hdsoft.JptAPI.HDS.Repositories.C_Uom_ConversionRepository;


public class M_InoutlineUpdateService {
	
	@Autowired
	C_Uom_ConversionRepository cucr;
	public static void addM_InoutLine(Long locatorID, Long productID, Double quantity, Long uomID, Long m_inout_id,
			Long c_orderline_id, Integer m_attributesetinstance_id, int qtyover) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inoutline(\r\n"
					+ "	m_inoutline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, line, description, m_inout_id, c_orderline_id, m_locator_id, m_product_id, c_uom_id, movementqty, isinvoiced, m_attributesetinstance_id, isdescription, confirmedqty, pickedqty, scrappedqty, targetqty, ref_inoutline_id, processed, qtyentered, c_charge_id, c_project_id, c_projectphase_id, c_projecttask_id, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id, m_rmaline_id, reversalline_id, m_inoutline_uu, qtyoverreceipt, attributeinfor, hds_inoutcheckline_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long m_inoutline_id = getNextID();
			ps.setLong(1, m_inoutline_id);
			ps.setInt(2, 1000010);
			ps.setInt(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 1000053);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 1000053);
			ps.setInt(9, getLine(m_inout_id));
			ps.setNull(10, java.sql.Types.VARCHAR);
			ps.setLong(11, m_inout_id);
			if (c_orderline_id == 0) {
				ps.setInt(12, 1338758);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setNull(20, java.sql.Types.NUMERIC);
				ps.setDouble(39, -qtyover);
			} else {
				ps.setLong(12, c_orderline_id);
				ps.setNull(20, java.sql.Types.NUMERIC);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setDouble(39, -qtyover);
			}
			ps.setLong(13, locatorID);
			ps.setLong(14, productID);
			ps.setLong(15, 1000028);
			ps.setDouble(16, quantity);
			ps.setString(17, "N");
			ps.setInt(18, m_attributesetinstance_id);
			ps.setString(19, "N");
			ps.setNull(21, java.sql.Types.NUMERIC);
			ps.setNull(22, java.sql.Types.NUMERIC);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, "N");
			ps.setDouble(26, quantity);
			ps.setNull(27, java.sql.Types.NUMERIC);
			ps.setNull(28, java.sql.Types.NUMERIC);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.NUMERIC);
			ps.setNull(31, java.sql.Types.NUMERIC);
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setNull(36, java.sql.Types.NUMERIC);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, getUUID());
			ps.setString(40, getASIInfor(m_attributesetinstance_id));
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addM_InoutLineYazaki(Long locatorID, Long productID, Double quantity, Long uomID, Long m_inout_id,
			Long c_orderline_id, Integer m_attributesetinstance_id, int qtyover) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inoutline(\r\n"
					+ "	m_inoutline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, line, description, m_inout_id, c_orderline_id, "
					+ "m_locator_id, m_product_id, c_uom_id, movementqty, isinvoiced, m_attributesetinstance_id, isdescription, confirmedqty, pickedqty, "
					+ "scrappedqty, targetqty, ref_inoutline_id, processed, qtyentered, c_charge_id, c_project_id, c_projectphase_id, c_projecttask_id, c_campaign_id,"
					+ "c_activity_id, user1_id, user2_id, ad_orgtrx_id, m_rmaline_id, reversalline_id, m_inoutline_uu, qtyoverreceipt, attributeinfor, hds_inoutcheckline_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long m_inoutline_id = getNextID();
			ps.setLong(1, m_inoutline_id);
			ps.setInt(2, 1000014);
			ps.setInt(3, 1000039);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 1000080);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 1000080);
			ps.setInt(9, getLine(m_inout_id));
			ps.setNull(10, java.sql.Types.VARCHAR);
			ps.setLong(11, m_inout_id);
			if (c_orderline_id == 0) {
				ps.setInt(12, 1275354);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setNull(20, java.sql.Types.NUMERIC);
				ps.setDouble(39, -qtyover);
			} else {
				ps.setLong(12, c_orderline_id);
				ps.setNull(20, java.sql.Types.NUMERIC);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setDouble(39, -qtyover);
			}
			ps.setLong(13, locatorID);
			ps.setLong(14, productID);
			ps.setLong(15,100);//c_uom in m_inoutline of ad_client_id 1000014
			ps.setDouble(16, quantity);
			ps.setString(17, "N");
			ps.setInt(18, m_attributesetinstance_id);
			ps.setString(19, "N");
			ps.setNull(21, java.sql.Types.NUMERIC);
			ps.setNull(22, java.sql.Types.NUMERIC);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, "N");
			ps.setDouble(26, quantity);
			ps.setNull(27, java.sql.Types.NUMERIC);
			ps.setNull(28, java.sql.Types.NUMERIC);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.NUMERIC);
			ps.setNull(31, java.sql.Types.NUMERIC);
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setNull(36, java.sql.Types.NUMERIC);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, getUUID());
			ps.setString(40, getASIInfor(m_attributesetinstance_id));
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void addM_InoutLineDemo(Long locatorID, Long productID, Double quantity, Long uomID, Long m_inout_id,
			Long c_orderline_id, String asiInfo, Double qtyover, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inoutline(\r\n"
					+ "	m_inoutline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, line, description, m_inout_id, c_orderline_id, m_locator_id, m_product_id, c_uom_id, movementqty, isinvoiced, m_attributesetinstance_id, isdescription, confirmedqty, pickedqty, scrappedqty, targetqty, ref_inoutline_id, processed, qtyentered, c_charge_id, c_project_id, c_projectphase_id, c_projecttask_id, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id, m_rmaline_id, reversalline_id, m_inoutline_uu, qtyoverreceipt, attributeinfor, hds_inoutcheckline_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long m_inoutline_id = getNextID();
			ps.setLong(1, m_inoutline_id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setInt(9, getLine(m_inout_id));
			ps.setNull(10, java.sql.Types.VARCHAR);
			ps.setLong(11, m_inout_id);
			if (c_orderline_id == 0) {
				ps.setNull(12, java.sql.Types.NUMERIC);
				ps.setInt(23, 0);
				ps.setInt(20, 0);
				ps.setDouble(39, 0);
			} else {
				ps.setLong(12, c_orderline_id);
				ps.setInt(20, 0);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setDouble(39, 0);
			}
			ps.setLong(13, locatorID);
			ps.setLong(14, productID);
			
			ps.setLong(15, 1000046);// m2
//			double conversion = cucr
			ps.setDouble(16, (quantity));
			ps.setString(17, "N");
			ps.setInt(18, 0);
			ps.setString(19, "N");
			ps.setInt(21, 0);
			ps.setInt(22, 0);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, "N");
			ps.setDouble(26, quantity);
			ps.setNull(27, java.sql.Types.NUMERIC);
			ps.setNull(28, java.sql.Types.NUMERIC);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.NUMERIC);
			ps.setNull(31, java.sql.Types.NUMERIC);
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setNull(36, java.sql.Types.NUMERIC);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, getUUID());
			ps.setString(40, asiInfo);
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static  void addM_InoutLineDemo1(Long locatorID, Long productID, Double quantity, Long uomID, Long m_inout_id,
			Long c_orderline_id, String asiInfo, Double qtyover, Long ad_client_id, Long ad_org_id, Long ad_user_id,long cuomid,String note,String guaranteedate ) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inoutline(\r\n"
					+ "	m_inoutline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, line, description, m_inout_id, c_orderline_id, m_locator_id, m_product_id, c_uom_id, movementqty, isinvoiced, m_attributesetinstance_id, isdescription, confirmedqty, pickedqty, scrappedqty, targetqty, ref_inoutline_id, processed, qtyentered, c_charge_id, c_project_id, c_projectphase_id, c_projecttask_id, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id, m_rmaline_id, reversalline_id, m_inoutline_uu, qtyoverreceipt, attributeinfor, hds_inoutcheckline_id,asinote,guaranteedate)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			ps = con.prepareStatement(sql);
			long m_inoutline_id = getNextID();
			ps.setLong(1, m_inoutline_id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setInt(9, getLine(m_inout_id));
			ps.setString(10, null);
			ps.setLong(11, m_inout_id);
			if (c_orderline_id == 0) {
				ps.setNull(12, java.sql.Types.NUMERIC);
				ps.setInt(23, 0);
				ps.setInt(20, 0);
				ps.setDouble(39, 0);
			} else {
				ps.setLong(12, c_orderline_id);
				ps.setInt(20, 0);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setDouble(39, 0);
			}
			ps.setLong(13, locatorID);
			ps.setLong(14, productID);
			
			ps.setLong(15, cuomid);// m2
			ps.setDouble(16, (quantity));
			ps.setString(17, "N");
			ps.setInt(18, 0);
			ps.setString(19, "N");
			ps.setInt(21, 0);
			ps.setInt(22, 0);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, "N");
			ps.setDouble(26, qtyover);
			ps.setNull(27, java.sql.Types.NUMERIC);
			ps.setNull(28, java.sql.Types.NUMERIC);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.NUMERIC);
			ps.setNull(31, java.sql.Types.NUMERIC);
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setNull(36, java.sql.Types.NUMERIC);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, getUUID());
			ps.setString(40, asiInfo);
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.setString(42, note);
			ps.setDate(43, Date.valueOf(guaranteedate));
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void addM_InoutLineLong(Long locatorID, Long productID, Double quantity, Long uomID, Long m_inout_id,
			Long c_orderline_id, String asiInfo, int qtyover, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inoutline(\r\n"
					+ "	m_inoutline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, line, description, m_inout_id, c_orderline_id, m_locator_id, m_product_id, c_uom_id, movementqty, isinvoiced, m_attributesetinstance_id, isdescription, confirmedqty, pickedqty, scrappedqty, targetqty, ref_inoutline_id, processed, qtyentered, c_charge_id, c_project_id, c_projectphase_id, c_projecttask_id, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id, m_rmaline_id, reversalline_id, m_inoutline_uu, qtyoverreceipt, attributeinfor, hds_inoutcheckline_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long m_inoutline_id = getNextID();
			ps.setLong(1, m_inoutline_id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setInt(9, getLine(m_inout_id));
			ps.setNull(10, java.sql.Types.VARCHAR);
			ps.setLong(11, m_inout_id);
			if (c_orderline_id == 0) {
				ps.setNull(12, java.sql.Types.NUMERIC);
				ps.setInt(23, 0);
				ps.setInt(20, 0);
				ps.setDouble(39, 0);
			} else {
				ps.setLong(12, c_orderline_id);
				ps.setInt(20, 0);
				ps.setNull(23, java.sql.Types.NUMERIC);
				ps.setDouble(39, 0);
			}
			ps.setLong(13, locatorID);
			ps.setLong(14, productID);
			ps.setLong(15, 100);
			ps.setDouble(16, quantity);
			ps.setString(17, "N");
			ps.setInt(18, 0);
			ps.setString(19, "N");
			ps.setInt(21, 0);
			ps.setInt(22, 0);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, "N");
			ps.setDouble(26, quantity);
			ps.setNull(27, java.sql.Types.NUMERIC);
			ps.setNull(28, java.sql.Types.NUMERIC);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.NUMERIC);
			ps.setNull(31, java.sql.Types.NUMERIC);
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setNull(36, java.sql.Types.NUMERIC);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, getUUID());
			ps.setString(40, asiInfo);
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static String getASIInfor(int m_attributesetinstance_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String asiInfor = "";
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT description from m_attributesetinstance where m_attributesetinstance_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_attributesetinstance_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				asiInfor = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return asiInfor;
	}

	public static void updateInout(long m_inout_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "UPDATE M_Inout SET Docstatus = 'CO', posted = 'E', processed = 'Y', isapproved = 'Y' WHERE m_inout_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, m_inout_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}
	
	public static void updateM_Inoutline(Long m_inout_id, Long productId) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "UPDATE M_Inoutline SET processed = 'Y' WHERE m_inout_id = ? and m_product_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, m_inout_id);
			ps.setLong(2, productId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}

//	public static void addM_InoutLine(Long locatorID, Long productID, Double quantity, Long uomID, Long m_inout_id,
//			Long c_orderline_id) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			con = ConnectDB.conHD();
//			String sql = "INSERT INTO adempiere.m_inoutline(\r\n"
//					+ "	m_inoutline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, line, description, m_inout_id, c_orderline_id, m_locator_id, m_product_id, c_uom_id, movementqty, isinvoiced, m_attributesetinstance_id, isdescription, confirmedqty, pickedqty, scrappedqty, targetqty, ref_inoutline_id, processed, qtyentered, c_charge_id, c_project_id, c_projectphase_id, c_projecttask_id, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id, m_rmaline_id, reversalline_id, m_inoutline_uu, qtyoverreceipt, attributeinfor, hds_inoutcheckline_id)\r\n"
//					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps = con.prepareStatement(sql);
//			long m_inoutline_id = getNextID();
//			ps.setLong(1, m_inoutline_id);
//			ps.setInt(2, 1000010);
//			ps.setInt(3, 1000022);
//			ps.setString(4, "Y");
//			ps.setTimestamp(5, getDate());
//			ps.setInt(6, 1000053);
//			ps.setTimestamp(7, getDate());
//			ps.setInt(8, 1000053);
//			ps.setInt(9, getLine(m_inout_id));
//			ps.setNull(10, java.sql.Types.VARCHAR);
//			ps.setLong(11, m_inout_id);
//			if (c_orderline_id == null) {
//				ps.setNull(12, java.sql.Types.NUMERIC);
//				ps.setInt(23, 0);
//				ps.setInt(20, 0);
//				ps.setDouble(39, quantity);
//			} else {
//				double quantityOrder = getCorderlineQty(c_orderline_id);
//				ps.setLong(12, c_orderline_id);
//				ps.setDouble(20, quantityOrder);
//				ps.setDouble(23, quantityOrder);
//				ps.setDouble(39, quantity - quantityOrder);
//			}
//			ps.setLong(13, locatorID);
//			ps.setLong(14, productID);
//			ps.setLong(15, 1000028);
//			ps.setDouble(16, quantity);
//			ps.setString(17, "N");
//			ps.setInt(18, 1258886);
//			ps.setString(19, "N");
//			ps.setInt(21, 0);
//			ps.setInt(22, 0);
//			ps.setNull(24, java.sql.Types.NUMERIC);
//			ps.setString(25, "Y");
//			ps.setDouble(26, quantity);
//			ps.setNull(27, java.sql.Types.NUMERIC);
//			ps.setNull(28, java.sql.Types.NUMERIC);
//			ps.setNull(29, java.sql.Types.NUMERIC);
//			ps.setNull(30, java.sql.Types.NUMERIC);
//			ps.setNull(31, java.sql.Types.NUMERIC);
//			ps.setNull(32, java.sql.Types.NUMERIC);
//			ps.setNull(33, java.sql.Types.NUMERIC);
//			ps.setNull(34, java.sql.Types.NUMERIC);
//			ps.setNull(35, java.sql.Types.NUMERIC);
//			ps.setNull(36, java.sql.Types.NUMERIC);
//			ps.setNull(37, java.sql.Types.NUMERIC);
//			ps.setString(38, getUUID());
//			ps.setNull(40, java.sql.Types.VARCHAR);
//			ps.setNull(41, java.sql.Types.NUMERIC);
//			ps.executeUpdate();
//			ps.close();
//			con.close();
//			M_InoutLineService.updateQuantityOnHand(locatorID, productID, quantity);
//			M_InoutLineService.updateTransaction(locatorID, productID, quantity, m_inoutline_id);
//			M_InoutLineService.updateInoutLineMA(m_inoutline_id, quantity);
//			M_InoutLineService.updateMatchPO(c_orderline_id, productID, m_inoutline_id, quantity, M_InoutLineService.getDocumentNo(m_inout_id));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

	public static Double getCorderlineQty(Long c_orderline_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Double result = 0.0;
		try {
			con = ConnectDB.conHD();
			String sql = "select qtyentered from c_orderline where c_orderline_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, c_orderline_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String getDocumentNo(long m_inout_id) {
		Connection con = null;
		Statement st = null;
		String result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select documentNo from m_inout where m_inout_id = " + m_inout_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void updateMatchPO(long c_orderline_id, long m_product_id, long m_inoutline_id, double quantity,
			String documentNo, long m_attributesetinstance_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_matchpo(\r\n"
					+ "	m_matchpo_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_orderline_id, m_product_id, m_inoutline_id, c_invoiceline_id, datetrx, qty, processing, processed, posted, documentno, dateacct, m_attributesetinstance_id, pricematchdifference, isapproved, description, processedon, m_matchpo_uu, reversal_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, getMatchPOId());
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "N");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setLong(9, c_orderline_id);
			ps.setLong(10, m_product_id);
			ps.setLong(11, m_inoutline_id);
			ps.setNull(12, java.sql.Types.NUMERIC);
			ps.setTimestamp(13, getDate());
			ps.setDouble(14, quantity);
			ps.setString(15, "N");
			ps.setString(16, "Y");
			ps.setString(17, "Y");
			ps.setString(18, documentNo);
			ps.setTimestamp(19, getDate());
			ps.setLong(20, m_attributesetinstance_id);
			ps.setNull(21, java.sql.Types.NUMERIC);
			ps.setString(22, "Y");
			ps.setNull(23, java.sql.Types.VARCHAR);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, getUUID());
			ps.setNull(26, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	}

	public static void updateInoutLineMA(long m_inoutline_id, Double movementQty, long m_attributesetinstance_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inoutlinema(\r\n"
					+ "	m_inoutline_id, m_attributesetinstance_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, movementqty, m_inoutlinema_uu, datematerialpolicy, isautogenerated)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, m_inoutline_id);
			ps.setLong(2, m_attributesetinstance_id);
			ps.setLong(3, 1000010);
			ps.setLong(4, 1000022);
			ps.setString(5, "N");
			ps.setTimestamp(6, getDate());
			ps.setInt(7, 100);
			ps.setTimestamp(8, getDate());
			ps.setInt(9, 100);
			ps.setDouble(10, movementQty);
			ps.setString(11, getUUID());
			ps.setTimestamp(12, getDate());
			ps.setString(13, "N");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public static void updateTransaction(long m_locator_id, long m_product_id, Double quantity, long m_inoutline_id,
			long m_attributesetinstance_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_transaction(\r\n"
					+ "	m_transaction_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, movementtype, m_locator_id, m_product_id, movementdate, movementqty, m_inventoryline_id, m_movementline_id, m_inoutline_id, m_productionline_id, c_projectissue_id, m_attributesetinstance_id, pp_cost_collector_id, m_transaction_uu)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, getTransactionId());
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setString(9, "V+");
			ps.setLong(10, m_locator_id);
			ps.setLong(11, m_product_id);
			ps.setTimestamp(12, getDate());
			ps.setDouble(13, quantity);
			ps.setNull(14, java.sql.Types.NUMERIC);
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setLong(16, m_inoutline_id);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setLong(19, m_attributesetinstance_id);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setString(21, getUUID());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
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
	}

	public static void updateQuantityOnHandNK(long m_locator_id, long m_product_id, long m_attributesetinstance_id,
			Double quantity) {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			if (checkQuantityOnHand(m_locator_id, m_product_id, m_attributesetinstance_id)) {
				double quan = getQuantityOnHand(m_locator_id, m_product_id, m_attributesetinstance_id) + quantity;
				String sql = "Update m_storageonhand set qtyonhand = " + quan
						+ ", updated = now() where m_locator_id = " + m_locator_id + " and m_product_id = "
						+ m_product_id + " and m_attributesetinstance_id = " + m_attributesetinstance_id;
				st = con.createStatement();
				st.executeUpdate(sql);
				st.close();
				con.close();
			} else {
				String sql = "INSERT INTO adempiere.m_storageonhand(\r\n"
						+ "	ad_client_id, ad_org_id, created, createdby, datelastinventory, isactive, m_attributesetinstance_id, m_locator_id, m_product_id, qtyonhand, updated, updatedby, m_storageonhand_uu, datematerialpolicy)\r\n"
						+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
				ps.setInt(1, 1000010);
				ps.setInt(2, 1000022);
				ps.setTimestamp(3, getDate());
				ps.setInt(4, 100);
				ps.setNull(5, java.sql.Types.TIMESTAMP);
				ps.setString(6, "Y");
				ps.setLong(7, m_attributesetinstance_id);
				ps.setLong(8, m_locator_id);
				ps.setLong(9, m_product_id);
				ps.setDouble(10, quantity);
				ps.setTimestamp(11, getDate());
				ps.setInt(12, 100);
				ps.setString(13, getUUID());
				ps.setTimestamp(14, getDate());
				ps.executeUpdate();
				ps.close();
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}



	public static Double getQuantityOnHand(long m_locator_id, long m_product_id, Long m_attributesetinstance_id) {
		Connection con = null;
		Statement st = null;
		Double result = 0.0;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select qtyonhand from m_storageonhand where m_locator_id = " + m_locator_id
					+ " and m_product_id = " + m_product_id + " and m_attributesetinstance_id = "
					+ m_attributesetinstance_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getDouble(1);
			}
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static boolean checkQuantityOnHand(long m_locator_id, long m_product_id, Long m_attributesetinstance_id) {
		Connection con = null;
		Statement st = null;
		Boolean check = false;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select * from m_storageonhand where m_locator_id = " + m_locator_id + " and m_product_id = "
					+ m_product_id + " and m_attributesetinstance_id = " + m_attributesetinstance_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				check = true;
			}
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return check;
	}

	public static Integer getLine(long m_inout_id) {
		Connection con = null;
		Statement st = null;
		Integer result = 10;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select max(line) from m_inoutline where m_inout_id = " + m_inout_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt("max") + 10;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static Integer getNextID() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_InOutLine')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String getUUID() {
		Connection con = null;
		CallableStatement cstmt = null;
		String result = null;
		try {
			con = ConnectDB.conHD();
			cstmt = con.prepareCall("{? = call generate_uuid()}");
			cstmt.registerOutParameter(1, Types.CHAR);
			cstmt.execute();
			result = cstmt.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				cstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public static Integer getTransactionId() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_Transaction')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static Integer getMAttributeSetInstanceId() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_AttributeSetInstance')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static Integer getMatchPOId() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_MatchPO')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static Timestamp getDate() {
		Timestamp result = null;
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			con = ConnectDB.conHD();
			cstmt = con.prepareCall("{? = call getdate()}");
			cstmt.registerOutParameter(1, java.sql.Types.TIMESTAMP);
			cstmt.execute();
			result = cstmt.getTimestamp(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (cstmt != null) {
				try {
					cstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
