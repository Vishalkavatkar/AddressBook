package addressBookMain;

public class Main {
	public static void main(String[] args) {
		AddressBookServices ab = new AddressBookServices();
		ab.addContact();
		ab.edit();
		ab.delete();
		ab.displayContact();
	}

}