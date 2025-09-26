package com.main;

public class User {
	private int id;
	private String name;

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// Getter 메소드들...
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "User{id=" + id + ", name='" + name + "'}";
	}
}