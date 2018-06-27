/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.highroller;

/**
 *
 * @author Kenny
 */


//Importing Scanner and Random
import java.util.Scanner;
import java.util.Random;

public class HighRoller {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What number of sides does the dice have?");
        
        int diceSides;
        
        diceSides = userInput.nextInt();
        
        
        Random diceRoller = new Random();

        int rollResult = diceRoller.nextInt(diceSides + 1);

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);
        
        if (rollResult == 1) {
            System.out.println("You rolled a critical failure!");
        } else if (rollResult == diceSides ) {
            System.out.println("You rolled a critical! Nice Job!");
        }
        
        
        
    }
}
