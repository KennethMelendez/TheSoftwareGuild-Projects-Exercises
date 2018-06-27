/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.Tax;

/**
 *
 * @author kmlnd
 */
public class DaoStubImpl implements Dao{

    
    private Order currentOrder;
    private List<Order> orderList = new ArrayList<>();
    
    public DaoStubImpl(){
        
        int orderNumber = 345893;
        currentOrder = new Order(orderNumber);
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
    }
    
    
    @Override
    public List<Order> DisplayOrder() {
        return new ArrayList<Order>();
    }

    @Override
    public void addOrder(int identifier, Order order) {


        if(currentOrder.getOrderNumber() == identifier){
            orderList.add(order);
        }
    }

    @Override
    public Order getOrder(int identifier) {
       return orderList.get(identifier);
    }

    @Override
    public Order editOrder(int identifier, Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOrder(int identifier) {
        orderList.remove(identifier);
    }

    @Override
    public int orderNumberGeneratorAndAssigner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SaveState() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadSaveState() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCurrentSession() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getOrderByDate(String date) {
                return orderList
                .stream()
                .filter(s -> s.getDate().toString().equals(date))
                .collect(Collectors.toList());
    }

    
    
}
