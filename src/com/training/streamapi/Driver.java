package com.training.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		
		
		List<Employee> employee = Arrays.asList(new Employee("101", "Soundarya", 100,25), new Employee("102", "Vishya", 10000,30),new Employee("103", "Sahana", 2200,40));
		
		System.out.println("Employee's with salary more then 5000");
		employee.stream().filter(e->e.getSalary()>5000).forEach(System.out::println);
		
		System.out.println("Sorting by age :");
		employee.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
		System.out.println("Salary increment : ");
		employee.stream().map((e)->e.getSalary()*0.10).forEach(System.out::println);
		
	}

}
