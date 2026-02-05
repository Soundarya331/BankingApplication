package com.HealthPolicy;

public class LifeInsurancePolicy implements InsurancePolicy {
  
	
	private String holderName;
	private double sumAssured;
	private int policyTerms;
	public LifeInsurancePolicy(String holderName, double sumAssured, int policyTerms) {
		super();
		this.holderName = holderName;
		this.sumAssured = sumAssured;
		this.policyTerms = policyTerms;
	}
	@Override
	public double calculatePremium() {
	    double perYearCoverage = sumAssured / policyTerms;
        return perYearCoverage * 0.05;
	}
	@Override
	public void displayPolicyDetails() {
	
		
		System.out.println("Life Insurance policy");
		   System.out.println("Policy Holder : " + holderName);
	        System.out.println("Sum Assured  : " + sumAssured);
	        System.out.println("Policy Terms : " + policyTerms);
	        System.out.println("Annual Premium : " + calculatePremium());
		
	}
	
}
