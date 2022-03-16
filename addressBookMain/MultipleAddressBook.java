package addressBookMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import addressBookMain.ContactPerson;
/**
 * This class have the implementation for the multiple address book.
 * We have created the methods for the address book manipulations.
 * We have used a HashMap to store multiple addressBook
 * The method addAddressBook will add the address book key to the Map.
 * The method addContact will add the contact to the addressBook
 * The method editContact will edit the contacts in the address book
 * Method to delete the addressBook
 * The method deleteContactInBook to delete the specific contact in the book
 * This method will print the AddressBook i.e keys in the Map
 * In this method we are searching the person by the city or State
 *
 */
public class MultipleAddressBook {
	/**
	 * We have created a HashMap and taken the key String as addressBook name and the value as AddressBookServices for contacts.
	 */
	Map<String, AddressBookServices> addressBookMap = new HashMap<>();    
	List<ContactPerson> contacts = new ArrayList<ContactPerson>();
	Scanner scanner = new Scanner(System.in);
	/**
	 * The method addAddressBook will add the address book key to the Map.
	 * We are taking a addressBook name from the console and using the .containsKep method to check if the book is already present
	 * Else we will use the put method to add the key and value.
	 */
	public void addAddressBook() {                                                  
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {                               
			System.out.println("Address book with this name exists, Enter new name.");
			addAddressBook();
		} else {
			AddressBookServices addressBook = new AddressBookServices();
			addressBookMap.put(bookName, addressBook);                              //adding address book and contacts to HashMap
			System.out.println("Address Book " + bookName + " successfully added!!");
		}
	}

	/**
	 * The method addContact will add the contact to the addressBook
	 * First we will ask the AddressBook name to add the contact to.
	 * Then we will get the key from the HashMap
	 * We are then just calling the add contact method and adding the contact to our ArrayList.
	 */
	public void addContact() {                                                     
		System.out.println("Enter the name of Address book to add the contact.");
		Scanner scanner = new Scanner(System.in);
		String newContact = scanner.nextLine();
		AddressBookServices addressBook = addressBookMap.get(newContact); 
		if (addressBook == null) {
			System.out.println("No book found");

		} else {
			addressBookMap.get(newContact).addContact();                         
		}
	}

	/**
	 * The method editContact will edit the contacts in the address book
	 * First we will ask the AddressBook name to edit the contact to.
	 * Then we will get the key from the HashMap
	 * We are then just calling the edit contact method
	 */
	public void editContactInBook() {
		System.out.println("Enter Name of Address Book you want to edit: ");
		Scanner scanner = new Scanner(System.in);
		String editBookName = scanner.next();
		if (addressBookMap.containsKey(editBookName)) {
			addressBookMap.get(editBookName).editContact();                               // calling the edit contact method to edit contacts
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			editContactInBook();
		}
	}

	/**
	 * Method to delete the addressBook
	 * In this we will delete the specific key and its contacts.
	 * We are using the remove method to delete the key & value form the map 
	 */
	public void deleteAddressBook() {
		System.out.println("Enter Name of Address Book you want to delete: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {                                       //we use containsKey to check if addressBook present 
			addressBookMap.remove(bookName);                                                 // and use remove fun to remove the book
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteAddressBook();
		}
	}

	/**
	 * The method deleteContactInBook to delete the specific contact in the book
	 * This method will only delete the value and not the key.
	 * We will check if the key is present and then we will call the deleteContact method and delete the specific contact.
	 * 
	 */
	public void deleteContactInBook() {
		System.out.println("Enter Name of Address Book you want to delete the contacts in it: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (addressBookMap.containsKey(bookName)) {
			addressBookMap.get(bookName).deleteContact();                                            
		} else {
			System.out.println("AddressBook doesn't exist, Please enter correct name.");
			deleteContactInBook();
		}
	}

	/**
	 * This method will print the AddressBook i.e keys in the Map
	 * We are using the advanced for loop to print the key.
	 * We are sung the .keySet to get all the keys from the Map.
	 */
	public void printBook() {
		System.out.println("These are AddressBooks in program.");
		for (String i : addressBookMap.keySet()) {                                     
			System.out.println(i);
		}
	}

	/**
	 * We are using this method to print the contacts in the AddressBook.
	 * We have used the get(key) metod to print the contacts.
	 */
	public void printContactsInBook() {
		for (String i : addressBookMap.keySet()) {
			System.out.println(i);
			System.out.println(addressBookMap.get(i).contacts);                     
		}
		System.out.println(" ");
	}
	/**
	 *In this method we are searching the person by the city
	 *We are using a advanced for loop to get all the keys
	 *Then we are saving contacts to the list.
	 *Then we are using the streams filter to get the contact matching the city and then printing it.
	 */
      public void searchByCity() {
		
		System.out.println("Enter the name of the City to get the persons : ");
		String cityName = scanner.next();
		for (String i : addressBookMap.keySet()) {
		List<ContactPerson>	arr = addressBookMap.get(i).contacts;
		arr.stream().filter(person -> person.getCity().equals(cityName)).forEach(person -> System.out.println(person.getFirstName()));
      }		
    }

      /**
  	 * In this method we are searching the person by the state
  	 * We are using a advanced for loop to get all the keys
  	 * Then we are saving contacts to the list.
  	 * Then we are using the streams filter to get the contact matching the state and then printing it.
  	 */
public void searchByState() {
	
	System.out.println("Enter the name of the State to the get persons : ");
	String stateName = scanner.next();
	for (String i : addressBookMap.keySet()) {
	List<ContactPerson>	arr = addressBookMap.get(i).contacts;
	arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstName()));
  }		
}
}