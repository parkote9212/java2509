package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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
			UserDao userDao = new UserDao();
			while (true) {
				System.out.println("\n=======================================================");
				System.out.println("메뉴를 선택하세요:");
				System.out.println("1. 테이블 생성 | 2. 데이터 추가 | 3. ID로 조회 | 4. 전체 조회");
				System.out.println("5. 데이터 수정 | 6. ID로 삭제 | 7. 테이블 삭제 | 8. 종료");
				System.out.println("=======================================================");
				System.out.print("선택 > ");

				String menu = scanner.nextLine();

				// 스위치에 매개변수로 넘김
				switch (menu) {
				case "1": // 테이블 생성
					userDao.createTable();
					break;
				case "2": // 데이터 추가
					System.out.print("추가할 이름 입력: ");
					String insertName = scanner.nextLine();
					userDao.insertData(insertName);
					break;
				case "3": // ID로 조회
					System.out.print("조회할 ID 입력: ");
					int findId = Integer.parseInt(scanner.nextLine());
					User foundUser = userDao.findData(findId);
					if (foundUser != null) {
						System.out.println("조회 결과: " + foundUser);
					} else {
						System.out.println("ID " + findId + "에 해당하는 사용자가 없습니다.");
					}
					break;
				case "4": // 전체 조회
					List<User> users = userDao.readTable();
					System.out.println("--- 전체 사용자 목록 ---");
					for (User user : users) {
						System.out.println(user);
					}
					System.out.println("----------------------");
					break;
				case "5": // 데이터 수정
					System.out.print("수정할 ID 입력: ");
					int updateId = Integer.parseInt(scanner.nextLine());
					System.out.print("새로운 이름 입력: ");
					String newName = scanner.nextLine();
					userDao.updateData(updateId, newName);
					break;
				case "6":
					System.out.print("삭제할 사용자 이름 또는 아이디를 입력하세요: ");
					String input = scanner.nextLine();
					try {
						// 1. 먼저 숫자로 변환 시도
						int id = Integer.parseInt(input);

						// 2. 변환 성공 시 -> id로 삭제하는 메소드 호출
						// (이전에 만든 deleteData(int id) 메소드가 호출됨)
						userDao.deleteData(id);

					} catch (NumberFormatException e) {
						// 3. 변환 실패 시 (입력값이 숫자가 아닐 경우) -> 이름으로 삭제하는 메소드 호출
						// (이전에 만든 deleteData(String name) 메소드가 호출됨)
						userDao.deleteData(input);
					}
					break;

				case "7": // 테이블 삭제
					userDao.dropTable();
					break;
				case "8": // 종료
					System.out.println("프로그램을 종료합니다.");
					scanner.close();
					return;
				default:
					System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
				}
			}
		} catch (SQLException e) {
			System.err.println("==DB 연결 실패 ==" + e.getMessage());
		}
	}
}
