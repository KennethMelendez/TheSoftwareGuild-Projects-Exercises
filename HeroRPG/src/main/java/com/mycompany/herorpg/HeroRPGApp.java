/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.herorpg;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Kenny
 */
public class HeroRPGApp {
    public static void main(String[] args) {
                System.out.println("What is your name, Hero");
        Scanner myScanner = new Scanner(System.in);
        String heroName = myScanner.nextLine();

        double maxHealth = 10;
        String heroClass;
        Random randomizer = new Random();

        do {
            System.out.println("What class is your hero");
            heroClass = myScanner.nextLine();
            if ("DPS".equals(heroClass)) {
                maxHealth -= 2;
            } else if ("Healer".equals(heroClass)) {
                maxHealth /= 2;
            } else if ("Tank".equals(heroClass)) {
                maxHealth *= 2;
            } else {
                System.out.println("You've entered an invalid class [Healer, DPS, Tank]");
            }
        } while (maxHealth == 10);
        double health = maxHealth;
        int numberofMurlockDeaths = 0;

        while (health > 0) {
            for (int i = 0; i < 10; i++) {
                System.out.println("You have taken a step! Currently step " + (i + 1) + "out of 10");

                int encounter = randomizer.nextInt(100);
                if (encounter <= 50) {
                    // we've encounter a murlock
                    System.out.println("Aaaaaughibbrgubugbugrguburgle!");
                    int murlockHealth = 5;
                    while (health > 0 && murlockHealth > 0) {
                        // try to hit the murlock
                        int hitChance = randomizer.nextInt(100);
                        if (hitChance <= 75) {
                            System.out.println("You've hit the murlock for 2pts of damage");
                            murlockHealth -= 2;
                        }
                        // check to see if murlock is dead.
                        if (murlockHealth <= 0) {
                            System.out.println("You've defeated the murlock!");
                            System.out.println("Your current health is: " + health + "/" + maxHealth);
                            numberofMurlockDeaths++;
                            break;
                        }
                        hitChance = randomizer.nextInt(100);
                        if (hitChance <= 75) {
                            System.out.println("You've hit for .5 pts of damage");
                            health -= .5;
                        }
                        // murlock tries to hit us
                    }
                } else {
                    System.out.println("You did not encounter any murlocks this time");
                }
            }
            if (health > 0 && health < maxHealth){
                health += .5;
            }
            // step 1 Do we encounter a murlock
            // if yes, kill the murlock by not dying
            // if no, continue
        }
        System.out.println("You have died, you've killed " + numberofMurlockDeaths);

    }
}
