/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.servicelayer;

/**
 *
 * @author kmlnd
 */
public class DataValidation extends Exception {

    public DataValidation(String message) {
        super(message);
    }

    public DataValidation(String message, Throwable cause) {
        super(message, cause);
    }
    
}