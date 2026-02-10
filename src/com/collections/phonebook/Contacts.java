package com.collections.phonebook;

public class Contacts {
	private String name;
	private long contactNumber;
	private String email;
	
	public Contacts(String name, long contactNumber, String email) {
		super();
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		
		    return "Name: " + name +", Number: " + contactNumber +", Email: " + email;
		

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	

}
