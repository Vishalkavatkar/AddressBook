package addressBookMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookServices {
	Scanner s = new Scanner(System.in);
	List<ContactPerson> contacts = new ArrayList<ContactPerson>();
	public void addContact() {                                                            //taking input from console to add user
		System.out.println("Enter the number of contacts you want to enter");
        int number = s.nextInt();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter the contact details of person ");
            writeContact();
        }
    }
	public void writeContact() {

		Scanner scan = new Scanner(System.in);
		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();

		System.out.print(" Please enter the last name: ");
		String lastName = scan.next();

		System.out.print(" Please enter the address: ");
		String address = scan.next();

		System.out.print(" Please enter the city: ");
		String city = scan.next();

		System.out.print(" Please enter the state: ");
		String state = scan.next();

		System.out.print(" Please enter the zip: ");
		int zip = scan.nextInt();

		System.out.print(" Please enter the phone number: ");
		Long phoneNumber = scan.nextLong();

		System.out.print(" Please enter the email: ");
		String email = scan.next();
 
		//taking the input from console and then adding it to the ArrayList contacts
		ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);   //Parameterized constructor
		contacts.add(newContact);
		
		System.out.println(contacts);

	}
	
	public ContactPerson findContact() {                                         //to find the contacts
		System.out.println("\n Enter the first name of the contact : ");
		String name = s.next();
		int duplicate = 0;                                                   //will increment the duplicate if found multiple contacts with same name
		ContactPerson temp = null;
		for (ContactPerson contact : contacts) {
			if (contact.getFirstName().equals(name)) {
				duplicate++;
				temp = contact;
			}
		}
		if (duplicate == 1) {
			return temp;

		} else if( duplicate > 1) {
			
		System.out.print(" There are multiple contacts with given name.\n Please enter their city : ");
			String city = s.next();
			for (ContactPerson contact : contacts) {
				if (contact.getFirstName().equals(name) && contact.getCity().equals(city)) {
					return contact;
				}
			}
		}
		else{
			System.out.println("No contact with the given first name. Please enter the correct first name");
			findContact();
		}
		return temp;
	} 



public void edit() {
	ContactPerson contact = findContact();
	System.out.println("1:to edit first name \n2:last name \n3: address \n4:city \n5 state \n6: zip \n7: phoneNumber \n8: email ");
	int choice = s.nextInt();

	switch (choice) {

	case 1:
		System.out.println("Enter new first name");
		String newName = s.next();
		contact.setFirstName(newName);
		System.out.println("Enter new Updated");
		break;
	case 2:
		System.out.println("Enter new last name");
		String newlastName = s.next();
		contact.setLastName(newlastName);
		System.out.println("Enter new Updated");
		break;
	case 3:
		System.out.println("Enter new address");
		String newAddress = s.next();
		contact.setAddress(newAddress);
		System.out.println("Enter new Updated");
		break;
	case 4:
		System.out.println("Enter new city");
		String newCity = s.next();
		contact.setCity(newCity);
		System.out.println("Enter new Updated");
		break;
	case 5:
		System.out.println("Enter new state");
		String newState = s.next();
		contact.setAddress(newState);
		System.out.println("Enter new Updated");
		break;
	case 6:
		System.out.println("Enter new zip");
		int newZip = s.nextInt();
		contact.setZip(newZip);
		System.out.println("Enter new Updated");
		break;
	case 7:
		System.out.println("Enter new phone number");
		Long newPhoneNumber = s.nextLong();
		contact.setPhoneNumber(newPhoneNumber);
		System.out.println("Enter new Updated");
		break;
	case 8:
		System.out.println("Enter new email");
		String newEmail = s.next();
		contact.setEmail(newEmail);
		System.out.println("Enter new Updated");
		break;

	}
	System.out.println("Contacts updated" + contact);

}
public void delete() {
	ContactPerson contact = findContact();
	contacts.remove(contact);
	System.out.println(contacts);
}
public void displayContact() {                                                       
	System.out.println(contacts);
}

}

