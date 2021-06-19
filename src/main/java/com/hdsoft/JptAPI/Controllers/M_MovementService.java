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

public class M_MovementService {

	public static void createMovement(String documentNo, Date movementDate) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movement(\r\n"
					+ "	m_movement_id, ad_client_id, ad_org_id, isactive, created, createdby, updatedby, updated, documentno, description, movementdate, posted, processed, processing, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, docaction, docstatus, isintransit, c_doctype_id, isapproved, approvalamt, freightcostrule, m_shipper_id, priorityrule, salesrep_id, ad_user_id, c_bpartner_id, c_bpartner_location_id, c_charge_id, chargeamt, createfrom, dd_order_id, deliveryrule, deliveryviarule, freightamt, reversal_id, poreference, processedon, m_movement_uu, status)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long id = getNextID();
			ps.setLong(1, id);
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setInt(7, 100);
			ps.setTimestamp(8, getDate());
			ps.setString(9, documentNo);
			ps.setString(10, "Mobile App");
			ps.setDate(11, movementDate);
			ps.setString(12, "Y");
			ps.setString(13, "Y");
			ps.setString(14, "N");
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setNull(19, java.sql.Types.NUMERIC);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setNull(21, java.sql.Types.TIMESTAMP);
			ps.setString(22, "CL");
			ps.setString(23, "CO");
			ps.setString(24, "N");
			ps.setInt(25, 1000664);
			ps.setString(26, "Y");
			ps.setInt(27, 0);
			ps.setNull(28, java.sql.Types.CHAR);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.CHAR);
			ps.setInt(31, 100);
			ps.setInt(32, 100);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setInt(36, 0);
			ps.setNull(37, java.sql.Types.CHAR);
			ps.setNull(38, java.sql.Types.NUMERIC);
			ps.setNull(39, java.sql.Types.CHAR);
			ps.setNull(40, java.sql.Types.CHAR);
			ps.setInt(41, 0);
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.VARCHAR);
			ps.setInt(44, 0);
			ps.setString(45, getUUID());
			ps.setString(46, "01");
			ps.executeUpdate();
			con.close();
			ps.close();
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void createMovementDemo(String documentNo, Date movementDate, Long ad_client_id, Long ad_org_id, Long ad_user_id,Long m_warehouse_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movement(\r\n"
					+ "	m_movement_id, ad_client_id, ad_org_id, isactive, created, createdby, updatedby, updated, documentno, description, movementdate, posted, processed, processing, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, docaction, docstatus, isintransit, c_doctype_id, isapproved, approvalamt, freightcostrule, m_shipper_id, priorityrule, salesrep_id, ad_user_id, c_bpartner_id, c_bpartner_location_id, c_charge_id, chargeamt, createfrom, dd_order_id, deliveryrule, deliveryviarule, freightamt, reversal_id, poreference, processedon, m_movement_uu, status,m_warehouse_id)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
			ps = con.prepareStatement(sql);
			long id = getNextID();
			ps.setLong(1, id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setLong(7, ad_user_id);
			ps.setTimestamp(8, getDate());
			ps.setString(9, documentNo);
			ps.setString(10, "Mobile App");
			ps.setDate(11, movementDate);
			ps.setString(12, "Y");
			ps.setString(13, "Y");
			ps.setString(14, "N");
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setNull(19, java.sql.Types.NUMERIC);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setNull(21, java.sql.Types.TIMESTAMP);
			ps.setString(22, "CL");
			ps.setString(23, "CO");
			ps.setString(24, "N");
			ps.setInt(25, 1000022);
			ps.setString(26, "Y");
			ps.setInt(27, 0);
			ps.setNull(28, java.sql.Types.CHAR);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.CHAR);
			ps.setLong(31, ad_user_id);
			ps.setLong(32, ad_user_id);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setInt(36, 0);
			ps.setNull(37, java.sql.Types.CHAR);
			ps.setNull(38, java.sql.Types.NUMERIC);
			ps.setNull(39, java.sql.Types.CHAR);
			ps.setNull(40, java.sql.Types.CHAR);
			ps.setInt(41, 0);
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.VARCHAR);
			ps.setInt(44, 0);
			ps.setString(45, getUUID());
			ps.setString(46, "01");
			ps.setLong(47, m_warehouse_id);
			ps.executeUpdate();
			con.close();
			ps.close();
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	public static void createMovementVanning(int c_order_id, String documentNo, Date movementDate) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movement(\r\n" + 
					"	m_movement_id, ad_client_id, ad_org_id, isactive, created, createdby, updatedby, updated, documentno, description, movementdate, posted, processed, processing, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, docaction, docstatus, isintransit, c_doctype_id, isapproved, approvalamt, freightcostrule, m_shipper_id, priorityrule, salesrep_id, ad_user_id, c_bpartner_id, c_bpartner_location_id, c_charge_id, chargeamt, createfrom, dd_order_id, deliveryrule, deliveryviarule, freightamt, reversal_id, poreference, processedon, m_movement_uu, status, c_order_id)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long id = getNextID();
			ps.setLong(1, id);
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setInt(7, 100);
			ps.setTimestamp(8, getDate());
			ps.setString(9, documentNo);
			ps.setString(10, "Mobile App");
			ps.setDate(11, movementDate);
			ps.setString(12, "Y");
			ps.setString(13, "Y");
			ps.setString(14, "N");
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setNull(19, java.sql.Types.NUMERIC);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setNull(21, java.sql.Types.TIMESTAMP);
			ps.setString(22, "CL");
			ps.setString(23, "CO");
			ps.setString(24, "N");
			ps.setInt(25, 1000987);
			ps.setString(26, "Y");
			ps.setInt(27, 0);
			ps.setNull(28, java.sql.Types.CHAR);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.CHAR);
			ps.setInt(31, 100);
			ps.setInt(32, 100);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setInt(36, 0);
			ps.setNull(37, java.sql.Types.CHAR);
			ps.setNull(38, java.sql.Types.NUMERIC);
			ps.setNull(39, java.sql.Types.CHAR);
			ps.setNull(40, java.sql.Types.CHAR);
			ps.setInt(41, 0); 
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.VARCHAR);
			ps.setInt(44, 0);
			ps.setString(45, getUUID());
			ps.setString(46, "01");
			ps.setInt(47, c_order_id);
			ps.executeUpdate();
			con.close();
			ps.close();
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void createMovementVanningToRack(int c_order_id, String documentNo, Date movementDate) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movement(\r\n" + 
					"	m_movement_id, ad_client_id, ad_org_id, isactive, created, createdby, updatedby, updated, documentno, description, movementdate, posted, processed, processing, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, docaction, docstatus, isintransit, c_doctype_id, isapproved, approvalamt, freightcostrule, m_shipper_id, priorityrule, salesrep_id, ad_user_id, c_bpartner_id, c_bpartner_location_id, c_charge_id, chargeamt, createfrom, dd_order_id, deliveryrule, deliveryviarule, freightamt, reversal_id, poreference, processedon, m_movement_uu, status, c_order_id)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			long id = getNextID();
			ps.setLong(1, id);
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setInt(7, 100);
			ps.setTimestamp(8, getDate());
			ps.setString(9, documentNo);
			ps.setString(10, "Mobile App");
			ps.setDate(11, movementDate);
			ps.setString(12, "Y");
			ps.setString(13, "Y");
			ps.setString(14, "N");
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setNull(19, java.sql.Types.NUMERIC);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setNull(21, java.sql.Types.TIMESTAMP);
			ps.setString(22, "CL");
			ps.setString(23, "CO");
			ps.setString(24, "N");
			ps.setInt(25, 1000988);
			ps.setString(26, "Y");
			ps.setInt(27, 0);
			ps.setNull(28, java.sql.Types.CHAR);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.CHAR);
			ps.setInt(31, 100);
			ps.setInt(32, 100);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setInt(36, 0);
			ps.setNull(37, java.sql.Types.CHAR);
			ps.setNull(38, java.sql.Types.NUMERIC);
			ps.setNull(39, java.sql.Types.CHAR);
			ps.setNull(40, java.sql.Types.CHAR);
			ps.setInt(41, 0); 
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.VARCHAR);
			ps.setInt(44, 0);
			ps.setString(45, getUUID());
			ps.setString(46, "01");
			ps.setNull(47, c_order_id);
			ps.executeUpdate();
			con.close();
			ps.close();
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void createMovementReceiving(Date movementDate) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movement(\r\n"
					+ "	m_movement_id, ad_client_id, ad_org_id, isactive, created, createdby, updatedby, updated, documentno, description, movementdate, posted, processed, processing, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, docaction, docstatus, isintransit, c_doctype_id, isapproved, approvalamt, freightcostrule, m_shipper_id, priorityrule, salesrep_id, ad_user_id, c_bpartner_id, c_bpartner_location_id, c_charge_id, chargeamt, createfrom, dd_order_id, deliveryrule, deliveryviarule, freightamt, reversal_id, poreference, processedon, m_movement_uu, status)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, getNextID());
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setInt(7, 100);
			ps.setTimestamp(8, getDate());
			ps.setString(9, getDocumentNoReceiving());
			ps.setString(10, "Mobile App");
			ps.setDate(11, movementDate);
			ps.setString(12, "Y");
			ps.setString(13, "Y");
			ps.setString(14, "N");
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setNull(19, java.sql.Types.NUMERIC);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setNull(21, java.sql.Types.TIMESTAMP);
			ps.setString(22, "CL");
			ps.setString(23, "CO");
			ps.setString(24, "N");
			ps.setInt(25, 1000664);
			ps.setString(26, "Y");
			ps.setInt(27, 0);
			ps.setNull(28, java.sql.Types.CHAR);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.CHAR);
			ps.setInt(31, 100);
			ps.setInt(32, 100);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setInt(36, 0);
			ps.setNull(37, java.sql.Types.CHAR);
			ps.setNull(38, java.sql.Types.NUMERIC);
			ps.setNull(39, java.sql.Types.CHAR);
			ps.setNull(40, java.sql.Types.CHAR);
			ps.setInt(41, 0);
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.VARCHAR);
			ps.setInt(44, 0);
			ps.setString(45, getUUID());
			ps.setString(46, "01");
			ps.executeUpdate();
			con.close();
			ps.close();
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void createMovementRack(Date movementDate) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_movement(\r\n"
					+ "	m_movement_id, ad_client_id, ad_org_id, isactive, created, createdby, updatedby, updated, documentno, description, movementdate, posted, processed, processing, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, docaction, docstatus, isintransit, c_doctype_id, isapproved, approvalamt, freightcostrule, m_shipper_id, priorityrule, salesrep_id, ad_user_id, c_bpartner_id, c_bpartner_location_id, c_charge_id, chargeamt, createfrom, dd_order_id, deliveryrule, deliveryviarule, freightamt, reversal_id, poreference, processedon, m_movement_uu, status)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setLong(1, getNextID());
			ps.setLong(2, 1000010);
			ps.setLong(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setInt(7, 100);
			ps.setTimestamp(8, getDate());
			ps.setString(9, getDocumentNoRack());
			ps.setString(10, "Mobile App");
			ps.setDate(11, movementDate);
			ps.setString(12, "Y");
			ps.setString(13, "Y");
			ps.setString(14, "N");
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setNull(16, java.sql.Types.NUMERIC);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setNull(19, java.sql.Types.NUMERIC);
			ps.setNull(20, java.sql.Types.NUMERIC);
			ps.setNull(21, java.sql.Types.TIMESTAMP);
			ps.setString(22, "CL");
			ps.setString(23, "CO");
			ps.setString(24, "N");
			ps.setInt(25, 1000664);
			ps.setString(26, "Y");
			ps.setInt(27, 0);
			ps.setNull(28, java.sql.Types.CHAR);
			ps.setNull(29, java.sql.Types.NUMERIC);
			ps.setNull(30, java.sql.Types.CHAR);
			ps.setInt(31, 100);
			ps.setInt(32, 100);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setNull(34, java.sql.Types.NUMERIC);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setInt(36, 0);
			ps.setNull(37, java.sql.Types.CHAR);
			ps.setNull(38, java.sql.Types.NUMERIC);
			ps.setNull(39, java.sql.Types.CHAR);
			ps.setNull(40, java.sql.Types.CHAR);
			ps.setInt(41, 0);
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.VARCHAR);
			ps.setInt(44, 0);
			ps.setString(45, getUUID());
			ps.setString(46, "01");
			ps.executeUpdate();
			con.close();
			ps.close();
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
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static String getDocumentNoReceiving() {
		Connection con = null;
		Statement st = null;
		String result = "CK-RECEIVING-1";
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select max(documentno) from m_movement where documentno like 'CK-RECEIVING%' and ad_client_id = 1000010";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String currentDocumentNo = rs.getString(1);
				Integer nextIndex = Integer
						.parseInt(currentDocumentNo.substring(currentDocumentNo.lastIndexOf("-") + 1)) + 1;
				result = currentDocumentNo.substring(0, currentDocumentNo.lastIndexOf("-") + 1)
						.concat(nextIndex.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "CK-RECEIVING-1";
		}
		return result;
	}

	public static String getDocumentNoRack() {
		Connection con = null;
		Statement st = null;
		String result = "CK-RACK-1";
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select max(documentno) from m_movement where documentno like 'CK-RACK%' and ad_client_id = 1000010";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String currentDocumentNo = rs.getString(1);
				Integer nextIndex = Integer
						.parseInt(currentDocumentNo.substring(currentDocumentNo.lastIndexOf("-") + 1)) + 1;
				result = currentDocumentNo.substring(0, currentDocumentNo.lastIndexOf("-") + 1)
						.concat(nextIndex.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "CK-RACK-1";
		}
		return result;
	}

	public static void updateMovementSuccessfully(String documentNo, long m_movement_id) {
		Connection con = null;
		Statement st = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Update m_movement set updated = now(), posted = 'Y', processed = 'Y', docaction = 'CL', docstatus = 'CO', isapproved = 'Y' where m_movement_id = "
					+ m_movement_id;
			st.executeUpdate(sql);
			String sql1 = "Update m_movementline set updated = now(), processed = 'Y' where m_movement_id = " + m_movement_id;
			st.executeUpdate(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Integer getNextID() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'M_Movement')::Integer, 'N'::Varchar)";
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
