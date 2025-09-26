package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	// Database connection parameters
	private static final String DB_URL = "jdbc:mariadb://localhost:3306/employees";
	private static final String USER = "root";
	private static final String PASS = "7305";

	// DB Connection을 얻는 메소드
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	// 자원을 닫는 메소드 (Statement, ResultSet)
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
