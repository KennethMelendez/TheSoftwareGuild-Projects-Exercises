/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Products;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kmlnd
 */
public class VendingMachineDaoTest {

    List<Products> list = new ArrayList<>();
    
    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct method, of class VendingMachineDao.
     */
    @org.junit.Test
    public void testAddProduct() {

        Products hersheys = new Products("A6");
        hersheys.setCost("2.00");
        hersheys.setNumberOfItemsInInventory(5);
        hersheys.setProductName("Hersheys");
        list.add(hersheys);
        
        Products popcorn = new Products("B6");
        hersheys.setCost("2.00");
        hersheys.setNumberOfItemsInInventory(5);
        hersheys.setProductName("Popcorn");
        list.add(popcorn);
        assertEquals(2,list.size());
        
    }

}
