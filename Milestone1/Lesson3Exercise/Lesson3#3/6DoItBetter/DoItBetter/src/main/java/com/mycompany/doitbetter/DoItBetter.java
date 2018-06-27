/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.doitbetter;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class DoItBetter {
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        int miles;
        int lang;
        int hotdogs;
                
        System.out.println("How many miles can you run huh??");
        miles = userinput.nextInt();
        System.out.println("How many Languages do you know huh!???");
        lang = userinput.nextInt();
        System.out.println("HOW MANY HOTDOGS CAN YOU EAT!!?!??!");
        hotdogs = userinput.nextInt();
        
        System.out.println("WELL I CAN RUN " + (miles * 2) + 1 + " MILES");
        System.out.println("I ALSO KNOW " + (lang * 2) + 1 + " MANY LANGUAGES");
        System.out.println("I CAN ALSO EAT " + (hotdogs * 2) + 1 + " MANY HOTDOGS");
    }
}
