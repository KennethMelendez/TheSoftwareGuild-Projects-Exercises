/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.dao;

import com.mycompany.addressbook.dto.Person;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface AddressBookDao {
    Person addAddress(String lastName, Person person);
    
    List<Person> getAllAddresses();
    
    Person getAddressByLastName(String lastName);
    
    Person removeAddress(String lastName);
}
