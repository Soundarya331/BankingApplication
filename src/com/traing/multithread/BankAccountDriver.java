package com.traing.multithread;

public class BankAccountDriver {
	public static void main(String[] args) {
		
		BankAccount account = new BankAccount(2000);
		
		Runnable user1 = ()->account.withDraw(200);
		
		Runnable user2 = ()->account.withDraw(200);
		
		Thread t1 = new Thread(user1,"thread 1");
		Thread t2 = new Thread(user2,"thread 2");
		
		t1.start();
		t2.start();
		
	}
	
	

}
