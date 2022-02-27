package addressBookMain;

import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {
	public static void main(String[] args) {

		System.out.println("---------Welcome to Address Book---------");

		List<ContactPerson> contacts = new ArrayList<>();                                   // creating a ArrayList for storing the contacts

		ContactPerson newContact = new ContactPerson("Vishal", "Kavatkar", "Kolamb", "Malvan", "Maharashtra", 416606,              
				"9326124009", "vkavatkar11@gmail.com");                                                                       // created a object

		contacts.add(newContact);                                                                                           //adding it to arrayList

		System.out.println(contacts);
	}

}