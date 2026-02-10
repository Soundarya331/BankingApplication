package com.training.collections;

import java.util.Comparator;

public class CompareAge implements Comparator<Student>{

	

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.getAge() - o2.getAge();
	}

}
