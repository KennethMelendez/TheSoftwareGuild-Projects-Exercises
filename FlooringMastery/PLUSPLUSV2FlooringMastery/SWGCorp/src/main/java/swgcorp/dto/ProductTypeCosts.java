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
public enum ProductTypeCosts {
    CARPET(new BigDecimal("2.25"),new BigDecimal("2.10")),
    LAMINATE(new BigDecimal("1.75"),new BigDecimal("2.10")),
    TILE(new BigDecimal("3.50"),new BigDecimal("4.15")),
    WOOD(new BigDecimal("5.15"),new BigDecimal("4.75"));
    
    BigDecimal CostPerSquareFoot;
    BigDecimal LaborCostPerSquareFoot;
    
    
    ProductTypeCosts(BigDecimal CostPerSquareFoot, BigDecimal LaborCostPerSquareFoot) {
        this.CostPerSquareFoot = CostPerSquareFoot;
        this.LaborCostPerSquareFoot = LaborCostPerSquareFoot;
    }
    
    /*
        Get the value of cost per Square foot and cost per square
        Below is our GETTERS The constructor above is setting the value of the enums
    */
    
    public BigDecimal getCostPerSquareFoot() {
        return CostPerSquareFoot;
    }

    public BigDecimal getLaborCostPerSquareFoot() {
        return LaborCostPerSquareFoot;
    }

}
