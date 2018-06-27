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
import java.util.Scanner;
public class ConsoleIO {
    
    private static Scanner sc = new Scanner(System.in);
    
    //Display String
    public static void Display(String message){
        System.out.println(message);
    }
    //Displays Integer
    public static void DisplayInt(int message){
        System.out.println(message);
    }
    //Prompts user and records response for string
    public static String PromptUser(String message){
        System.out.println(message);
        String result = sc.nextLine();
        return result;
    }
    //Prompts user and records response for integer
    public static int PromptUserInt(String message){
        String prompt = PromptUser(message);
        int result = Integer.parseInt(prompt);
        return result;
    }
    
  
    
    
}
