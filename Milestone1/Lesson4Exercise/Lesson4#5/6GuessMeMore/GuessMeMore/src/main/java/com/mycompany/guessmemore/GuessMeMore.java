/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessmemore;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
import java.util.Random;


public class GuessMeMore {
    public static void main(String[] args) {
        
        int maximum = 100;
        int minimum = -100;
        
        Scanner userInput = new Scanner(System.in);

        Random randomizer = new Random();
        int randomNum = randomizer.nextInt((maximum - minimum) + 1) + minimum;
        

        
        //System.out.println(randomNum);
        int userNum;
        do {
       
        System.out.println("I've chosen a number between " + maximum + " and " + minimum + " Betcha cant guess it!");
        userNum = (int) userInput.nextInt();
        System.out.println("You chose " + userNum);
        
        if (userNum == randomNum) {
                System.out.println("WOW, you guessed right!!!");
            
            } 
             else if (userNum < randomNum){
             System.out.println("Ha, nice try - too low! Try again!");
//             System.out.println("Your number is " + userNum); //userNum instead of userInput
             
         } else if (userNum > randomNum){
             System.out.println("Ha! nice try - too high! Try again!");
//                    userNum = userInput.nextInt();
                    
         } 
            
        } while (userNum!= randomNum);
        
        
            
        }
 
        


        
        
    }
  





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
// */
//package com.mycompany.guessmemore;
//
///**
// *
// * @author Kenny
// */
//
//import java.util.Scanner;
//import java.util.Random;
//import java.util.concurrent.ThreadLocalRandom;
//
//public class GuessMeMore {
//    public static void main(String[] args) {
//        
//        int maximum = 100;
//        int minimum = -100;
//        
//        Scanner userInput = new Scanner(System.in);
//
//                
//        System.out.println("I've chosen a number between -100 and 100. Betcha can't guess it!");
//        int userNum;
//        userNum = userInput.nextInt();
//        System.out.println("You chose " + userNum);
//        
//        
//        Random randomizer = new Random();
//        int randomNum = randomizer.nextInt((maximum - minimum) + 1) + minimum;
//        
//
//        
//        //System.out.println(randomNum);
//         if (userNum < randomNum){
//             System.out.println("Ha, nice try - too low! Try again!");
//             System.out.println("Your number is " + userInput);
//                    userNum = userInput.nextInt();
//         } else if (userNum > randomNum){
//             System.out.println("Ha! nice try - too high! Try again!");
//                    userNum = userInput.nextInt();
//         } else if (userNum == randomNum){
//             System.out.println("WOW, you guessed right!!!");
//         }
//        
// 
//        
//
//
//        
//        
//    }
//}
