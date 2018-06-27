/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.waitawhile;

/**
 *
 * @author Kenny
 */
public class WaitAWhile {
    public static void main(String[] args) {
        //changing the variables for bedTIme makes the loop end during that time peroid.
        //changing the variable for timeNow changes where the loop starts
        int timeNow = 5;
        int bedTime = 11;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            //Removing timeNow++ creates an infinite loop.
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
        
    }
}
