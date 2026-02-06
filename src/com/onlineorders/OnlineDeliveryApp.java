package com.onlineorders;

import java.util.Scanner;

public class OnlineDeliveryApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int input;
		while(true) {
		System.out.println("Select the ordering platform : 1.Restaurants 2.CloudKitchen 3.Grocery Shop 4.Exit");
		input = sc.nextInt();
		
		if(input==1) {
			System.out.println("Enter the Customer name : ");
			String customerName = sc.next();
			System.out.println("Enter the order amount : ");
			double amount = sc.nextDouble();
			Orders order = new Restaurant(customerName, amount);
			order.getOrderDetails();
		}
		if(input==2) {
			System.out.println("Enter the Customer name : ");
			String customerName = sc.next();
			System.out.println("Enter the order amount : ");
			double amount = sc.nextDouble();
			System.out.println("Enter the delivery distance : ");
			double distance = sc.nextDouble();
			Orders order = new CloudKitchen(customerName, amount,distance);
			order.getOrderDetails();
		}
		if(input==3) {
			System.out.println("Enter the Customer name : ");
			String customerName = sc.next();
			System.out.println("Enter the order amount : ");
			double amount = sc.nextDouble();
			System.out.println("Confirm the member ship : true /false");
			boolean isMemberHolder = sc.nextBoolean();
			Orders order = new GroceryStore(customerName, amount,isMemberHolder);
			order.getOrderDetails();
		}
		if(input==4) {
			System.out.println("Thank you for shopping !!!");
			break;
		}
		
		}
		sc.close();
		


		
	}
	}
