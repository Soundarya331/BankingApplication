package com.training.jdbcpractice;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		DBdriver db = new DBdriver();
		
		

		ProductManagementSystem p = new ProductManagementSystem();
//		p.deleteProduct();
		p.addProduct();
		
		
		
	}

}
