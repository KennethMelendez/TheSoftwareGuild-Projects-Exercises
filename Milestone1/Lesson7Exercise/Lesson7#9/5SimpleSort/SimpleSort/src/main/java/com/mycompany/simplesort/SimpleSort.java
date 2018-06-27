/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simplesort;

import java.util.Arrays;

/**
 *
 * @author Kenny
 */
public class SimpleSort {

    public static void main(String[] args) {

        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 55, 67, 88, 99};
        int[] secondHalf = {1, 4, 8, 11, 15, 18, 21, 44, 54, 79, 89, 100};

        int[] wholeNumbers = new int[24];

        // Sorting code should go here!
        int[] allNums = new int[firstHalf.length + secondHalf.length];
        System.arraycopy(firstHalf, 0, allNums, 0, firstHalf.length);
        System.arraycopy(secondHalf,0,allNums,firstHalf.length,secondHalf.length);
        
        Arrays.sort(allNums);
        for(int sums: allNums){
            System.out.println("Here yoooo gooo! Nice and ordered..");
            System.out.print(" " + sums + " ");
        }
    }
}
