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
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.StateTaxRates;
import swgcorp.dto.Tax;

/**
 *
 * @author kmlnd
 */
public class TrainingModeDaoImpl implements Dao {

    Map<Integer, Order> Inventory = new HashMap<>();
    public static final String DELIMETER = "::";
    public static final String ROSTER_FILE = "ORDERS_YYYYMMDD.txt";
    private int orderNumber = 0;

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
    public List<Order> getOrderByDate(String date) {
         return Inventory.values()
                .stream()
                .filter(s -> s.getDate().toString().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> DisplayOrder() {
        return new ArrayList<>(Inventory.values());
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

    public Order getOrder(int identifier) {
        Order currentOrder = Inventory.get(identifier);
        return currentOrder;
    }

    @Override
    public void removeOrder(int identifier) {
        Inventory.remove(identifier);
    }

    @Override
    public void addOrder(int identifier, Order order) {
        Inventory.put(identifier, order);
    }

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
        Order currentOrder = this.getOrder(nums);

        /*
            Below im assigning my current order ID and adding it by one in order to generate
            the next number
         */
        int lastObjectOrderNumber = currentOrder.getOrderNumber();
        lastObjectOrderNumber += 1;

        /*
            I am now returning our new number!
         */
        return lastObjectOrderNumber;
    }

    /*=======================================================================================
            LOAD AND SAVESTATE ****FINISH LATER AFTER CREATING THE PRODUCTS****
=======================================================================================*/
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
        //throw new PersistenceException("\n=== Unable to load Data ===\nMode Not availible in training mode\n");
    }

    public void SaveState() throws PersistenceException {
       // throw new PersistenceException("\n=== Unable to Save Data ===\nMode Not availible in training mode\n");
    }

    public void saveCurrentSession() throws PersistenceException {
      //  throw new PersistenceException("\n=== Unable to Save Current Session ===\nMode Not availible in training mode\n");
    }



}
