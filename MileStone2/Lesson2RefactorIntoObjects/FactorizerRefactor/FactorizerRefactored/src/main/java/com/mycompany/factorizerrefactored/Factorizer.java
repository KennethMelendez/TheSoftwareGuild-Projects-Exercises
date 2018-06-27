/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.factorizerrefactored;

/**
 *
 * @author kmlnd
 */

public class Factorizer {
    
    
    
    public void run(){
        
        
        int factorizerNum = ConsoleIO.PromptUserInt("What number would you like to factor?");
        ConsoleIO.DisplayInt(factorizerNum);
        int result = factorizer(factorizerNum);
        ConsoleIO.Display("The factorial of " + factorizerNum + " is " + result);
    }
    
    
    public static int factorizer(int UserNumber){
       
        int factorial = 1;
        int x = 0;
        while(x < UserNumber){
            x++;
            factorial = x * factorial;
        }
        return factorial;
    }
    
}
