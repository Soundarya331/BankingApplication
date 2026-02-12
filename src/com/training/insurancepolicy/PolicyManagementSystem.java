package com.training.insurancepolicy;

import java.util.*;
import com.training.insurancepolicy.PolicyDetails.policyStatus;
import com.training.insurancepolicy.PolicyDetails.policyType;

/**
 * Implementation class for Insurance interface
 * Handles policy management operations using List and Map
 * Includes premium calculation logic
 */
public class PolicyManagementSystem implements Insurance {
    
    // Using both List and Map as required
    private List<PolicyDetails> policyList = new ArrayList<>();
    private Map<Integer, PolicyDetails> policyMap = new HashMap<>();
    
    /**
     * Calculate final premium based on base premium and policy type
     * 
     * Premium Increase Rules:
     * HEALTH  -> +20%
     * LIFE    -> +35%
     * VEHICLE -> +15%
     * TRAVEL  -> +10%
     */
    private double calculatePremium(double basePremium, policyType type) {
        double increasePercentage = 0;
        
        switch (type) {
            case HEALTH:
                increasePercentage = 0.20; // +20%
                break;
            case LIFE:
                increasePercentage = 0.35; // +35%
                break;
            case VEHICLE:
                increasePercentage = 0.15; // +15%
                break;
            case TRAVEL:
                increasePercentage = 0.10; // +10%
                break;
        }
        
        return basePremium + (basePremium * increasePercentage);
    }
    
    @Override
    public void addPolicy(PolicyDetails policy) {
        if (checkDuplicatePolicyNumber(policy.getPolicyNumber())) {
            System.out.println("Error: Policy number " + policy.getPolicyNumber() + " already exists!");
            return;
        }
        
        // Calculate final premium before adding
        double basePremium = policy.getPremium();
        double finalPremium = calculatePremium(basePremium, policy.getPolicyType());
        policy.setPremium(finalPremium);
        
        policyList.add(policy);
        policyMap.put(policy.getPolicyNumber(), policy);
        System.out.println("Policy added successfully!");
        System.out.println("Base Premium: " + basePremium);
        System.out.println("Final Premium: " + finalPremium);
    }
    
    @Override
    public void updatePremium(Integer policyNumber, double newBasePremium) {
        PolicyDetails policy = policyMap.get(policyNumber);
        if (policy == null) {
            System.out.println("Policy not found!");
            return;
        }
        
        // Recalculate premium with new base amount
        double newFinalPremium = calculatePremium(newBasePremium, policy.getPolicyType());
        policy.setPremium(newFinalPremium);
        
        System.out.println("Premium updated successfully!");
        System.out.println("New base premium: " + newBasePremium);
        System.out.println("New final premium: " + newFinalPremium);
    }
    
    @Override
    public PolicyDetails searchPolicy(Integer policyNumber) {
        // Using Map for O(1) lookup
        PolicyDetails policy = policyMap.get(policyNumber);
        if (policy != null) {
            System.out.println("\nPolicy Found:");
            System.out.println(policy);
        } else {
            System.out.println("Policy not found!");
        }
        return policy;
    }
    
    @Override
    public void fetchActivePolicies() {
        System.out.println("\n=== ACTIVE POLICIES ===");
        boolean found = false;
        for (PolicyDetails policy : policyList) {
            if (policy.getPolicyStatus() == policyStatus.ACTIVE) {
                System.out.println(policy);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No active policies found.");
        }
    }
    
    @Override
    public void removeExpiredPolicies() {
        System.out.println("\n=== REMOVING EXPIRED POLICIES ===");
        int removedCount = 0;
        
        // Use iterator to safely remove while iterating
        Iterator<PolicyDetails> iterator = policyList.iterator();
        while (iterator.hasNext()) {
            PolicyDetails policy = iterator.next();
            if (policy.getPolicyStatus() == policyStatus.EXPIRED) {
                iterator.remove();
                policyMap.remove(policy.getPolicyNumber());
                System.out.println("Removed: " + policy);
                removedCount++;
            }
        }
        
        System.out.println("Total expired policies removed: " + removedCount);
    }
    
    @Override
    public boolean checkDuplicatePolicyNumber(Integer policyNumber) {
        return policyMap.containsKey(policyNumber);
    }
    
    @Override
    public void groupPoliciesByType() {
        System.out.println("\n=== POLICIES GROUPED BY TYPE ===");
        Map<policyType, Integer> policyCount = new HashMap<>();
        
        // Initialize counts
        for (policyType type : policyType.values()) {
            policyCount.put(type, 0);
        }
        
        // Count policies by type
        for (PolicyDetails policy : policyList) {
            policyType type = policy.getPolicyType();
            policyCount.put(type, policyCount.get(type) + 1);
        }
        
        // Display results
        for (Map.Entry<policyType, Integer> entry : policyCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " policies");
        }
    }
    
    @Override
    public PolicyDetails findHighestPremiumPolicy() {
        if (policyList.isEmpty()) {
            System.out.println("No policies in the system.");
            return null;
        }
        
        PolicyDetails highest = policyList.get(0);
        for (PolicyDetails policy : policyList) {
            if (policy.getPremium() > highest.getPremium()) {
                highest = policy;
            }
        }
        
        System.out.println("\n=== HIGHEST PREMIUM POLICY ===");
        System.out.println(highest);
        return highest;
    }
}