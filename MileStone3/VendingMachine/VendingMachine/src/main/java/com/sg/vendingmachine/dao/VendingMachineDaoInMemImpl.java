/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Products;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kenny
 */
public class VendingMachineDaoInMemImpl implements VendingMachineDao {

    Map<String, Products> productMap = new HashMap<>();

    @Override
    public Products addProduct(String productIdentification, Products product) {
        Products newProduct = productMap.put(productIdentification, product);
        return newProduct;
    }

    @Override
    public Products changeInventoryStatus(Products product, int invoNumber) {
       product.setNumberOfItemsInInventory(invoNumber);      
       return product;
    }

    


   

}
