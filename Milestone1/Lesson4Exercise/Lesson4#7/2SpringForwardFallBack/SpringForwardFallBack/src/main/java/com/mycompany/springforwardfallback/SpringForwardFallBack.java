/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springforwardfallback;

/**
 *
 * @author Kenny
 */
public class SpringForwardFallBack {
    public static void main(String[] args) {
        
        
        //the start output for both loops are from 1 - 10
        //Updated loop #1 so that it prints out the same range as loop #2
        System.out.println("It's Spring...!");
        for (int i = 1; i < 11; i++) {
            System.out.print(i + ", ");
        }
        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
        
        
        
    }
}
