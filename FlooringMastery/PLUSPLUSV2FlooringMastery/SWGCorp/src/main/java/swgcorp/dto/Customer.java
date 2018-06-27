/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import swgcorp.dao.PersistenceException;

/**
 *
 * @author kmlnd
 */
public class Customer {

    /*
        Get customer by phone number
        
        Please input Nums
        X-(XXX)-XXX-XXXX
    
        Later on we are going to prompt the use with a phone number
        if not null then we will pull up all orders by customer
    
     */
    private String phoneNumber;
    
    private Order currentOrder;
    private String name;
    private String state;
    private List<Order> customersOrders = new ArrayList<>();
    private int numberOfOrders;
    private boolean discount;
    
    public Customer(String phoneNumber/*, Order currentOrder*/) {
        this.phoneNumber = phoneNumber;
//        this.currentOrder = currentOrder;
//        customersOrders.add(currentOrder);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public Order getOrderById(int orderNumber) throws PersistenceException{
      Order foundOrder = null;
        
        for(Order currentOrders :customersOrders){
            if(currentOrders.getOrderNumber() == orderNumber){
                foundOrder = currentOrders;
            }
        }
        
        if(foundOrder == null){
            throw new PersistenceException("Could not find order");
        }
        return foundOrder;
    }

//    public Order getCurrentOrder(int orderNumber) {
//        Order orderChosen =  customersOrders.get(orderNumber);
//        
//        return orderChosen;
//    }
//    
    public String getCustomersName() {
        //getting name from first order assigned
        if(name == null){
            name = currentOrder.getName();
        }
        return name;
    }
    
    public void setCustomersName(String name){
        this.name = name;
    }
    
    public String getCustomersState(){
        state = currentOrder.getState();
        return state;
    }
    
    public void removeOrder(Order currentOrder){
        customersOrders.remove(currentOrder);
    }
    

    public void addOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
        customersOrders.add(currentOrder);
    }

//    public List<Order> allOrders() {
//        return new ArrayList<>(customersOrders);
//    }
    
    public List<Order> allOrders() {
        return customersOrders;
    }
    
    public int totalNumberOfItems(){
        numberOfOrders = customersOrders.size() + 2;
        return numberOfOrders;
    }
    
    public boolean getDiscount(){
        discount = false;
        
        discount = (numberOfOrders % 5 == 0);
        return discount;
    }

}
