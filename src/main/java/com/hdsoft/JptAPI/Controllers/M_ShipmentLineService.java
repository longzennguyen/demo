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

public class M_ShipmentLineService {

	public static void addShipmentLine(int m_inout_id, Integer c_orderline_id, int m_locator_id, int m_product_id,
			double quantity) {
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
			ps.setInt(6, 100);
			ps.setTimestamp(7, getDate());
			ps.setInt(8, 100);
			ps.setInt(9, getLine(m_inout_id));
			ps.setNull(10, java.sql.Types.VARCHAR);
			ps.setLong(11, m_inout_id);
			ps.setLong(12, c_orderline_id);
			ps.setDouble(20, 0);
			ps.setDouble(23, 0);
			ps.setDouble(39, 0);
			ps.setLong(13, m_locator_id);
			ps.setLong(14, m_product_id);
			ps.setLong(15, 1000028);
			ps.setDouble(16, quantity);
			ps.setString(17, "N");
			ps.setInt(18, 0);
			ps.setString(19, "N");
			ps.setInt(21, 0);
			ps.setInt(22, 0);
			ps.setNull(24, java.sql.Types.NUMERIC);
			ps.setString(25, "Y");
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
			ps.setNull(40, java.sql.Types.VARCHAR);
			ps.setNull(41, java.sql.Types.NUMERIC);
			ps.executeUpdate();
			ps.close();
			con.close();
			updateQuantityOnHand(m_locator_id, m_product_id, quantity);
			updateTransaction(m_locator_id, m_product_id, quantity, m_inoutline_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateQuantityOnHand(int m_locator_id, int m_product_id, Double quantity) {
		Connection con = null;
		Statement st = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			double quan = getQuantityOnHand(m_locator_id, m_product_id) - quantity;
			String sql = "Update m_storageonhand set qtyonhand = " + quan + ", updated = now() where m_locator_id = " + m_locator_id
					+ " and m_product_id = " + m_product_id;
			st = con.createStatement();
			st.executeUpdate(sql);
			st.close();
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

	public static Double getQuantityOnHand(long m_locator_id, long m_product_id) {
		Connection con = null;
		Statement st = null;
		Double result = 0.0;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "select sum(qtyonhand) from m_storageonhand where m_locator_id = " + m_locator_id
					+ " and m_product_id = " + m_product_id;
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

	public static void updateTransaction(long m_locator_id, long m_product_id, Double quantity, long m_inoutline_id) {
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
			ps.setString(9, "C-");
			ps.setLong(10, m_locator_id);
			ps.setLong(11, m_product_id);
			ps.setTimestamp(12, getDate());
			ps.setDouble(13, -quantity);
			ps.setNull(14, java.sql.Types.NUMERIC);
			ps.setNull(15, java.sql.Types.NUMERIC);
			ps.setLong(16, m_inoutline_id);
			ps.setNull(17, java.sql.Types.NUMERIC);
			ps.setNull(18, java.sql.Types.NUMERIC);
			ps.setInt(19, 0);
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

	public static Double getCorderlineQty(int c_orderline_id) {
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

}
