/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.forandtwentyblackbirds;

/**
 *
 * @author Kenny
 */
public class ForAndTwentyBlackBirds {
    public static void main(String[] args) {
         
        int birdsInPie = 0;
        
        //I increased the number in the for loop in order to reach the result of 24 birds.
        for (int i = 0; i < 24; i++) {
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
        
         
    }

