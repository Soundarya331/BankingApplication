package com.inventarymanagementsystem;

public class Warehouse {
	
	  int initialStock = 10;
	
	
	public synchronized  void inventory(int requiredStock) {
		if(initialStock>=requiredStock) {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		initialStock = initialStock -requiredStock;	
		System.out.println(Thread.currentThread().getName()+ " required stock " + requiredStock + " remaining stock " + initialStock);
		
		}
		else {
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			System.err.println(Thread.currentThread().getName() + " the required stock " +requiredStock + " is greater then remaining stock : " + initialStock);
		}
	}
		
}
