package com.onlineorders;

public class CloudKitchen implements Orders {
//	Cloud Kitchen Order
//	=================
//	Inputs
//	    Customer Name
//	    Order Amount
//	    Delivery Distance (in km)
//
//	Pricing Rules
//	========
//	Delivery charge:
//	    Up to 5 km → ₹30
//	    Above 5 km → ₹60
//	    Final Amount = Order Amount + Delivery Charge  
	
	
	private String customerName;
	private double amount;
	private double distance;
	double finalAmount;
	 double gstPercentage =0.05;
	
	public CloudKitchen(String customerName, double amount, double distance) {
		super();
		this.customerName = customerName;
		this.amount = amount;
		this.distance = distance;
	}
	@Override
	public double calculateFinalAmount() {
		if(distance<=5) {
			return finalAmount =  amount + 30 + (amount*gstPercentage);
		}
		else {
		return finalAmount =  amount + 60 + (amount*gstPercentage);
		}
	}
	@Override
	public void getOrderDetails() {
		// TODO Auto-generated method stub
		System.out.println("Cloud Kitchen order details : ");
		System.out.println("Customer name : "+ customerName);
		System.out.println("Total bill amount : "+ calculateFinalAmount());
	
	}
	


}
