/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lazyteenager;

/**
 *
 * @author Kenny
 */

//import java.util.Scanner;
import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        
        int chancesOfHimCleaningHisRoom = 0;
        boolean didHeCleanHisRoom = false;
        int timesToldToCleanHisRoom = 0;
        
        double oneHundredPercent = 1;
        
        //formula for creating a percentage outcome
        int randomizedNums = randomizer.nextInt(5) + 1;
        double resultToPercent = randomizedNums / 100.0;
//        System.out.println(resultToPercent + "what");
        
        
        do{
                timesToldToCleanHisRoom++;
                System.out.println("CLEAN YOUR ROOM!!! " + " x" + "(" + timesToldToCleanHisRoom + ")");
                resultToPercent+=resultToPercent;
                
                if(resultToPercent >= oneHundredPercent){
                    System.out.println("FINE, ILL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEASE.");
                    break;
                    
                }
            
        }while(timesToldToCleanHisRoom < 15);
        
        if (timesToldToCleanHisRoom == 15){
        System.out.println("THATS IT, I'm doing it!!! You're grounded and I'm taking your Xbox!!!");
    }
   }
}
