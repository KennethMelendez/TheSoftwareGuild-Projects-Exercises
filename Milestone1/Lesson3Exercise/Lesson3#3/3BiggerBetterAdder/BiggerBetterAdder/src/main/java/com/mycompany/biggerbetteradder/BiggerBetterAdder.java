/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biggerbetteradder;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;
public class BiggerBetterAdder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int x = 10;
        int y = 2234;

        
        System.out.println("Give me a number!");
        x = myScanner.nextInt();
        System.out.println("Give me another NUMBERRRR!!!! AHAHAAHAHA IM CRAZY!!");
        y = myScanner.nextInt();
        int sums = x + y;
        System.out.println("Oh, here I added those numbers it equals : " + sums );
        
    }
}
