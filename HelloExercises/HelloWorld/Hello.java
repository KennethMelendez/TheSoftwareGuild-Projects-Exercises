/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.helloworld;

import java.util.Scanner
/**
 *
 * @author Kenny
 */
public class Hello {
    public static void main(String[] args){
        scanner = myScanner = new Scanner(System.in);
        System.out.println("What is your name, Hero?");
        name = myScanner.nextLine();
        System.out.println("Welcome hero: " + name);
                
        int age;
        System.out.println("What is your age " + name + "?");
        String ageInput = myScanner.nextLine();
        
        age = Integer.parseInt(ageInput);
        
        System.out.println("You're age is :" + age);
        
        
        
        //declare an int called counter
        int counter;
        int operand2;
        
        //now im assigning a number to counter
        counter = 7;
        
        //declare a boolean called isDOne
        boolean isDone;
        
        //now assign false to isDone
        isDone = false;
        
        counter = counter + 2;
        counter += 2;
        System.out.println("Hello, World");
    }
}
