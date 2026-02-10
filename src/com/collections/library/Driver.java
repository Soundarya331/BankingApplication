package com.collections.library;

import java.util.Scanner;

public class Driver {
	

    Scanner scanner = new Scanner(System.in);
	  public static Member inputData(){
		  Member member = null;
		  Scanner scanner = new Scanner(System.in); 
     	 System.out.println("Enter the member details");

          System.out.print("Enter the member name : ");
          String name = scanner.nextLine();

          System.out.print("Enter the member's contact number : ");
          long contactNumber = scanner.nextLong();
          scanner.nextLine(); 

          System.out.print("Enter the member email : ");
          String email = scanner.nextLine();

          return member = new Member(name, contactNumber, email);
     }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        Library lib = new Library();

        
     
      
      
        while (true) {
        	System.out.println("\nChoose the operation:");
        	 System.out.println("1. Add Member ");
             System.out.println("2. Display Members ");
             System.out.println("3. Exit");
             int input = scanner.nextInt();
            if(input==1)
            { 
            	lib.addMember(inputData());
            	
            	
            }
            if(input==2)
            {
                lib.displayMembers();
                
            }
            if(input==3) {
                System.out.println("Thank you !!!");
                
                break;
            }
        }

       
    }
    
}
