/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Products;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;

/**
 *
 * @author Kenny
 */
public class VendingMachineController {

    //Injection
    VendingMachineView view;
    VendingMachineDao dao;

    public VendingMachineController(VendingMachineView view, VendingMachineDao dao) {
        this.view = view;
        this.dao = dao;
    }

    /*=======================================================
    
    Run/Main/Controller program
    MENU && DISPLAYS
    
=======================================================*/
    public void run() {

        boolean runVendingMachine = true;

        //Prompt X Amount of Money
        String usersMoneyAmount = InsertMoneyPrompt();
        //Inventory
        //POPCORN   A1  $1.00
        int popcornInventory = 3;
        //PEPSI     B8  $1.25
        int pepsiInventory = 1;
        //HERSHEYS  G4  $2.00
        int hersheyInventory = 6;
        //SNICKERS  F9  $0.90
        int snickersInventory = 6;

        while (runVendingMachine) {

            displayMenu();
            String menuSelection = recordSelection();

            switch (menuSelection) {
                //POPCORN   A1  $1.00
                //PEPSI     B8  $1.25
                //HERSHEYS  G4  $2.00
                //SNICKERS  F9  $0.90
                case "A1":

                    //Popcorn
                    //variable processes transaction and returns result
                    if (popcornInventory == 0) {
                        view.SOLDOUT();
                        view.hitEnterToContinue();
                        break;
                    } else {
                        //usersMoneyAmount
                        String changedMoney = popcornINVENTORY(usersMoneyAmount, popcornInventory);
                        if (changedMoney.equals(usersMoneyAmount)) {
                            usersMoneyAmount = changedMoney;
                            int foo = Integer.parseInt(usersMoneyAmount);
                            foo += foo;
                            String superFoo = String.valueOf(foo);
                            usersMoneyAmount = superFoo;
                            popcornInventory++;
                        } else {
                            usersMoneyAmount = changedMoney;
                            popcornInventory--;
                        }

                    }

                    break;
                case "B8":
                    //Pepsi

                    if (pepsiInventory == 0) {
                        view.SOLDOUT();
                        view.hitEnterToContinue();
                        break;
                    } else {
                        //usersMoneyAmount
                        String changedMoney = pepsiINVENTORY(usersMoneyAmount, popcornInventory);
                        if (changedMoney.equals(usersMoneyAmount)) {
                            usersMoneyAmount = changedMoney;
                            int foo = Integer.parseInt(usersMoneyAmount);
                            foo += foo;
                            String superFoo = String.valueOf(foo);
                            usersMoneyAmount = superFoo;
                            pepsiInventory++;
                        } else {
                            usersMoneyAmount = changedMoney;
                            pepsiInventory--;
                        }

                    }
                    break;
                case "G4":
                    //hersheys
                    if (hersheyInventory == 0) {
                        view.SOLDOUT();
                        view.hitEnterToContinue();
                        break;
                    } else {
                        //usersMoneyAmount
                        String changedMoney = hersheysINVENTORY(usersMoneyAmount, hersheyInventory);
                        if (changedMoney.equals(usersMoneyAmount)) {
                            usersMoneyAmount = changedMoney;
                            int foo = Integer.parseInt(usersMoneyAmount);
                            foo += foo;
                            String superFoo = String.valueOf(foo);
                            usersMoneyAmount = superFoo;
                            hersheyInventory++;
                        } else {
                            usersMoneyAmount = changedMoney;
                            hersheyInventory--;
                        }

                    }
                    break;
                case "F9":
                    //snickers
                    if (snickersInventory == 0) {
                        view.SOLDOUT();
                        view.hitEnterToContinue();
                        break;
                    } else {
                        //usersMoneyAmount
                        String changedMoney = snickersINVENTORY(usersMoneyAmount, snickersInventory);
                        if (changedMoney.equals(usersMoneyAmount)) {
                            usersMoneyAmount = changedMoney;
                            int foo = Integer.parseInt(usersMoneyAmount);
                            foo += foo;
                            String superFoo = String.valueOf(foo);
                            usersMoneyAmount = superFoo;
                            snickersInventory++;
                        } else {
                            usersMoneyAmount = changedMoney;
                            snickersInventory--;
                        }

                    }
                    break;
                   
                default:
                    //error
                    runVendingMachine = false;

            }

        }
        GBye();
    }

