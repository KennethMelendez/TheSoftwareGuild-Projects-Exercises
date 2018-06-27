/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.servicelayer;

import java.time.LocalDate;
import java.util.List;
import swgcorp.dao.Dao;
import swgcorp.dao.PersistenceException;
import swgcorp.dto.Customer;
import swgcorp.dto.Order;

/**
 *
 * @author kmlnd
 */
public class ServiceLayerStubImpl implements ServiceLayer {

    Dao dao;

    public ServiceLayerStubImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<Order> DisplayOrder() {
        return dao.DisplayOrder();
    }

    @Override
    public void addOrder(int identifier, Order order) throws InvalidStateException, PersistenceException {

        /*
            use for loop to go through values of enums
        *l8r*
         */
        if (order.getState().equalsIgnoreCase("OH") || order.getState().equalsIgnoreCase("PA") || order.getState().equalsIgnoreCase("MI") || order.getState().equalsIgnoreCase("IN")) {
            try {
                dao.addOrder(identifier, order);
            } catch (Exception e) {                
                throw new PersistenceException("Invalid Order", e);
            }
        } else {
            throw new InvalidStateException("Invalid State Input");

        }
    }

    @Override
    public Order editOrder(int identifier, Order order) {
        return dao.editOrder(identifier, order);
    }

    @Override
    public void removeOrder(int identifier) throws RemoveOrderException {
        try {
            dao.removeOrder(identifier);
        } catch (Exception e) {
            throw new RemoveOrderException("Error removing Order", e);
        }
    }

    @Override
    public int orderNumberGeneratorAndAssigner() {
        return dao.orderNumberGeneratorAndAssigner();
    }

    @Override
    public Order getOrder(int identifier) throws InvalidOrderNumberException {
        try {
            Order currentOrder = dao.getOrder(identifier);
            return currentOrder;
        } catch (Exception e) {
            throw new InvalidOrderNumberException("Invalid Order", e);
        }
    }

    @Override
    public void SaveState() throws PersistenceException {
        dao.SaveState();
    }

    @Override
    public void loadSaveState() throws PersistenceException {
        dao.loadSaveState();
    }

    @Override
    public void saveCurrentSession() throws PersistenceException {
        dao.saveCurrentSession();
    }

    @Override
    public List<Order> getOrderByDate(String date) {
       return dao.getOrderByDate(date);
    }

    @Override
    public  void addCUSTOMER(String phoneNumber, Customer currentCustomer) {
        dao.addCUSTOMER(phoneNumber, currentCustomer);
    }

    @Override
    public Customer getCustomer(String phoneNumber) {
        return dao.getCustomer(phoneNumber);
    }

    @Override
    public void removeCustomer(String phoneNumber) {
        dao.removeCustomer(phoneNumber);
    }

    @Override
    public List<Customer> viewCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToCart(Order currentOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> viewCartOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearOutCartForNextPurchase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadSaveStateCustomer() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadOrdersIntoCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
