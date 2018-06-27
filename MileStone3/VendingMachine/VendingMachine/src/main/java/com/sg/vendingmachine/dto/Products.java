/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

/**
 *
 * @author Kenny
 */
public class Products {
    /*
    Product Identification
    Item name
    Item cost
    Number of items in inventory    
     */
    
    private String productName;
    private String cost;
    private int numberOfItemsInInventory;
    private String productIdentification;

    public Products(String productIdentification) {
        this.productIdentification = productIdentification;
    }

    
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getNumberOfItemsInInventory() {
        return numberOfItemsInInventory;
    }

    public void setNumberOfItemsInInventory(int numberOfItemsInInventory) {
        this.numberOfItemsInInventory = numberOfItemsInInventory;
    }

    public String getProductIdentification() {
        return productIdentification;
    }
}
