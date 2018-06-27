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

import java.util.Scanner;
public class ConsoleIO {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void Display(String message){
        System.out.println(message);
    }
    
    public static void DisplayInt(int message){
        System.out.println(message);
    }
    
    public static String UserPrompt(String message){
        System.out.println(message);
        String result = sc.nextLine();
        return result;
    } 
    
    public static int UserPromptInt(String message){
        String result = UserPrompt(message);
        int output = Integer.parseInt(result);
        return output;
    }
}
