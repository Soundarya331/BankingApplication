 package com.bankingApplication;

import java.util.Scanner;

public class MainApplication {

    static int MAX_ATTEMPTS = 3;
    static String Password = "1111";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputClass input = new InputClass();

        System.out.println("Enter applicant name:");
        input.setName(sc.nextLine());

        int attempts = 0;
        boolean validPinEntered = false;
        String pin ;
        System.out.println("Enter 4-digit PIN:");
        
        pin = sc.next();
        input.setPin(pin);

        while (attempts < MAX_ATTEMPTS) {
           
          
            if (!Application.isValidPin(pin)) {
                attempts++;
                System.out.println("Invalid PIN format. Attempts left: " 
                        + (MAX_ATTEMPTS - attempts));
                continue;
            }

            if (!pin.equals(Password)) {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " 
                        + (MAX_ATTEMPTS - attempts));
                continue;
            }

            input.setPin(pin);
            validPinEntered = true;
            break;
        }

        if (!validPinEntered) {
            System.out.println("Maximum attempts reached. Application closed.");
            sc.close();
            return;
        }

        System.out.println("Enter withdrawal amount:");
        double amount = sc.nextDouble();
        input.setAmount(amount);

        Application.processTransaction(input);
    }
}
