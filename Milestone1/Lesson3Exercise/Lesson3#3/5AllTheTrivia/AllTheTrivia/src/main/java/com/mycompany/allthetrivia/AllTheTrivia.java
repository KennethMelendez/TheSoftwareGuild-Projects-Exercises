/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.allthetrivia;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class AllTheTrivia {
    public static void main(String[] args) {
        
        String hat;
        String weapon;
        String potatoe;
        
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("What color is Super Mario's Hat!");
        hat = userInput.nextLine();
        System.out.println("What is Links favorite weapon from The Legend Of Zelda???");
        weapon = userInput.nextLine();
        System.out.println("What is a potatoe???");
        potatoe = userInput.nextLine();
        
        System.out.println("WOW I didnt know marios hat is " + potatoe);
        System.out.println("WOW, who knew that Links favorate weapon is " + hat);
        System.out.println("No way.....I had no idea a potatoe was a" + weapon);
   
        
        
    }
}
