package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDClass {

	public CRUDClass() {
//		Create 테이블 - create table
		createTable();

//		Read 테이블 - select
		selectTable();

//		Update 테이블 - update table
//		updateTable();

//		Delete 데이터 삭제 -  delete
//		deleteUser();

//		drop 테이블 삭제
//		dropTables();

//		insert
//		insertUser();
	}

	private void dropTables() {
		// TODO Auto-generated method stub
		String sql = "drop table test1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			DB연결
			conn = DBConnection.getConnection();
//			sql 정보 전달
			pstmt = conn.prepareStatement(sql);
//			결과값 리턴
			rs = pstmt.executeQuery();
			System.out.println("======= 데이터배이스내 테이블 확인 ===============");
			while (rs.next()) {
				String tblName = rs.getString("tables_in_employees");
				String tblName2 = rs.getString(1);
				System.out.println("[" + tblName + "--" + tblName2 + "]");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void insertUser() {
		// TODO Auto-generated method stub

	}

	private void deleteUser() {
		// TODO Auto-generated method stub

	}

	private void updateTable() {
		// TODO Auto-generated method stub

	}

	private void selectTable() {
		// TODO Auto-generated method stub
		String sql = "show tables";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			DB연결
			conn = DBConnection.getConnection();
//			sql 정보 전달
			pstmt = conn.prepareStatement(sql);
//			결과값 리턴
			rs = pstmt.executeQuery();
			System.out.println("======= 데이터배이스내 테이블 확인 ===============");
			while (rs.next()) {
				String tblName = rs.getString("tables_in_employees");
				String tblName2 = rs.getString(1);
				System.out.println("[" + tblName + "--" + tblName2 + "]");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 4. 이제 finally 블록에서 stmt에 접근 가능
			DBConnection.close(rs, pstmt, conn);
		}

	}

	private void createTable() {
		String sql = "CREATE TABLE test1 (userID CHAR(8) NOT NULL PRIMARY KEY, mdate DATE)";
		Connection conn = null;
		Statement stmt = null; // 1. try 블록 밖에서 선언

		try {
			// DB연결
			conn = DBConnection.getConnection();
			// Statement 객체 생성
			stmt = conn.createStatement(); // 2. 파라미터 없이 호출

			// SQL 실행
			stmt.execute(sql); // 3. execute() 메소드에 sql 전달
			System.out.println("테이블이 성공적으로 생성되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 이제 finally 블록에서 stmt에 접근 가능
			DBConnection.close(stmt, conn);
		}
	}

}
