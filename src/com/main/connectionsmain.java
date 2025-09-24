package com.main;

import java.sql.Connection;

public class connectionsmain {

//	static final String DB_URL = "jdbc:mariadb://localhostL3306/employees";
//	static final String USER = "root";
//	static final String PASS = "7305";
//	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. DB 연결을 위한 접속 정보
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			System.out.println("==DB 연결 성공 ==");
			CRUDClass crudClass = new CRUDClass();
		} finally {
			// TODO: handle finally clause
		}

	}

}
