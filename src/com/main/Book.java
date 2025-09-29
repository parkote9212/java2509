package com.main;

import java.time.LocalDate;

public class Book {
	private int bookID;
	private String title;
	private String author;
	private String publisher;
	private int price;
	private LocalDate pubYear;

	public Book() {
		// 기본 생성자
	}

	public Book(int bookID, String title, String autor, String publisher, int price, LocalDate pubYear) {
		this.bookID = bookID;
		this.title = title;
		this.author = autor;
		this.publisher = publisher;
		this.price = price;
		this.pubYear = pubYear;
	}

	public int getBookID() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public String getAutor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public LocalDate getPubYear() {
		return pubYear;
	}

	@Override
	public String toString() {
		return "도서번호:" + bookID + " 도서명:" + title + " 저자:" + author + " 출판사:" + publisher + " 가격:" + price + " 출판년도:"
				+ pubYear;
	}
}
