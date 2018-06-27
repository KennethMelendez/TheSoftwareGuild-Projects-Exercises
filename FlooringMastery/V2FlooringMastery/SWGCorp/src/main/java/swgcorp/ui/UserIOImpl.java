/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOImpl implements UserIO {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void Display(String msg) {
        System.out.println(msg);
    }

    @Override
    public String PromptString(String msg) {
        String result = "";
        Display(msg);
        result = sc.nextLine();
        return result;
    }

    @Override
    public int PromptInt(String msg) {
        int result;
        String prompt = PromptString(msg);
        result = Integer.parseInt(prompt);
        return result;
    }
    
    
    /*
        Used for displaying Big Decimals
    */

    @Override
    public void DisplayBigDecimal(String msg) {
        BigDecimal conversion = new BigDecimal(msg);
        System.out.println(conversion);
    }

    
/*================================================================
        Use for currency
================================================================*/
    
    /*
        Creating a method that inputs and prompts a string and converts the result
        into a big decimal
    */
    
    @Override
    public BigDecimal PromptBigDecimal(String msg) {
        String result = PromptString(msg);
        BigDecimal conversion = new BigDecimal(result);
        return conversion;
    }

}
