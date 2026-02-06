package com.bankaccount;

  abstract class Account {
	  
	  String accountNumber;
	  double accountBalance;
	  Customer customer;
	  
	  public void setAccountDetails(String accountNumber, Customer customer) {
	        this.accountNumber = accountNumber;
	        this.customer = customer;
	    }
	  
	  
	 public  abstract void deposit(String accountNumber, Customer cus, double accountBalance);
	 
	 public abstract void  withdraw(String accountNumber, Customer cus, double accountBalance) throws InsufficentBalanceException;
	 	  
	  
  }
