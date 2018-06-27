/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

/**
 *
 * @author kmlnd
 */
public enum Currency {
   
    
   PENNIES("0.01"),DIMES("0.10"),NICKELS("0.05"),QUARTERS("0.25");

   private String value;
   
   Currency(String value){
       this.value = value;
   }
   public String getValue(){
       return value;
   }
   
   
}
