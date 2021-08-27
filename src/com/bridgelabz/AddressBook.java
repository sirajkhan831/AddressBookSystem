package com.bridgelabz;

import java.util.*;

public class AddressBook {

    public static void main(String[] args) {
        LinkedList<Contact> contact = new LinkedList<>();       // Creating a linked list of Contact to store all the contact objects

        // Declaring Contact Objects below
        Contact Siraj = new Contact("Siraj", "Khan", "9689785644", "Mowa, Raipur", "Raipur", "Chhattisgarh", "sirajkhanc2305@gmail.com", 492001);
        Contact Aakash = new Contact("Aakash", "Chopra", "8634548263", "Friends Nagar, Delhi", "Delhi", "Delhi", "akash@gmail.com", 792001);
        Contact Rahul = new Contact("Rahul", "Singh", "7630267863", "NewYork, USA", "NY", "NewYork", "rahul@gmail.com", 211001);
        Contact Yugal = new Contact("Yugal", "Sahu", "7890267863", "Adarsh Nagar", "Raipur", "Chhattisgarh", "yugal@gmail.com", 511001);
        Contact Vibhooti = new Contact("Vibhooti", "Gonnade", "7823476863", "Marathalli", "Bangalore", "Karnataka", "vg2334@gmail.com", 451007);
        Contact Harsh = new Contact("Harsh", "Patel", "9523472863", "Mahavir Nagar", "Bangalore", "Karnataka", "harsh34@gmail.com", 271001);
        Contact Neeraj = new Contact("Neeraj", "Sharma", "7623472863", "Ram Nagar", "Agra", "UttarPradesh", "neerajS@gmail.com", 891004);
        Contact Sagar = new Contact("Sagar", "Rao", "9223472863", "Singapore City", "Visakhapatnam", "AndhraPradesh", "sagarrao@gmail.com", 791003);
        Contact Rohit = new Contact("Rohit", "Sharma", "6223472863", "Panvel", "Mumbai", "Maharastra", "rohit45@gmail.com", 991003);
        Contact AAAA = new Contact("AAA", "null", "null", "null", "null", "null", "null", 0); // Added Default contact to fix a bug

        // sorting all the contacts in alphabetical order via method sort();
        sort(contact, Siraj);
        sort(contact, Aakash);
        sort(contact, Rahul);
        sort(contact, Yugal);
        sort(contact, Vibhooti);
        sort(contact, Harsh);
        sort(contact, Neeraj);
        sort(contact, Sagar);
        sort(contact, Rohit);
        sort(contact, AAAA);  // Default contact to fix index position bug IGNORE
        System.out.println("Hello welcome to your address book.");
        menu(contact);
    }

    // Menu method for user interaction
    public static void menu(LinkedList<Contact> contact) {
        System.out.println("Press 1 to view all your contacts.");
        System.out.println("Press 2 to add a contact.");
        System.out.println("Press 3 to remove a contact.");
        System.out.println("Press 4 to modify a contact.");
        System.out.println("Press 9 to stop the program.");
        Scanner optionScan = new Scanner(System.in);
        int option = optionScan.nextInt();
        if (option == 1) {
            printList(contact);
            contactDetails(contact);
            System.out.println("Enter 99 to continue to the menu : ");
            Scanner menuOptScan = new Scanner(System.in);
            int menuOpt = menuOptScan.nextInt();
            if (menuOpt == 99) {
                menu(contact);
            }
        } else if (option == 2) {
            Contact newContact = addContact();
            sort(contact, newContact);
            printList(contact);
            contactDetails(contact);
            System.out.println("Enter 99 to continue to the menu : ");
            Scanner menuOptScan = new Scanner(System.in);
            int menuOpt = menuOptScan.nextInt();
            if (menuOpt == 99) {
                menu(contact);
            }
        } else if (option == 3) {
            printList(contact);
            delete(contact);
            printList(contact);
            System.out.println("Operation Successful");
            System.out.println("Enter 99 to continue to the menu : ");
            Scanner menuOptScan = new Scanner(System.in);
            int menuOpt = menuOptScan.nextInt();
            if (menuOpt == 99) {
                menu(contact);
            }
        } else if (option == 4) {
            modify(contact);
            printList(contact);
            contactDetails(contact);
            System.out.println("Enter 99 to continue to the menu : ");
            Scanner menuOptScan = new Scanner(System.in);
            int menuOpt = menuOptScan.nextInt();
            if (menuOpt == 99) {
                menu(contact);
            }
        } else if (option == 9) {
            System.exit(1);
        }
    }

