package com.insurancepolicy;

public class VehicleInsurancePolicy implements InsurancePolicy {

	
	private String holderName ;
	private String vehicleType;
	private double vehicleValue;
	
	

	public VehicleInsurancePolicy(String holderName, String vehicleType, double vehicleValue) {
		super();
		this.holderName = holderName;
		this.vehicleType = vehicleType;
		this.vehicleValue = vehicleValue;
	}

	@Override
	public double calculatePremium() {
		double result= 0 ;
		if(vehicleType.equalsIgnoreCase("TwoWheeler")) {
			return result = vehicleValue * 0.02;
			
		}
		else if (vehicleType.equalsIgnoreCase("FourWheeler")) {
			return result =  vehicleValue * 0.04;
            
        }
		return result;
	}

	@Override
	public void displayPolicyDetails() {
		// TODO Auto-generated method stub
		 System.out.println("Vehicle Insurance Policy");
	        System.out.println("Policy Holder : " + holderName);
	        System.out.println("Vehicle Type  : " + vehicleType);
	        System.out.println("Vehicle Value : " + vehicleValue);
	        System.out.println("Annual Premium : " + calculatePremium());
		
	}

}
