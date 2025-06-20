contacts = []

def add_contact(name, last_name, phone_number):
    contact = {'name': name, 'last_name': last_name, 'phone_number': phone_number}
    contacts.append(contact)
    print(f"Contact {name} {last_name} added.")

def remove_contact(phone_number):
    for contact in contacts:
        if contact['phone_number'] == phone_number:
            contacts.remove(contact)
            print(f"Contact with phone number {phone_number} removed.")
            return
    print("Contact not found.")

def contact_found_by_phone_number(phone_number):
    for contact in contacts:
        if contact['phone_number'] == phone_number:
            print(f"Contact Found: {contact['name']} {contact['last_name']}, Phone: {contact['phone_number']}")
            return
    print("Contact not found.")

def contact_found_by_first_name(name):
    found = False
    for contact in contacts:
        if contact['name'] == name:
            print(f"Contact Found: {contact['last_name']} {contact['phone_number']}, First Name: {contact['name']}")
            found = True
    if not found:
        print("Contact not found with first name.")

def contact_found_by_last_name(last_name):
    found = False
    for contact in contacts:
        if contact['last_name'] == last_name:
            print(f"Contact Found: {contact['name']} {contact['phone_number']}, Last Name: {contact['last_name']}")
            found = True
    if not found:
        print("Contact not found with last name.")

def edit_contact(phone_number):
    for contact in contacts:
        if contact['phone_number'] == phone_number:
            print(f"Editing Contact: {contact['name']} {contact['last_name']}, Phone: {contact['phone_number']}")
            new_name = input("Enter new First Name:   ")
            new_last_name = input("Enter new Last Name:   ")
            new_phone_number = input("Enter new Phone Number:   ")

            # Update fields if new values are provided
            if new_name:
                contact['name'] = new_name
            if new_last_name:
                contact['last_name'] = new_last_name
            if new_phone_number:
                contact['phone_number'] = new_phone_number
            
            print("Contact updated successfully.")
            return
    print("Contact not found.")

def main():
    while True:
        menu_options = """
Welcome to PhoneBook 

Choose An Option
1 => Add Contact
2 => Remove Contact
3 => Find Contact By Phone Number
4 => Find Contact By First Name
5 => Find Contact By Last Name 
6 => Edit Contact
0 => Exit
"""
        print(menu_options)
        try: 
            user_input = int(input("Enter Your Choice: "))
            match user_input:
                case 1: 
                    name = input("Enter First Name: ")
                    last_name = input("Enter Last Name: ")
                    phone_number = input("Enter Phone Number: ")
                    add_contact(name, last_name, phone_number)
                case 2: 
                    phone_number = input("Enter Phone Number to Remove: ")
                    remove_contact(phone_number)
                case 3:
                    phone_number = input("Enter Phone Number to Find Contact: ")
                    contact_found_by_phone_number(phone_number)
                case 4: 
                    name = input("Enter First Name to Find Contact: ")
                    contact_found_by_first_name(name)
                case 5:
                    last_name = input("Enter Last Name to Find Contact: ")
                    contact_found_by_last_name(last_name)
                case 6:
                    phone_number = input("Enter Phone Number to Edit Contact: ")
                    edit_contact(phone_number)
                case 0:
                    print("Exiting PhoneBook. Goodbye!")
                    break
                case _:
                    print("Invalid option. Please try again.")
        except ValueError:
            print("Invalid input. Please enter a number.")

if __name__ == "__main__":
    main()
