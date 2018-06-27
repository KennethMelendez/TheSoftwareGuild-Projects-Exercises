/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizscores;

import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class ConsoleIO {
    public static Scanner sc = new Scanner(System.in);
    
    
    public static void Display(String message){
        System.out.println(message);
    }
    
    public static String Print(String message){
        
        System.out.println(message);
        String result = sc.nextLine();
        return result;
    }
    
    
    public static int readInt(String message){
        int result = 0;
        String input = Print(message);
        result = Integer.parseInt(input);
        return result;
    }
    
    
    public static int readInt(String message, int min, int max){
        int resultMiddle = max / min;
        String input = Print(message);
        int result = Integer.parseInt(input); 
        while (result != resultMiddle){
            input = Print(message);
            result = Integer.parseInt(input); 
        }
        System.out.println("You guess right.");
        
        return result;
    }
    
    public static Double readDouble(String message){
        double result = 0;
        String input = Print(message);
        result = Double.parseDouble(input);
        return result;
    }
    
    public static Double readDouble(String message, double min, double max){
        double resultMiddle = max / min;
        String input = Print(message);
        double result = Double.parseDouble(input); 
        while (result != resultMiddle){
            input = Print(message);
            result = Double.parseDouble(input); 
        }
        System.out.println("You guess right.");
        
        return result;
    }
    
    public static float readFloat(String message){
        float result = 0;
        String input = Print(message);
        result = Float.parseFloat(input);
        return result;
    }
    
    public static float readFloat(String message, float min, float max){
        float resultMiddle = max / min;
        String input = Print(message);
        float result = Float.parseFloat(input); 
        while (result != resultMiddle){
            input = Print(message);
            result = Float.parseFloat(input); 
        }
        System.out.println("You guess right.");
        
        return result;
    }
    
}
