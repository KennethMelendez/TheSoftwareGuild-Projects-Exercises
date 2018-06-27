/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.healthyhearts;

/**
 *
 * @author Kenny
 */
import java.util.Scanner;
public class HealthyHearts {
    public static void main(String[] args) {
        
/*========================================================

            HEALTHY HEARTS - KENNTH MELENDEZ

========================================================*/
        
        
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
< :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: >
< ::::::::::::            ::::::::::::            :::::::::::: >
< :::::::::                   ::::                   ::::::::: >
< :::::::         ********     ::     ********         ::::::: >
< :::::      ****          ****  ****         ****       ::::: >
< ::::     ****               ****               ****     :::: >
< :::     ****                 **                 ****     ::: >
< :::     ****                                    ****     ::: >
< ::::     ****                                  *****    :::: >
< :::::     ****                                ****     ::::: >
< :::::::     ****                            ****     ::::::: >
< :::::::::     ****                        ****     ::::::::: >
< :::::::::::     ****                    ****     ::::::::::: >
< ::::::::::::::      ****            ****      :::::::::::::: >
< :::::::::::::::::       ****    ****       ::::::::::::::::: >
< ::::::::::::::::::::        ****        :::::::::::::::::::: >
< :::::::::::::::::::::::      **      ::::::::::::::::::::::: >
< :::::::::::::::::::::::::          ::::::::::::::::::::::::: >
< :::::::::::::::::::::::::::      ::::::::::::::::::::::::::: >
< :::::::::::::::::::::::::::::  ::::::::::::::::::::::::::::: >
< :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: >
  ()()()()()()()()()()()()()()()()()()()()()()()()()()()()()()*/
        
/*========================================================

    HEALTHY HEARTS - KENNTH MELENDEZ

========================================================*/



        //Scanner Import for the age input
        Scanner ageInput = new Scanner(System.in);
        
        
        //Textoutput and store the age
        System.out.println("What is your age?");
        int age = ageInput.nextInt();
        
        //give heart results
        System.out.println("Your maximum heart rate should be " + maximumHeartRate(age) + " beats per minute");
        System.out.println(heartRateZone(maximumHeartRate(age)));
        
        
        
        
        
    }

    /*================================
    Methods
    ================================*/

    public static int maximumHeartRate(int usersage){
        int maximumHeartRate = 220 - usersage;
        return maximumHeartRate;
    }
    
        public static String heartRateZone(int maxHeartRate){
        
        double fiftyPercent = .50 * maxHeartRate;
        double eightyFivePercent = .85 * maxHeartRate;
        
        //converting result
        int a = (int) fiftyPercent;
        int b = (int) eightyFivePercent;
        //output
        String result = "Your target HR Zone is " + a + " - " + b + " beats per minute";
        return result;
    }

}

