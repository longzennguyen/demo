package com.hdsoft.JptAPI.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hdsoft.ConnectDB;


public class MovementlineDAO {

	public double getQtyOnHandOfProduct(int m_product_id, int m_locator_id, int m_attributesetinstance_id) {
		double qty = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "SELECT qtyonhand from m_storageonhand where m_product_id = ? and m_locator_id = ? and m_attributesetinstance_id = ? and ad_client_id = 1000010";
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_product_id);
			ps.setInt(2, m_locator_id);
			ps.setInt(3, m_attributesetinstance_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				qty = rs.getDouble(1);
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
		return qty;
	}
	
}
