package com.streamapi.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DriverClass {
	
	
	public static void main(String[] args) {
		List<Employee> empolyees = Arrays.asList(new Employee(1, "Soundarya", 20000,20,"Civil"),new Employee(2, "Aish", 30000,88,"IT"),new Employee(3, "Sahana", 5000,25,"Civil"));

		System.out.println(empolyees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).reduce((first,second)->second));
		
		empolyees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).limit(1).forEach(System.out::println);;
		empolyees.stream().max(Comparator.comparing(Employee::getAge));
		Optional<Employee> obj = empolyees.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println(obj.get());
		
		System.out.println( empolyees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())));
		System.out.println( empolyees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))));
		
		double avgSal =  empolyees.stream().collect(Collectors.averagingDouble(Employee::getSalary));

		empolyees.stream().filter(e-> e.getSalary()>avgSal).forEach(System.out::println);
		System.out.println();
		
		empolyees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).forEach(System.out::println);
		
	}

}
