package com.hdsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static ConnectDB conInstance = null;

	public static ConnectDB getInstance() {
		if (conInstance == null) {
			return new ConnectDB();
		}
		return conInstance;
	}

	public static Connection conHD() throws SQLException {
		String url = "jdbc:postgresql://210.245.84.28:5432/id41HD";
		String user = "adempiere";
		String pass = "hdsofterppassword@123$";
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	
	
}
