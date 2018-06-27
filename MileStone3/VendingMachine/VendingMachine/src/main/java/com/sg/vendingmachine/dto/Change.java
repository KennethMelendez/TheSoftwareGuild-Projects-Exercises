/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Kenny
 */
public class Change {
    
    public String calculateChange(String userMoney,Products product){
        
        BigDecimal userAmount = new BigDecimal(userMoney);
        BigDecimal productPrice = new BigDecimal(product.getCost());
       
        BigDecimal change = userAmount.subtract(productPrice);
        
        return change.toString();
    }
    
}
