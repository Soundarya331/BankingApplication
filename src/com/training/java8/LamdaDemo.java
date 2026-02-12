package com.training.java8;

import java.util.Random;
import java.util.function.Supplier;

public class LamdaDemo {

	public static void main(String[] args) {

	
		
		Random random = new Random();
		Supplier<String> supplier =  ()->String.format("%06d", random.nextInt(1000000));
		
		for(int i=0;i<5;i++) {
		System.out.println(supplier.get());
		
		}
		
		
	}
	
}
