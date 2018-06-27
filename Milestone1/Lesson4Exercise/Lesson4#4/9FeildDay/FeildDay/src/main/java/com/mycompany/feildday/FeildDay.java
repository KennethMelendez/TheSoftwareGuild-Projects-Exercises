/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.feildday;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;

public class FeildDay {
    public static void main(String[] args){
        
        Scanner userInput = new Scanner(System.in);
        String userName;
        
        String baggins = "Baggins";
        String dresden = "Dresdon";
        String howl = "Howl";
        String potter = "Potter";
        String vimes = "Vimes";
        
        //variable used to measure length of string
        //empty string is used to give me the value of string within the compareTo
        String s = "";

        
        System.out.println("What is your last name?");        
        userName = userInput.nextLine();
        
        
        //Creating string lengths for comparisons used below using compareTo
        int userNameValue = userName.compareTo(s);
        int bagginsValue = baggins.compareTo(s);
        int dresdenValue = dresden.compareTo(s);
        int howlValue = howl.compareTo(s);
        int potterValue = potter.compareTo(s);
        int vimesValue = vimes.compareTo(s);
        
        //creating the logical output and outcome of the user
        if (userNameValue < bagginsValue){
            System.out.println("Aha! You're on the team 'Red Dragons'!");
        } else if (userNameValue > bagginsValue && userNameValue < dresdenValue){
            System.out.println("Aha! You're on the team 'Dark Wizards'!");
        } else if (userNameValue > dresdenValue && userNameValue < howlValue){
            System.out.println("Aha! You're on the team 'Moving Castles'!");
        } else if (userNameValue > howlValue && userNameValue < potterValue){
            System.out.println("Aha! You're on the team 'Golden Snitches'!");
        } else if (userNameValue > potterValue && userNameValue < vimesValue){
            System.out.println("Aha! You're on the team 'Night Guards'!");
        } else if (userNameValue > vimesValue){
            System.out.println("Aha! You're on the team 'Black Holes'!");
        }
        
        System.out.println("Good luck in the games!!!!");

  


        
        
        
        
        
        
        
        
    }
}
