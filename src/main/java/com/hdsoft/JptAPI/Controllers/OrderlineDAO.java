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
import java.util.ArrayList;
import java.util.List;

import com.hdsoft.ConnectDB;

public class OrderlineDAO {

	public void addOrderline(long c_order_id, long m_product_id, double qty, long ad_client_id, long ad_org_id,
			long ad_user_id, Date dateOrder, Date datePromised) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "INSERT INTO adempiere.c_orderline(\r\n"
					+ "	c_orderline_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, c_order_id, line, c_bpartner_id, c_bpartner_location_id, dateordered, datepromised, datedelivered, dateinvoiced, description, m_product_id, m_warehouse_id, c_uom_id, qtyordered, qtyreserved, qtydelivered, qtyinvoiced, m_shipper_id, c_currency_id, pricelist, priceactual, pricelimit, linenetamt, discount, freightamt, c_charge_id, c_tax_id, s_resourceassignment_id, ref_orderline_id, m_attributesetinstance_id, isdescription, processed, qtyentered, priceentered, c_project_id, pricecost, qtylostsales, c_projectphase_id, c_projecttask_id, rrstartdate, rramt, c_campaign_id, c_activity_id, user1_id, user2_id, ad_orgtrx_id, link_orderline_id, pp_cost_collector_id, m_promotion_id, c_orderline_uu, createshipment, createproduction, m_inoutline_id, serno, lot, guaranteedate, ismatched, isback, qtycheck, ctntally, ctnpallet, palletno)\r\n"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			ps = con.prepareStatement(sql);
			int c_orderline_id = getId();
			ps.setInt(1, c_orderline_id);
			ps.setLong(2, ad_client_id);
			ps.setLong(3, ad_org_id);
			ps.setString(4, "Y");
			ps.setTimestamp(5, getDate());
			ps.setLong(6, ad_user_id);
			ps.setTimestamp(7, getDate());
			ps.setLong(8, ad_user_id);
			ps.setLong(9, c_order_id);
			ps.setInt(10, getLine(c_order_id));
			ps.setInt(11, getCBpartnerId(c_order_id));
			ps.setInt(12, getCBpartnerLocationId(c_order_id));
			ps.setDate(13, dateOrder);
			ps.setDate(14, datePromised);
			ps.setNull(15, java.sql.Types.TIMESTAMP);
			ps.setNull(16, java.sql.Types.TIMESTAMP);
			ps.setNull(17, java.sql.Types.VARCHAR);
			ps.setLong(18, m_product_id);
			ps.setInt(19, 1000000);
			ps.setInt(20, 1000046);
			ps.setDouble(21, qty);
			ps.setDouble(22, qty);
			ps.setInt(23, 0);
			ps.setInt(24, 0);
			ps.setNull(25, java.sql.Types.NUMERIC);
			ps.setInt(26, 234);
			ps.setInt(27, 1);
			ps.setInt(28, 1);
			ps.setInt(29, 1);
			ps.setInt(30, 20);
			ps.setInt(31, 0);
			ps.setInt(32, 0);
			ps.setNull(33, java.sql.Types.NUMERIC);
			ps.setInt(34, 1000000);
			ps.setNull(35, java.sql.Types.NUMERIC);
			ps.setNull(36, java.sql.Types.NUMERIC);
			ps.setInt(37, 0);
			ps.setString(38, "N");
			ps.setString(39, "Y");
			ps.setDouble(40, qty);
			ps.setInt(41, 1);
			ps.setNull(42, java.sql.Types.NUMERIC);
			ps.setInt(43, 0);
			ps.setInt(44, 0);
			ps.setNull(45, java.sql.Types.NUMERIC);
			ps.setNull(46, java.sql.Types.NUMERIC);
			ps.setNull(47, java.sql.Types.TIMESTAMP);
			ps.setInt(48, 0);
			ps.setNull(49, java.sql.Types.NUMERIC);
			ps.setNull(50, java.sql.Types.NUMERIC);
			ps.setNull(51, java.sql.Types.NUMERIC);
			ps.setNull(52, java.sql.Types.NUMERIC);
			ps.setNull(53, java.sql.Types.NUMERIC);
			ps.setNull(54, java.sql.Types.NUMERIC);
			ps.setNull(55, java.sql.Types.NUMERIC);
			ps.setNull(56, java.sql.Types.NUMERIC);
			ps.setString(57, getUUID());
			ps.setString(58, "N");
			ps.setString(59, "N");
			ps.setNull(60, java.sql.Types.NUMERIC);
			ps.setNull(61, java.sql.Types.VARCHAR);
			ps.setNull(62, java.sql.Types.VARCHAR);
			ps.setNull(63, java.sql.Types.TIMESTAMP);
			ps.setString(64, "N");
			ps.setNull(65, java.sql.Types.CHAR);
			ps.setNull(66, java.sql.Types.NUMERIC);
			ps.setNull(67, java.sql.Types.NUMERIC);
			ps.setNull(68, java.sql.Types.NUMERIC);
			ps.setNull(69, java.sql.Types.NUMERIC);
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

