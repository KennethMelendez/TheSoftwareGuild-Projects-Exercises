/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.yourlifeinmovies;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class YourLifeInMovies {
    public static void main(String[] args){
        Scanner userinput = new Scanner(System.in);
        int userYear;
        
        System.out.println("What year were you born?!?");
        userYear = userinput.nextInt();
        
        if(userYear < 2005){
            System.out.println("Did you know that Pixar's 'Up' came out half a decade ago?");
        } else if (userYear < 1995){
            System.out.println("And that the first Harry Potter came out over 15 years ago!");
        } else if (userYear < 1985){
            System.out.println("Also, Space Jam came out not last decade, but the one before THAT.");
        } else if (userYear < 1975) {
            System.out.println("The original Jurassic Park release is closer to the lunar landing, than today.");
        } else if (userYear < 1965) {
            System.out.println("MASH has been around for almost half a century!");
        } 
        
        
    }
}
