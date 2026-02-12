package com.training.insurancepolicy;

import java.util.Scanner;
import com.training.insurancepolicy.PolicyDetails.policyStatus;
import com.training.insurancepolicy.PolicyDetails.policyType;

public class DriverClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Insurance insurance = new PolicyManagementSystem();
        
        while (true) {
            displayMenu();
            
            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }
            
            switch (choice) {
                case 1:
                    addNewPolicy(scanner, insurance);
                    break;
                case 2:
                    insurance.fetchActivePolicies();
                    break;
                case 3:
                    searchPolicy(scanner, insurance);
                    break;
                case 4:
                    updatePremium(scanner, insurance);
                    break;
                case 5:
                    insurance.groupPoliciesByType();
                    break;
                case 6:
                    insurance.findHighestPremiumPolicy();
                    break;
                case 7:
                    insurance.removeExpiredPolicies();
                    break;
                case 8:
                    System.out.println("Thank you for using Policy Management System. Goodbye!");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Please select 1-8.");
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n" + "=======================================");
        System.out.println("    INSURANCE POLICY MANAGEMENT SYSTEM");
        System.out.println("==================================");
        System.out.println("1. Add New Policy");
        System.out.println("2. Display All Active Policies");
        System.out.println("3. Search Policy");
        System.out.println("4. Update Policy Premium");
        System.out.println("5. Group Policies by Type");
        System.out.println("6. Find Highest Premium Policy");
        System.out.println("7. Remove Expired Policies");
        System.out.println("8. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }
    
    private static void addNewPolicy(Scanner scanner, Insurance insurance) {
        try {
            Integer policyNumber = getValidPolicyNumber(scanner);
            
 
            String customerName = getValidCustomerName(scanner);
            
      
            int customerAge = getValidAge(scanner);
            
            policyStatus status = getValidPolicyStatus(scanner);
            
         
            policyType type = getValidPolicyType(scanner);
            
            double basePremium = getValidPremium(scanner);
            
        
            PolicyDetails policy = new PolicyDetails(policyNumber, customerName, customerAge, basePremium, type, status);
            insurance.addPolicy(policy);
            
        } catch (Exception e) {
            System.out.println("Error adding policy: " + e.getMessage());
        }
    }
    
    private static Integer getValidPolicyNumber(Scanner scanner) throws InvalidPolicyTypeException {
        while (true) {
            try {
                System.out.print("Enter Policy Number (numeric only): ");
                String input = scanner.nextLine().trim();
                
                if (!input.matches("\\d+")) {
                    throw new InvalidPolicyTypeException("Policy number must contain only digits!");
                }
                
                return Integer.parseInt(input);
            } catch (InvalidPolicyTypeException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format!");
            }
        }
    }
    
    private static String getValidCustomerName(Scanner scanner) throws InvalidPolicyTypeException {
        while (true) {
            try {
                System.out.print("Enter Customer Name: ");
                String name = scanner.nextLine().trim();
                
                if (!name.matches("[a-zA-Z ]+")) {
                    throw new InvalidPolicyTypeException("Name should contain only alphabets and spaces!");
                }
                
                if (name.isEmpty()) {
                    throw new InvalidPolicyTypeException("Name cannot be empty!");
                }
                
                return name;
            } catch (InvalidPolicyTypeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private static int getValidAge(Scanner scanner) throws InvalidPolicyTypeException {
        while (true) {
            try {
                System.out.print("Enter Customer Age: ");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                
                if (age <= 0) {
                    throw new InvalidPolicyTypeException("Age must be greater than 0!");
                }
                
                if (age > 150) {
                    throw new InvalidPolicyTypeException("Age must be realistic (under 150)!");
                }
                
                return age;
            } catch (InvalidPolicyTypeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    private static policyStatus getValidPolicyStatus(Scanner scanner) throws InvalidPolicyTypeException {
        while (true) {
            try {
                System.out.print("Enter Policy Status (ACTIVE/EXPIRED): ");
                String statusInput = scanner.nextLine().trim().toUpperCase();
                
                if (!statusInput.equals("ACTIVE") && !statusInput.equals("EXPIRED")) {
                    throw new InvalidPolicyTypeException("Status must be ACTIVE or EXPIRED!");
                }
                
                return policyStatus.valueOf(statusInput);
            } catch (InvalidPolicyTypeException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status! Must be ACTIVE or EXPIRED.");
            }
        }
    }
    
    private static policyType getValidPolicyType(Scanner scanner) throws InvalidPolicyTypeException {
        while (true) {
            try {
                System.out.print("Enter Policy Type (HEALTH/LIFE/VEHICLE/TRAVEL): ");
                String typeInput = scanner.nextLine().trim().toUpperCase();
                
                // Check if input matches any valid policy type
                boolean validType = false;
                for (policyType pt : policyType.values()) {
                    if (pt.name().equals(typeInput)) {
                        validType = true;
                        break;
                    }
                }
                
                if (!validType) {
                    throw new InvalidPolicyTypeException("Invalid policy type! Must be HEALTH, LIFE, VEHICLE, or TRAVEL.");
                }
                
                return policyType.valueOf(typeInput);
            } catch (InvalidPolicyTypeException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid policy type!");
            }
        }
    }
    
    private static double getValidPremium(Scanner scanner) throws InvalidPolicyTypeException {
        while (true) {
            try {
                System.out.print("Enter Base Premium Amount: ");
                double premium = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                
                if (premium <= 0) {
                    throw new InvalidPolicyTypeException("Premium must be greater than 0!");
                }
                
                return premium;
            } catch (InvalidPolicyTypeException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
    
    private static void searchPolicy(Scanner scanner, Insurance insurance) {
        try {
            System.out.print("Enter Policy Number to search: ");
            Integer policyNumber = scanner.nextInt();
            scanner.nextLine();
            insurance.searchPolicy(policyNumber);
        } catch (Exception e) {
            System.out.println("Invalid input!");
            scanner.nextLine();
        }
    }
    
    private static void updatePremium(Scanner scanner, Insurance insurance) {
        try {
            System.out.print("Enter Policy Number: ");
            Integer policyNumber = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter New Base Premium: ");
            double newPremium = scanner.nextDouble();
            scanner.nextLine();
            
            if (newPremium <= 0) {
                System.out.println("Premium must be greater than 0!");
                return;
            }
            
            insurance.updatePremium(policyNumber, newPremium);
        } catch (Exception e) {
            System.out.println("Invalid input!");
            scanner.nextLine();
        }
    }
}