	public Integer getCBpartnerId(long c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			String sql = "select c_Bpartner_id from c_order where c_order_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, c_order_id);
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

	public Integer getCBpartnerLocationId(long c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			String sql = "select c_bpartner_location_id from c_order where c_order_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, c_order_id);
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

	public Integer getLine(long c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		Integer result = 10;
		try {
			con = ConnectDB.conHD();
			String sql = "select max(line) from c_orderline where c_order_id = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, c_order_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt("max") + 10;
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

	/*
	 * Get list orderline xuất by c_order_id
	 * 
	 * @param c_order_id
	 */
	public List<C_Orderline> getOrderlineBy(int c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<C_Orderline> listOrderlineXuat = new ArrayList<C_Orderline>();
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT M_Product_ID, Qtyentered FROM C_Orderline WHERE C_Order_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				C_Orderline orderline = new C_Orderline();
				orderline.setM_product_id(rs.getInt(1));
				orderline.setQuantity(rs.getInt(2));
				listOrderlineXuat.add(orderline);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listOrderlineXuat;
	}

	
	public Integer getLocatorIdOfOrderline(int c_order_id,int m_product_id) {
		Integer m_locator_id = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT m_locator_id from c_orderline where c_order_id = ? and m_product_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			ps.setInt(2, m_product_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				m_locator_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return m_locator_id;
	}
	
	/**
	 * 
	 * @param c_order_id
	 * @param m_product_id
	 * @return
	 */
	public int getOrderlineByOrderIdAndProductId(int c_order_id, int m_product_id) {
		int qtyExport = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT m_product_id, qtyordered FROM C_Orderline WHERE C_Order_ID = ? and m_product_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			ps.setInt(2, m_product_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				qtyExport = rs.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return qtyExport;
	}

	/*
	 * Get list orderline back chỉ định by c_order_id
	 * 
	 * @param c_order_id
	 */
	public List<C_OrderlineBack> getOrderlineBackBy(int c_order_id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<C_OrderlineBack> listOrderlineXuat = new ArrayList<>();
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT c_orderline_id, m_product_id, qtyentered, m_attributesetinstance_id FROM C_Orderline WHERE C_Order_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_order_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				C_OrderlineBack orderline = new C_OrderlineBack();
				orderline.setC_orderline_id(rs.getInt(1));
				orderline.setM_product_id(rs.getInt(2));
				orderline.setQuantity(rs.getInt(3));
				orderline.setAsiId(rs.getInt(4));
				listOrderlineXuat.add(orderline);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listOrderlineXuat;
	}

	public Integer getId() {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = 'C_OrderLine')::Integer, 'N'::Varchar)";
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
