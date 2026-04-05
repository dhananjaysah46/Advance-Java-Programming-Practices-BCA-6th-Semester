package com.advancejava.mvc;

public class UserData {
	
	private String name;
	private String email;
	private float height;
	private long phone;
	
	public UserData(String name, String email, float height, long phone) {
		super();
		this.name = name;
		this.email = email;
		this.height = height;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public float getHeight() {
		return height;
	}

	public long getPhone() {
		return phone;
	}
}
