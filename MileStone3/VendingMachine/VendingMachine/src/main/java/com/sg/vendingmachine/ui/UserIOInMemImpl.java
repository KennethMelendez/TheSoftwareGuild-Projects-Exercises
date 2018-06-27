/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Kenny
 */
public class UserIOInMemImpl implements UserIO {

    Scanner sc = new Scanner(System.in);
    
    @Override
    public void display(String msg) {
        System.out.println(msg);
    }

    @Override
    public String promptRead(String msg) {
        String result = "";
        display(msg);
        result = sc.nextLine();
        return result;
    }

    @Override
    public int promptInt(String msg) {
        int result = 0;
        String recordedResult = promptRead(msg);
        result = Integer.parseInt(recordedResult);
        return result;
    }

    @Override
    public void displayBigDecimal(BigDecimal bd) {
        System.out.println(bd);
    }
    
}
