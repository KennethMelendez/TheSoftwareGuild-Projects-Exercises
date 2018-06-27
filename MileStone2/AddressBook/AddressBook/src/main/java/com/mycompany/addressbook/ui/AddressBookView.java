/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.ui;

import com.mycompany.addressbook.dto.Person;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class AddressBookView {
    
    UserIO io = new UserIOConsoleImpl();
    private int numberOfAddresses;
    
    public int displayMenuReturnSelection(){
         io.print("=== Address Book Menu ===");
         displayAddressCount();
         io.print("1. Add Address");
         io.print("2. Remove Address");
         io.print("3. List All Address");
         io.print("4. Find Address by Last Name");
         io.print("5. Edit Address");
         io.print("6. Exit");
         
        return io.readInt("Please select the operation you wish to perform", 1, 6);
    }
    
    public Person getAddressInfo(){
        String firstName = io.readString("Please Enter First Name");
        String lastName = io.readString("Please Enter Last Name");
        String address = io.readString("Please Enter Address");
        Person newPerson = new Person(lastName);
        newPerson.setfirstName(firstName);
        newPerson.setStreetAddress(address);
        numberOfAddresses++;
        return newPerson;
    }
    
    public void displayCreateAddressBanner(){
        io.print("=== Create Address Banner ===");
    }
    
    public void displayCreateSuccessBanner(){
        io.print("Address Successfully logged");
    }
    
    public void displayAllAddresses(List<Person> personList){
        
        for(Person currentPerson: personList){
            io.print(" ");
            io.print(currentPerson.getfirstName());
            
            io.print(currentPerson.getLastName());
            io.print(" ");
            io.print(currentPerson.getStreetAddress());
            io.print(" ");
        }
        io.readString("Please hit enter to continue");
        
    }
    
    
    	public void displayDisplayAllBanner() {
	    io.print("=== Display All Addresses ===");
	}
        
        public void displayGetAddressBanner(){
            io.print("=== Get Address ===");
        }
        
        public String getLastNameChoice(){
            return io.readString("Please Enter Last Name.");
        }
        
        public void displayAddress(Person person){
            if(person != null){
                io.print(person.getfirstName());
                io.print(person.getLastName());
                io.print(person.getStreetAddress());
                io.print(" ");
            } else {
                io.print("No such Student.");
            }
            io.readString("Please hit enter to continue.");
        }
        
        public void displayRemoveBanner(){
            io.print("=== Remove Address ===");
        }
        
        public void displayRemoveSuccessBanner(){
            numberOfAddresses--;
            io.readString("Address Removed. Please hit enter to continue.");
        }
        
        public void displayUnknownCommand(){
            io.print("Unknown Command.");
        }
        
        public void displayGoodBye(){
            io.print("Good Bye!");
        }
        
        public void displayAddressCount(){
            io.print("Number of Addresses " + numberOfAddresses);
        }
}
