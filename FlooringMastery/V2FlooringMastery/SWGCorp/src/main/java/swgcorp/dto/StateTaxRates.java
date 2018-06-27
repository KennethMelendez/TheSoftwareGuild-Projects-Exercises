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
public enum StateTaxRates {

    OH(new BigDecimal(6.25)),
    PA(new BigDecimal(6.75)),
    MI(new BigDecimal(5.75)),
    IN(new BigDecimal(6.00));

    BigDecimal TaxRates;

    StateTaxRates(BigDecimal TaxRates) {
        this.TaxRates = TaxRates;
    }
    public BigDecimal getTax(){
        return TaxRates;
    }

}
