package com.streamapi.examples;

public class Employee {
	public Employee(int emp_id, String name, double salary, int age, String department) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.department = department;
	}
	public Employee(int emp_id, String name, double salary) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.salary = salary;
	}
	private int emp_id;
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + ", age=" + age + ", department="
				+ department + "]";
	}
	private String name;
	private double salary;
	private int age;
	private String department;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	

}
