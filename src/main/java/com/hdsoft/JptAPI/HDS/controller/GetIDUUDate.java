package com.hdsoft.JptAPI.HDS.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import com.hdsoft.ConnectDB;


public class GetIDUUDate {
	public static Integer getNextID(String tableName) {
		Connection con = null;
		Statement st = null;
		Integer result = null;
		try {
			con = ConnectDB.conHD();
			st = con.createStatement();
			
			String sql = "Select * from nextid((select ad_sequence_id from ad_sequence where name = '"+tableName+"')::Integer, 'N'::Varchar)";
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
