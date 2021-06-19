package com.hdsoft.JptAPI.Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hdsoft.ConnectDB;

public class MInoutLineDAO {

	public void updateCheckQty(long m_inoutline_id, double qtyCheck) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectDB.conHD();
			String sql = "UPDATE M_inoutline set hds_qtycheckdemo = ? where M_inoutline_id = ?";
			ps = con.prepareStatement(sql);
			ps.setDouble(1, qtyCheck);
			ps.setLong(2, m_inoutline_id);
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
	
}
