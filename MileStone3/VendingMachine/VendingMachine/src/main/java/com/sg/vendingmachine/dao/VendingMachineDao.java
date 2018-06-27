/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Products;

/**
 *
 * @author Kenny
 */
public interface VendingMachineDao {

    Products addProduct(String productIdentification, Products product);
    Products changeInventoryStatus(Products product, int invoNumber);
}
