/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fruitsalad;

/**
 *
 * @author Kenny
 */

import java.util.ArrayList;
public class FruitSalad {
    public static void main(String[] args) {
        
        
        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",  "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
        
        String[] fruitSalad;
        
        // Code Recipe for fruit salad should go here!
        // I used the .contains method!
        int apples = 0;
        int oranges = 0;
        int total = 0;
        int sums = 0;
        for(String fruits: fruit){
            System.out.println(fruits);
            if(fruits.contains("Apple")){
                apples+=1;
                
            } else if(fruits.contains("Orange")){
                oranges+=1;
                
            } else {
                total+=1;
            }
            sums = total + apples + oranges;

        }
        
            System.out.println("We got this many apples " + apples);
            System.out.println("We got this many oranges " + oranges);
            System.out.println("Total fruits " + sums);
        
        
    }    
}

