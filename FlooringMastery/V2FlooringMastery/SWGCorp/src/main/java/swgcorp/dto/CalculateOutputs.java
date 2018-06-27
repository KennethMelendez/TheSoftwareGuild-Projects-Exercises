/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dto;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.Tax;

/**
 *
 * @author kmlnd
 */
public class CalculateOutputs {

    public Order calculateTotal(Product currentProduct,Order currentOrder){
        
        
/*================================================================================================
        
                Calculating total and setting them into the dto
        
================================================================================================*/
//Getting the area from the dto

        BigDecimal areaConversion = currentOrder.getArea();
        
//rewriting method

        BigDecimal gettingcostPerSqFT = currentProduct.getCostPerSqFt();
        BigDecimal costPerSqFT = gettingcostPerSqFT.multiply(areaConversion);

//multiplying area with cost per square feet

        BigDecimal LaborCostPerSqFT = currentOrder.getProduct().getLaborCostPerSqFt().multiply(areaConversion);
        
//converting percentage to decimal

        BigDecimal percentageConversion = currentOrder.getTaxClass().getTaxRate();
        BigDecimal taxToDecimal = percentageConversion.divide(new BigDecimal("100"));
        
//add total costpersqfoot and labor and times it by tax
       
//adding costs

        BigDecimal addedCostPerSqFT = costPerSqFT.add(LaborCostPerSqFT);
        
//material cost
        currentOrder.setMaterialCost(addedCostPerSqFT);
        
//multiplaying tex decimal to added cost

        BigDecimal TAX = addedCostPerSqFT.multiply(taxToDecimal).setScale(2,HALF_UP);
        
//Setting the tax in my dto
        
        currentOrder.getTaxClass().setStateTax(TAX);
        
//totalcost

        BigDecimal TOTAL = addedCostPerSqFT.add(TAX);
        currentOrder.setTotal(TOTAL);
        
        return currentOrder;
    }
    
    
    

}
