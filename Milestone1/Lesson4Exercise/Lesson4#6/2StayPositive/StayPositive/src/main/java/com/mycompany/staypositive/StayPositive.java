/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.staypositive;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
public class StayPositive {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        int userNums;
        int minimum = 0;
        
        System.out.println("What number should i count from?");
         userNums = userInput.nextInt();
         while (userNums > 0){
             userNums--;
             System.out.print(" " + userNums); 
             
             if (userNums % 10 == 0){
                 System.out.println();
             }

         }
             System.out.println("Phew, better stop there...!");
        
        
    }
}
