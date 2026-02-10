package com.training.collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String [] args) {
		
//		CompareId c = new CompareId ();
		Set <Student> student = new TreeSet<Student>(new CompareAge());
		
		student.add(new Student(101,"Soundarya",4));
		student.add(new Student(105,"Vijay",1));
		student.add(new Student(103,"Abhiram",11));
		
		
	for (Student student2 : student) {
		System.out.println(student2.getName());
	}
		
	}

}
