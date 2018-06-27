/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fortimes;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
public class ForTimes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int timesResult;

        System.out.println("Which times table shall I recite?");
        int userInput = input.nextInt();
                

        
        for(int i = 1; i < 16; i++){
            
        timesResult = userInput * i;    
            
        System.out.println(i + " * " + userInput + " is: " + timesResult);
    }
        
    }
}
