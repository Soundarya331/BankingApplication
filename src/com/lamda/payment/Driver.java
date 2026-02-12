package com.lamda.payment;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.lamda.payment.Payment.Status;

public class Driver {
	
	public static void main(String[] args) {
		Predicate<Double> pre = (validAmount)-> validAmount>0 ;

		
		
		//generate the random number
		Random random = new Random();
		Supplier<String> supplier =  ()->String.format("%06d", random.nextInt(1000000));
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the payment id");
		String id = scanner.next();
		System.out.println("Enter the payment amount");
		double amount = scanner.nextDouble();
		System.out.println("Enter the status  ACTIVE, EXPIRED; ");
		String inputStatus = scanner.next();		
		Payment payment = new Payment(id, amount, Status.valueOf(inputStatus),supplier.get());
		Consumer<Payment> consumer = (obj)-> System.out.println(payment);
		
		System.out.println("Select operation 1.Payment log 2.Payment details");
		
		int input = scanner.nextInt();
		if(input==1) {
			if(pre.test(amount)) {
			consumer.accept(payment);
			}
			
		}
		if(input==2) {
			
			Function<Payment,String> obj =  (p)-> payment.toString();
			System.out.println(obj.apply(payment));
		}
		scanner.close();
	}
}
