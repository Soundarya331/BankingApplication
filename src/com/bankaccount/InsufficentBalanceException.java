package com.bankaccount;

public class InsufficentBalanceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InsufficentBalanceException(String msg){
		super(msg);
	}

}
