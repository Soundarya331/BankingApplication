package com.insurancepolicy;

import java.util.Scanner;

public class InsuranceApp  {
	
	public static void main(String[] args) {
		int input;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Choose the Policy type 1.Health Insurance 2.Life Insurence "
					+ "3.Vehicle Insurance 4.Exit");
			input = sc.nextInt();
			
			if(input==2) {
				
				System.out.println("Enter the holderName : ");
				String holderName = sc.nextLine();
				sc.next();
				System.out.println("Enter the sumAssured : ");
				double sumAssured = sc.nextDouble();
				System.out.println("Enter the policyTerms : ");
				int policyTerms = sc.nextInt();
				InsurancePolicy insurancePolicy = new LifeInsurancePolicy(holderName, sumAssured, policyTerms);
				insurancePolicy.displayPolicyDetails();
							
			}
			if(input==1) {
				System.out.println("Enter the holderName : ");
				String holderName = sc.nextLine();
				sc.next();
				System.out.println("Enter the sumAssured : ");
				double sumAssured = sc.nextDouble();
				System.out.println("Enter the Age : ");
				int age = sc.nextInt();
				InsurancePolicy insurancePolicy = new HealthInsurancePolicy(holderName, age , sumAssured);
				insurancePolicy.displayPolicyDetails();
			}
			if(input==3) {
				System.out.println("Enter the holderName : ");
				String holderName = sc.next();

				System.out.println("Enter the vehicleType : ");
				String vehicleType = sc.next();

				System.out.println("Enter the vehicleValue : ");
				double vehicleValue = sc.nextDouble();

				InsurancePolicy insurancePolicy = new VehicleInsurancePolicy(holderName, vehicleType,vehicleValue );
				insurancePolicy.displayPolicyDetails();
			}
			if(input==4) {
				System.out.println("Thank you for choosing us!!!");
				break;
			}
				
		}
		sc.close();
		
		
	}

}
