/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.addressbook.dto;

/**
 *
 * @author kmlnd
 */
public class Person {
    private String firstName;
    private String lastName;
    private String streetAddress;
    
    public Person(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setfirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getfirstName(){
        return firstName;
    }
    
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }
    
    public String getStreetAddress(){
        return streetAddress;
    }
}
