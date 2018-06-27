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
public class SimpleCalculator {
    public void Run(){
        
      boolean finishedInput = false;
      boolean exit = false;
      int result = 0;
      int x = 0;
      int y = 0;
      String operator = "";
while(exit == false){      
     do{
         
        App.Menu();
        
        
            
            
        
        x = ConsoleIO.UserPromptInt("____ () ____ = _____");
        operator = ConsoleIO.UserPrompt("+ , / , * , -");
        

        
        
        
        y = ConsoleIO.UserPromptInt(x + " " + operator + " ____ = _____");
        

        
          switch (operator) {
              case "+":
                  result = SimpleCalculator.Addition(x, y);
                  break;
              case "-":
                  result = SimpleCalculator.Subtraction(x, y);
                  break;
              case "/":
                  result = SimpleCalculator.Division(x, y);
                  break;
              case "*":
                  result = SimpleCalculator.Multiplication(x, y);
                  break;
              default:
                  ConsoleIO.Display("Error");
                  break;
          }
        
        
        
        finishedInput = true;
        
     }while(finishedInput = false);
            
        ConsoleIO.Display(x + " " + operator + " " + y + " " + "= " + result);
        String end = ConsoleIO.UserPrompt("Input Exit to end application , Input anything to continue");
        if(end.equalsIgnoreCase("exit")){
            exit = true;
            ConsoleIO.Display("Thank you");
        } else {
            
        }
}//End of boolean loop       
     
     
    }
    
    public static int Addition(int x, int y){
        int result = x + y;
        return result;
    }
    
    public static int Subtraction(int x, int y){
        int result = x - y;
        return result;
    }
    
    public static int Multiplication(int x, int y){
        int result = x * y;
        return result;
    }
    
    public static int Division(int x, int y){
        int result = x / y;
        return result;
    }
}
