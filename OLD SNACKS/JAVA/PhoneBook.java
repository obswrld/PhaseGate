import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook{
	private static ArrayList<String[]> contacts = new ArrayList<>();

	public static void addContact(String name, String lastName, String phoneNumber){
		contacts.add(new String[]{name, lastName, phoneNumber});
		System.out.println("Contact " + name + " " + lastName + " added.");
	}
	
	public static void removeContact(String phoneNumber){
		boolean found = false;
		for (int i = 0; i < contacts.size(); i++){
			if(contacts.get(i)[2].equals(phoneNumber)) {
				contacts.remove(i);
				System.out.println("Contact with Phone number " + phoneNumber + " removed");
				found = true;                                                                                                                                                                                nb                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
				break;
			}
		}
		if(!found){
			System.out.println("Contact not found");
		}
	}

	public static void findContactByPhoneNumber(String phoneNumber){
		for (String[] contact : contacts){
			if(contact[2].equals(phoneNumber)){
				System.out.println("Contact Found: " + contact[0] + "  " + contact[1] + "  " + "phoneNumber:  " + contact[2]);
				return;
			} 
		}
		System.out.println("Contact not Found");
	}

	public static void findContactByFirstName(String name){
		boolean found = false;
		for (String[] contact : contacts){
			if(contact[0].equals(name)){
				System.out.println("Contact Found: " + contact[1] + "  " + contact[2] + "  " + " Name:   " + contact[0]);
				found = true;
			} 
		}
		if(!found){
			System.out.println("Contact not found");
		}
	}

	public static void findContactByLastName(String lastName){
		boolean found = false;
		for (String[] contact : contacts){
			if(contact[1].equals(lastName)){
				System.out.println("Contact Found: " + contact[0] + "  " + contact[2] + "  " + " Last Name:   " + contact[1]);
				found = true;
			} 
		}
		if(!found){
			System.out.println("Contact not Found.");
		}
	}
	
	public static void editContact(String phoneNumber){
		for(String[] contact : contacts){
			if(contact[2].equals(phoneNumber)){
				Scanner input = new Scanner(System.in);
				System.out.println("Enter new First Name:   ");
				String newName = input.nextLine();
				System.out.println("Enter new Last Name:   ");
				String newLastName = input.nextLine();
				System.out.println("Enter new Phone Number:   ");
				String newPhoneNumber = input.nextLine();
				

				if (!newName.isEmpty()){
					contact[0] = newName;
				} 
				if (!newLastName.isEmpty()){
					contact[1] = newLastName;
				}
				if (!newPhoneNumber.isEmpty()){
					contact[2] = newPhoneNumber;
				}
				System.out.println("Contact Update Successfully.");
				return;
			}
		}
		System.out.println("Contact not Found.");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int userInput = -1;
		
		System.out.println("Welcome to Phone Book App: ");
		while(userInput != 1) {
			System.out.println("""
					Choose an Option
					1 => Add Contact
					2 => Remove Contact
					3 => Find Contact By Phone Number
					4 => Find Contact By First Name 
					5 => Find Contact By Last Name
					6 => Edit Contact	
					0 => Edit Contact
					""");
			System.out.println("Enter your Choice:   ");
			userInput = input.nextInt();
			input.nextLine();

			switch(userInput){
				case 1 -> {
					System.out.println("Enter First Name:   ");
					String name = input.nextLine();
					System.out.println("Enter Last Name:   ");
					String lastName = input.nextLine();
					System.out.println("Enter Phone Number:   ");
					String phoneNumber = input.nextLine();
					addContact(name, lastName, phoneNumber);
				}
				case 2 -> {
					System.out.println("Enter Phone Number to Remove:   ");
					String phoneNumber = input.nextLine();
					removeContact(phoneNumber);
				}
				case 3 -> {
					System.out.println("Enter Phone Number to Find Contact:   ");
					String phoneNumber = input.nextLine();
					findContactByPhoneNumber(phoneNumber);
				}
				case 4 -> {
					System.out.println("Enter First Name to Find Contact:   ");
					String name = input.nextLine();
					findContactByFirstName(name);
				}
				case 5 -> {
					System.out.println("Enter Last Name to Find Contact:   ");
					String lastName = input.nextLine();
					findContactByLastName(lastName);
				}
				case 6 -> {
					System.out.println("Enter Phone Number to Edit Contact:   ");
					String phoneNumber = input.nextLine();
					editContact(phoneNumber);
				}
				case 0 -> {
					System.out.println("Exiting.....");
				}
				default -> System.out.println("Invalid Choice. Please Try agian.");
			}
		}
	}
}