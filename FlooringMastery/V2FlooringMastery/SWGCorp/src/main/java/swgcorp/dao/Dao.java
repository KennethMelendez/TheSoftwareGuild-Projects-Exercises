/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import swgcorp.dto.Order;

/**
 *
 * @author kmlnd
 */
public interface Dao {
    
    
    
    //  (1.) Display Orders     
    
    //  (2.) Add an Order       
    
    //  (3.) Edit an order      
    
    //  (4.) Remove an Order    
    
    
    
    List <Order> DisplayOrder();
    
    void addOrder(int identifier,Order order);
    
    Order getOrder(int identifier);
    
    Order editOrder(int identifier, Order order);
    
    void removeOrder(int identifier);
    
    public int orderNumberGeneratorAndAssigner();
    
    void SaveState() throws PersistenceException;
    
    void loadSaveState() throws PersistenceException;
    
    void saveCurrentSession() throws PersistenceException;
    
    
    
    /*
            TEST
    */
    
    
    
    public List<Order>getOrderByDate(String date);
    
    /*
     For those asking about the config file, just read from a file and get the mode, that mode should go to the bean Id that you use to get the controller
    */
    
   
}
