/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.servicelayer;

import com.sg.vendingmachine.dto.Products;

/**
 *
 * @author kmlnd
 */
public interface VendingMachineServiceLayer {
    Products addProduct(String productIdentification, Products product) throws Exception;
    Products changeInventoryStatus(Products product, int invoNumber)throws Exception;
}
