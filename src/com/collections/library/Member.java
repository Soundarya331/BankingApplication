package com.collections.library;

public class Member {
	private String name ;
	private long number;
	private String  email;
	public Member(String name, long number, String email) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
