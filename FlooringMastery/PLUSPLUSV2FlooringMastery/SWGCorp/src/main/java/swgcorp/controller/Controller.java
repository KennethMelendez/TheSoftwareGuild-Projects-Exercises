/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import swgcorp.dao.PersistenceException;
import swgcorp.dto.CalculateOutputs;
import swgcorp.dto.Customer;
import swgcorp.dto.Order;
import swgcorp.dto.ProductTypeCosts;
import swgcorp.dto.StateTaxRates;
import swgcorp.servicelayer.InvalidOrderNumberException;
import swgcorp.servicelayer.InvalidPurchaseException;
import swgcorp.servicelayer.InvalidStateException;
import swgcorp.servicelayer.RemoveOrderException;
import swgcorp.servicelayer.ServiceLayer;
import swgcorp.ui.View;

/*


                ADD MORE TO ADD ORDER ************


 */
/**
 *
 * @author kmlnd
 */
public class Controller {

    View view;
    ServiceLayer serviceLayer;
    CalculateOutputs calculateOutputs;

    public Controller(View view, ServiceLayer serviceLayer, CalculateOutputs calculateOutputs) {
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
                        } catch (InvalidPurchaseException | PersistenceException | InvalidStateException | InvalidOrderNumberException | NullPointerException e) {
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
        String promptPhoneNumber = view.promptPhoneNumber();
        int promptNums = view.PromptOrderNumber();
        String Date = view.PromptDate();
        Order currentOrder = serviceLayer.getOrder(promptNums);
        /*
            new code help me
         */
        Customer currentCustomer = serviceLayer.getCustomer(promptPhoneNumber);
        Order customersOrder = currentCustomer.getOrderById(promptNums); //new
        if (currentOrder.getDate().toString().equals(Date) && currentOrder.getOrderNumber() == promptNums) {
            currentOrder = view.editOrder(currentOrder);
            //
            //customersOrder = currentOrder;
            currentCustomer.removeOrder(customersOrder);
            currentCustomer.addOrder(currentOrder);
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
        boolean keepOrdering = true;
        BigDecimal totalPrice = new BigDecimal("0");
        int currentOrderNumber = 0;
        //int orderNumberGenerator = serviceLayer.orderNumberGeneratorAndAssigner();

        String phoneNumber = view.promptPhoneNumber();  //NEW

        while (keepOrdering) {
            int orderNumberGenerator = serviceLayer.orderNumberGeneratorAndAssigner();
            Customer existingCustomer = serviceLayer.getCustomer(phoneNumber);
            Customer newCustomer = null;
            Order currentOrder = null;

            //currentCustomer = serviceLayer.getCustomer(phoneNumber);
            if (existingCustomer == null) {
                // if customer does not exist add make an order and new customer
                currentOrder = view.addOrder(orderNumberGenerator);
                newCustomer = new Customer(phoneNumber/*, currentOrder*/); //NEW
                newCustomer.addOrder(currentOrder);
                //view.displayMessage("Here is all orders for " + newCustomer.getCustomersName());
                view.displayOrders(newCustomer.allOrders());    //NEW
                //view.displayMessage("Thank you.");

            } else {
                //if the customer exists just prompt a new order
                //display current order then ask if they would like to continue

                currentOrder = view.promptExistingCustomerAddNewOrder(orderNumberGenerator, existingCustomer);
                //view.displayAnOrder(currentOrder);
                existingCustomer.addOrder(currentOrder);

                view.displayOrders(existingCustomer.allOrders());    //NEW
                view.displayMessage("Order History for " + existingCustomer.getCustomersName() + " above.");
                view.displayMessage("");
                view.displayAnOrder(currentOrder);

            }

            keepGoing = view.wouldYouLikeToContinue();

            if (keepGoing == true) {
                if (existingCustomer == null) {
                    //if no customer
                    serviceLayer.addCUSTOMER(phoneNumber, newCustomer); //NEW
                    serviceLayer.addOrder(orderNumberGenerator, currentOrder);
                    view.displayMessage("Thank you for shopping.");
                    serviceLayer.addToCart(currentOrder);
                } else {
                    //if customer
                    //existingCustomer.addOrder(currentOrder);
                    serviceLayer.addCUSTOMER(phoneNumber, existingCustomer); //NEW
                    view.displayOrders(existingCustomer.allOrders());    //NEW
                    serviceLayer.addOrder(orderNumberGenerator, currentOrder);
                    view.displayMessage("Thank you for shopping.");
                    serviceLayer.addToCart(currentOrder);
                }
                currentOrderNumber++;
            } else {
                view.displayMessage("Order Cancelled.");
            }
            totalPrice = totalPrice.add(currentOrder.getMaterialCost());

            view.displayMessage("* CURRENT ITEMS IN YOUR SHOPPING CART *");
            view.displayMessage("");
            view.displayOrdersFromShoppingCart(serviceLayer.viewCartOrders());

            //view.displayMessage("Total price of all Order/s : $" + totalPrice);
            view.displayMessage("You currently have " + currentOrderNumber + " order in your cart.");
            //view.displayMessage("Tax included.");
            keepOrdering = view.buyAnotherProductOption();

            if (keepOrdering == false || keepGoing == false) {
                // if done ordering clear out orders for the next customer or line order
                view.displayMessage("Total price of all Order/s : $" + totalPrice);
                view.displayMessage("Tax included.");

                //LineItems lo = new LineItems(currentOrder.getName());
                //new code
                //view.displayMessage(lo.displayProductsBought(serviceLayer.viewCartOrders()));
                view.OrderSummary(serviceLayer.viewCartOrders(), currentOrder);

                if ((existingCustomer.totalNumberOfItems() % 5 == 0)) {
                    //display int
                    //view.displayInt(existingCustomer.totalNumberOfItems());
                    view.displayMessage("Eligible for a 10% discount.");
                    BigDecimal discount = totalPrice.divide(new BigDecimal("10"));
                    discount.setScale(2, RoundingMode.HALF_UP);
                    BigDecimal finalCalc = totalPrice.subtract(discount);
                    view.displayMessage("Total price after discount: $" + finalCalc + "\nPurchase complete.");
                }

                view.promptItemsPurchased("Items purchased.\nHit enter to continue.");

                serviceLayer.clearOutCartForNextPurchase();
            }

        }
    }

    private void displayOrders() {
        view.displayOrders(serviceLayer.DisplayOrder());
    }

    private void displayordersByDate() throws PersistenceException {
        String date = view.PromptDate();
        List<Order> orders = serviceLayer.getOrderByDate(date);
        view.displayOrders(orders);
    }

    private void removeOrder() throws PersistenceException, InvalidOrderNumberException, RemoveOrderException {

        boolean areYouSure = false;
        boolean removeorder = false;
        //boolean wouldYouLikeToContinue = true;

        while (!areYouSure) {

            //prompt number
            String phoneNumber = view.promptPhoneNumber();

            int orderNumber = view.PromptOrderNumber();

            String Date = view.PromptDate();
            //new
            Customer currentCustomer = serviceLayer.getCustomer(phoneNumber);
            view.displayMessage("Customer " + currentCustomer.getCustomersName() + " has been chosen.");
            //new
            Order currentorder = serviceLayer.getOrder(orderNumber);
            if (currentorder.getDate().toString().equals(Date) && currentorder.getOrderNumber() == orderNumber) {
                view.displayAnOrder(currentorder);
                removeorder = view.areYouSure();

                while (removeorder) {
//                    //new
//                    currentCustomer = serviceLayer.getCustomer(phoneNumber);
//                    currentCustomer.removeOrder(currentorder);
//                    //new
//                    serviceLayer.removeOrder(orderNumber);
                    removeOrderFromCustomerHashMap(currentCustomer, phoneNumber, currentorder, orderNumber);
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

    private void removeOrderFromCustomerHashMap(Customer currentCustomer, String phoneNumber, Order currentorder, int orderNumber) throws RemoveOrderException {
        currentCustomer = serviceLayer.getCustomer(phoneNumber);
        currentCustomer.removeOrder(currentorder);
        //new
        serviceLayer.removeOrder(orderNumber);
    }

    private void saveCurrentSession() throws PersistenceException {
        serviceLayer.saveCurrentSession();
    }

    private void loadSession() throws PersistenceException {
        serviceLayer.loadSaveState();
        serviceLayer.loadSaveStateCustomer();
        serviceLayer.loadOrdersIntoCustomers();
    }

}// end of controller method
