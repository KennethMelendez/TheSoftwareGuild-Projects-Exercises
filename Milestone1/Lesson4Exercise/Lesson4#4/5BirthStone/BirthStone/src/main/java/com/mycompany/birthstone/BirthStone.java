/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.birthstone;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class BirthStone {
    public static void main(String[] args){
        //BirthStones!!!
        Scanner userInput = new Scanner(System.in);
        int nums;
        
        System.out.println("Give me a month number!");
        nums = userInput.nextInt();
        
        if (nums == 1){
            System.out.println("January - Garnet");
        } else if (nums == 2){
            System.out.println("February - Amethyst");
        } else if (nums == 3){
            System.out.println("March - Aquamarine");
        } else if (nums == 4){
            System.out.println("April - Diamond");
        } else if (nums == 5){
            System.out.println("May - Emerald");
        } else if (nums == 6){
            System.out.println("June - Pearl");
        } else if (nums == 7){
            System.out.println("July - Ruby");
        } else if (nums == 8){
            System.out.println("August - Peridot");
        } else if (nums == 9){
            System.out.println("September - Sapphire");
        } else if (nums == 10){
            System.out.println("October - Opal");
        } else if (nums == 11){
            System.out.println("November - Topaz");
        } else if (nums == 12){
            System.out.println("December - Turquoise");
        } else {
            System.out.println("I think you must be confused.....that's not a month number");
        }
        
        
    }
}
