package com.training.producerconsumer;

public class Driver {
	
	public static void main(String[] args) {
		
		SharedResource obj = new SharedResource();
		
		Thread t1 = new Thread(()->{
					
					obj.producer(40);
					},"producer"
				);
		
		Thread t2 = new Thread(()->{
			obj.consumer();
			},"consumer"
		);
		
		t1.start();
	
		t2.start();
	}

}
