package addressBookMain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Iterator;

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
 * Method to sort the address book by name/city/state/zip
 *
 */
public class MultipleAddressBook {
	/**
	 * We have created a HashMap and taken the key String as addressBook name and the value as AddressBookServices for contacts.
	 */
	Map<String, AddressBookServices> addressBookMap = new HashMap<>(); 
	public Map<String, ContactPerson> contacts = new HashMap<String,ContactPerson>();
	//List<ContactPerson> contacts = new ArrayList<ContactPerson>();
	ContactPerson person = new ContactPerson();
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
		//we use containsKey to check if addressBook present
		// and use remove fun to remove the book
		if (addressBookMap.containsKey(bookName)) {                                        
			addressBookMap.remove(bookName);                                                 
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
		List<ContactPerson>	arr = (List<ContactPerson>) addressBookMap.get(i).contacts;
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
			List<ContactPerson>	arr = (List<ContactPerson>) addressBookMap.get(i).contacts;
			arr.stream().filter(person -> person.getState().equals(stateName)).forEach(person -> System.out.println(person.getFirstName()));
		}		
	}
	
	/**
	 * We are displaying the people by region
	 * @param addressBookMap -  In this we are passing the hashmap
	 */
	public void displayPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> addressBookMap) {
		System.out.println("Enter the name of the region :");
		String regionName = scanner.next();
		
		addressBookMap.values().stream()
			    .map(region -> region.stream()
				.filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.forEach(person -> person.forEach(personDetails -> System.out.println(personDetails)));
	}
	/**
	 * In this method we are displaying the number of person in the city or state.
	 * @param listToDisplay - we are passing the list of city or state
	 */
	public void countPeopleByRegion(HashMap<String, ArrayList<ContactPerson>> listToDisplay) {

		System.out.println("Enter the name of the region :");
		String regionName = scanner.next();
		long countPeople = listToDisplay.values().stream()
				.map(region -> region.stream().filter(person -> person.getState().equals(regionName) || person.getCity().equals(regionName)))
				.count();
					
		System.out.println("Number of People residing in " + regionName+" are: "+countPeople+"\n");
		
	}
	
	/**
	 * Method to sort the address book by name
	 * In this method we are sorting the address book by the person first name
	 * we have used the sorted method and compared 2 contacts and arranged them.
	 * In this way it will compare and arrange it.
	 */
	public void sortAddressBook(int sortingChoice){
		List<ContactPerson> sortedContactList;
		for (String i : addressBookMap.keySet()) {
			 Map<String, ContactPerson> contactList = addressBookMap.get(i).contacts;
			
			 switch(sortingChoice) {
				
				case 1: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> firstperson.getFirstName().compareTo(secondperson.getFirstName()))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
					
				case 2: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> firstperson.getCity().compareTo(secondperson.getCity()))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
					
				case 3: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> firstperson.getState().compareTo(secondperson.getState()))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
					
				case 4: sortedContactList = contactList.values().stream()
						.sorted((firstperson, secondperson) -> Long.valueOf(firstperson.getZip()).compareTo(Long.valueOf(secondperson.getZip())))
						.collect(Collectors.toList());
						printSortedList(sortedContactList);
						break;
			}
					
		}
	}
		
	public void printSortedList(List<ContactPerson> sortedContactList) {
		System.out.println("------ Sorted Address Book ------");
		Iterator iterator = sortedContactList.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println();
		}
		System.out.println("-----------------------------------------");
	}

} 