/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trivianight;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class TriviaNight {
    public static void main(String[] args){
        
        Scanner userInput = new Scanner(System.in);
        int score = 1;
        
        System.out.println("TIME FOR SOME.......TRIVIAAAAAAA WOOOO!!!!");
        
        System.out.println("QUESTION 1...What was the first ever video game console??");
        System.out.println("1.) The NES");
        System.out.println("2.) The XBOX");
        System.out.println("3.) the Magnavox Odyssey");
        int answerOne = userInput.nextInt();
        if (answerOne == 3){
          score+=1; 
        }
        
        System.out.println("QUESTION 2...What color is Pikachu???");
        System.out.println("1.) Orange");
        System.out.println("2.) Yellow");
        System.out.println("3.) It has no color");
        int answerTwo = userInput.nextInt();
        if (answerOne == 2){
          score+=1;  
        }
        
        
        System.out.println("QUESTION 3 LAST ONE...Who is one of the founders of Microsoft???");
        System.out.println("1.) SpongeBob");
        System.out.println("2.) DoomGuy");
        System.out.println("3.) Bill Gates");
        int answerThree = userInput.nextInt();
        if (answerOne == 3){
          score+=1;  
        }
        
        System.out.println(" You have " + score + " questions correct out of 3!!!");

        
    }
}
