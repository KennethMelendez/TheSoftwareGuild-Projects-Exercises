/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.dao;

import com.mycompany.addressbook.dto.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author kmlnd
 */
public class AddressBookDaoImpl implements AddressBookDao{

    private Map<String, Person> personList = new HashMap<>();
    
    @Override
    public Person addAddress(String lastName, Person person) {
       Person newPerson = personList.put(lastName, person);
       return newPerson;
    }

    @Override
    public List<Person> getAllAddresses() {
        return new ArrayList<Person>(personList.values());
    }

    @Override
    public Person getAddressByLastName(String lastName) {
        return personList.get(lastName);
    }

    @Override
    public Person removeAddress(String lastName) {
        Person removeAddress = personList.remove(lastName);
        
        return removeAddress;
    }
    
}
