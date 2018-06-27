/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.healthyhearts;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        
        int age;
  
        
        System.out.println("What is your age?");
        age = userInput.nextInt();
        int heartRate = 220 - age;
        System.out.println("Your maximum heart rate should be " + heartRate + " beats per minute");
        System.out.println("Your target HR Zone is %" + (heartRate * .50) + " - %" + (heartRate * .85));
        
        
        
        
        
    }
}
