/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doordonot;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
public class DoOrDoNot {
    public static void main(String[] args) {
        
        //in the original program
        //If I press Y the output prints out "I did it!"
        //If I press Y the output prints "I know you said not to ... but I totally did anyways."
        
      

        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;

        if (input.next().equals("y")) {
            doIt = true; // DO IT!
        } else {
            doIt = false; // DONT YOU DARE!
        }

//        boolean iDidIt = false;

//        do {
//            iDidIt = true;
//            break;
//        } while (doIt);
//
//        if (doIt && iDidIt) {
//            System.out.println("I did it!");
//        } else if (!doIt && iDidIt) {
//            System.out.println("I know you said not to ... but I totally did anyways.");
//        } else {
//            System.out.println("Don't look at me, I didn't do anything!");
//        }
        

//Creating ONLY a while LOOP creates an infinite LOOP within the program if answer is (Y)
//if answer is no. it makes the statement false and ends the program not starting the while loop.

        while (doIt){
        if (doIt) {
            System.out.println("I did it!");
        } else if (!doIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!");
        }
        
        
        
        
        
        
        }
    }
}
        
        
    

