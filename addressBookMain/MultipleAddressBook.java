package addressBookMain;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {
	// use of hashMap to save the addressBook
	Map<String, AddressBookServices> addressBookMap = new HashMap<>();              

	// to add address book
	public void addAddressBook() {                                                  
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		
		//we use containsKey to check if the book name exists
		if (addressBookMap.containsKey(bookName)) {                                
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBookServices addressBook = new AddressBookServices();
			addressBookMap.put(bookName, addressBook);  
			
			//adding address book and contacts to HashMap
			System.out.println("Address Book " + bookName + " successfully added!!");
		}
	}

	// to add contact in Address book
	public void addContact() {                                                     
		System.out.println("Enter the name of Address book to add the contact.");
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		
		// to check if the addressbook is present
		AddressBookServices addressBook = addressBookMap.get(newContact);           
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			// if present then add it to hashMap
			addressBookMap.get(newContact).addContact();                         
		}
	}

	public void editContactInBook() {
		System.out.println("Enter Name of Address Book you want to edit: ");
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			
			// calling the edit contact method to edit contacts
			addressBookMap.get(editBookName).editContact();                               
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			editContactInBook();
		}
	}

	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		
		//we use containsKey to check if addressBook present 
		// and use remove fun to remove the book
		addressBookMap.remove(bookName);                                                 
		if (addressBookMap.containsKey(bookName)) {                                       
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteAddressBook();
		}
	}

	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName).deleteContact();                                            // we call the deleteContact function to delete the contact
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (String i : addressBookMap.keySet()) {                                     // we use keySet to get all the keys and display it
			System.out.println(i);
		}
	}

	public void printContactsInBook() {
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
			System.out.println(addressBookMap.get(i).contacts);                     //we print the values of the key
		}
		System.out.println(" ");
	}

}