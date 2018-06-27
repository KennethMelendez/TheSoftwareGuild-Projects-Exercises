/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.knockknock;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args) {
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock Knock! Guess who!! ");
        String nameGuess = inputReader.nextLine();

        
        //With Java you have to be more specific with user output so i created and defined both oucomes for the user in the if statement
        
        if(nameGuess.equals("Marty McFly") || nameGuess.equals("marty mcfly") ){
            System.out.println("Hey! That's right! I'm back!");
            System.out.println(".... from the Future."); // Sorry, had to!

        }else{
            System.out.println(nameGuess + " Dude, do I -look- like ");
        }
        
     
        
        
        
        
    }
}
