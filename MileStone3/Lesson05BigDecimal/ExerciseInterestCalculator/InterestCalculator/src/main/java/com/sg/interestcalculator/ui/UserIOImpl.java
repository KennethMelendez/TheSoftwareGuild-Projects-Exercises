/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator.ui;

import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOImpl implements UserIO{

    Scanner sc = new Scanner(System.in);
    
    @Override
    public void DisplayString(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String msg) {
        String result = "";
        DisplayString(msg);
        result = sc.nextLine();
        return result;
    }
    
}
