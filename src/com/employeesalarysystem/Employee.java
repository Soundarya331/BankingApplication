package com.employeesalarysystem;

	public interface Employee {

	    double calculateSalary()throws InvalidSalaryException;
	    double calculateTax(double salary);

	    void displayEmployeeDetails();
	}


