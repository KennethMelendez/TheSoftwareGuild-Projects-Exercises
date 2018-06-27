/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.differentkettleoffish;

/**
 *
 * @author Kenny
 */
public class DifferentKettleOfFish {
    public static void main(String[] args) {
        
        //NEW CODE AS FOR LOOP
        int fish = 1;
        for(int x = 0; fish < 11; x++){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }
            
            fish++;
        
        
        
        //ORIGINAL CODE
//        int fish = 1;
//        while(fish < 10){
//            if(fish == 3){
//                System.out.println("RED fish!");
//            }else if(fish == 4){
//                System.out.println("BLUE fish!");
//            } else{
//                System.out.println(fish + " fish!");
//            }
//            
//            fish++;
//            
//            
            
            
            
            
        }
        
        
        
        
        
    }
}

