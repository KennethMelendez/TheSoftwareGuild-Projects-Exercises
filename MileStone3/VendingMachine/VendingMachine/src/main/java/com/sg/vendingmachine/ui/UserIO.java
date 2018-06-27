/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author Kenny
 */
public interface UserIO {
    void display(String msg);
    void displayBigDecimal(BigDecimal bd);
    
    String promptRead(String msg);
    int promptInt(String msg);
}