    // contactDetails method which prints out all the details of given method via getAll(); inside Contact class
    public static void contactDetails(LinkedList<Contact> contact) {
        System.out.println("Enter index position for all the details for chosen contact or press 99 for menu: ");
        Scanner numberScan = new Scanner(System.in);
        int number = numberScan.nextInt();
        if (number == 99) {
            menu(contact);
        } else
            contact.get(number).getAll();
    }

    // printList for printing the sorted contacts in the console
    public static void printList(LinkedList<Contact> contacts) {
        int index = -1;
        System.out.println("Position        |          Name");
        System.out.println("________________________________");
        for (Contact contact : contacts) {
            index++;
            if (index > 0) {
                System.out.println("  " + index + "             |         " + contact.getFirstName());
            }
        }
    }

    //sort method to sort all the contacts in alphabetical order using ListIterators
    public static void sort(LinkedList<Contact> contactLinkedList, Contact contact) {
        ListIterator<Contact> contactListIterator = contactLinkedList.listIterator();
        while (contactListIterator.hasNext()) {
            String compareStr = contactListIterator.next().getFirstName();
            int compare = compareStr.compareTo(contact.getFirstName());
            if (compare == 0) {
                System.out.println("The same contact already exists.");
                return;
            } else if (compare > 0) {
                contactListIterator.previous();
                contactListIterator.add(contact);
                return;
            }
        }
        contactListIterator.add(contact);
    }

    // addContact method to add a new contact by creating a new class and returning it through addContact();
    public static Contact addContact() {
        System.out.println("Enter a new first name (The first letter should be in uppercase): ");
        Scanner firstNameScan = new Scanner(System.in);
        String firstName = firstNameScan.nextLine();
        System.out.println("Enter last name : ");
        Scanner lastNameScan = new Scanner(System.in);
        String lastName = lastNameScan.nextLine();
        System.out.println("Enter contact number : ");
        Scanner contactScan = new Scanner(System.in);
        String contact = contactScan.nextLine();
        System.out.println("Enter Email : ");
        Scanner emailScan = new Scanner(System.in);
        String email = emailScan.nextLine();
        System.out.println("Enter city : ");
        Scanner cityScan = new Scanner(System.in);
        String city = cityScan.nextLine();
        System.out.println("Enter State : ");
        Scanner stateScan = new Scanner(System.in);
        String state = stateScan.nextLine();
        System.out.println("Enter Address : ");
        Scanner addressScan = new Scanner(System.in);
        String address = addressScan.nextLine();
        System.out.println("Enter ZipCode : ");
        Scanner zipScan = new Scanner(System.in);
        int zipcode = zipScan.nextInt();

        return new Contact(firstName, lastName, contact, address, city, state, email, zipcode);
    }

    // delete method to delete selected contact by removing it from the linked list
    public static void delete(LinkedList<Contact> contacts) {
        System.out.println("Enter the name of contact to delete : ");
        Scanner nameScan = new Scanner(System.in);
        String name = nameScan.nextLine().toLowerCase(Locale.ROOT);
        contacts.removeIf(contact -> Objects.equals(name, contact.getFirstName().toLowerCase(Locale.ROOT)));
    }

    //modify method to modify selected contact
    public static void modify(LinkedList<Contact> contacts) {
        printList(contacts);
        System.out.println("Enter the name of contact to modify : ");
        Scanner nameScan = new Scanner(System.in);
        String name = nameScan.nextLine().toLowerCase(Locale.ROOT);
        ListIterator<Contact> contactListIterator = contacts.listIterator();
        while (contactListIterator.hasNext()) {
            if (Objects.equals(name, contactListIterator.next().getFirstName().toLowerCase(Locale.ROOT))) {
                contactListIterator.remove();
                Contact newContact = addContact();
                sort(contacts, newContact);
                printList(contacts);
                contactDetails(contacts);
                System.out.println("Enter 99 to continue to the menu : ");
                Scanner menuOptScan = new Scanner(System.in);
                int menuOpt = menuOptScan.nextInt();
                if (menuOpt == 99) {
                    menu(contacts);
                }

            }
        }

    }
}