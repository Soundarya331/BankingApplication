package com.HealthPolicy;

public class HealthInsurancePolicy implements InsurancePolicy {
	
	private String name ;
	private  int age;
  	private  double sumAssured;
  	 double basePremium = 500;


	@Override
	public double calculatePremium() {
		double results = 0.0;
		if(age>45) {
			
		basePremium = basePremium + (basePremium * 0.02);	
		results = basePremium + (sumAssured/(80-age));
		}
		else {
			results = basePremium + (sumAssured/(80-age));
		}
		return results;
	}

	@Override
	public void displayPolicyDetails() {
		  System.out.println("Health Insurance Policy");
	        System.out.println("Policy Holder : " + name);
	        System.out.println("Age  : " + age);
	        System.out.println("Annual Premium: " + calculatePremium());
		
	}

	public HealthInsurancePolicy(String name, int age, double sumAssured) {
	
		this.name = name;
		this.age = age;
		this.sumAssured = sumAssured;
	}
}
