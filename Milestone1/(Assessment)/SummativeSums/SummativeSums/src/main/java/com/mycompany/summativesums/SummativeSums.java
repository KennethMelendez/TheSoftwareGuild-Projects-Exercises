/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.summativesums;



/**
 *
 * @author Kenny
 */
public class SummativeSums {
    public static void main(String[] args) {
        //ArrayList
        int[] nums1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] nums2 = { 999, -60, -77, 14, 160, 301 };
        int[] nums3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };
        
        //Variables calling the method for adding the arrays
        int total = addingArrays(nums1);
        int total2 = addingArrays(nums2);
        int total3 = addingArrays(nums3);
        
        //printing out the arrays into the console!
        System.out.println("#1 Array Sum: " + total);
        System.out.println("#2 Array Sum: " + total2);
        System.out.println("#3 Array Sum: " + total3);
    }
    
    //Method for adding the total arrays
    public static int addingArrays(int[] sums){
        //Declaring the variables
        int total = 0;
        int sum = 0;
        //creating a for loop which will go through the arrays and add them one by one
        for(int n = 0; n < sums.length; n++){
            sum += sums[n];
            total = sum;
        }
        //will return the total number 
        return total;
    }
}

