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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import swgcorp.dto.ConfigSettings;
import swgcorp.dto.Customer;
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

    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Dao dao = ctx.getBean("Dao", Dao.class);
    ServiceLayer test = ctx.getBean("ServiceLayer", ServiceLayer.class);

    //Dao dao = new DaoImpl();
    //ServiceLayer test = new ServiceLayerImpl(dao);
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

        List<Customer> allCustomers = test.viewCustomers();

        for (Customer currentCustomer : allCustomers) {
            dao.removeCustomer(currentCustomer.getPhoneNumber());
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

    /**
     * Test of saveCurrentSession method, of class ServiceLayer.
     */
    @org.junit.Test
    public void testAddingCustomer() throws Exception {
        String phoneNumber = "000-000-0000";

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

        assertEquals(currentOrder.getName(), "Spiderman");

        Customer customer = new Customer(phoneNumber/*, currentOrder*/);
        customer.addOrder(currentOrder);
        //assertEquals("Spiderman",customer.getCurrentOrder(orderNumber).getName());
        assertEquals(1, customer.allOrders().size());

        int orderNumber2 = 70;
        LocalDate date2 = LocalDate.of(1992, 02, 21);

        Order currentOrder2 = new Order(orderNumber2);
        currentOrder2.setName("Mario");
        currentOrder2.setDate(date);
        currentOrder2.setState("PA");
        currentOrder2.setArea(new BigDecimal("100"));
        Product tempProduct2 = new Product("Wood");
        currentOrder2.setProduct(tempProduct2);
        currentOrder2.setMaterialCost(new BigDecimal("600"));
        Tax tempTax2 = new Tax(new BigDecimal("0.9"));
        currentOrder2.setTaxClass(tempTax2);
        currentOrder2.setTotal(new BigDecimal("9898"));

        customer = new Customer(phoneNumber/*,currentOrder2*/);
        customer.addOrder(currentOrder);
        customer.addOrder(currentOrder2);
        assertEquals(2, customer.allOrders().size());

        test.addCUSTOMER(phoneNumber, customer);
        //test.addCUSTOMER(phoneNumber, currentOrder2);
        assertEquals(1, dao.viewCustomers().size());

        
               // String phoneNumber = "000-000-0000";
        //Customer currentCustomer = test.getCustomer(phoneNumber);
        
        assertEquals("000-000-0000",test.getCustomer(phoneNumber).getPhoneNumber());
        assertEquals(2,test.getCustomer(phoneNumber).allOrders().size());
    }
    
    @org.junit.Test
    public void testGettingCustomer() throws Exception {
//        String phoneNumber = "000-000-0000";
//        //Customer currentCustomer = test.getCustomer(phoneNumber);
//        
//        assertEquals(1,test.getCustomer(phoneNumber));

    }

}
