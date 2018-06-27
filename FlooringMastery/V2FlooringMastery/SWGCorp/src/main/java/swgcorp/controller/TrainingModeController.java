/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import swgcorp.dao.PersistenceException;
import swgcorp.dto.CalculateOutputs;
import swgcorp.dto.Order;
import swgcorp.dto.ProductTypeCosts;
import swgcorp.dto.StateTaxRates;
import swgcorp.servicelayer.InvalidOrderNumberException;
import swgcorp.servicelayer.InvalidPurchaseException;
import swgcorp.servicelayer.InvalidStateException;
import swgcorp.servicelayer.RemoveOrderException;
import swgcorp.servicelayer.ServiceLayer;
import swgcorp.ui.View;

/**
 *
 * @author kmlnd
 */
public class TrainingModeController {

    View view;
    ServiceLayer serviceLayer;
    CalculateOutputs calculateOutputs;

    public TrainingModeController(View view, ServiceLayer serviceLayer, CalculateOutputs calculateOutputs) {
        this.view = view;
        this.serviceLayer = serviceLayer;
        this.calculateOutputs = calculateOutputs;
    }

    public void run() {

        boolean RunProgram = true;
        try {
            loadSession();
        } catch (PersistenceException ex) {
            view.displayMessage(ex.getMessage());
        }
        while (RunProgram) {

            try {
                trainingModeBanner();
                mainMenu();
                
                int userSelection = menuSelection();
                
                switch (userSelection) {
                    case 1:
                        displayingOrdersBANNER();
                        //displayOrders();
                        displayordersByDate();
                        break;
                    case 2:
                        addingOrdersBANNER();
                        
                        try {
                            addOrder();
                            
                        } catch (InvalidPurchaseException | InvalidStateException e) {
                            view.displayMessage(e.getMessage());
                        }
                        
                        break;
                    case 3:
                        editOrdersBANNER();
                        
                        try {
                            editOrder();
                        } catch (InvalidPurchaseException | PersistenceException | InvalidStateException | InvalidOrderNumberException e) {
                            view.displayMessage(e.getMessage());
                        }
                        
                        break;
                    case 4:
                        removeOrderBANNER();
                        try {
                            removeOrder();
                        } catch (PersistenceException | InvalidOrderNumberException | RemoveOrderException e) {
                            view.displayMessage(e.getMessage());
                        }
                        break;
                    case 5:
                        saveCurrentWorkBanner();
                        saveCurrentSession();
                        view.displayMessage("Current Session has been saved.");
                        break;
                    case 6:
                        quitAppBANNER();
                        RunProgram = false;
                        break;
                    default:
                        InvalidInput();
                        break;
                        
                }// end of switch
            } // end of while
            catch (PersistenceException ex) {
                view.displayMessage(ex.getMessage());
            }

        }

    }// end of run method

    private void InvalidInput() {
        view.InvalidInput();
    }

    private int menuSelection() {
        int result = view.menuSelection();
        return result;
    }

    private void mainMenu() {
        view.menu();
    }

    private void displayingOrdersBANNER() {
        view.displayingOrdersBANNER();
    }

    private void addingOrdersBANNER() {
        view.addingOrdersBANNER();
    }

    private void editOrdersBANNER() {
        view.editOrdersBANNER();

    }

    private void editOrder() throws InvalidPurchaseException, PersistenceException, InvalidStateException, InvalidOrderNumberException {
        int promptNums = view.PromptOrderNumber();
        String Date = view.PromptDate();
        Order currentOrder = serviceLayer.getOrder(promptNums);
        if (currentOrder.getDate().toString().equals(Date) && currentOrder.getOrderNumber() == promptNums) {
            currentOrder = view.editOrder(currentOrder);
            serviceLayer.editOrder(promptNums, currentOrder);
        }
    }

    private void removeOrderBANNER() {
        view.removeOrdersBANNER();
    }

    private void saveCurrentWorkBanner() {
        view.saveCurrentWorkBANNER();
    }

    private void quitAppBANNER() {
        view.quitApplication();
    }

    private void addOrder() throws InvalidStateException, InvalidPurchaseException, PersistenceException {
        boolean keepGoing;

        int orderNumberGenerator = serviceLayer.orderNumberGeneratorAndAssigner();
        Order currentOrder = view.addOrder(orderNumberGenerator);

        view.displayAnOrder(currentOrder);
        keepGoing = view.wouldYouLikeToContinue();

        if (keepGoing == true) {
            serviceLayer.addOrder(orderNumberGenerator, currentOrder);
        } else {
            view.displayMessage("Order Cancelled.");
        }
    }

    
    /*
        Refactoring Orders
    */
    
    
    private void displayOrders() {
        view.displayOrders(serviceLayer.DisplayOrder());
    }
    
    private void displayordersByDate() throws PersistenceException{
        String date = view.PromptDate();
        List<Order> orders = serviceLayer.getOrderByDate(date);
        view.displayOrders(orders);
    }

    private void removeOrder() throws PersistenceException, InvalidOrderNumberException, RemoveOrderException {

        boolean areYouSure = false;
        boolean removeorder = false;
        //boolean wouldYouLikeToContinue = true;

        while (!areYouSure) {

            int orderNumber = view.PromptOrderNumber();
            String Date = view.PromptDate();
            Order currentorder = serviceLayer.getOrder(orderNumber);
            if (currentorder.getDate().toString().equals(Date) && currentorder.getOrderNumber() == orderNumber) {
                view.displayAnOrder(currentorder);
                removeorder = view.areYouSure();

                while (removeorder) {

                    serviceLayer.removeOrder(orderNumber);
                    removeorder = false;
                    areYouSure = true;
                }
            } else {
                view.InvalidInput();

                if (view.wouldYouLikeToContinue() == false) {
                    areYouSure = true;
                    removeorder = false;
                }
                break;
            }
        }
    }
    
    private void saveCurrentSession() throws PersistenceException{
        serviceLayer.saveCurrentSession();
    }

    private void loadSession() throws PersistenceException{
        serviceLayer.loadSaveState();
    }
    
    private void trainingModeBanner(){
        view.displayMessage("");
        view.displayMessage("=== Currently in Training mode ===");
        view.displayMessage("");
    }
    
}// end of controller method
