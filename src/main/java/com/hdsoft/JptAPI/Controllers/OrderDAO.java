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


public class OrderDAO {

	
	public void addOrderDemo(String documentNo,String description, long c_bpartner_id, Date dateOrder, Date datePromised, long ad_client_id, long ad_org_id, long ad_user_id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.c_order(\r\n"
					+ "	c_order_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, issotrx, documentno, docstatus, "
					+ "docaction, processing, processed, c_doctype_id, c_doctypetarget_id, description, isapproved, iscreditapproved, isdelivered, isinvoiced, isprinted, istransferred, isselected, salesrep_id, dateordered, datepromised, dateprinted, dateacct, c_bpartner_id, c_bpartner_location_id, poreference, isdiscountprinted, c_currency_id, paymentrule, c_paymentterm_id, invoicerule, deliveryrule, freightcostrule, freightamt, deliveryviarule, m_shipper_id, c_charge_id, chargeamt, priorityrule, totallines, grandtotal, m_warehouse_id, m_pricelist_id, istaxincluded, c_campaign_id, c_project_id, c_activity_id, posted, c_payment_id, c_cashline_id, sendemail, ad_user_id, copyfrom, isselfservice, ad_orgtrx_id, user1_id, user2_id, c_conversiontype_id, bill_bpartner_id, bill_location_id, bill_user_id, pay_bpartner_id, pay_location_id, ref_order_id, isdropship, volume, weight, ordertype, c_pos_id, amounttendered, amountrefunded, link_order_id, m_freightcategory_id, dropship_bpartner_id, dropship_location_id, dropship_user_id, promotioncode, c_ordersource_id, processedon, ispayschedulevalid, c_cashplanline_id, c_order_uu, shippingrateinquiry, ispriviledgedrate, c_opportunity_id, quotationorder_id, m_inout_id, importinternal, checkwh, isscanning, isvanning, contactname, contactno, destport, driverid, drivername, driverphoneno, packinglistno, shiptolocation, sino, tripcount, vehiclelicenseplate, btnshippinginstruction, isback, ismoving, btncheckproduct, btnconfirmsi, btnconfirmorder)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, getId());
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setString(9, "Y");
			ps.setString(10, documentNo);
			ps.setString(11, "DR");
			ps.setString(12, "CO");
			ps.setString(13, "N");
			ps.setString(14, "N");
			ps.setInt(15, 0);
			ps.setInt(16, 1000030);
			ps.setString(17, description);
			ps.setString(18, "N");
			ps.setString(19, "N");
			ps.setString(20, "N");
			ps.setString(21, "N");
			ps.setString(22, "N");
			ps.setString(23, "N");
			ps.setString(24, "N");
			ps.setInt(25, 1000005);
			ps.setDate(26, dateOrder);
			ps.setDate(27, datePromised);
			ps.setNull(28, java.sql.Types.TIMESTAMP);
			ps.setDate(29, dateOrder);
			ps.setLong(30, c_bpartner_id);
			ps.setInt(31, getCBpartnerLocator(c_bpartner_id));
			ps.setNull(32, java.sql.Types.VARCHAR);
			ps.setString(33, "N");
			ps.setInt(34, 234);
			ps.setString(35, "P");
			ps.setInt(36, 105);
			ps.setString(37, "D");
			ps.setString(38, "A");
			ps.setString(39, "I");
			ps.setInt(40, 0);
			ps.setString(41, "P");
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setNull(43, java.sql.Types.NUMERIC);
			ps.setInt(44, 0);
			ps.setInt(45, 5);
			ps.setInt(46, 1);
			ps.setInt(47, 1);
			ps.setInt(48, 1000000);
			ps.setInt(49, 1000003);
			ps.setString(50, "N");
			ps.setNull(51, java.sql.Types.NUMERIC);
			ps.setNull(52, java.sql.Types.NUMERIC);
			ps.setNull(53, java.sql.Types.NUMERIC);
			ps.setString(54, "N");
			ps.setNull(55, java.sql.Types.NUMERIC);
			ps.setNull(56, java.sql.Types.NUMERIC);
			ps.setString(57, "N");
			ps.setNull(58, java.sql.Types.NUMERIC);
			ps.setString(59, "N");
			ps.setString(60, "N");
			ps.setNull(61, java.sql.Types.NUMERIC);
			ps.setNull(62, java.sql.Types.NUMERIC);
			ps.setNull(63, java.sql.Types.NUMERIC);
			ps.setInt(64, 114);
			ps.setInt(65, 1003497);
			ps.setInt(66, 1001971);
			ps.setNull(67, java.sql.Types.NUMERIC);
			ps.setNull(68, java.sql.Types.NUMERIC);
			ps.setNull(69, java.sql.Types.NUMERIC);
			ps.setNull(70, java.sql.Types.NUMERIC);
			ps.setString(71, "N");
			ps.setDouble(72, 0.00);
			ps.setDouble(73, 0.00);
			ps.setNull(74, java.sql.Types.VARCHAR);
			ps.setNull(75, java.sql.Types.NUMERIC);
			ps.setDouble(76, 0.00);
			ps.setDouble(77, 0.00);
			ps.setNull(78, java.sql.Types.NUMERIC);
			ps.setNull(79, java.sql.Types.NUMERIC);
			ps.setNull(80, java.sql.Types.NUMERIC);
			ps.setNull(81, java.sql.Types.NUMERIC);
			ps.setNull(82, java.sql.Types.NUMERIC);
			ps.setNull(83, java.sql.Types.VARCHAR);
			ps.setNull(84, java.sql.Types.NUMERIC);
			ps.setInt(85, 0);
			ps.setString(86, "N");
			ps.setNull(87, java.sql.Types.NUMERIC);
			ps.setString(88, getUUID());
			ps.setString(89, "N");
			ps.setString(90, "N");
			ps.setNull(91, java.sql.Types.NUMERIC);
			ps.setNull(92, java.sql.Types.NUMERIC);
			ps.setNull(93, java.sql.Types.NUMERIC);
			ps.setNull(94, java.sql.Types.CHAR);
			ps.setString(95, "N");
			ps.setString(96, "N");
			ps.setString(97, "N");
			ps.setNull(98, java.sql.Types.VARCHAR);
			ps.setNull(99, java.sql.Types.VARCHAR);
			ps.setNull(100, java.sql.Types.VARCHAR);
			ps.setNull(101, java.sql.Types.VARCHAR);
			ps.setNull(102, java.sql.Types.VARCHAR);
			ps.setNull(103, java.sql.Types.VARCHAR);
			ps.setNull(104, java.sql.Types.VARCHAR);
			ps.setNull(105, java.sql.Types.VARCHAR);
			ps.setNull(106, java.sql.Types.VARCHAR);
			ps.setNull(107, java.sql.Types.VARCHAR);
			ps.setNull(108, java.sql.Types.VARCHAR);
			ps.setNull(109, java.sql.Types.CHAR);
			ps.setString(110, "N");
			ps.setNull(111, java.sql.Types.CHAR);
			ps.setNull(112, java.sql.Types.CHAR);
			ps.setNull(113, java.sql.Types.CHAR);
			ps.setNull(114, java.sql.Types.CHAR);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
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
	
	public Integer getCBpartnerLocator(long c_bpartner_id) {
		Connection con = null;
		PreparedStatement ps = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT c_bpartner_location_id FROM C_Bpartner_location where c_Bpartner_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, c_bpartner_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
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
		return result;
	}
	
	public Integer getId() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'C_Order')::Integer, 'N'::Varchar)";
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
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
		return result;
	}

	public String getUUID() {
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
				e.printStackTrace();
			}
			try {
				cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Timestamp getDate() {
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
