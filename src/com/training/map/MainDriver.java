package com.training.map;

import java.util.Map.Entry;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {

            System.out.println(
                "\nSelect operation:\n" +
                "1. Add\n" +
                "2. Remove\n" +
                "3. Display all contacts\n" +
                "4. Display specific contact\n" +
                "5. Exit"
            );

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    System.out.print("Enter Contact Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    long number = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter Contact Email: ");
                    String email = scanner.nextLine();

                    phoneBook.addContact(number,new  Contacts(name, number, email));
                    break;

                case 2:
                    System.out.print("Enter Contact Number to delete: ");
                    long deleteNumber = scanner.nextLong();

                    Contacts removed = phoneBook.removeContact(deleteNumber);
                    System.out.println(removed != null ? "Contact removed" : "Contact not found");
                    break;

                case 3:
                    for (Entry<Long, Contacts> entry : phoneBook.displayContacts().entrySet()) {
                        System.out.println("Number: " + entry.getKey() +" | Details: " + entry.getValue());
                    }
                    break;

                case 4:
                    System.out.print("Enter Contact Number: ");
                    long searchNumber = scanner.nextLong();

                    Contacts contact = phoneBook.displaySpecificContact(searchNumber);
                    System.out.println(contact != null ? contact : "Contact not found");
                    break;

                case 5:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
