/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stillpositive;

/**
 *
 * @author Kenny
 */
public class StillPositive {
    public static void main(String[] args) {
        int[] numbers = { 389, -447, 26, -485, 712, -884, 94, -64, 868, -776, 227, -744, 422, -109, 259, -500, 278, -219, 799, -311};
    
        
        for(int x = 0; x < numbers.length; x++){
            if (x % 2 == 0){
            System.out.println(numbers[x]);
            }
        }
   }
}
