/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.thecount;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
public class TheCount {
    public static void main(String[] args) {
        
        //created scanners for both inputs
        Scanner userInputStart = new Scanner(System.in);
        Scanner userInputIncrement = new Scanner(System.in);
        Scanner count = new Scanner(System.in);
        

 

        
        //creating response for the user
        System.out.println("I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU!");
        System.out.println("Start at what number?");
        
            //scanner for user input starting number
        int userNumsStart = userInputStart.nextInt();
        System.out.println("Stop at what number?");
            //ending number
        int userInputIncrementStart = userInputIncrement.nextInt();
        
            //count by
        System.out.println("Count by?");
        int countBy = userInputIncrement.nextInt();
        // for loop that displays the count
        
 
        int columns = 0;
        for(int x = userNumsStart; x < userInputIncrementStart; x = x + countBy){
        
            
          //COLUMNS
               columns++;
               System.out.print(" " + x + " ");
                 if (columns % 3 == 0){
                 System.out.println(" ");
 
           }
            
            
            
            
            
            
        }
 
        
    }
}
