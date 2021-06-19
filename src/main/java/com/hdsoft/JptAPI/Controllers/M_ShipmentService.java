package com.hdsoft.JptAPI.Controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import com.hdsoft.ConnectDB;


public class M_ShipmentService {

	public static void AddShipment(int c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.m_inout(\r\n" + 
					"	m_inout_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, issotrx, documentno, docaction, docstatus, posted, processing, processed, c_doctype_id, description, c_order_id, dateordered, isprinted, movementtype, movementdate, dateacct, c_bpartner_id, c_bpartner_location_id, m_warehouse_id, poreference, deliveryrule, freightcostrule, freightamt, deliveryviarule, m_shipper_id, c_charge_id, chargeamt, priorityrule, dateprinted, c_invoice_id, createfrom, generateto, sendemail, ad_user_id, salesrep_id, nopackages, pickdate, shipdate, trackingno, ad_orgtrx_id, c_project_id, c_campaign_id, c_activity_id, user1_id, user2_id, datereceived, isintransit, ref_inout_id, createconfirm, createpackage, isapproved, isindispute, volume, weight, m_rma_id, reversal_id, isdropship, dropship_bpartner_id, dropship_location_id, dropship_user_id, processedon, m_inout_uu, freightcharges, shipperaccount, insurance, fob, isalternatereturnaddress, returnbpartner_id, returnlocation_id, returnuser_id, iscreatedorder, barcode, scanqty, checkscan, isvalidscanlist, generateinoutline, scancode, shiptoaddress)\r\n" + 
					"	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getNextInoutID());
			ps.setInt(2, 1000010);
			ps.setInt(3, 1000022);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setString(9, "Y");
			ps.setString(10, generateDocumentNo(c_order_id));
			ps.setString(11, "CL");
			ps.setString(12, "CO");
			ps.setString(13, "E");
			ps.setString(14, "N");
			ps.setString(15, "Y");
			ps.setInt(16, 1000653);
			ps.setString(17, "Mobile App");
			ps.setInt(18, c_order_id);
			ps.setNull(19, java.sql.Types.TIMESTAMP);
			ps.setString(20, "N");
			ps.setString(21, "C-");
			ps.setTimestamp(22, getDate());
			ps.setTimestamp(23, getDate());
			ps.setInt(24, 1001790);
			ps.setInt(25, 1001436);
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
			ps.setString(58, "Y");
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
		}
	}

	public static String generateDocumentNo(int c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String result = "";
		try {
			con = ConnectDB.conHD();
			String sql = "Select documentno from c_order where c_order_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = "XK-".concat(rs.getString(1));
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

	public static Integer getNextInoutID() {
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
