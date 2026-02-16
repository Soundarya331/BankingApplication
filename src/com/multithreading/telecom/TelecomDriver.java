package com.multithreading.telecom;

import java.util.Scanner;

public class TelecomDriver {
	
public static void main(String[] args) {
//		Producer Threads
//		================
//		    Create multiple producer threads:
//		They:
//		    Randomly generate call requests
//		    Add to CallQueue
//		    Sleep randomly (simulate network delay)
//		    

	System.out.println("Enter the customer details : ");
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the customer Id : ");
	int  customerId = scanner.nextInt();
	scanner.next();
	System.out.println("Enter the customer name : ");
	String  customerName = scanner.nextLine();
	System.out.println("Enter customer Phone number ");
	long phoneNumber = scanner.nextLong();
	System.out.println("Enter customer Phone balance ");
	double balance = scanner.nextDouble();
	
	Customer customer = new Customer(customerId, customerName, phoneNumber, balance);
	
	
	
	
	Thread producer = new Thread (()-> {
		
		
	}
		);
	}

	


}
