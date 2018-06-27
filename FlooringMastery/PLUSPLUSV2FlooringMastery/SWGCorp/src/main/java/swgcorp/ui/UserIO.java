/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swgcorp.ui;

import java.math.BigDecimal;

/**
 *
 * @author kmlnd
 */
public interface UserIO {

    void Display(String msg);
    
    void DisplayInt(int num);
    
    void DisplayBigDecimal(String msg);
    
    BigDecimal PromptBigDecimal(String msg);

    String PromptString(String msg);

    int PromptInt(String msg);
    
   
}
