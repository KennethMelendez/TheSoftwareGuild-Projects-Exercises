/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.traditionalfizzbuzz;

/**
 *
 * @author Kenny
 */

import java.util.Scanner;
public class TraditionalFizzBuzz {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Give me a number!!!");
        int userInput = input.nextInt();
        
        
        for(int n = 0; n < userInput + 1; n++){
         
            if(n % 3 == 0 && n % 5 == 0){
                System.out.println("FizzBuzz");
            } else if (n % 3 == 0){
                System.out.println("fizz");
            } else if (n % 5 == 0){
                System.out.println("buzz");
            }
       
        }
        
        System.out.println("TRADITION!!!!!");

    }
    
}
