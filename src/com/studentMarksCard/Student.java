package com.studentMarksCard;

import java.util.Scanner;

public class Student {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size;
		System.out.print("Enter the no of subjects : ");
		
		size = sc.nextInt();
		int marks[] = new int[size];
		
		
		int sum = 0;
		for(int i = 0 ;i<marks.length;i++) {
			System.out.println("Enter the mark of subject " + (i+1));
			marks[i] = sc.nextInt();
			sum = sum + marks[i];
		}
		int avg = sum /size;
		
		System.out.println("The average of the marks "+ avg);
		
	
	
		
	}

	

}
