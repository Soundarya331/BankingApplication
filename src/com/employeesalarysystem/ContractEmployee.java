package com.employeesalarysystem;

public class ContractEmployee implements Employee {

    private String id;
    private String name;
    private String department;
    private int hoursWorked;
    private double hourlyRate;

    public ContractEmployee(String id, String name, String department,
                            int hoursWorked, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() throws InvalidSalaryException {
        if (hoursWorked <= 0) {
            throw new InvalidSalaryException(
                "Invalid Hours Worked for Contract Employee: " + name);
        }
        if (hourlyRate <= 0) {
            throw new InvalidSalaryException(
                "Invalid Hourly Rate for Contract Employee: " + name);
        }
        return hoursWorked * hourlyRate;
    }

    @Override
    public double calculateTax(double salary) {
        return salary * 0.10;
    }

    @Override
    public void displayEmployeeDetails() {
        try {
            double salary = calculateSalary();
            double tax = calculateTax(salary);
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Type: Contract");
            System.out.println("Salary: " + salary);
            System.out.println("Tax: " + tax);
            System.out.println("Net Salary: " + (salary - tax));

        } catch (InvalidSalaryException e) {
            System.out.println( e.getMessage());
        }
    }
}
