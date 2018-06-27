/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import com.sg.interestcalculator.ui.UserIO;
import com.sg.interestcalculator.ui.UserIOImpl;
import java.math.BigDecimal;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        String CURRENTBALANCE = io.readString("Insert Current Balance");
        String QUARTERLYINTERESTRATE = io.readString("Insert Quarterly Interest Rate");
        BigDecimal CB = new BigDecimal(CURRENTBALANCE);
        BigDecimal QIR = new BigDecimal(QUARTERLYINTERESTRATE);
        Calculate c = new Calculate();
        c.calculate(CB, QIR);
        System.out.println(c.calculate(CB, QIR));
    }

}
