package com.exceptionalhandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RegistrationForm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Marathon marathon = new Marathon();

        System.out.println("Marathon Registration Form");

        boolean isNameValid = false;
        while (!isNameValid) {
            try {
                System.out.print("Enter the name of participant: ");
                String name = sc.nextLine();

                if (name.length() < 4) {
                    System.out.println("Name must have minimum 4 characters");
                } else if (!name.matches("[A-Za-z' ']+")) {
                    System.out.println("Name should contain only alphabets");
                } else {
                    marathon.setName(name);
                    isNameValid = true; 
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter valid name");
            }
        }

        boolean isAgeValid = false;
        while (!isAgeValid) {
            try {
                System.out.print("Enter the age: ");
                int age = sc.nextInt();

                if (age < 18 || age > 60) {
                    System.out.println("Age must be between 18 and 60");
                } else {
                    marathon.setAge(age);
                    isAgeValid = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Age must be numeric");
            }
        }

        boolean isGenderValid = false;
        while (!isGenderValid) {
            try {
                System.out.print("Enter the gender (Male/Female/Others): ");
                String gender = sc.next();

                if (gender.equalsIgnoreCase("Male") ||gender.equalsIgnoreCase("Female") ||gender.equalsIgnoreCase("Others")) {

                    marathon.setGender(gender);
                    isGenderValid = true;
                } else {
                    System.out.println("Gender must be Male, Female or Others");
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter valid gender");
            }
        }

        boolean isContactValid = false;
        while (!isContactValid) {
            try {
                System.out.print("Enter the contact number: ");
                String contact = sc.next();

                if (!contact.matches("\\d{10}")) {
                    System.out.println("Contact number must be exactly 10 digits");
                } else {
                    marathon.setContact(contact);
                    isContactValid = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Contact must be numeric");
            }
        }

        System.out.println("Registration Completed Successfully!");
        System.out.println("Participant Name: " + marathon.getName());
        System.out.println("Participant age: " + marathon.getAge());
        System.out.println("Participant Contact Number : " + marathon.getContact());
        System.out.println("Participant Gender: " + marathon.getGender());

        sc.close();
    }
}
