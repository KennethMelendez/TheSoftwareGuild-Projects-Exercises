/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twoforsandtenyearsago;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
public class TwoForsAndTenYearsAgo {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What year would you like to count back from?");
        int year = userInput.nextInt();
        
        
        //the starting and stopping for both loops are both incrementing to upto 10 years
        //the second loop makes more sense because were subracting years
        
        for(int i = 0; i <= 10; i++){
            System.out.println(i + " years ago would be " + (year - i));
        }
        
        System.out.println("\nI can count backwards using a different way too...");
        //changed loop to go back 20 years
        for(int i = year; i >= year - 20; i--){
            System.out.println((year - i) + " years ago would be " + i);
        }

    }
}
