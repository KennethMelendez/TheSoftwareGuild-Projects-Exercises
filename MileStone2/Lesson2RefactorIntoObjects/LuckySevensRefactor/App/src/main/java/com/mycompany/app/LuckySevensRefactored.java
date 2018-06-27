/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
class LuckySevensRefactored {
     public void Run(){
         
        //Greet the user and ask for a response 
        Greetings();
        int dollars = ConsoleIO.PromptUserInt("How many dollars do you have?");
        
        //The program keeps track of how many rolls were taken before the money ran out.
        int rollCount = 0;
        //The program keeps track of the maximum amount of money held by the player.
        int maxMoney = 0;
        //The program keeps track of how many rolls were taken at the point when the user held the most money.
        int rollCountMax = 0;
        
        do{
            int diceRoll = dice();
            int secondDiceRoll = dice();
            
            int resultRolls = diceRoll + secondDiceRoll;
            

            
            if(resultRolls == 7){
                dollars+=4;
                rollCount++;
                maxMoney++;
                rollCountMax++;
                

            }else{
                dollars--;
                rollCount++;
            }
            
            rollCountMax = rollCount - maxMoney;
            
        }while(dollars > 0);
                
        results(rollCount,maxMoney,rollCountMax);
         
     }
     
     public static void Greetings(){
        System.out.println("WELCOME to Lucky Sevens");
        System.out.println("How much cash yah got to play huh?");
     }
     
     public static void results(int rollCount,int maxMoney, int rollCountMax){
        System.out.println("Wow you are broke after " + rollCount + " rolls");
        System.out.println("The highest amount of money you made was $" + maxMoney + " before being broke");
        System.out.println("You should have stopped after " + rollCountMax + " rolls..");
     }
     
    public static int dice(){
        Random randomizer = new Random();
        int dice = randomizer.nextInt(7)+ 1;
        return dice;
    }
}
