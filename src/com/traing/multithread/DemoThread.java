package com.traing.multithread;

public class DemoThread {
	
	public static void main(String[] args) {
		//2 multiple
		Runnable  t1 = () -> 
		{ 
			for (int i = 1; i <=10; i++) {
				System.out.println("2 multiple " + Thread.currentThread().getName() + "---"+i *2);
				}
		};
		Runnable  t2 = () -> 
		{ 
			for (int i = 1; i <=10; i++) {
				System.out.println("5 multiple " + Thread.currentThread().getName() + "---"+i *5);
				}
		};
		Runnable  t3 = () -> 
		{ 
			for (int i = 1; i <=10; i++) {
				System.out.println("10 multiple " + Thread.currentThread().getName() + "---"+i *10);
				}
		};
		
		
		Thread thread1 = new Thread(t1, "2 multiple ");
		Thread thread2 = new Thread(t2 , "5 multiple");
		Thread thread3 = new Thread(t3 , "10 multiple");
		thread1.start();
		try {
			thread1.join();
			
			thread3.start();
			thread3.join();
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
	
		
		
		}
	
	//NumberThread thread1 =  new NumberThread();
		

}
