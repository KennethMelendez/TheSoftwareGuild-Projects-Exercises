/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.classmodeling;

/**
 *
 * @author kmlnd
 */
public class BookPublishingSystem {
    private int ISBN;
    private int colorProfile;
    private boolean readyForPrintOrOutput;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getColorProfile() {
        return colorProfile;
    }

    public void setColorProfile(int colorProfile) {
        this.colorProfile = colorProfile;
    }

    public boolean isReadyForPrintOrOutput() {
        return readyForPrintOrOutput;
    }

    public void setReadyForPrintOrOutput(boolean readyForPrintOrOutput) {
        this.readyForPrintOrOutput = readyForPrintOrOutput;
    }
    
    
}
