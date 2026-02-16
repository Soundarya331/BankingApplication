package com.traing.multithread;

public class BankAccount {
	

	double balance;
	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}
	
	synchronized void withDraw(double withdrawalAmount) {
		for (int i = 0; i < 2; i++) {
			if(withdrawalAmount<balance) {
			balance =  balance - withdrawalAmount;
			System.out.println(Thread.currentThread().getName() + "    withdrawalAmount   " +   withdrawalAmount);
			System.out.println(Thread.currentThread().getName() + "    balance             " + balance);
			}
			else {
				System.out.println("Insufficent balanace");
			}
		}
	}
	

}
