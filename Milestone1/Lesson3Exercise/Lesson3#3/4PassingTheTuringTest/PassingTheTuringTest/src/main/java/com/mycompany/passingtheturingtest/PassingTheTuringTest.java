/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.passingtheturingtest;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class PassingTheTuringTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String name;
        String food;
        String color;
        Double number;
        
        System.out.println("HELLO HUMAN, HOW ARE YOU. WHAT IS YOUR NAME.");
        name = input.nextLine();
        
        System.out.println("WOW SO YOUR NAME IS " + name + " ?");
        System.out.println("IT SOUNDS LOVELY, NOW TELL ME YOUR FAVORITE FOOD IM HUNGRY AND IM UNSURE OF WHAT TO EAT...");
        food = input.nextLine();
        
        System.out.println("OH WOW THAT ACTUALLY SOUNDS DELICIOUS");
        System.out.println("Yeah, I'm actually not a robot. So anyway what's your favorite color?");
        color = input.nextLine();
        
        System.out.println("Hmmm i like the color " + color + " as well .... now tell me your favorite number...");
        number = input.nextDouble();
        
        System.out.println("Oh that number " + number + " is cool too. Welp I'm bored now bye!!!");
        
        
        
        
        
    }
}
