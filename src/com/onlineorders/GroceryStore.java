package com.onlineorders;

public class GroceryStore implements Orders {
//	======
//			Inputs
//			    Customer Name
//			    Order Amount
//			    Is Membership Holder (true / false)
//
//			Pricing Rules
//			    If customer is a member:
//			    Apply 10% discount
//			    Otherwise:
//			        No discount
//			        Final Amount = Order Amount – Discount
	
	
	private String name;
	private double amount;
	private boolean isMemberHolder;
	double finalAmount;
	double gstPercentage = 0.05;
	public GroceryStore(String name, double amount, boolean isMemberHolder) {
		super();
		this.name = name;
		this.amount = amount;
		this.isMemberHolder = isMemberHolder;
	}
	@Override
	public double calculateFinalAmount() {
	    if (isMemberHolder) {

	        double discount = amount * 0.10;   
	        double discountedAmount = amount - discount;
	        double gstApplied = discountedAmount * gstPercentage;

	        return finalAmount = discountedAmount + gstApplied;
	    }

	    return finalAmount = amount + (amount * gstPercentage);
	}

	@Override
	public void getOrderDetails() {
		System.out.println("Grocery shop's order details : ");
		System.out.println("Customer's name : " + name);
		System.out.println("Final bill amount : " + calculateFinalAmount());
		
	}
	

}
