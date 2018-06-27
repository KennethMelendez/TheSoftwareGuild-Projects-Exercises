/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.servicelayer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import swgcorp.dao.Dao;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.Tax;

/**
 *
 * @author kmlnd
 */
public class ServiceLayerStubImplTest {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Dao dao = ctx.getBean("Dao", Dao.class);
    ServiceLayer test = ctx.getBean("ServiceLayer", ServiceLayer.class);

    public ServiceLayerStubImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws RemoveOrderException {

        List<Order> allOrders = test.DisplayOrder();
        for (Order currentOrder : allOrders) {
            test.removeOrder(currentOrder.getOrderNumber());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of DisplayOrder method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testDisplayOrder() {
    }

    /**
     * Test of addOrder method, of class ServiceLayerStubImpl.
     */
    @Test (expected = InvalidStateException.class)
    public void testAddOrder() throws Exception {
        int orderNumber = 345893;
        Order currentOrder = new Order(orderNumber);
        currentOrder.setName("Kenny");
        currentOrder.setDate(LocalDate.now());
        currentOrder.setState("SPonge");
        currentOrder.setArea(new BigDecimal("100"));
        Product tempProduct = new Product("Wood");
        currentOrder.setProduct(tempProduct);
        currentOrder.setMaterialCost(new BigDecimal("600"));
        Tax tempTax = new Tax(new BigDecimal("0.9"));
        currentOrder.setTaxClass(tempTax);
        currentOrder.setTotal(new BigDecimal("9898"));
        test.addOrder(orderNumber, currentOrder);
        
        assertEquals(orderNumber,test.getOrder(orderNumber));
    }

    /**
     * Test of editOrder method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testEditOrder() {
    }

    /**
     * Test of removeOrder method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testRemoveOrder() throws Exception {
    }

    /**
     * Test of orderNumberGeneratorAndAssigner method, of class
     * ServiceLayerStubImpl.
     */
    @Test
    public void testOrderNumberGeneratorAndAssigner() {
    }

    /**
     * Test of getOrder method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testGetOrder() throws Exception {
        Order currentOrder = new Order(29382);
        assertNull(currentOrder.getName());
    }

    /**
     * Test of SaveState method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testSaveState() throws Exception {
    }

    /**
     * Test of loadSaveState method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testLoadSaveState() throws Exception {
    }

    /**
     * Test of saveCurrentSession method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testSaveCurrentSession() throws Exception {
    }

    /**
     * Test of getOrderByDate method, of class ServiceLayerStubImpl.
     */
    @Test
    public void testGetOrderByDate() {
    }

}
