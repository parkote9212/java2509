package com.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
	public void createTables() { // 메서드 이름을 복수형으로 바꾸는 것을 추천
		// 1. 각 CREATE 문을 별도의 문자열로 분리합니다.
		String sqlBook = """
				CREATE TABLE Book(
				    BookID INT PRIMARY KEY AUTO_INCREMENT,
				    Title VARCHAR(20) NOT NULL,
				    Author VARCHAR(20) NOT NULL,
				    Publisher VARCHAR(20) NOT NULL,
				    price INT CHECK (price >= 0),
				    PubYear DATE
				)
				""";

		String sqlMember = """
				CREATE TABLE MEMBER(
				    memberID INT PRIMARY KEY AUTO_INCREMENT,
				    NAME VARCHAR(20) NOT NULL,
				    phone VARCHAR(20),
				    address VARCHAR(20)
				)
				""";
		String sqlRental = """
				CREATE TABLE Rental(
				    RentalID INT PRIMARY KEY AUTO_INCREMENT,
				    MemberID INT NOT NULL,
				    BookID INT NOT NULL,
				    RentDate DATE NOT NULL,
				    ReturnDate DATE,
				    FOREIGN KEY (MemberID) REFERENCES MEMBER(memberID),
				    FOREIGN KEY (BookID) REFERENCES Book(BookID)
				)
				""";

		// 2. try-with-resources 안에서 각 SQL을 순서대로 실행합니다.
		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
			// 참조 관계(FOREIGN KEY)가 있으므로 순서가 중요합니다. (Book, MEMBER -> Rental)
			stmt.execute(sqlBook);
			stmt.execute(sqlMember);
			stmt.execute(sqlRental);
			System.out.println("✅ 3개의 테이블 생성 완료");
		} catch (SQLException e) {
			// 어떤 테이블에서 오류가 났는지 알기 더 쉬워집니다.
			System.err.println("테이블 생성 실패: " + e.getMessage());
		}
	}

	public void insertData() {
		String sqlBook = """
				INSERT INTO Book(Title, Author, Publisher, price, PubYear) VALUES
				    ('축구의 역사', '김축구', '굿스포츠', 7000, '2020-01-01'),
				    ('축구 아는 여자', '이축구', '굿스포츠', 13000, '2023-05-10'),
				    ('피겨의 정석', '박피겨', '좋은북스', 11000, '2022-08-15'),
				    ('야구란 무엇인가', '최야구', '좋은북스', 9500, '2021-03-01'),
				    ('생존 수영', '정수영', '생각서점', 15000, '2024-02-20');
				""";

		String sqlMember = """
				INSERT INTO MEMBER(NAME, phone, address) VALUES
				    ('박지성', '010-1111-2222', '서울'),
				    ('김연아', '010-3333-4444', '경기'),
				    ('손흥민', '010-5555-6666', '강원'),
				    ('이대호', NULL, '부산');
				""";

		String sqlRental = """
				INSERT INTO Rental(MemberID, BookID, RentDate, ReturnDate) VALUES
				    (1, 1, '2024-01-05', '2024-01-15'),
				    (1, 2, '2024-02-10', '2024-02-20'),
				    (2, 3, '2024-03-01', '2024-03-10'),
				    (3, 1, '2024-03-05', NULL),
				    (3, 4, '2024-04-11', NULL),
				    (4, 5, '2024-05-20', '2024-05-30');
				""";

		// 2. PreparedStatement 대신 Statement를 사용합니다.
		try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(sqlBook);
			stmt.executeUpdate(sqlMember);
			stmt.executeUpdate(sqlRental);
			System.out.println("✅ 데이터 삽입 성공");
		} catch (SQLException e) {
			System.err.println("데이터 삽입 실패: " + e.getMessage());

		}

	}

	public List<Book> readBooks() {
		List<Book> books = new ArrayList<>(); // 변수명을 복수형(books)으로 하는 것을 추천
		String sql = "SELECT * FROM Book";

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				// ResultSet에서 Book 데이터 추출
				int bookID = rs.getInt("BookID");
				String title = rs.getString("Title");
				String author = rs.getString("Author");
				String publisher = rs.getString("Publisher");
				int price = rs.getInt("price"); // DB 컬럼명이 price이므로 "price"

				// 1. java.sql.Date를 java.time.LocalDate로 변환
				LocalDate pubYear = rs.getDate("PubYear").toLocalDate();

				// 2. 모든 데이터를 Book 객체 생성자에 전달하여 리스트에 추가
				books.add(new Book(bookID, title, author, publisher, price, pubYear));
			}
		} catch (SQLException e) {
			System.err.println("Book 데이터 조회 실패: " + e.getMessage());
		}
		return books;
	}

	public void test1(int startYear) {
		System.out.println("---- " + startYear + "년 이후 출판된 도서 ----");

		// 1. WHERE 절에 파라미터(?), YEAR() 함수 컬럼에 별칭(AS) 추가
		String sql = """
				SELECT
				    title,
				    YEAR(pubyear) AS publication_year
				FROM
				    book
				WHERE
				    YEAR(pubyear) >= ?;
				""";

		// 2. Statement 대신 PreparedStatement 사용
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// 3. SQL의 첫 번째 ? 에 매개변수로 받은 startYear 값을 설정
			pstmt.setInt(1, startYear);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String title = rs.getString("title");
					// 4. 별칭으로 안전하게 값을 가져옴
					int year = rs.getInt("publication_year");
					System.out.println("도서명: " + title + ", 출판연도: " + year);
				}
			}
		} catch (SQLException e) {
			System.err.println("쿼리 실행 실패: " + e.getMessage());
		}
		System.out.println();
	}

	// 이름을 파라미터로 받아 어떤 회원이든 검색할 수 있는 메서드로 변경
	public void test2(String memberName) {
		System.out.println("---- " + memberName + " 회원이 대출한 도서 목록 ----");

		String sql = """
				SELECT M.name, M.memberId, B.Title, R.RentDate
				FROM member M
				INNER JOIN rental R ON M.memberID = R.MemberID
				INNER JOIN book B ON R.BookID = B.BookID
				WHERE M.name = ?
				""";

		try (Connection conn = DBConnection.getConnection();
				// PreparedStatement 객체 사용
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// SQL의 첫 번째 ?에 파라미터로 받은 memberName 값을 설정
			pstmt.setString(1, memberName);

			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					String name = rs.getString("name");
					int id = rs.getInt("memberId");
					String title = rs.getString("Title");
					LocalDate date = rs.getDate("RentDate").toLocalDate();
					System.out.println("이름: " + name + ", 회원ID: " + id + ", 도서명: " + title + ", 대출일: " + date);
				}
			}
		} catch (SQLException e) {
			System.err.println("쿼리 실행 실패: " + e.getMessage());
		}
		System.out.println();
	}

	public void test3() {
		System.out.println("----3. 반납하지 않은 책목록----");

		String sql = """
				SELECT
				    M.name AS '이름',
				    M.memberId AS '회원번호',
				    B.Title AS '도서명',
				    R.RentDate AS '대출일자'
				FROM
				    member M
				INNER JOIN
				    rental R ON M.memberID = R.MemberID
				INNER JOIN
				    book B ON R.BookID = B.BookID
				WHERE
				    R.ReturnDate IS NULL;
				""";

		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				// 2. 컬럼 이름(Label)을 정확하게 사용
				String name = rs.getString("이름");
				int id = rs.getInt("회원번호");
				String title = rs.getString("도서명");

				// 3. 날짜 타입을 올바르게 처리
				LocalDate date = rs.getDate("대출일자").toLocalDate();

				System.out.println("이름: " + name + ", 회원ID: " + id + ", 도서명: " + title + ", 대출일: " + date);
			}
		} catch (SQLException e) {
			System.err.println("쿼리 실행 실패: " + e.getMessage());
		}
		System.out.println();
	}

	public void test4() {
		System.out.println("----도서별 대출 횟수를 출력하시오.----");

		String sql = """
				SELECT
				    B.title AS '도서명',
				    B.bookid AS '도서번호',
				    COUNT(R.bookid) AS '대출횟수'
				FROM
				    book B
				LEFT JOIN
				    rental R ON R.BookId = B.BookID
				GROUP BY
				    B.bookID;
				""";
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				// 2. 컬럼 이름(Label)을 정확하게 사용
				String title = rs.getString("도서명");
				int id = rs.getInt("도서번호");
				int count = rs.getInt("대출횟수");

				System.out.println("도서명: " + title + " 도서번호: " + id + " 대출횟수: " + count);
			}
		} catch (SQLException e) {
			System.err.println("쿼리 실행 실패: " + e.getMessage());
		}
		System.out.println();
	}

	public void test4(String title) {
		System.out.println("---- " + title + " 의 대출횟수 ----");

		String sql = """
				SELECT
				    B.title AS '도서명',
				    B.bookid AS '도서번호',
				    COUNT(R.bookid) AS '대출횟수'
				FROM
				    book B
				LEFT JOIN
				    rental R ON R.BookId = B.BookID
				WHERE
					B.title = ?
				GROUP BY
				    B.bookID, B.title;

				""";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// 4. SQL의 ? 부분에 매개변수로 받은 title 값을 설정
			pstmt.setString(1, title);

			try (ResultSet rs = pstmt.executeQuery()) {
				// 결과는 0 또는 1개이므로 if문으로 처리 가능
				if (rs.next()) {
					String bookTitle = rs.getString("도서명");
					int id = rs.getInt("도서번호");
					int count = rs.getInt("대출횟수");

					System.out.println("도서명: " + bookTitle + ", 도서번호: " + id + ", 대출횟수: " + count);
				} else {
					System.out.println("해당 도서를 찾을 수 없거나 대출 기록이 없습니다.");
				}
			}
		} catch (SQLException e) {
			System.err.println("쿼리 실행 실패: " + e.getMessage());
		}
		System.out.println();
	}

	public void test5() {
		System.out.println("가격이 가장 비싼 도서");

		String sql = """
				SELECT
				    title AS '도서명',
				    price AS '가격'
				FROM
				    book
				WHERE
				    price = (SELECT MAX(price) FROM Book);
				""";
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				// 2. 컬럼 이름(Label)을 정확하게 사용
				String title = rs.getString("도서명");
				int price = rs.getInt("가격");

				System.out.println("도서명: " + title + " 가격: " + price);
			}
		} catch (SQLException e) {
			System.err.println("쿼리 실행 실패: " + e.getMessage());
		}
		System.out.println();
	}

}
