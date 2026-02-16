package com.inventarymanagementsystem;

public class Customer {
	
	public Customer(int customerId, String name, int requiredStock) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.requiredStock = requiredStock;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	private int customerId;
	private String name;
	private int requiredStock;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRequiredStock() {
		return requiredStock;
	}
	public void setRequiredStock(int requiredStock) {
		this.requiredStock = requiredStock;
	}

}
