package com.training.streamapi;

public class Employee {
	
	public Employee(String empId, String name, double salary, int age) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
	private String empId;
	private String name;
	private double salary;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

	
}
