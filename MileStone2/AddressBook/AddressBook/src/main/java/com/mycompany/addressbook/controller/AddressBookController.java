/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.controller;

import com.mycompany.addressbook.dao.AddressBookDao;
import com.mycompany.addressbook.dao.AddressBookDaoImpl;
import com.mycompany.addressbook.dto.Person;
import com.mycompany.addressbook.ui.AddressBookView;
import com.mycompany.addressbook.ui.UserIO;
import com.mycompany.addressbook.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class AddressBookController {
    
    AddressBookView view = new AddressBookView();
    AddressBookDao dao = new AddressBookDaoImpl();
    private UserIO io = new UserIOConsoleImpl();
    
    public void run(){
        
     int menuSelection = 0;
     boolean keepGoing = true;
     
     
     
     
     
     while(keepGoing){
         
        menuSelection = getMenuAndSelection();
         
         switch (menuSelection){
             case 1:
                 createPersonAddress();
                 break;
             case 2:
                 removeAddress();
                 break;
             case 3:
                 listAddresses();
                 break;
             case 4:
                 viewAddress();
                 break;
             case 5:
                 editAddress();
                 break;
             case 6:
                 keepGoing = false;
                 break;
             default:
                 displayUnknownCommand();
         }

     }
     displayGoodBye();
    }
    
    private int getMenuAndSelection(){
        return view.displayMenuReturnSelection();
    }
    
    private void createPersonAddress(){
        view.displayCreateAddressBanner();
        Person newPerson = view.getAddressInfo();
        dao.addAddress(newPerson.getLastName(), newPerson);
        view.displayCreateSuccessBanner();
    }
    
    private void listAddresses(){
        view.displayDisplayAllBanner();
        List<Person> AddressList = dao.getAllAddresses();
        view.displayAllAddresses(AddressList);
    }
    
    private void viewAddress(){
        view.displayGetAddressBanner();
        String lastName = view.getLastNameChoice();
        Person person = dao.getAddressByLastName(lastName);
        view.displayAddress(person);
    }
    
    private void removeAddress(){
        view.displayRemoveBanner();
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayRemoveSuccessBanner();
    }
    private void displayUnknownCommand(){
        view.displayUnknownCommand();
    }
    private void displayGoodBye(){
        view.displayGoodBye();
    }
    
    private void editAddress(){
        String lastName = view.getLastNameChoice();
        dao.removeAddress(lastName);
        view.displayCreateAddressBanner();
        Person newPerson = view.getAddressInfo();
        dao.addAddress(newPerson.getLastName(), newPerson);
        view.displayCreateSuccessBanner();
        
    }
}
