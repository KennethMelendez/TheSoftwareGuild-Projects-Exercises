/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import swgcorp.dto.Customer;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.StateTaxRates;
import swgcorp.dto.Tax;

/**
 *
 * @author kmlnd
 */
public class DaoImpl implements Dao {

    Map<Integer, Order> Inventory = new HashMap<>();
    //this hashmap is for items in your current cart
    List<Order> itemsForCheckout = new ArrayList<>();
    //create hashmap for users. check if phone numbers taken or not then modify based on results

    public static final String DELIMETER = "::";

    public LocalDate date = LocalDate.now();
    public String ROSTER_FILE = "ORDERS.txt"/* + date.toString() + ".txt"*/;
    public String ROSTER_FILE_CUSTOMER = "CUSTOMERS.txt"/* + date.toString() + ".txt"*/;
    /*
        creating hashmap for the customers
     */
    Map<String, Customer> customerOrders = new HashMap<>();
    //public static final String ROSTER_FILE = "ORDERS_YYYYMMDD.txt";

    /**
     *
     */
    private int orderNumber = 0;
    private int removedOrdersCount;

    /*
    
        --------**Things to do**-----------
    
        Add Lambdas, Streams and Aggregate Operations into methods instead of conventional methods***
    
        For display order use .get(Date); <-which will be a string
        For add order use .put() 
        for edit order make sure to prompt and edit and delete
        remove order is simple .remove function from the hashmap.
        Finish up the save state
        ** Add more ascii art http://www.chris.com/ascii/
     */
    @Override
    public List<Order> DisplayOrder() {
        return new ArrayList<>(Inventory.values());
    }

    /*
        getting the order by date TESTTEST TEST
     */
    public List<Order> getOrderByDate(String date) {
        return Inventory.values()
                .stream()
                .filter(s -> s.getDate().toString().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public Order editOrder(int identifier, Order order) {

        Order currentOrder = Inventory.put(identifier, order);
        try {
            SaveState();
        } catch (PersistenceException ex) {
            ex.getMessage();
        }
        return currentOrder;
    }

    @Override
    public Order getOrder(int identifier) {
        Order currentOrder = Inventory.get(identifier);
        return currentOrder;
    }

    @Override
    public void removeOrder(int identifier) {
        removedOrdersCount++;
        Inventory.remove(identifier);
    }

    @Override
    public void addOrder(int identifier, Order order) {
        Inventory.put(identifier, order);
    }

    /*==================================================
    
    Costumer Logic
    
    ===================================================*/
    @Override
    public void addCUSTOMER(String phoneNumber, Customer currentCustomer) {    //CUSTOMER
        customerOrders.put(phoneNumber, currentCustomer);
    }

    @Override
    public Customer getCustomer(String phoneNumber) {
        return customerOrders.get(phoneNumber);
    }

    @Override
    public void removeCustomer(String phoneNumber) {
        customerOrders.remove(phoneNumber);
    }

    @Override
    public List<Customer> viewCustomers() {
        return new ArrayList<>(customerOrders.values());
    }

    @Override
    public int orderNumberGeneratorAndAssigner() {

        /*
            int nums = Inventory.size(); 
            
            The purpose of this int is to get the size of the hashmap
            which would serve as the product ID for the most
            recent Order.
         */
        int nums = Inventory.size();

        /*
            Order currentOrder = this.getOrder(nums);
        
            I am not "Getting" the order number by its identifier using the nums variable
            which contains the order ID for the most recent order
         */
        Order currentOrder;
        int newNumber = 0;
        if (this.getOrder(nums) == null) {
            nums = 0;
        } else {
            currentOrder = this.getOrder(nums);
            newNumber = currentOrder.getOrderNumber();
        }

        //Order currentOrder = this.getOrder(nums);

        /*
            Below im assigning my current order ID and adding it by one in order to generate
            the next number
         */
        int lastObjectOrderNumber = newNumber;
        lastObjectOrderNumber += 1;

        /*
            I am now returning our new number!
         */
        return lastObjectOrderNumber + removedOrdersCount;
    }

    /*=======================================================================================
            Display current Orders to the user
=======================================================================================*/
    //adding order to cart
    @Override
    public void addToCart(Order currentOrder) {
        itemsForCheckout.add(currentOrder);
    }

    //viewing the cart orders
    @Override
    public List<Order> viewCartOrders() {
        return itemsForCheckout;
    }

    //clearing out the cart for next order
    @Override
    public void clearOutCartForNextPurchase() {
        //using the built in clear method to remove all objects
        itemsForCheckout.clear();
    }

    /*=======================================================================================
            LOAD AND SAVESTATE ****FINISH LATER AFTER CREATING THE PRODUCTS****
=======================================================================================*/
    @Override
    public void loadSaveState() throws PersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("File not found", e);
        }

        String currentLine;
        String[] currentToken;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentToken = currentLine.split(DELIMETER);

            Order currentOrder = new Order(Integer.parseInt(currentToken[0]));

            currentOrder.setDate(LocalDate.parse(currentToken[1]));
            currentOrder.setName(currentToken[2]);
            currentOrder.setState(currentToken[3]);
            currentOrder.setArea(new BigDecimal(currentToken[4]));
//            currentOrder.getProduct().setProductType(currentToken[5].toUpperCase());

            Product newProduct = new Product(currentToken[5].toUpperCase());
            currentOrder.setProduct(newProduct);

            //currentOrder.getProduct().setProductType(currentToken[5]);
            currentOrder.setMaterialCost(new BigDecimal(currentToken[6]));

            Tax newTax = new Tax(new BigDecimal(currentToken[7]));
            //currentOrder.getTaxClass().setTaxRate(new BigDecimal(currentToken[7]));
            currentOrder.setTaxClass(newTax);
            currentOrder.setTotal(new BigDecimal(currentToken[8]));

            currentOrder.getProduct().setCostPerSqFt(new BigDecimal(currentToken[9]));
            currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(currentToken[10]));
            currentOrder.getTaxClass().setStateTax(new BigDecimal(currentToken[11]));

