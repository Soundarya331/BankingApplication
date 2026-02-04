package com.studentMarksCard;

import java.util.Scanner;

public class MultiStudentsMarks {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter the number of students");
		
		int student = sc.nextInt();
		
		System.out.println("Enter the number of subjects");
		
		int sub = sc.nextInt();
		
		int students[] [] = new int [student][sub];
		double sum = 0;
	
		
		for (int i = 0; i < students[student].length; i++) {
			System.out.println("Enter the marks of student : " + (i+1));
			for (int j = 0; j < students[sub].length; j++) {
				
				students[i][j]= sc.nextInt();
				sum = sum + students[i][j];
				
			}
			double avg = sum/students[1].length;
			System.out.println("AVG Of student " + (i+1) + " is  " + avg );
			avg = 0;
			sum = 0;
			
		}
		System.out.println();
	}
	


}
