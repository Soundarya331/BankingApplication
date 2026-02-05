package com.onlineShopping;


import java.util.Scanner;

public class Shop {
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String name ;
		String address;
		
		System.out.println("Enter the Shop name: ");
		name = sc.nextLine();
		System.out.println("Enter the Shop address: ");
		address =sc.nextLine();
		System.out.println("Enter the number of products: ");
		
		int size = sc.nextInt();
		String products [] = new String [size];
		System.out.println("Add the products");
		for (int i = 0; i < size ; i++) {
			products[i] = sc.next();
		}
		System.out.println("Do you want to search for the product : Yes/No");
		String choose = sc.next();
		if(!choose.equals("Yes")) {
			System.out.print("Thanks for adding product");
		}
		if(choose.equalsIgnoreCase("Yes")) {
			System.out.println("Enter the product");
			String input = sc.next();
			for (int i = 0; i < products.length; i++) {
				if(products[i].equalsIgnoreCase(input) )
				{
					System.out.println("Product found");
					break;
				}
				System.out.println("Product not found");
				break;
	
		}
			
		
	}
	}
}
