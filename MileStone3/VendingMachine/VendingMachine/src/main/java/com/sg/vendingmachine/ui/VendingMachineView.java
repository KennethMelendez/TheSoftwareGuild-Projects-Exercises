/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Change;
import com.sg.vendingmachine.dto.Products;
import java.math.BigDecimal;

/**
 *
 * @author Kenny
 */
public class VendingMachineView {

    UserIO io;
    Change change;
    
    public VendingMachineView(UserIO io,Change change) {
        this.io = io;
        this.change = change;
    }

    public String settingTheUserTransactionAmount(){
        String result = io.promptRead("Welcome. Insert Amount of Money Below (XX.XX) ");
        return result;
    }
    
    public String change(String userMoney, Products product){
        String result = change.calculateChange(userMoney, product);
        return result;
    }
    
    public void displayChange(BigDecimal bd){
        io.displayBigDecimal(bd);
    }
    
    public void hitEnterToContinue(){
        io.promptRead("Hit Enter To Continue");
    }
    
    public void menu() {
        
        
        io.display("___________________________________");
        io.display("|* ********************************|");
        io.display("|*     | VENDING MACHINE |        *|");
        io.display("|**********************************|");
        io.display("|__________________________________|");
        io.display("|                                  |");
        io.display("|         POPCORN   A1  $1.00      |");
        io.display("|__________________________________|");
        io.display("|                                  |");
        io.display("|         PEPSI     B8  $1.25      |");
        io.display("|__________________________________|");
        io.display("|                                  |");
        io.display("|         HERSHEYS  G4  $2.00      |");
        io.display("|__________________________________|");
        io.display("|                                  |");
        io.display("|         SNICKERS  F9  $0.90      |");
        io.display("|__________________________________|");
        io.display("|___________|_EXIT__|______________|");
        io.display("|__________________________________|");
        io.display("");
        io.display("Input Options: (A1) (B8) (G4) (F9) (EXIT)");
        io.display("");
    }
    
    public void GoodBye(){
        String bye = "Good Bye! Thank you for shopping.";
        io.display(bye);
    }
    
    public String recordMenuSelection(){
        String response = io.promptRead("Input Selection");
        return response;
    }
    public void displayProduct(String msg){
        io.display(msg);
    }
    
    public void SOLDOUT(){
        io.display("Sorry We are SOLD OUT.");
    }
    public void insufficientFunds(){
        io.display("Insufficient Funds");
    }
  
}
