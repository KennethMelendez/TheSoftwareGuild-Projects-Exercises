/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import swgcorp.dao.PersistenceException;
import swgcorp.dto.CalculateOutputs;
import swgcorp.dto.Customer;
import swgcorp.dto.Order;
import swgcorp.dto.Product;
import swgcorp.dto.ProductTypeCosts;
import swgcorp.dto.StateTaxRates;
import swgcorp.dto.Tax;
import swgcorp.servicelayer.InvalidPurchaseException;
import swgcorp.servicelayer.InvalidStateException;

/**
 *
 * @author kmlnd
 */
public class View {

    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    //=========   Banners/Boolean Menu logic   =========       
    public void menu() {
        io.Display("  __)(__  __)(__  __)(__  __)(__  __)");
        io.Display("");
        io.Display("           Welcome to SWG CORP");
        io.Display("           <<Flooring Program>>");
        io.Display("");
        io.Display("  __)(__  __)(__  __)(__  __)(__  __)");
        io.Display("");
        io.Display("( 1.) Displaying Orders");
        io.Display("( 2.) Add an Order");
        io.Display("( 3.) Edit an Order");
        io.Display("( 4.) Remove an Order");
        io.Display("( 5.) Save Current Work");
        io.Display("( 6.) Quit");
        io.Display("");
    }

    public void displayingOrdersBANNER() {
        io.Display("");
        io.Display("*** Displaying Orders ***");
        io.Display("");
    }

    public void addingOrdersBANNER() {
        io.Display("");
        io.Display("*** Add an Order ***");
        io.Display("");
    }

    public void editOrdersBANNER() {
        io.Display("");
        io.Display("*** Edit an Order ***");
        io.Display("");
    }

    public void removeOrdersBANNER() {
        io.Display("");
        io.Display("*** Remove an Order ***");
        io.Display("");
    }

    public void saveCurrentWorkBANNER() {
        io.Display("");
        io.Display("*** Save Current Work ***");
        io.Display("");
    }

    public void quitApplication() {
        io.Display("  .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.\n"
                + ":::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\\n"
                + "'      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      `");
        io.Display("*** Quiting Application ... Thank you! ***");
        io.Display("  .--.      .-'.      .--.      .--.      .--.      .--.      .`-.      .--.\n"
                + ":::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\::::::::.\\\n"
                + "'      `--'      `.-'      `--'      `--'      `--'      `-.'      `--'      `");
    }

    public int menuSelection() {
        int result = 1;
        result = io.PromptInt("Please Choose Selection #1-6");
        return result;
    }

    public void InvalidInput() {
        io.Display("Invalid Input");
    }

    public void displayOrderBanner() {
        io.Display(" ________  ________  ________  _______   ________  ________      \n"
                + "|\\   __  \\|\\   __  \\|\\   ___ \\|\\  ___ \\ |\\   __  \\|\\   ____\\     \n"
                + "\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\   __/|\\ \\  \\|\\  \\ \\  \\___|_    \n"
                + " \\ \\  \\\\\\  \\ \\   _  _\\ \\  \\ \\\\ \\ \\  \\_|/_\\ \\   _  _\\ \\_____  \\   \n"
                + "  \\ \\  \\\\\\  \\ \\  \\\\  \\\\ \\  \\_\\\\ \\ \\  \\_|\\ \\ \\  \\\\  \\\\|____|\\  \\  \n"
                + "   \\ \\_______\\ \\__\\\\ _\\\\ \\_______\\ \\_______\\ \\__\\\\ _\\ ____\\_\\  \\ \n"
                + "    \\|_______|\\|__|\\|__|\\|_______|\\|_______|\\|__|\\|__|\\_________\\\n"
                + "                                                     \\|_________|\n");
    }

