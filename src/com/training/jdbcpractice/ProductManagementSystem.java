package com.training.jdbcpractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductManagementSystem {

	Scanner scanner = new Scanner(System.in);
	Connection connection = new DBdriver().getConnection();
	public void deleteProduct() {
		String sql = "delete  from product p  using orders o  where p.prod_id != o.prod_id";
	
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			
			if(preStatement.executeUpdate()==1) {
			System.out.println("Product deleted sucessfully");
			}else {
				System.out.println("Cannot delete product with existing orders");
			}
			String query = "select * from product";
			PreparedStatement preStatement1 = connection.prepareStatement(query);
			ResultSet   result =  preStatement1.executeQuery();
			
			while (result.next()) {
				System.out.println(result.getInt("prod_id") + " " + result.getString("prod_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addProduct() {
		
		String sql ="call product_insertion(?,?,?,?);";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			
			while(true) {
				System.out.println("Enter the product details  ");	
				
				System.out.print("Enter the product name : ");
				String name = scanner.nextLine();
				ps.setString(1, name);
				System.out.print("Enter the product description : ");
				String prod_desc = scanner.nextLine();
		        ps.setString(2, prod_desc);
		        System.out.print("Enter the product category : ");
				String prod_category = scanner.nextLine();
		        ps.setString(3, prod_category);
		        System.out.print("Enter the price : ");
		        int price = scanner.nextInt();
		        ps.setInt(4, price);
		        scanner.nextLine(); 
		        ps.execute();
		        
		        System.out.print("Do you want add some more products y/n : ");
		        char input = scanner.next().charAt(0);
		        scanner.nextLine();
		        
		        if(input=='n') {
		        	break;
		        }
				
				
			
			}
			  
			
		    	String query = "select * from product";
		    	PreparedStatement preStatement1 = connection.prepareStatement(query);
				ResultSet   result =  preStatement1.executeQuery();
				
				while (result.next()) {
					System.out.println(result.getInt("prod_id") + " " + result.getString("prod_name")
					+ " "+result.getString("prod_desc")+ "    "+result.getInt("price"));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
