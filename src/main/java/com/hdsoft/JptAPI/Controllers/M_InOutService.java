package com.hdsoft.JptAPI.Controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import com.hdsoft.ConnectDB;
public class M_InOutService {
	
	public static void completeOrder(String documentNo, long c_Bpartner_ID, Date movenmentDate, Long C_Doctype_ID,
			Long C_Order_ID) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inout(\r\n"
					+ "	m_inout_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, issotrx, documentno, docaction, docstatus, posted, processing, processed, c_doctype_id, description, c_order_id, dateordered, isprinted, movementtype, movementdate, dateacct, c_bpartner_id, c_bpartner_location_id, m_warehouse_id, poreference, deliveryrule, freightcostrule, freightamt, deliveryviarule, m_shipper_id, c_charge_id, chargeamt, priorityrule, dateprinted, c_invoice_id, createfrom, generateto, sendemail, ad_user_id, salesrep_id, nopackages, pickdate, shipdate, trackingno, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, isintransit, ref_inout_id, createconfirm, createpackage, isapproved, isindispute, volume, weight, m_rma_id, reversal_id, isdropship, dropship_bpartner_id, dropship_location_id, dropship_user_id, processedon, m_inout_uu, freightcharges, shipperaccount, insurance, fob, isalternatereturnaddress, returnbpartner_id, returnlocation_id, returnuser_id, iscreatedorder, barcode, scanqty, checkscan, isvalidscanlist, generateinoutline, scancode, shiptoaddress)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getNextID());
			ps.setInt(2, 1000010);
			ps.setInt(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 1000053);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 1000053);
			ps.setString(9, "N");
			ps.setString(10, getDocumentNo(documentNo));
			ps.setString(11, "CO");
			ps.setString(12, "DR");
			ps.setString(13, "N");
			ps.setString(14, "N");
			ps.setString(15, "N");
			ps.setLong(16, C_Doctype_ID);
			ps.setString(17, "Mobile App");
			if (C_Order_ID == 0) {
				ps.setNull(18, java.sql.Types.NUMERIC);
			}
			else {
				ps.setLong(18, C_Order_ID);
			}
			ps.setNull(19, java.sql.Types.DATE);
			ps.setString(20, "N");
			ps.setString(21, "V+");
			ps.setDate(22, movenmentDate);
			ps.setDate(23, movenmentDate);
			ps.setLong(24, c_Bpartner_ID);
			ps.setInt(25, getLocaltionID(c_Bpartner_ID));
			ps.setInt(26, 1000034);
			ps.setNull(27, java.sql.Types.VARCHAR);
			ps.setString(28, "A");
			ps.setString(29, "I");
			ps.setInt(30, 0);
			ps.setString(31, "P");
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setInt(34, 0);
			ps.setString(35, "5");
			ps.setNull(36, java.sql.Types.TIMESTAMP);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, "N");
			ps.setString(39, "N");
			ps.setString(40, "N");
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.setInt(42, 100);
			ps.setInt(43, 1);
			ps.setNull(44, java.sql.Types.TIMESTAMP);
			ps.setNull(45, java.sql.Types.TIMESTAMP);
			ps.setNull(46, java.sql.Types.VARCHAR);
			ps.setNull(47, java.sql.Types.NUMERIC);
			ps.setNull(48, java.sql.Types.NUMERIC);
			ps.setNull(49, java.sql.Types.NUMERIC);
			ps.setNull(50, java.sql.Types.NUMERIC);
			ps.setNull(51, java.sql.Types.NUMERIC);
			ps.setNull(52, java.sql.Types.NUMERIC);
			ps.setNull(53, java.sql.Types.TIMESTAMP);
			ps.setString(54, "N");
			ps.setNull(55, java.sql.Types.NUMERIC);
			ps.setString(56, "N");
			ps.setString(57, "N");
			ps.setString(58, "N");
			ps.setString(59, "N");
			ps.setDouble(60, 0.00);
			ps.setDouble(61, 0.00);
			ps.setNull(62, java.sql.Types.NUMERIC);
			ps.setNull(63, java.sql.Types.NUMERIC);
			ps.setString(64, "N");
			ps.setNull(65, java.sql.Types.NUMERIC);
			ps.setNull(66, java.sql.Types.NUMERIC);
			ps.setNull(67, java.sql.Types.NUMERIC);
			ps.setNull(68, java.sql.Types.NUMERIC);
			ps.setString(69, getUUID());
			ps.setNull(70, java.sql.Types.VARCHAR);
			ps.setNull(71, java.sql.Types.VARCHAR);
			ps.setNull(72, java.sql.Types.CHAR);
			ps.setNull(73, java.sql.Types.VARCHAR);
			ps.setString(74, "N");
			ps.setNull(75, java.sql.Types.NUMERIC);
			ps.setNull(76, java.sql.Types.NUMERIC);
			ps.setNull(77, java.sql.Types.NUMERIC);
			ps.setString(78, "N");
			ps.setNull(79, java.sql.Types.VARCHAR);
			ps.setNull(80, java.sql.Types.NUMERIC);
			ps.setNull(81, java.sql.Types.CHAR);
			ps.setString(82, "N");
			ps.setNull(83, java.sql.Types.CHAR);
			ps.setNull(84, java.sql.Types.VARCHAR);
			ps.setNull(85, java.sql.Types.VARCHAR);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void completeOrderDemo(String documentNo, long c_Bpartner_ID, Date movenmentDate, Long C_Doctype_ID,
			Long C_Order_ID, Long ad_client_id, Long ad_org_id, Long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inout(\r\n"
					+ "	m_inout_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, issotrx, documentno, docaction, docstatus, posted, processing, processed, c_doctype_id, description, c_order_id, dateordered, isprinted, movementtype, movementdate, dateacct, c_bpartner_id, c_bpartner_location_id, m_warehouse_id, poreference, deliveryrule, freightcostrule, freightamt, deliveryviarule, m_shipper_id, c_charge_id, chargeamt, priorityrule, dateprinted, c_invoice_id, createfrom, generateto, sendemail, ad_user_id, salesrep_id, nopackages, pickdate, shipdate, trackingno, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, isintransit, ref_inout_id, createconfirm, createpackage, isapproved, isindispute, volume, weight, m_rma_id, reversal_id, isdropship, dropship_bpartner_id, dropship_location_id, dropship_user_id, processedon, m_inout_uu, freightcharges, shipperaccount, insurance, fob, isalternatereturnaddress, returnbpartner_id, returnlocation_id, returnuser_id, iscreatedorder, barcode, scanqty, checkscan, isvalidscanlist, generateinoutline, scancode, shiptoaddress)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getNextID());
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setString(9, "N");
			ps.setString(10, getDocumentNo(documentNo));
			ps.setString(11, "CO");
			ps.setString(12, "DR");
			ps.setString(13, "N");
			ps.setString(14, "N");
			ps.setString(15, "N");
			ps.setLong(16, C_Doctype_ID);
			ps.setString(17, "Mobile App");
			if (C_Order_ID == 0) {
				ps.setNull(18, java.sql.Types.NUMERIC);
			}
			else {
				ps.setLong(18, C_Order_ID);
			}
			ps.setNull(19, java.sql.Types.DATE);
			ps.setString(20, "N");
			ps.setString(21, "V+");
			ps.setDate(22, movenmentDate);
			ps.setDate(23, movenmentDate);
			ps.setLong(24, c_Bpartner_ID);
			ps.setInt(25, getLocaltionID(c_Bpartner_ID));
			ps.setInt(26, 1000000);
			ps.setNull(27, java.sql.Types.VARCHAR);
			ps.setString(28, "A");
			ps.setString(29, "I");
			ps.setInt(30, 0);
			ps.setString(31, "P");
			ps.setNull(32, java.sql.Types.NUMERIC);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setInt(34, 0);
			ps.setString(35, "5");
			ps.setNull(36, java.sql.Types.TIMESTAMP);
			ps.setNull(37, java.sql.Types.NUMERIC);
			ps.setString(38, "N");
			ps.setString(39, "N");
			ps.setString(40, "N");
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.setInt(42, 100);
			ps.setInt(43, 1);
			ps.setNull(44, java.sql.Types.TIMESTAMP);
			ps.setNull(45, java.sql.Types.TIMESTAMP);
			ps.setNull(46, java.sql.Types.VARCHAR);
			ps.setNull(47, java.sql.Types.NUMERIC);
			ps.setNull(48, java.sql.Types.NUMERIC);
			ps.setNull(49, java.sql.Types.NUMERIC);
			ps.setNull(50, java.sql.Types.NUMERIC);
			ps.setNull(51, java.sql.Types.NUMERIC);
			ps.setNull(52, java.sql.Types.NUMERIC);
			ps.setNull(53, java.sql.Types.TIMESTAMP);
			ps.setString(54, "N");
			ps.setNull(55, java.sql.Types.NUMERIC);
			ps.setString(56, "N");
			ps.setString(57, "N");
			ps.setString(58, "N");
			ps.setString(59, "N");
			ps.setDouble(60, 0.00);
			ps.setDouble(61, 0.00);
			ps.setNull(62, java.sql.Types.NUMERIC);
			ps.setNull(63, java.sql.Types.NUMERIC);
			ps.setString(64, "N");
			ps.setNull(65, java.sql.Types.NUMERIC);
			ps.setNull(66, java.sql.Types.NUMERIC);
			ps.setNull(67, java.sql.Types.NUMERIC);
			ps.setNull(68, java.sql.Types.NUMERIC);
			ps.setString(69, getUUID());
			ps.setNull(70, java.sql.Types.VARCHAR);
			ps.setNull(71, java.sql.Types.VARCHAR);
			ps.setNull(72, java.sql.Types.CHAR);
			ps.setNull(73, java.sql.Types.VARCHAR);
			ps.setString(74, "N");
			ps.setNull(75, java.sql.Types.NUMERIC);
			ps.setNull(76, java.sql.Types.NUMERIC);
			ps.setNull(77, java.sql.Types.NUMERIC);
			ps.setString(78, "N");
			ps.setNull(79, java.sql.Types.VARCHAR);
			ps.setNull(80, java.sql.Types.NUMERIC);
			ps.setNull(81, java.sql.Types.CHAR);
			ps.setString(82, "N");
			ps.setNull(83, java.sql.Types.CHAR);
			ps.setNull(84, java.sql.Types.VARCHAR);
			ps.setNull(85, java.sql.Types.VARCHAR);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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

//	public static void completeOrder(String documentNo, long c_Bpartner_ID, Date movenmentDate, long C_Doctype_ID,
//			long C_Order_ID) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			con = ConnectDB.conHD();
//			String sql = "INSERT INTO adempiere.m_inout(\r\n"
//					+ "	m_inout_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, issotrx, documentno, docaction, docstatus, posted, processing, processed, c_doctype_id, description, c_order_id, dateordered, isprinted, movementtype, movementdate, dateacct, c_bpartner_id, c_bpartner_location_id, m_warehouse_id, poreference, deliveryrule, freightcostrule, freightamt, deliveryviarule, m_shipper_id, c_charge_id, chargeamt, priorityrule, dateprinted, c_invoice_id, createfrom, generateto, sendemail, ad_user_id, salesrep_id, nopackages, pickdate, shipdate, trackingno, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, isintransit, ref_inout_id, createconfirm, createpackage, isapproved, isindispute, volume, weight, m_rma_id, reversal_id, isdropship, dropship_bpartner_id, dropship_location_id, dropship_user_id, processedon, m_inout_uu, freightcharges, shipperaccount, insurance, fob, isalternatereturnaddress, returnbpartner_id, returnlocation_id, returnuser_id, iscreatedorder, barcode, scanqty, checkscan, isvalidscanlist, generateinoutline, scancode, shiptoaddress)\r\n"
//					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, getNextID());
//			ps.setInt(2, 1000010);
//			ps.setInt(3, 1000022);
//			ps.setString(4, "Y");
//			ps.setTimestamp(5, getDate());
//			ps.setInt(6, 1000053);
//			ps.setTimestamp(7, getDate());
//			ps.setInt(8, 1000053);
//			ps.setString(9, "N");
//			ps.setString(10, getDocumentNo(documentNo));
//			ps.setString(11, "CO");
//			ps.setString(12, "DR");
//			ps.setString(13, "E");
//			ps.setString(14, "N");
//			ps.setString(15, "Y");
//			ps.setLong(16, C_Doctype_ID);
//			ps.setString(17, "Mobile App");
//			ps.setLong(18, C_Order_ID);
//			ps.setNull(19, java.sql.Types.DATE);
//			ps.setString(20, "N");
//			ps.setString(21, "V+");
//			ps.setDate(22, movenmentDate);
//			ps.setDate(23, movenmentDate);
//			ps.setLong(24, c_Bpartner_ID);
//			ps.setInt(25, getLocaltionID(c_Bpartner_ID));
//			ps.setInt(26, 1000034);
//			ps.setNull(27, java.sql.Types.VARCHAR);
//			ps.setString(28, "A");
//			ps.setString(29, "I");
//			ps.setInt(30, 0);
//			ps.setString(31, "P");
//			ps.setNull(32, java.sql.Types.NUMERIC);
//			ps.setNull(33, java.sql.Types.NUMERIC);
//			ps.setInt(34, 0);
//			ps.setString(35, "5");
//			ps.setNull(36, java.sql.Types.TIMESTAMP);
//			ps.setNull(37, java.sql.Types.NUMERIC);
//			ps.setString(38, "N");
//			ps.setString(39, "N");
//			ps.setString(40, "N");
//			ps.setNull(41, java.sql.Types.NUMERIC);
//			ps.setInt(42, 100);
//			ps.setInt(43, 1);
//			ps.setNull(44, java.sql.Types.TIMESTAMP);
//			ps.setNull(45, java.sql.Types.TIMESTAMP);
//			ps.setNull(46, java.sql.Types.VARCHAR);
//			ps.setNull(47, java.sql.Types.NUMERIC);
//			ps.setNull(48, java.sql.Types.NUMERIC);
//			ps.setNull(49, java.sql.Types.NUMERIC);
//			ps.setNull(50, java.sql.Types.NUMERIC);
//			ps.setNull(51, java.sql.Types.NUMERIC);
//			ps.setNull(52, java.sql.Types.NUMERIC);
//			ps.setNull(53, java.sql.Types.TIMESTAMP);
//			ps.setString(54, "N");
//			ps.setNull(55, java.sql.Types.NUMERIC);
//			ps.setString(56, "N");
//			ps.setString(57, "N");
//			ps.setString(58, "Y");
//			ps.setString(59, "N");
//			ps.setDouble(60, 0.00);
//			ps.setDouble(61, 0.00);
//			ps.setNull(62, java.sql.Types.NUMERIC);
//			ps.setNull(63, java.sql.Types.NUMERIC);
//			ps.setString(64, "N");
//			ps.setNull(65, java.sql.Types.NUMERIC);
//			ps.setNull(66, java.sql.Types.NUMERIC);
//			ps.setNull(67, java.sql.Types.NUMERIC);
//			ps.setNull(68, java.sql.Types.NUMERIC);
//			ps.setString(69, getUUID());
//			ps.setNull(70, java.sql.Types.VARCHAR);
//			ps.setNull(71, java.sql.Types.VARCHAR);
//			ps.setNull(72, java.sql.Types.CHAR);
//			ps.setNull(73, java.sql.Types.VARCHAR);
//			ps.setString(74, "N");
//			ps.setNull(75, java.sql.Types.NUMERIC);
//			ps.setNull(76, java.sql.Types.NUMERIC);
//			ps.setNull(77, java.sql.Types.NUMERIC);
//			ps.setString(78, "N");
//			ps.setNull(79, java.sql.Types.VARCHAR);
//			ps.setNull(80, java.sql.Types.NUMERIC);
//			ps.setNull(81, java.sql.Types.CHAR);
//			ps.setString(82, "N");
//			ps.setNull(83, java.sql.Types.CHAR);
//			ps.setNull(84, java.sql.Types.VARCHAR);
//			ps.setNull(85, java.sql.Types.VARCHAR);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public static void updateOrderDocStatus(long c_order_id) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "update c_order set docstatus = 'CL', docaction = '--', updated = now() where c_order_id = " + c_order_id;
			st.executeUpdate(sql);
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void updateOrderIsVanning	(long c_order_id) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "update c_order set isvanning = 'Y' " + ", updated = now()" + " where c_order_id = " + c_order_id;
			st.executeUpdate(sql);
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void updateOrderIsScanning (long c_order_id) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "update c_order set isscanning = 'Y', updated = now() where c_order_id = " + c_order_id;
			st.executeUpdate(sql);
			con.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static String getDocumentNo(String documentNo) {
		Connection con = null;
		Statement st = null;
		String result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select max(documentNo) from m_inout where documentNo like '" + documentNo + "%'";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String currentDocumentNo = rs.getString(1);
				Integer nextIndex = Integer
						.parseInt(currentDocumentNo.substring(currentDocumentNo.lastIndexOf("-") + 1)) + 1;
				result = currentDocumentNo.substring(0, currentDocumentNo.lastIndexOf("-") + 1)
						.concat(nextIndex.toString());
				con.close();
				st.close();
				return result;
			}
		} catch (Exception e) {
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
		return documentNo.concat("-1");
	}

	public static Integer getLocaltionID(long c_bpartner_id) {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select c_bpartner_location_id from c_bpartner_location where c_bpartner_id = "
					+ c_bpartner_id;
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_InOut')::Integer, 'N'::Varchar)";
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
