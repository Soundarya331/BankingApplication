package com.training.insurancepolicy;

import java.util.Map;

import com.training.insurancepolicy.PolicyDetails.policyType;

public class HealthInsurancePolicy implements Insurance{




	@Override
	public void updatePermium(Map<Integer, Double> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PolicyDetails searchPolicy(int policyNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fetchActivePolicies() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PolicyDetails removePolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkDuplicatePolicyNumber(String policyNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculatePermium(policyType type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addPolicy(PolicyDetails policy) {
		// TODO Auto-generated method stub
		
	}

}
