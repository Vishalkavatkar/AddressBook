package addressBookMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import addressBookMain.ContactPerson;

/**
 * This is the main class and we are calling the main method there. We are
 * calling the addressBookMain in this method that has all the operations.
 */
public class Main {
	public static Scanner scannerObject = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("---------- Welcome To Address Book Pr1ogram!! ----------");
		MultipleAddressBook addressBookDirectory = new MultipleAddressBook();
		addressBookDirectory.addressBookMain();
	}

}