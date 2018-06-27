/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessme;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class GuessMe {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        
        int guessedNumber = 50;
        int userNums;
        
        System.out.println("Guess my number Bwuahahahahah!!!!!!");
        userNums = userInput.nextInt();
        
        if (userNums <= guessedNumber){
            System.out.println("HAAA YOU GUESSED TOO LOW....MY NUMBER WAS " + guessedNumber);
        } else if (userNums >= guessedNumber){
            System.out.println("HHAHAHAHAHA you guessed too HIGHH!!! My NUMBER was...." + guessedNumber);
    }
        
    }
}
