/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class Order {

    private int orderNumber;
    private String name;
    private BigDecimal area;
    private String state;
    private BigDecimal materialCost;
    private BigDecimal total;
    private LocalDate date;

    private Product productClass;
    private Tax taxClass;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

//    public BigDecimal getTax() {
//        return taxClass;
//    }
//
//    public void setTax(BigDecimal taxClass) {
//        this.taxClass = taxClass;
//    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // DTOS composition classes
    public Product getProduct() {
        return productClass;
    }

    public void setProduct(Product productClass) {
        this.productClass = productClass;
    }

    public Tax getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(Tax taxClass) {
        this.taxClass = taxClass;
    }
    
    @Override
    public String toString(){
        return "Date : " + date + " Order number : " + orderNumber + " Name : " + name + " Area : " + " Product type : " + productClass.getProductType() + " Product CostPerSqFt : " + productClass.getCostPerSqFt() + " Product Labor CostPerSqFt : " + productClass.getLaborCostPerSqFt() + " Tax : " + taxClass.getStateTax() + " TaxRate : " + taxClass.getTaxRate() + area + " State : " + state + " Material cost : " + materialCost + " Total : " + total; 
    }
    


}
