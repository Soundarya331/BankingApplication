package com.bankaccount;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		Customer customer = new Customer();
		
		System.out.println("Enter customer details");
		
		System.out.println("Enter the customer name : ");
		customer.setCustName(sc.next());
		
		System.out.println("Enter the customer Id : ");
		customer.setCustId(sc.next());
		
		System.out.println("Enter the customer email : ");
		customer.setEmail(sc.next());
		
		
		System.out.println("Enter the account number :  ");
		
		
		
		String accountNumber = sc.next();
		
		Account account = new SavingAccount();
		account.setAccountDetails(accountNumber, customer);
		double depositAmount;
		double withdrawalAmount;
		
		System.out.println("Enter the deposit amount : " );
		depositAmount = sc.nextDouble();
		account.deposit(accountNumber, customer, depositAmount);
		
		while(true) {
			
		
		System.out.println("Do you want to perform 1. Depost 2. Withdraw 3. Exit");
		int input = sc.nextInt();
		
		if(input==3) {
			System.out.println("Good Bye!");
			break;
		}
		
		if(input==1) {
			
			System.out.println("Enter the deposit amount : " );
			depositAmount = sc.nextDouble();
			account.deposit(accountNumber, customer, depositAmount);
			
		}
		if(input==2) {
			
			System.out.println("Enter the withdrawal amount : " );
			withdrawalAmount = sc.nextDouble();
			try {
				account.withdraw(accountNumber, customer, withdrawalAmount);
			} catch (InsufficentBalanceException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
		}
		}
		
	}

}
