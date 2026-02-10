package com.collections.phonebook;

import java.util.ArrayList;

import java.util.List;

public class PhoneBook {

     List<Contacts> contactList = new ArrayList<>();
     
     public PhoneBook(List<Contacts> contactList) {
    		super();
    		this.contactList = contactList;
    	}
         

	public Contacts addContacts(Contacts contact) {
    	contactList.add(contact);
    	return contact;
    }
    
	public Contacts removeContact(long contactNumber) {
    	Contacts contact = null;
    	
    	for (Contacts c : contactList) {
			if(c.getContactNumber()==contactNumber){
				contact = c;
				contactList.remove(c);
			}
		}
    	return contact;
    }
    public List<Contacts> displayContacts() {
    	if( contactList.isEmpty()) {
    		System.out.println("No insertion found to display!!");
    	}
    	return contactList;
    }
    
    public Contacts displaySpecificContact(long contactNumber) {
    	Contacts contact = null;
    	for (Contacts c : contactList) {
			if(c.getContactNumber()==contactNumber){
				contact =c;
				break;
    	
			}
    	}
    	return contact;
    }
  
   
}
