/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentquizscores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



/**
 *
 * @author kmlnd
 */
public class StudentQuizScores implements Students{
    
//======================================================================================
        
    // ARRAY LIST
    private static ArrayList<Integer> list = new ArrayList<>();
    
    //HASHMAP
    private static HashMap<String, ArrayList<Integer>> hash = new HashMap<String,ArrayList<Integer>>();
    
    //Student UI
    private static Students UI = new StudentQuizScores();
    
    //scanner
    private static Scanner sc = new Scanner(System.in);
    
//======================================================================================
    
    public static void main(String[] args) {
        
        //Boolean for TURNING ON APP
        boolean turnOn = true;

        
        
        
      while(turnOn = true){
        
          
        //Menu
        UI.menu();
          
          
        String response = ConsoleIO.Print("Input Keyword");  
          

        
        
        
                //Navigating to program
                if(response.equalsIgnoreCase("Exit")){
                    break;
                } 
                
                if(response.equalsIgnoreCase("add student")){
                    UI.addStudent();
                } 
                
                if(response.equalsIgnoreCase("view quiz scores")){
                    UI.viewQuizScoresOfStudent();
                } 
                
                if(response.equalsIgnoreCase("remove student")){
                    UI.removeStudent();
                } 
          
                if(response.equalsIgnoreCase("view student list")){
                    UI.viewListOfSTudents();
                } 
                
                if(response.equalsIgnoreCase("average")){
                    UI.averageQuizScoreForStudent();
                } 
        
                
     
          
          
          
          

        
      }//While oop
    }

    @Override
    public void viewListOfSTudents() {
        //view List
        for(Map.Entry<String,ArrayList<Integer>> entry : hash.entrySet()){
            System.out.println("Student: " + entry.getKey());
        }
    }

    
    public void addStudent() {        
        String name = ConsoleIO.Print("Name of Student");
     
        hash.put(name, new ArrayList<Integer>());
        
        
        boolean insertAnotherScore = true;
        
        while(insertAnotherScore = true){
        
            int score = ConsoleIO.readInt("Please put score");
            hash.get(name).add(score);
            
           
                
              
            
                String response = ConsoleIO.Print("Continue adding Scores? Yes or No?");
                if(response.equalsIgnoreCase("no")){
                    break;
                } else if(response.equalsIgnoreCase("yes")){
                   
                    ConsoleIO.Display("Thank you");
                   
                    
                } else {
                   
                    ConsoleIO.Display("Error: Adding another score");                
                }

                
            
        }//end of loop
        
        //view List
        for(Map.Entry<String,ArrayList<Integer>> entry : hash.entrySet()){
            System.out.println("Student: " + entry.getKey() + " " + "Score " + entry.getValue());
        }
        

        
        
        
    }

    @Override
    public void removeStudent() {
        
        String name = ConsoleIO.Print("Name of Student");
        hash.remove(name);
        ConsoleIO.Display("Student Removed");
        
    }

    @Override
    public void viewQuizScoresOfStudent() {
        //view List
        for(Map.Entry<String,ArrayList<Integer>> entry : hash.entrySet()){
            System.out.println("Student: " + entry.getKey() + " " + "Score " + entry.getValue());
        }
    }

    @Override
    public void averageQuizScoreForStudent() {
        
        int total = 0;
        int countHowManyNumbers = 0;
        String name = ConsoleIO.Print("Name of Student");
        ArrayList<Integer> getValues = hash.get(name);
        for(Integer values : getValues){
            total = total + values;
            countHowManyNumbers++;
        }
        
        ConsoleIO.Display("Average of " + name + " is ");
        int average = total / countHowManyNumbers;
        System.out.println(average);
    }

    @Override
    public void menu() {
        ConsoleIO.Display("*/*=========================================================*");
        ConsoleIO.Display("*                                                           *");
        ConsoleIO.Display("*        STUDENT QUIZ SCORES PROGRAM                        *"); 
        ConsoleIO.Display("*                                                           *");
        ConsoleIO.Display("============================================================*");
        ConsoleIO.Display("*                                                           *");
        ConsoleIO.Display("*     >|List of key words for program navigation|<          *");
        ConsoleIO.Display("*___________________________________________________________*");
        ConsoleIO.Display("*Add Student | Remove Student | View Quiz Scores | Average |*");
        ConsoleIO.Display("*            |   Exit   | view student list |               */");
        ConsoleIO.Display("*==========================================================*/");
    }
}
