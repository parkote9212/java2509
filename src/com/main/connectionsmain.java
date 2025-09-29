package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class connectionsmain {

//	static final String DB_URL = "jdbc:mariadb://localhostL3306/employees";
//	static final String USER = "root";
//	static final String PASS = "7305";
//	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. DB 연결을 위한 접속 정보

		try (Connection conn = DBConnection.getConnection(); Scanner scanner = new Scanner(System.in)) {
			System.out.println("==DB 연결 성공 ==");
		} catch (SQLException e) {
			System.err.println("==DB 연결 실패 ==" + e.getMessage());
		}
		TestDao testDao = new TestDao();
//		testDao.createTables();
//		testDao.insertData();

//		20이후 출판된 도서
//		testDao.test1(2021);
//		괄호안에 사용자가 빌려간 책 반환
//		testDao.test2("박지성");
//		testDao.test3();
		testDao.test4();
		testDao.test4("생존 수영");
//		testDao.test5();
	}
}
