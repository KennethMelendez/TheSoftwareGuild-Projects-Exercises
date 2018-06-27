/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessmefinally;

/**
 *
 * @author Kenny
 */
import java.util.Scanner;
import java.util.Random;
public class GuessMeFinally {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomizer = new Random();
        
        //Retrying Project
        //Psuedo-code
        
        //Number guessing program
        //Guess a number from -100 and 100
        //if they get it print "WOW, nice guess!,That was it"
        //Otherwise "finally, it's about time you got it!

        System.out.println("Give me a number from -100 - 100");
        int userNum = input.nextInt();
        int randomNums = randomizer.nextInt(100) + - 100;
//        System.out.println(randomNums);
        
        do{
            if(userNum == randomNums){
                System.out.println("Wow, Nice Guess!!!! That was it.");                
            } else if (userNum >= randomNums){
                System.out.println("Nice try ...too high try again!");
                userNum = input.nextInt();
            } else if (userNum <= randomNums){
                System.out.println("Nice try....too low..try again!!");
                userNum = input.nextInt();
            } else {
                System.out.println("Woah what?");
                userNum = input.nextInt();
            }
        } while(userNum != randomNums);
        
        if(userNum == randomNums){
            System.out.println("Finally, you got it!");
        }
        
    }
}
