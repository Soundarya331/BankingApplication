package com.training.producerconsumer;

public class SharedResource {
	
	int data;
	boolean available = false;
	
	

	public synchronized void producer(int data) {
		while(available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.data = data;
			System.out.println("Produced data : " + data);
			available = true;
		}
	
		
		
		notify();
	}
	
	public synchronized void consumer() {
		
		while(!available) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
			System.out.println("Consumed data : " + data);
			available = false;
			notify();
		}
	}


