package com.productreport;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.training.jdbcpractice.DBdriver;

public class ReportService {

	Scanner scanner = new Scanner(System.in);
	Connection connection =DBdriver.getConnection();
	
	public void fetchData() {
		
		String sql =""" 
				select p.prod_id,p.prod_name,
				sum(p.price) as total_revenue ,
				count(p.prod_id) as prod_count
				from product p inner join
				orders o on p.prod_id = o.prod_id
				group by p.prod_id order by count(p.prod_id) desc limit (3) """;
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			
			ResultSet result = preStatement.executeQuery();
			while(result.next()) {
				
				String name = result.getString("prod_name") ;
				double total = result.getDouble("total_revenue");
				int count = result.getInt("prod_count");
				
				ProductReport p = new ProductReport(name, count, total);
				
				System.out.println(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void batchInsertion() {
		String sql ="call product_insertion(?,?,?,?);";
		
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			 connection.setAutoCommit(false); 
			
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
		        
		        ps.addBatch();
		        
		        System.out.print("Do you want add some more products y/n : ");
		        char input = scanner.next().charAt(0);
		        scanner.nextLine();
		        
		        if(input=='n') {
		        	break;
		        }
		        
		        
			}	
			ps.executeBatch();
			
			connection.commit();
		    	String query = "select * from product";
		    	PreparedStatement preStatement1 = connection.prepareStatement(query);
				ResultSet   result =  preStatement1.executeQuery();
				
				while (result.next()) {
					System.out.println(result.getInt("prod_id") + " " + result.getString("prod_name")
					+ " "+result.getString("prod_desc")+ "    "+result.getInt("price"));
				}
			
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InputMismatchException e) {
			System.out.println("Input Mismatch Error:::::");
			e.printStackTrace();
		}
				
				
			
			
	}
	
	public void searchByFilter() {

	    String sql = "select o.*, p.price from orders o " +
	                 "product p o.prod_id = p.prod_id " +
	                 "where 1=1 ";

	    System.out.println("Enter orderType (or press Enter to skip): ");
	    String orderType = scanner.nextLine();

	    System.out.println("Enter startDate (yyyy-mm-dd) or press Enter to skip: ");
	    String startDate = scanner.nextLine();

	    System.out.println("Enter endDate (yyyy-mm-dd) or press Enter to skip: ");
	    String endDate = scanner.nextLine();

	    System.out.println("Enter price (or press Enter to skip): ");
	    String price = scanner.nextLine();

	    try {

	        if (!orderType.isEmpty()) {
	            sql += " AND o.ord_type = ? ";
	        }

	        if (!startDate.isEmpty() && !endDate.isEmpty()) {
	            sql += " AND o.ord_date BETWEEN ? AND ? ";
	        } else if (!startDate.isEmpty()) {
	            sql += " AND o.ord_date >= ? ";
	        } else if (!endDate.isEmpty()) {
	            sql += " AND o.ord_date <= ? ";
	        }

	        if (!price.isEmpty()) {
	            sql += " AND p.price = ? ";
	        }

	        PreparedStatement ps = connection.prepareStatement(sql);

	        int index = 1;

	        if (!orderType.isEmpty()) {
	            ps.setString(index++, orderType);
	        }

	        if (!startDate.isEmpty() && !endDate.isEmpty()) {
	            ps.setDate(index++, Date.valueOf(startDate));
	            ps.setDate(index++, Date.valueOf(endDate));
	        } else if (!startDate.isEmpty()) {
	            ps.setDate(index++, Date.valueOf(startDate));
	        } else if (!endDate.isEmpty()) {
	            ps.setDate(index++, Date.valueOf(endDate));
	        }

	        if (!price.isEmpty()) {
	            ps.setDouble(index++, Double.parseDouble(price));
	        }

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            System.out.println(
	                rs.getString("ord_type") + " | " +
	                rs.getDate("ord_date") + " | " +
	                rs.getDouble("price")
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
