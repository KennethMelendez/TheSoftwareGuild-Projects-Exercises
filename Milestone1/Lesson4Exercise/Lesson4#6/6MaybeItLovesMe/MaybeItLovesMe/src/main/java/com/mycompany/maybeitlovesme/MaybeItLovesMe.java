/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.maybeitlovesme;

import java.util.Random;

/**
 *
 * @author Kenny
 */
public class MaybeItLovesMe {
    public static void main(String[] args) {
        
        
            Random randomizer = new Random();
    
//    int min = randomizer.nextInt(13) + 1;
//    int max = randomizer.nextInt(89) + 1;
    int randomPedals = randomizer.nextInt(89) + 13;
    
    boolean lovesMe;
    
    int pedalsNums = 13;
        
        do{
            pedalsNums++;
            //can use & if an integer
            if ((pedalsNums & 2) == 0){
                System.out.println("IT LOVES ME!!!");
                lovesMe = true;
            } else {
                System.out.println("It loves me not..");
                lovesMe = false;
            }           

            pedalsNums++;
        }while(pedalsNums < randomPedals);
        
        if(!lovesMe){
            System.out.println("Awwww....bummer");
        }
    }
}
