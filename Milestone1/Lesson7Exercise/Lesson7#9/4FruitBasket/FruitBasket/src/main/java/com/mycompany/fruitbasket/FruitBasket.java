/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fruitbasket;

/**
 *
 * @author Kenny
 */
import java.util.ArrayList;

public class FruitBasket {

    public static void main(String[] args) {
        String[] fruit = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange", "Orange"};

        // Fruit sorting code goes here!
        int totalFruits = 0;
        for (int x = 0; x < fruit.length; x++) {
            System.out.println(fruit[x]);
            if (fruit[x] == "Orange" || fruit[x] == "Apple") {
                totalFruits++;
                System.out.println(totalFruits);
            }
        }

        int oranges = 0;
        ArrayList<String> fruitBasketWithOranges = new ArrayList<>();
        for (int x = 0; x < fruit.length; x++) {
            System.out.println(fruit[x]);
            if (fruit[x] == "Orange") {
                oranges++;
                System.out.println(oranges);
            }
            for (int a = 0; a < oranges; a++) {
                fruitBasketWithOranges.add("Oranges");

            }
        }

        int apple = 0;
        ArrayList<String> fruitBasketWithApples = new ArrayList<>();
        for (int x = 0; x < fruit.length; x++) {
            System.out.println(fruit[x]);
            if (fruit[x] == "Apple") {
                apple++;
                System.out.println(apple);

            } //end of if

            //adding apples to new array
            for (int a = 0; a < apple; a++) {
                fruitBasketWithApples.add("Apples");

            }
        }//end of loop
        System.out.println("Total fruits are " + totalFruits);
        System.out.println("There are " + oranges + " oranges");
        System.out.println("There are " + apple + " apples");

    }

}