            Inventory.put(currentOrder.getOrderNumber(), currentOrder);
        }
        scanner.close();

    }

    @Override
    public void SaveState() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new PersistenceException("Could not save Data", e);
        }

        List<Order> orders = this.DisplayOrder();

        //write order to file
        for (Order currentOrder : orders) {
            out.println(currentOrder.getOrderNumber() + DELIMETER
                    + currentOrder.getDate() + DELIMETER
                    + currentOrder.getName() + DELIMETER
                    + currentOrder.getState().toUpperCase() + DELIMETER
                    + currentOrder.getArea() + DELIMETER
                    + currentOrder.getProduct().getProductType() + DELIMETER
                    + currentOrder.getMaterialCost() + DELIMETER
                    + currentOrder.getTaxClass().getTaxRate() + DELIMETER
                    + currentOrder.getTotal() + DELIMETER
                    + currentOrder.getProduct().getCostPerSqFt() + DELIMETER
                    + currentOrder.getProduct().getLaborCostPerSqFt() + DELIMETER
                    + currentOrder.getTaxClass().getStateTax());

            out.flush();
        }
        out.close();
    }

    @Override
    public void saveCurrentSession() throws PersistenceException {

        this.DisplayOrder();
        this.viewCustomers();
        this.loadSaveStateCustomer();
        this.loadSaveState();
        this.SaveState();
        this.SaveStateCUSTOMER();

    }

    /*=======================================================================================
            LOAD AND SAVESTATE CUSTOMERS
=======================================================================================*/
    public void SaveStateCUSTOMER() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE_CUSTOMER));
        } catch (IOException e) {
            throw new PersistenceException("Could not save Data", e);
        }

        List<Customer> orders = this.viewCustomers();

        //write order to file
        for (Customer currentCustomers : orders) {
            out.println(
                    currentCustomers.getPhoneNumber() + DELIMETER
                    + currentCustomers.getCustomersName());

            // out.println(currentOrder.getPhoneNumber() + DELIMETER);                             //0 phone number
            //loop for orders inside customer
//            for (Order customerOrders : currentCustomers.allOrders()) {
//                out.println(
//                          customerOrders.getOrderNumber() + DELIMETER             //1 order number
//                        + customerOrders.getDate() + DELIMETER                      //2 date
//                        + customerOrders.getName() + DELIMETER                      //3 name
//                        + customerOrders.getState().toUpperCase() + DELIMETER       //4 state
//                        + customerOrders.getArea() + DELIMETER                      //5 area
//                        + customerOrders.getProduct().getProductType() + DELIMETER  //6 product type
//                        + customerOrders.getMaterialCost() + DELIMETER              //7 material cost
//                        + customerOrders.getTaxClass().getTaxRate() + DELIMETER     //8 tax rate
//                        + customerOrders.getTotal() + DELIMETER                     //9 total
//                        + customerOrders.getProduct().getCostPerSqFt() + DELIMETER  //10 cost per sqft
//                        + customerOrders.getProduct().getLaborCostPerSqFt() + DELIMETER //11 labor
//                        + customerOrders.getTaxClass().getStateTax());                  //12 state tax
//            }
            out.flush();
        }
        out.close();
    }

    public void loadSaveStateCustomer() throws PersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE_CUSTOMER)));
        } catch (FileNotFoundException e) {
            throw new PersistenceException("File not found", e);
        }

        String currentLine;
        String[] currentToken;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentToken = currentLine.split(DELIMETER);
