package com.employeesalarysystem;

import java.util.Scanner;

public class SalarySystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of employees:");
        int n = scanner.nextInt();
        scanner.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter details for Employee " + (i + 1));

            System.out.println("Enter Employee ID:");
            String id = scanner.nextLine();

            System.out.println("Enter Employee Name:");
            String name = scanner.nextLine();

            System.out.println("Enter Department:");
            String department = scanner.nextLine();

            boolean isValidType = false;

            while (!isValidType) {

                System.out.println("Enter Employee Type (Permanent / Contract):");
                String type = scanner.nextLine();

                try {
                    if (type.equalsIgnoreCase("Permanent")) {

                        double salary;
                        double hra;

                        while (true) {
                            try {
                                System.out.println("Enter Base Salary:");
                                salary = scanner.nextDouble();

                                if (salary <= 0) {
                                    throw new InvalidSalaryException(
                                            "Base Salary must be greater than 0");
                                }
                                break;
                            } catch (InvalidSalaryException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Invalid input. Enter numeric value.");
                                scanner.next();
                            }
                        }

                        while (true) {
                            try {
                                System.out.println("Enter HRA:");
                                hra = scanner.nextDouble();

                                if (hra < 0) {
                                    throw new InvalidSalaryException(
                                            "HRA cannot be negative");
                                }
                                break;
                            } catch (InvalidSalaryException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Invalid input. Enter numeric value.");
                                scanner.next();
                            }
                        }

                        scanner.nextLine(); 
                        employees[i] = new PermanentEmployee(id, name, department, salary, hra);
                        isValidType = true;
                    }

                    else if (type.equalsIgnoreCase("Contract")) {

                        int hoursWorked;
                        double hourlyRate;
                        while (true) {
                            try {
                                System.out.println("Enter Hours Worked:");
                                hoursWorked = scanner.nextInt();

                                if (hoursWorked <= 0) {
                                    throw new InvalidSalaryException(
                                            "Hours Worked must be greater than 0");
                                }
                                break;
                            } catch (InvalidSalaryException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Invalid input. Enter numeric value.");
                                scanner.next();
                            }
                        }

                      
                        while (true) {
                            try {
                                System.out.println("Enter Hourly Rate:");
                                hourlyRate = scanner.nextDouble();

                                if (hourlyRate <= 0) {
                                    throw new InvalidSalaryException(
                                            "Hourly Rate must be greater than 0");
                                }
                                break;
                            } catch (InvalidSalaryException e) {
                                System.out.println(e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Invalid input. Enter numeric value.");
                                scanner.next();
                            }
                        }

                        scanner.nextLine();
                        employees[i] = new ContractEmployee(id, name, department,
                                hoursWorked, hourlyRate);
                        isValidType = true;
                    }

                    else {
                        System.out.println("Invalid Employee Type. Please re-enter.");
                    }

                } catch (Exception e) {
                    System.out.println("Unexpected error occurred. Try again.");
                }
            }
        }

        System.out.println("\n--- Employee Details ---");
       for (int j = 0; j < employees.length; j++) {
		employees[j].displayEmployeeDetails();
	}

        scanner.close();
    }
}
