package com.collections.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Contacts> contactsList = new ArrayList<>();
        PhoneBook phoneBook = new PhoneBook(contactsList);

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

                    phoneBook.addContacts(new Contacts(name, number, email));
                    break;

                case 2:
                    System.out.print("Enter Contact Number to delete: ");
                    long deleteNumber = scanner.nextLong();
                    phoneBook.removeContact(deleteNumber);
                    break;

                case 3:
                    for (Contacts c : phoneBook.displayContacts()) {
                        System.out.println(c);
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
