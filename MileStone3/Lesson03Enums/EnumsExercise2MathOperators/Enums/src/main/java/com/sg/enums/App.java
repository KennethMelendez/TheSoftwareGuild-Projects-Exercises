/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.enums;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
        
        /*
        -------------
        |   ENUMS   |
        -------------
        
        Exercise 2: Math Operators
        
        Create an enum for math Operators: plus, minus, multiply, and divide.
        Create an App class that reads in two operands and calls the calculate method (shown below) one time for each operator in your enum.
        Output your results to the screen after every operation is performed.   */
        
           IntMath math = new IntMath();
           int PlusOperation = math.calculate(MathOperator.PLUS, 10, 4);
           int MinusOperation = math.calculate(MathOperator.MINUS, 10, 4);
           int MultiplyOperation = math.calculate(MathOperator.MULTIPLY, 10, 4);
           int DivideOperation = math.calculate(MathOperator.DIVIDE, 10, 4);
           
           /*======================
           |      OUTPUT          |
           ======================*/
           
           System.out.println(PlusOperation);
           System.out.println(MinusOperation);
           System.out.println(MultiplyOperation);
           System.out.println(DivideOperation);
    }
}
