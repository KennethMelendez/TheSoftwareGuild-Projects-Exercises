/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitals2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author kmlnd
 */
public class StateCapitals2 {
        public void Display(){

            //Alabama Object
            Capital Alabama = new Capital();
            Alabama.setName("Alabama");
            Alabama.setPopulation(205000);
            Alabama.setSquareMileage(156);
            
            //Alaska Object
            Capital Alaska = new Capital();
            Alaska.setName("Alaska");
            Alaska.setPopulation(31000);
            Alaska.setSquareMileage(3255);
            
            //Arizona Object
            Capital Arizona = new Capital();
            Arizona.setName("Phoenix");
            Arizona.setPopulation(1445000 );
            Arizona.setSquareMileage(517);
            
            //Arkansas Object
            Capital Arkansas = new Capital();
            Arkansas .setName("Arkansas ");
            Arkansas .setPopulation(193000);
            Arkansas .setSquareMileage(116);
            
            
            //Calls map
            Map<String,Integer> map = new HashMap<>();
            
            //inputs map
            map.put(Alabama.getName(),Alabama.getPopulation());
            map.put(Alaska.getName(),Alaska.getPopulation());
            map.put(Arizona.getName(),Arizona.getPopulation());
            map.put(Arkansas.getName(),Arkansas.getPopulation());
            
            System.out.println("STATE PAIRS:");
            System.out.println("====================");
      
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                
            String key = entry.getKey();
            Integer value = entry.getValue();
            
                System.out.println(key + " | " + " Population " + value);
            
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the lower limit for capital city population:");
            int userInput = sc.nextInt();
            
                        
            System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + userInput + ":");
            System.out.println("====================");
            
            
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                
            String key = entry.getKey();
            Integer value = entry.getValue();

            
             if(userInput < value){
                 

                 
                    System.out.println(key + " | " + " Population " + value);
                
                }
            }
            
            
    }
}
