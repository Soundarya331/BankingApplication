package com.training.insurancepolicy;

/**
 * POJO class representing Insurance Policy Details
 * Contains only data fields, getters, setters, and toString
 * No business logic
 */
public class PolicyDetails {
    private Integer policyNumber;
    private String customerName;
    private int age;
    private double premium;
    private policyType policyType;
    private policyStatus policyStatus;

    public enum policyType {
        HEALTH, LIFE, VEHICLE, TRAVEL
    }

    public enum policyStatus {
        ACTIVE, EXPIRED
    }

    // Constructor
    public PolicyDetails(Integer policyNumber, String customerName, int age, 
                        double premium, policyType policyType, policyStatus policyStatus) {
        this.policyNumber = policyNumber;
        this.customerName = customerName;
        this.age = age;
        this.premium = premium;
        this.policyType = policyType;
        this.policyStatus = policyStatus;
    }

    // Getters and Setters
    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public policyType getPolicyType() {
        return policyType;
    }

    public void setPolicyType(policyType policyType) {
        this.policyType = policyType;
    }

    public policyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(policyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    @Override
    public String toString() {
        return String.format("Policy #%d | Customer: %s | Age: %d | Type: %s | Status: %s | Premium: %.2f",
                policyNumber, customerName, age, policyType, policyStatus, premium);
    }
}