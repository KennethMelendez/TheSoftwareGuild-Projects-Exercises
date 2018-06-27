/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDLibraryui;

import DVDLibraryui.UserIO;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOConsoleImpl implements UserIO {

    private Scanner sc = new Scanner(System.in);
    
    @Override
    public void print(String prompt) {
        System.out.println(prompt);
    }

    @Override
    public double readDouble(String prompt) {
        double result = 0;
        String input = readString(prompt);
        result = Double.parseDouble(input);
        return result;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        String input = readString(prompt);
        double result = Double.parseDouble(input); 
        if (result < min || result > max){
            readString("Number not in range");
        }
        return result;
    }

    @Override
    public float readFloat(String prompt) {
        float result = 0;
        String input = readString(prompt);
        result = Float.parseFloat(input);
        return result;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        String input = readString(prompt);
        float result = Float.parseFloat(input); 
        if (result < min || result > max){
            readString("Number not in range");
        }
        return result;
    }

    @Override
    public int readInt(String prompt) {
        int result = 0;
        String input = readString(prompt);
        result = Integer.parseInt(input);
        return result;    
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        
       
        String input = readString(prompt);
        int result = Integer.parseInt(input); 
        if (result < min || result > max){
            readString("Number not in range");
        }
        return result;
        
    }

    @Override
    public long readLong(String prompt) {
        long result = 0;
        String input = readString(prompt);
        result = Integer.parseInt(input);
        return result;    
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        String input = readString(prompt);
        int result = Integer.parseInt(input);
        if (result < min || result > max){
            readString("Number not in range");
        }
        return result;    
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String result = sc.nextLine();
        return result;
    }
    
}