    /*=======================================================
    
    Calling the Display Messages and Prompts 
                 from the view
    
=======================================================*/
    private String InsertMoneyPrompt() {
        String result = view.settingTheUserTransactionAmount();
        return result;
    }

    private void displayMenu() {
        view.menu();
    }

    private String recordSelection() {
        String response = view.recordMenuSelection();
        return response;
    }

    private void GBye() {
        view.GoodBye();
    }

    /*=======================================================
    
    Using controller to put products into the inventory
    INVENTORY
    
=======================================================*/
    //Using controller to put products into the inventory
    private String popcornINVENTORY(String userMoney, int inventory) {
        String productIdentification = "A1";
        Products popcorn = new Products(productIdentification);
        popcorn.setCost("1.00");

        if (Double.parseDouble(userMoney) <= Double.parseDouble(popcorn.getCost())) {
            view.insufficientFunds();

            inventory++;
        } else {

            popcorn.setNumberOfItemsInInventory(inventory);
            popcorn.setProductName("Popcorn");
            dao.addProduct(productIdentification, popcorn);
            view.displayProduct(popcorn.getProductName());
            //gives value
            String changeValue = view.change(userMoney, popcorn);
            //displays value
            view.displayProduct(changeValue);
            //changes inventorystatus
            inventory--;
            dao.changeInventoryStatus(popcorn, inventory);
            return changeValue;
        }
        return userMoney;
    }

    private String pepsiINVENTORY(String userMoney, int inventory) {
        String productIdentification = "B8";
        Products pepsi = new Products(productIdentification);
        pepsi.setCost("1.25");

        if (Double.parseDouble(userMoney) <= Double.parseDouble(pepsi.getCost())) {
            view.insufficientFunds();

            inventory++;
        } else {
            pepsi.setNumberOfItemsInInventory(inventory);
            pepsi.setProductName("Pepsi");
            dao.addProduct(productIdentification, pepsi);
            view.displayProduct(pepsi.getProductName());
            //gives value
            String changeValue = view.change(userMoney, pepsi);
            //displays value
            view.displayProduct(changeValue);
            //changes inventorystatus
            inventory--;
            dao.changeInventoryStatus(pepsi, inventory);

            return changeValue;
        }
        return userMoney;

    }

    private String hersheysINVENTORY(String userMoney, int inventory) {
        String productIdentification = "G4";
        Products hersheys = new Products(productIdentification);
        hersheys.setCost("2.00");
        if (Double.parseDouble(userMoney) <= Double.parseDouble(hersheys.getCost())) {
            view.insufficientFunds();

            inventory++;
        } else {
            hersheys.setNumberOfItemsInInventory(inventory);
            hersheys.setProductName("Hersheys");
            dao.addProduct(productIdentification, hersheys);
            view.displayProduct(hersheys.getProductName());
            //gives value
            String changeValue = view.change(userMoney, hersheys);
            //displays value
            view.displayProduct(changeValue);
            //changes inventorystatus
            inventory--;
            dao.changeInventoryStatus(hersheys, inventory);
            return changeValue;
        }
        return userMoney;

    }

    private String snickersINVENTORY(String userMoney, int inventory) {
        String productIdentification = "F9";
        Products snickers = new Products(productIdentification);
        snickers.setCost("0.90");
        if (Double.parseDouble(userMoney) <= Double.parseDouble(snickers.getCost())) {
            view.insufficientFunds();
            inventory++;
        } else {
            snickers.setNumberOfItemsInInventory(inventory);
            snickers.setProductName("Snickers");
            dao.addProduct(productIdentification, snickers);
            view.displayProduct(snickers.getProductName());
            //gives value
            String changeValue = view.change(userMoney, snickers);
            //displays value
            view.displayProduct(changeValue);
            //changes inventorystatus
            inventory--;
            dao.changeInventoryStatus(snickers, inventory);
            return changeValue;
        }
        return userMoney;

    }

}
