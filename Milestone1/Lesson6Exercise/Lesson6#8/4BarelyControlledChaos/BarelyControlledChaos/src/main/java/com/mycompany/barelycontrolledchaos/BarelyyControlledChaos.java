/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.barelycontrolledchaos;

/**
 *
 * @author Kenny
 */

import java.util.Random;
public class BarelyyControlledChaos {
    public static void main(String[] args) {
        
        
        String color = color(); // call color method here 
   
        String animal = animal(); // call animal method again here 
   
        String colorAgain = color(); // call color method again here 
 
        int weight = randomNumbers(200,5); // call number method, 
//            // with a range between 5 - 200 
        int distance = randomNumbers(200,5);// call number method, 
//            // with a range between 10 - 20 
        int number = randomNumbers(20000,10000);// call number method, 
//            // with a range between 10000 - 20000 
        int time = randomNumbers(6,2);// call number method, 
//            // with a range between 2 - 6            
//    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    } 
    
    // ??? Method 1 ??? 
    public static String color(){
        Random randomizer = new Random();
        int random = randomizer.nextInt(5) + 1;
        String red = "red";
        String blue = "blue";
        String orange = "orange";
        String yellow = "yellow";
        String pink = "pink";
        String ColorOutput = null;
        
        if (random == 1){
            ColorOutput = red;
        } else if(random == 2){
            ColorOutput = blue;
        } else if(random == 3){
            ColorOutput = orange;
        } else if (random == 4){
            ColorOutput = yellow;
        } else if (random == 5){
            ColorOutput = pink;
        }
        return ColorOutput;
        
        
    }

    
    // ??? Method 2 ??? 
        public static String animal(){
        Random randomizer = new Random();
        int random = randomizer.nextInt(5) + 1;
        String red = "Rabbit";
        String blue = "Squid";
        String orange = "Tiger";
        String yellow = "Mouse";
        String pink = "Bird";
        String ColorOutput = null;
        
        if (random == 1){
            ColorOutput = red;
        } else if(random == 2){
            ColorOutput = blue;
        } else if(random == 3){
            ColorOutput = orange;
        } else if (random == 4){
            ColorOutput = yellow;
        } else if (random == 5){
            ColorOutput = pink;
        }
        return ColorOutput;
        
        
    }
    // ??? Method 3 ??? 
    public static int randomNumbers(int maximum, int minimum){
        Random randomizer = new Random();
//        Random randomizer2 = new Random();
        
        
        int random = randomizer.nextInt(maximum)+ minimum;
//        int y = randomizer2.nextInt();
//        int result = x + y;
        return random;
    }
        
    }


