package com.fsmob;

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
		String url = "jdbc:postgresql://127.0.0.1:5432/postgres";
		String user = "postgres";
		String pass = "123123";
		Connection con = DriverManager.getConnection(url, user, pass);
		return con;
	}
	
	
}
