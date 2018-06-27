/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.Tax;
import swgcorp.servicelayer.InvalidOrderNumberException;
import swgcorp.servicelayer.InvalidStateException;
import swgcorp.servicelayer.RemoveOrderException;
import swgcorp.servicelayer.ServiceLayer;
import swgcorp.servicelayer.ServiceLayerImpl;

/**
 *
 * @author kmlnd
 */
public class DaoTest {
    
    Dao dao = new DaoImpl();
    ServiceLayer test = new ServiceLayerImpl(dao);

    public DaoTest() {
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
     * Test of DisplayOrder method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testDisplayOrders() {
        assertEquals(0, test.DisplayOrder().size());
    }

    /**
     * Test of addOrder method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testAddOrder() throws Exception {
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
        test.addOrder(orderNumber, currentOrder);
        assertEquals(1, test.DisplayOrder().size());
    }

    /**
     * Test of removeOrder method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testRemoveOrder() throws Exception {
        int orderNumber = 345893;
        test.removeOrder(orderNumber);
        assertEquals(0, test.DisplayOrder().size());
    }

    /**
     * Test of getOrder method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testGetOrder() throws Exception {
        int orderNumber = 90;

        Order currentOrder = new Order(orderNumber);
        currentOrder.setName("Bob The Builder");
        currentOrder.setDate(LocalDate.now());
        currentOrder.setState("MI");
        currentOrder.setArea(new BigDecimal("100"));
        Product tempProduct = new Product("Wood");
        currentOrder.setProduct(tempProduct);
        currentOrder.setMaterialCost(new BigDecimal("600"));
        Tax tempTax = new Tax(new BigDecimal("0.9"));
        currentOrder.setTaxClass(tempTax);
        currentOrder.setTotal(new BigDecimal("9898"));
        test.addOrder(orderNumber, currentOrder);

        Order gettingOrder = test.getOrder(orderNumber);

        assertEquals(gettingOrder.getName(), currentOrder.getName());
    }

    /**
     * Test of orderNumberGeneratorAndAssigner method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testOrderNumber() throws InvalidStateException, PersistenceException {
        int nums = 5;
        Order currentOrder = new Order(nums);
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
   
        assertEquals(5, currentOrder.getOrderNumber());
    }

    /**
     * Test of SaveState method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testSaveState() throws Exception {
    }

    /**
     * Test of loadSaveState method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testLoadSaveState() throws Exception {
    }

    /**
     * Test of saveCurrentSession method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testSaveCurrentSession() throws Exception {
    }

    /**
     * Test of getOrderByDate method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testGetOrderByDate() throws InvalidStateException, PersistenceException, InvalidOrderNumberException {
        int orderNumber = 934590;
        LocalDate date = LocalDate.of(1992, 02, 21);

        Order currentOrder = new Order(orderNumber);
        currentOrder.setName("Spiderman");
        currentOrder.setDate(date);
        currentOrder.setState("MI");
        currentOrder.setArea(new BigDecimal("100"));
        Product tempProduct = new Product("Wood");
        currentOrder.setProduct(tempProduct);
        currentOrder.setMaterialCost(new BigDecimal("600"));
        Tax tempTax = new Tax(new BigDecimal("0.9"));
        currentOrder.setTaxClass(tempTax);
        currentOrder.setTotal(new BigDecimal("9898"));

        test.addOrder(orderNumber, currentOrder);

        test.getOrderByDate("1992-02-21").size();
        assertEquals(1, test.getOrderByDate("1992-02-21").size());
    }

    }
    

