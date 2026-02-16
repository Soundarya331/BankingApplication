package com.inventarymanagementsystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DriverClass {
	

	
	public static void main(String[] args) throws InterruptedException {
		
		Warehouse wareHouse = new Warehouse();
				
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		
		for (int i = 1; i<=5; i++) {
			 int customerId = i; 
			executor.submit(()->{
				int value = (int)(Math.random() * 6) + 1;
				Customer customer = new Customer(customerId,"customer" + customerId, value);
				wareHouse.inventory(customer.getRequiredStock());	
			},"Customer"+ customerId);
		}
		try {
		executor.awaitTermination(5,TimeUnit.SECONDS);}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}

}
