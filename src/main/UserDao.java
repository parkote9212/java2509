package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static final String TABLE_NAME = "my_table";

	/** 테이블을 생성합니다. */
	public void createTable() {
		// [수정] 올바른 SQL 문법으로 수정
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY, "
				+ "name VARCHAR(50)" + ")";
		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("✅ 테이블 생성 또는 확인 완료");
		} catch (SQLException e) {
			System.err.println("테이블 생성 실패: " + e.getMessage());
		}
	}

	/** 데이터를 추가합니다. (Create) */
	public boolean insertData(String name) {
		String sql = "INSERT INTO " + TABLE_NAME + " (name) VALUES (?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("✅ 데이터 삽입 성공: " + name);
			}
			return affectedRows > 0;
		} catch (SQLException e) {
			System.err.println("데이터 삽입 실패: " + e.getMessage());
			return false;
		}
	}

	/** ID로 특정 데이터를 조회합니다. (Read) */
	public User findData(int id) {
		String sql = "SELECT id, name FROM " + TABLE_NAME + " WHERE id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return new User(rs.getInt("id"), rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			System.err.println("데이터 조회 실패: " + e.getMessage());
		}
		return null; // 데이터가 없으면 null 반환
	}

	/** 모든 데이터를 조회합니다. (Read) */
	public List<User> readTable() {
		List<User> users = new ArrayList<>();
		String sql = "SELECT id, name FROM " + TABLE_NAME;
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("name")));
			}
		} catch (SQLException e) {
			System.err.println("전체 데이터 조회 실패: " + e.getMessage());
		}
		return users;
	}

	/** ID로 데이터를 수정합니다. (Update) */
	public boolean updateData(int id, String newName) {
		String sql = "UPDATE " + TABLE_NAME + " SET name = ? WHERE id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, newName);
			pstmt.setInt(2, id);
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("✅ 데이터 수정 성공: id=" + id);
			}
			return affectedRows > 0;
		} catch (SQLException e) {
			System.err.println("데이터 수정 실패: " + e.getMessage());
			return false;
		}
	}

	/** ID로 데이터를 삭제합니다. (Delete) */
	public boolean deleteData(int id) {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			int affectedRows = pstmt.executeUpdate();
			// [수정] try 블록 안에도 return문 추가
			return affectedRows > 0;
		} catch (SQLException e) {
			System.err.println("데이터 삭제 실패: " + e.getMessage());
			return false;
		}
	}

	/** 이름으로 데이터를 삭제합니다. (Delete) */
	public boolean deleteData(String name) {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE name = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			int affectedRows = pstmt.executeUpdate();
			// [수정] try 블록 안에도 return문 추가
			return affectedRows > 0;
		} catch (SQLException e) {
			System.err.println("데이터 삭제 실패: " + e.getMessage());
			return false;
		}
	}

	/** 테이블을 삭제합니다. */
	public void dropTable() {
		String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
			System.out.println("✅ 테이블 삭제 완료");
		} catch (SQLException e) {
			System.err.println("테이블 삭제 실패: " + e.getMessage());
		}
	}
}