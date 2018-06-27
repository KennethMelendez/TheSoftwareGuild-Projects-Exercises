/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coinflipper;

/**
 *
 * @author Kenny
 */

import java.util.Random;
public class CoinFlipper {
    public static void main(String[] args) {
        Random randomizer = new Random();                
        
        int coinFlipRandomizer = randomizer.nextInt(2) + 1;
        
        System.out.println("Ready, Set, Flip!!!!!!!!");
        
        if (coinFlipRandomizer == 1){
           System.out.println("Heads!!");
        } else if (coinFlipRandomizer == 2){
           System.out.println("Tails!!!");    
    }

        
    
    }
}
