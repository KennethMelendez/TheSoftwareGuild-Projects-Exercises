/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

/**
 *
 * @author kmlnd
 */
public interface UserIO {
    void Display(String msg);
    String PromptString(String msg);
    int PromptInt(String msg);

    //added for time
    public String PromptStringTime();
    
}
