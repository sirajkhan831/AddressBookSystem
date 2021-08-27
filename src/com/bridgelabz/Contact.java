package com.bridgelabz;

public class Contact {
    private final String firstName;
    private final String lastName;
    private final String number;
    private final String Address;
    private final String city;
    private final String state;
    private final String email;
    private final int zipCode;

    public Contact(String firstName, String lastName, String number, String address, String city, String state, String email, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        Address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void getAll(){
        System.out.println("Name     :  "+firstName+" "+lastName);
        System.out.println("Number   :  "+number);
        System.out.println("Email    :  "+email);
        System.out.println("Address  :  "+Address);
        System.out.println("City     :  "+city);
        System.out.println("State    :  "+state);
        System.out.println("ZipCode  :  "+zipCode+"\n");
    }
}
