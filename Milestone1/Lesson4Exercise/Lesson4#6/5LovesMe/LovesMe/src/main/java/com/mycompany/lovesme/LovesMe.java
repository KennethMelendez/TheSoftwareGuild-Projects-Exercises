/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lovesme;

/**
 *
 * @author Kenny
 */
public class LovesMe {
    public static void main(String[] args) {
      int pedals = 0;
      int NumberOfPedals = 34;
      
      while(pedals < NumberOfPedals){
//         
          pedals++;
//          System.out.println(pedals);
          
          
          if((pedals % 2) == 0){
              System.out.println("IT LOVES ME!!!");
              //even
          }
          
          else{
          System.out.println("It Loves me NOT.....");
              //odd
        }
      }
    }
}
      
    

