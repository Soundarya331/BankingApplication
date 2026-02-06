package com.employeesalarysystem;

public class PermanentEmployee implements Employee {

    private String id;
    private String name;
    private String department;
    private double baseSalary;
    private double hra;

    public PermanentEmployee(String id, String name, String department,
                             double baseSalary, double hra) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        this.hra = hra;
    }

    @Override
    public double calculateSalary() throws InvalidSalaryException {
        if (baseSalary <= 0) {
            throw new InvalidSalaryException("Invalid Base Salary for Permanent Employee: " + name);
        }
        return baseSalary + hra;
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
            System.out.println("Type: Permanent");
            System.out.println("Salary: " + salary);
            System.out.println("Tax: " + tax);
            System.out.println("Net Salary: " + (salary - tax));

        } catch (InvalidSalaryException e) {
            System.out.println( e.getMessage());
        }
    }
}
