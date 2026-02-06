package com.stringprograms;

import java.util.Scanner;

public class StringConverstion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		
		String words = sc.nextLine();
		String[] sepWords = words.split(" ");
		
		String eachstring;
		String result ="";
		for (int i = 0; i < sepWords.length; i++) {
			eachstring = sepWords[i];
			
			String caps = eachstring.substring(0,1).toUpperCase() + eachstring.substring(1) ;
			result = result + caps + " ";
		}
		
		System.out.println("Converted String value : " + result);
	}

}
