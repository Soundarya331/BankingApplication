package com.training.java8;

import java.util.function.DoubleFunction;

public class SalarySystem {

	
	public static void main(String[] args) {
		Employee emp = new Employee("123", "Name", 500);
		double salary = emp.getSalary();
		
		
		DoubleFunction <Double> doubleFun = (sal)->sal + (sal*0.15);
		
		
		emp.setSalary(doubleFun.apply(salary));
		System.out.println(emp.getSalary());
	}
	
	
}