//            Order currentOrder = new Order(Integer.parseInt(currentToken[1]));                          //1 orderNumber

            Customer currentCustomer = new Customer(currentToken[0]);
            currentCustomer.setCustomersName(currentToken[1]);

//            
//            currentOrder.setDate(LocalDate.parse(currentToken[2]));                                     //2 date    
//            currentOrder.setName(currentToken[3]);                                                      //3 name
//            currentOrder.setState(currentToken[4]);                                                     //4 state
//            currentOrder.setArea(new BigDecimal(currentToken[5]));                                      //5 area
//            Product newProduct = new Product(currentToken[6].toUpperCase());                            //6 product type
//            currentOrder.setProduct(newProduct);
//            currentOrder.setMaterialCost(new BigDecimal(currentToken[7]));                              //7 material cost
//            Tax newTax = new Tax(new BigDecimal(currentToken[8]));                                      //8 tax rate
//            
//            currentOrder.setTaxClass(newTax);
//            currentOrder.setTotal(new BigDecimal(currentToken[9]));                                     //9 total
//            currentOrder.getProduct().setCostPerSqFt(new BigDecimal(currentToken[10]));                 //10 cost per square foot
//            currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(currentToken[11]));            //11 labor
//            currentOrder.getTaxClass().setStateTax(new BigDecimal(currentToken[12]));                   //12 state tax
//            
            //do customer add order method
            customerOrders.put(currentToken[0], currentCustomer);                                       //0 phone number

        }
        scanner.close();

    }

    /**
     *
     * @throws PersistenceException
     */
    @Override
    public void loadOrdersIntoCustomers() throws PersistenceException {

        for (Order currentOrder : this.DisplayOrder()) {
            for (Customer currentCustomer : this.viewCustomers()) {
                if (currentOrder.getName().equalsIgnoreCase(currentCustomer.getCustomersName())) {
                    currentCustomer.addOrder(currentOrder);
                    this.addCUSTOMER(currentCustomer.getPhoneNumber(), currentCustomer);
                }
            }
        } // end of fors
    } //end of method

}
