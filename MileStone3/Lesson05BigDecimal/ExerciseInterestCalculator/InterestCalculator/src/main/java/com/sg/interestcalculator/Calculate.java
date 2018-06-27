/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author kmlnd
 */
public class Calculate {
    
    /*
    FORMULA : CurrentBalance * (1 + (QuarterlyInterestRate / 100))
    */
    public BigDecimal calculate(BigDecimal CURRENTBALANCE,BigDecimal QUARTERLYINTERESTRATE){
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal one = new BigDecimal("1");
        BigDecimal step1 = QUARTERLYINTERESTRATE.divide(hundred,2,RoundingMode.HALF_UP);
        BigDecimal step2 = one.add(step1);
        BigDecimal step3 = CURRENTBALANCE.multiply(step2);
        BigDecimal result = step3;
        return result;
    }
}
