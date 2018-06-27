/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.howmanydaysuntilfriday;

/**
 *
 * @author kmlnd
 */
public class HowManyDaysUntilFriday {
    public void daysTillFriday(WeekOperator day){
        switch(day){
            case MONDAY:
                System.out.println("There are 4 days untill Friday.");
                break;
            case TUESDAY:
                System.out.println("There are 3 days untill Friday.");
                break;
            case WEDNESDAY:
                System.out.println("There are 2 days untill Friday.");
                break;
            case THURSDAY:
                System.out.println("There are 1 days untill Friday.");
                break;
            case FRIDAY:
                System.out.println("It's Friday!");
                break;
            default:
                
                throw new UnsupportedOperationException();
        }
        
    }
}
