/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.minimadlibs;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class MiniMadLibs {
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        
        System.out.println("Give me a noun!!");
        String noun = userinput.nextLine();
        System.out.println("Give me a adj!!");
        String adj = userinput.nextLine();
        System.out.println("Give me a number!!!!!");
        int number = userinput.nextInt();
        
        System.out.println("So I heard you like " + noun + " during a " + adj + " day while eating " + number + " hot dogs...");
        
        
    }
}
