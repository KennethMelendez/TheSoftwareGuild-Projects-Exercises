/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fortimesfor;

import java.util.Scanner;

/**
 *
 * @author Kenny
 */
public class ForTimesFor {
    public static void main(String[] args) {
        
        
        
        Scanner input = new Scanner(System.in);
        Scanner quizAnswer = new Scanner(System.in);
        
        int timesResult;

        System.out.println("Which times table shall I recite?");
        int userInput = input.nextInt();

        int score = 0;
        double fiftyPercentScore = 16 * 0.50;
        double ninetyPercentScore = 16 * 0.90;
        for(int i = 1; i < 16; i++){   
        timesResult = userInput * i;    
            
        System.out.println(i + " * " + userInput + " is: ");
        int quizTestAnswer = quizAnswer.nextInt();

        if(quizTestAnswer == timesResult){
            System.out.println("Correct!");
            score++;
            System.out.println(score);
        } else if (quizTestAnswer != timesResult){
            System.out.println("Sorry no... the answer is " + timesResult);
        }
        
    }
        
        if (score <= fiftyPercentScore ){
            System.out.println("Study More!");
        } else if (score >= ninetyPercentScore){
            System.out.println("WOW CONGRATS. YOU GOT A HIGH SCORE");
        }
        
    }
}
