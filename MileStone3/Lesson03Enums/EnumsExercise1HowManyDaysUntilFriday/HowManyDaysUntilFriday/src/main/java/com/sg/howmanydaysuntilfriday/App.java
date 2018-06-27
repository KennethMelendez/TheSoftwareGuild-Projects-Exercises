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
public class App {

    public static void main(String[] args) {
        HowManyDaysUntilFriday day = new HowManyDaysUntilFriday();
        UserIO io = new UserIOimpl();

        boolean keepGoing = true;
        

        while (keepGoing == true) {
            io.Display("How many days untill Friday?");
            String userInput = io.readStringPrompt("Insert a Weekday");
            
            if (userInput.equalsIgnoreCase("monday")) {
                day.daysTillFriday(WeekOperator.MONDAY);
                break;
            } else if (userInput.equalsIgnoreCase("tuesday")) {
                day.daysTillFriday(WeekOperator.TUESDAY);
                break;
            } else if (userInput.equalsIgnoreCase("wednesday")) {
                day.daysTillFriday(WeekOperator.WEDNESDAY);
                break;
            } else if (userInput.equalsIgnoreCase("thursday")) {
                day.daysTillFriday(WeekOperator.THURSDAY);
                break;
            } else if (userInput.equalsIgnoreCase("friday")) {
                day.daysTillFriday(WeekOperator.FRIDAY);
                break;
            } else {
                System.out.println("Not a week!");
            }

        }

        System.out.println("Thank you!");
    }
}
