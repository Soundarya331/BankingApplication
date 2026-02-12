package com.training.insurancepolicy;

import java.util.Map;

public interface Insurance {
    void addPolicy(PolicyDetails policy);
    void updatePremium(Integer policyNumber, double newBasePremium);
    PolicyDetails searchPolicy(Integer policyNumber);
    void fetchActivePolicies();
    void removeExpiredPolicies();
    boolean checkDuplicatePolicyNumber(Integer policyNumber);
    void groupPoliciesByType();
    PolicyDetails findHighestPremiumPolicy();
}