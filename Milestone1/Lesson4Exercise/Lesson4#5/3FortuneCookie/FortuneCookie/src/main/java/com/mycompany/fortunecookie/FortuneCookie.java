/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fortunecookie;

/**
 *
 * @author Kenny
 */

import java.util.Random;
public class FortuneCookie {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        System.out.println("Here is a random Response");
        
        int randomResponse = randomizer.nextInt(11);
//        System.out.println(randomResponse);
        
        
        if( randomResponse == 1 ){
             System.out.println("Those aren’t the droids you’re looking for.");
        } else if ( randomResponse == 2 ){
            System.out.println("Never go in against a Sicilian when death is on the line!");
        } else if ( randomResponse == 3 ){
            System.out.println("Goonies never say die.");
        } else if ( randomResponse == 4 ) {
            System.out.println("With great power there must also come — great responsibility.");
        } else if ( randomResponse == 5 ) {
            System.out.println("Never argue with the data.");
        } else if ( randomResponse == 6 ) {
            System.out.println("Try not. Do, or do not. There is no try.");
        } else if ( randomResponse == 7 ) {
            System.out.println("You are a leaf on the wind, watch how you soar.");
        } else if ( randomResponse == 8 ) {
            System.out.println("Do absolutely nothing, and it will be everything that you thought it could be.");
        } else if ( randomResponse == 9 ) {
            System.out.println("Kneel before Zod.");
        } else if ( randomResponse == 10 ) {
            System.out.println("Make it so.");
        }
      }   
    }
        
        