    public boolean wouldYouLikeToContinue() {
        String prompt = io.PromptString("Would you like to continue? (Y/N)");
        if (prompt.equalsIgnoreCase("Yes") || prompt.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean areYouSure() {
        displayOrderBanner();
        io.Display("====================================");
        String prompt = io.PromptString("Are you sure? (Y/N)\n====================================");
        if (prompt.equalsIgnoreCase("Yes") || prompt.equalsIgnoreCase("Y")) {
            io.Display(" ");
            io.Display("Order Deleted.");
            io.PromptString("Hit enter to continue");
            return true;
        } else {
            io.Display(" ");
            io.Display("** Order unsuccessfully deleted **");
            io.Display(" ");
            io.PromptString("Hit enter to continue");
            return false;
        }
    }

    public boolean buyAnotherProductOption() {
        boolean validInput = true;
        boolean buy = true;
        while (validInput) {
            io.Display("Would you like to purchase another product ?");

            String name = io.PromptString("(Yes) or (No)?");
            if (name.equalsIgnoreCase("no")) {
                buy = false;
                break;
            } else if (name.equalsIgnoreCase("yes")) {
                buy = true;
                break;
            } else {
                io.Display("Please input a valid response.");
            }
        }
        return buy;
    }

    //=========   Displaying Setting Orders   =========     
    public Order addOrder(int orderNumber) throws InvalidStateException, InvalidPurchaseException {

        /*
            In order to validate the add order method I created two separate methods
            that examines the user input and sets them based on whether or not the enums
            class is accessible.
         */
        //Creating new order
        Order currentOrder = new Order(orderNumber);

        /*
                    NEW CODE
         */
        //String phoneNumber = promptPhoneNumber();
        String name = io.PromptString("Please Input Name");
        BigDecimal area = io.PromptBigDecimal("Please Input Area");
        String state = io.PromptString("Please Input State\n (OH,PA,MI,IN)");
        String productType = io.PromptString("Please Input product type\n*Carpet, Laminate, Tile, Wood*");
        LocalDate date = LocalDate.now();
        currentOrder.setDate(date);

        //calling the set state method created in order to reduce code
        currentOrder = setState(state, currentOrder);

        /*
            Getting the information we recieve from the user input
            and setting them into out dtos in this order
        
            (Order Number from perameter)
            Name
            State - > based on input set the TAXRATE
            Product type - > based on input set the enum costs
            Area -> based on input do the caculations
            => will output total
        
         */
        //Order currentOrder = new Order(orderNumber);
        currentOrder.setName(name);
        //currentOrder.setState(state); set state above
        currentOrder.setArea(area);
        //setting the purchase and doing the calculations
        currentOrder = setPurchase(productType, currentOrder);

        /*
                NEW CODE
         */
        //CustomerFile currentCustomer = new Customer(phoneNumber,currentOrder);
        return currentOrder;
    }

    public int PromptOrderNumber() throws PersistenceException {
        int prompt;
        try {
            prompt = io.PromptInt("Please Input Order Number");

        } catch (Exception e) {
            throw new PersistenceException("Invalid Order Number", e);
        }
        return prompt;
    }

    public String PromptDate() throws PersistenceException {
        String prompt = "";

        try {
            prompt = io.PromptString("Please Input Date (YYYY-mm-dd)");

            if (prompt == null || "".equals(prompt)) {
                throw new PersistenceException("Please input valid entry");
            }
        } catch (PersistenceException e) {
            throw new PersistenceException("Invalid Date", e);
        }
        return prompt;

    }

    public void displayMessage(String msg) {
        io.Display(msg);
    }

    public String promptPhoneNumber() {
        String result = io.PromptString("Please insert Phone number XXX-XXX-XXXX");
        return result;
    }

    public Order promptExistingCustomerAddNewOrder(int orderNumber, Customer currentCustomer) throws InvalidStateException, InvalidPurchaseException {
        Order currentOrder = new Order(orderNumber);

        String name = currentCustomer.getCustomersName();
        BigDecimal area = io.PromptBigDecimal("Please Input Area");
        //String state = io.PromptString("Please Input State\n (OH,PA,MI,IN)");
        String productType = io.PromptString("Please Input product type\n*Carpet, Laminate, Tile, Wood*");
        LocalDate date = LocalDate.now();
        currentOrder.setDate(date);

        //calling the set state method created in order to reduce code
        //currentOrder = setState(state, currentOrder);
        //please dont break lol
        currentOrder = setState(currentCustomer.getCustomersState(), currentOrder); //refactored code

        /*
            Getting the information we recieve from the user input
            and setting them into out dtos in this order
        
            (Order Number from perameter)
            Name
            State - > based on input set the TAXRATE
            Product type - > based on input set the enum costs
            Area -> based on input do the caculations
            => will output total
        
         */
        //Order currentOrder = new Order(orderNumber);
        //
        currentOrder.setName(name);                    //TEST
        //currentOrder.setState(state); set state above
        currentOrder.setArea(area);
        //setting the purchase and doing the calculations
        currentOrder = setPurchase(productType, currentOrder);

        return currentOrder;

    }

    public void displayAnOrder(Order currentOrder) {
        io.Display("");
        io.Display("*** Chosen ORDER ***");
        io.Display("");

        io.Display("| Order Number: "
                + currentOrder.getOrderNumber() + " | Date: "
                + currentOrder.getDate() + " | Name: "
                + currentOrder.getName() + " | State: "
                + currentOrder.getState().toUpperCase() + " | Area: "
                + currentOrder.getArea() + " | Product Type: "
                + currentOrder.getProduct().getProductType().toUpperCase() + " | Material Cost: "
                + currentOrder.getMaterialCost() + " | Tax: "
                + currentOrder.getTaxClass().getTaxRate() + " | Total Cost: "
                + currentOrder.getTotal() + " "
        );

        io.Display("");
    }

    public void OrderSummary(List<Order> orders, Order name) {

        int count = 1;
        io.Display("=== Order Summary ===");
        io.Display("Name: " + name.getName().toUpperCase());
        for (Order o : orders) {

            io.Display(count + "x " + o.getProduct().getProductType().toUpperCase() + " Area: " + o.getArea());
        }

    }

    public void displayOrdersFromShoppingCart(List<Order> List) {
        for (Order display : List) {

            io.Display(" * ~~~~ > || Order Number: "
                    + display.getOrderNumber() + " | Date: "
                    + display.getDate() + " | Name: "
                    + display.getName() + " | State: "
                    + display.getState().toUpperCase() + " | Area: "
                    + display.getArea() + " | Product Type: "
                    + display.getProduct().getProductType().toUpperCase() + " | Material Cost: "
                    + display.getMaterialCost() + " | Tax: "
                    + display.getTaxClass().getTaxRate() + " | Total Cost: "
                    + display.getTotal() + " "
            );

            io.Display("");
            io.Display("");

        }
    }

    public void displayOrders(List<Order> List) {

        displayOrderBanner();

        for (Order display : List) {

            io.Display(" ~~~~ > || Order Number: "
                    + display.getOrderNumber() + " | Date: "
                    + display.getDate() + " | Name: "
                    + display.getName() + " | State: "
                    + display.getState().toUpperCase() + " | Area: "
                    + display.getArea() + " | Product Type: "
                    + display.getProduct().getProductType().toUpperCase() + " | Material Cost: "
                    + display.getMaterialCost() + " | Tax: "
                    + display.getTaxClass().getTaxRate() + " | Total Cost: "
                    + display.getTotal() + " "
            );

            io.Display("");
            io.Display("");

        }
    }

    public Order setState(String state, Order currentOrder) throws InvalidStateException {
        //setting the state into the current order
        // STATE EX. OH => Your current order is being set to OH!

        currentOrder.setState(state);
        //getting the tax from the enums based on the string value
        //ValueOf Note that the name must be an exact match, including case:
        //in order to pass the enum

        try {
            BigDecimal tax = StateTaxRates.valueOf(state.toUpperCase()).getTax();
            Tax currentTax = new Tax(tax);
            currentOrder.setTaxClass(currentTax);
            //setting it into the current order
            //setting the current order tax
            return currentOrder;
        } catch (Exception ex) {
            throw new InvalidStateException("Invalid State", ex);
        }

    }

    /*
            Sets the purchase and assigns the purchase to their associated cost
     */
    public Order setPurchase(String productType, Order currentOrder) throws InvalidPurchaseException {
        Product currentProduct = new Product(productType);

        try {
            //get the labor costs ====== 

            BigDecimal cost = ProductTypeCosts.valueOf(productType.toUpperCase()).getCostPerSquareFoot();
            BigDecimal laborCost = ProductTypeCosts.valueOf(productType.toUpperCase()).getLaborCostPerSquareFoot();

            currentProduct.setCostPerSqFt(cost);
            currentProduct.setLaborCostPerSqFt(laborCost);

            currentOrder.setProduct(currentProduct);
            CalculateOutputs calculatingPurchase = new CalculateOutputs();
            currentOrder = calculatingPurchase.calculateTotal(currentProduct, currentOrder);
            return currentOrder;
        } catch (Exception ex) {
            throw new InvalidPurchaseException("Invalid Product", ex);
        }

    }

    public void promptItemsPurchased(String message) {
        io.PromptString(message);
    }

    public Order editOrder(Order currentOrder) throws InvalidPurchaseException {

        io.Display("");
        io.Display("*** Chosen ORDER ***");
        io.Display("");
        io.Display("| Order Number: "
                + currentOrder.getOrderNumber() + " | Date: "
                + currentOrder.getDate() + " | Name: "
                + currentOrder.getName() + " | State: "
                + currentOrder.getState().toUpperCase() + " | Area: "
                + currentOrder.getArea() + " | Product Type: "
                + currentOrder.getProduct().getProductType().toUpperCase() + " | Material Cost: "
                + currentOrder.getMaterialCost() + " | Tax: "
                + currentOrder.getTaxClass().getTaxRate() + " | Total Cost: "
                + currentOrder.getTotal() + " "
        );

        io.Display("");

        io.Display("==============================================================================");
        io.Display(" Input new fields in order to edit / Leave empty to leave it at default");
        io.Display("===============================================================================");

        String name = io.PromptString("| Name: " + currentOrder.getName());
        if (!"".equals(name)) {
            currentOrder.setName(name);
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
            io.Display("(" + name + ") Name Updated");
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
        } else {
            io.Display("");
            io.Display("[x] Name unchanged.");
            io.Display("");
        }
        String area = io.PromptString("Please Input Area");

        if (!"".equals(area)) {
            currentOrder.setArea(new BigDecimal(area));
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
            io.Display("(" + area + ") Area Updated");
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
        } else {
            io.Display("");
            io.Display("[x] Area unchanged.");
            io.Display("");
        }
        String state = io.PromptString("Please Input State\n (OH,PA,MI,IN)");

        if (!"".equals(state)) {
            currentOrder.setState(state);
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
            io.Display("(" + state + ") State Updated");
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
        } else {
            io.Display("");
            io.Display("[x]  State unchanged.");
            io.Display("");
        }
        String productType = io.PromptString("Please Input product type\n*Carpet, Laminate, Tile, Wood*");
        if (!"".equals(productType)) {
            currentOrder = setPurchase(productType, currentOrder);
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
            io.Display("(" + productType + ") Product Updated");
            io.Display("");
            io.Display(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
            io.Display("");
            io.Display("Order Successfully Updated");
            io.PromptString("Hit Enter to continue.");
            LocalDate date = LocalDate.now();
            currentOrder.setDate(date);
        } else {
            io.Display("[x] Product unchanged.");
        }
        return currentOrder;
    }
    
    public void displayInt(int num){
        io.DisplayInt(num);
    }

}
