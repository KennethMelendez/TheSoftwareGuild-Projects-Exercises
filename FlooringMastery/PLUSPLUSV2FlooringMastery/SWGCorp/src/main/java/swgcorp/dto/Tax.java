/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dto;

import java.math.BigDecimal;

/**
 *
 * @author kmlnd
 */
public class Tax {
    private BigDecimal stateTax;
    private BigDecimal taxRate;

    public Tax(BigDecimal taxRate){
        this.taxRate = taxRate;
      
    }
    
    public BigDecimal getStateTax() {
        return stateTax;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setStateTax(BigDecimal stateTax) {
        this.stateTax = stateTax;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    
    
}
