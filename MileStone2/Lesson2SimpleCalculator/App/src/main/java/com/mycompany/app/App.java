/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.app;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
        SimpleCalculator Calculator = new SimpleCalculator();

        
        Calculator.Run();
        

    }
    
    
    public static void Menu(){
        
        
 ConsoleIO.Display("OoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOo");
 ConsoleIO.Display("8                                                      8");
 ConsoleIO.Display("O          Calculator Math Operators                   O");
 ConsoleIO.Display("O   Input each number and operator one at a time       O");
 ConsoleIO.Display("8              +    /    *    -                        8");
 ConsoleIO.Display("8                                                      8");
 ConsoleIO.Display("OoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOo");
 ConsoleIO.Display(" ");
 ConsoleIO.Display("________________________________________________________");
 ConsoleIO.Display(" ");
    }
}
