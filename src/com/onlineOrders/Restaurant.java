package com.onlineOrders;

public class Restaurant implements Orders {
	
	private String customerName;
	private double orderAmount;
	private double gstPercentage = 0.05;
	double finalAmount = 0;
	
	public Restaurant(String customerName, double orderAmount) {
		super();
		this.customerName = customerName;
		this.orderAmount = orderAmount;
	}

	@Override
	public double calculateFinalAmount() {
		return finalAmount = orderAmount + (orderAmount * gstPercentage);
	}

	@Override
	public void getOrderDetails() {
		System.out.println(" Restaurant order details : ");
		System.out.println("Customer name :  " + customerName);
		System.out.println("Total amount to be paid :" + calculateFinalAmount());
		
	}
	
    
//Pricing Rules
//    GST is applied on the order amount
//    Final Amount = Order Amount + GST
	
	

}
