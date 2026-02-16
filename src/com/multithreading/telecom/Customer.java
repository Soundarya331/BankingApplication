package com.multithreading.telecom;

public class Customer {
	 public Customer(int customerId, String name, long phoneNumber, double balance) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}
	private  int customerId;
	private  String name;
	private long phoneNumber;
	private double balance;
	private double charges;
	 
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getCharges() {
		return charges;
	}
	public void setCharges(double charges) {
		this.charges = charges;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	void calculateCharges(int minutes) {
		
		
		 charges += minutes * 2;
		
		
	}
	
	 synchronized void makeCall(int minutes) {
	
		 
 }
	    synchronized void recharge(double amount) {
	    	
	    	balance = balance + amount;
	    	
	    }
	    double getBalance() {
	    	if(balance<0) {
	    		throw new InsufficientBalanceException(" Insufficient balance rechange the wallet ");
	    	}
			return balance;
	    	
	    }

}
