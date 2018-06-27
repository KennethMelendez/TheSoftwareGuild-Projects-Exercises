/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.servicelayer;

import java.time.LocalDate;
import java.util.List;
import swgcorp.dao.PersistenceException;
import swgcorp.dto.Order;

/**
 *
 * @author kmlnd
 */
public interface ServiceLayer {

    List<Order> DisplayOrder();

    void addOrder(int identifier, Order order) throws InvalidStateException, PersistenceException;

    Order editOrder(int identifier, Order order);

    void removeOrder(int identifier) throws RemoveOrderException;

    Order getOrder(int identifier) throws InvalidOrderNumberException;

    public int orderNumberGeneratorAndAssigner();

    void SaveState() throws PersistenceException;

    void loadSaveState() throws PersistenceException;

    void saveCurrentSession() throws PersistenceException;
    
    
    /* test */
    
    List<Order>getOrderByDate(String date);
}
