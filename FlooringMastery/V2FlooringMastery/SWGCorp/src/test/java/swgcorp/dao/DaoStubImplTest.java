/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.Tax;

/**
 *
 * @author kmlnd
 */
public class DaoStubImplTest {

    Dao test = new DaoStubImpl();

    public DaoStubImplTest() {
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
     * Test of DisplayOrder method, of class DaoStubImpl.
     */
    @Test
    public void testDisplayOrder() {
        int orderNumber = 345893;
        Order currentOrder = new Order(orderNumber);
        currentOrder.setName("Kenny");
        currentOrder.setDate(LocalDate.now());
        currentOrder.setState("MI");
        currentOrder.setArea(new BigDecimal("100"));
        Product tempProduct = new Product("Wood");
        currentOrder.setProduct(tempProduct);
        currentOrder.setMaterialCost(new BigDecimal("600"));
        Tax tempTax = new Tax(new BigDecimal("0.9"));
        currentOrder.setTaxClass(tempTax);
        currentOrder.setTotal(new BigDecimal("9898"));

        test.addOrder(currentOrder.getOrderNumber(), currentOrder);
        assertEquals("Kenny", currentOrder.getName());
    }

    /**
     * Test of addOrder method, of class DaoStubImpl.
     */
    @Test
    public void testAddOrder() {
    }

    /**
     * Test of getOrder method, of class DaoStubImpl.
     */
    @Test
    public void testGetOrder() {
    }

    /**
     * Test of editOrder method, of class DaoStubImpl.
     */
    @Test
    public void testEditOrder() {
    }

    /**
     * Test of removeOrder method, of class DaoStubImpl.
     */
    @Test
    public void testRemoveOrder() {
    }

    /**
     * Test of orderNumberGeneratorAndAssigner method, of class DaoStubImpl.
     */
    @Test
    public void testOrderNumberGeneratorAndAssigner() {
    }

    /**
     * Test of SaveState method, of class DaoStubImpl.
     */
    @Test
    public void testSaveState() throws Exception {
    }

    /**
     * Test of loadSaveState method, of class DaoStubImpl.
     */
    @Test
    public void testLoadSaveState() throws Exception {
    }

    /**
     * Test of saveCurrentSession method, of class DaoStubImpl.
     */
    @Test
    public void testSaveCurrentSession() throws Exception {
    }

    /**
     * Test of getOrderByDate method, of class DaoStubImpl.
     */
    @Test
    public void testGetOrderByDate() {
    }

}
