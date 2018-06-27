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
public class Product {
    
    private String productType;
    private BigDecimal costPerSqFt;
    private BigDecimal LaborCostPerSqFt;

    public Product (String productType){
        this.productType = productType;
    }
    
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return LaborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal LaborCostPerSqFt) {
        this.LaborCostPerSqFt = LaborCostPerSqFt;
    }
    
    
    
}
