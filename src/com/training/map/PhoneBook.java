package com.training.map;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<Long, Contacts> contactsMap = new HashMap<>();
    
    

    public void addContact(Long phonenumber,Contacts con) {
        contactsMap.put(phonenumber,con);
        System.out.println("Contact added successfully");
    }

    public Contacts removeContact(long number) {
        return contactsMap.remove(number);
    }

    public Map<Long, Contacts> displayContacts() {
        if (contactsMap.isEmpty()) {
            System.out.println("No contacts found");
        }
        return contactsMap;
    }

    public Contacts displaySpecificContact(long number) {
        return  contactsMap.get(number);
    }
}


