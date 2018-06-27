/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.minizork;

/**
 *
 * @author kmlnd
 */

import java.util.Scanner;

public class MiniZork {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You feel a strange presence trying to consuming you..");
                System.out.println("You are trapped, what do you do?");
                System.out.println("Pull hand out or do nothing");
                action = userInput.nextLine();
                
                if (action.equals("pull hand out")) {
                    System.out.println("You pull your hand as hard as you could and succeed. But you find that your hand is covered in blood");
                    System.out.println("You freak out, knocking over the mailbox.");
                    System.out.println("Weird ooze crawls from inside the mailbox trying to wrap around you");
                    System.out.println("You noticed a bat laying on the ground, what do you do?");
                    System.out.println("Grab bat or run");
                    action = userInput.nextLine(); 
                    
                        if (action.equals("grab bat")){
                    System.out.println("You grab the bat and try and smash the mailbox and ooze");
                    System.out.println("The ooze consumes the bat and your legs");
                    System.out.println("It slowly eats you whole as your scream for help");
                    System.out.println("You are dead.");
                    } else if (action.equals("run")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                    }
                        
                } else if (action.equals("do nothing")){
                    System.out.println("The weird ooze wraps around you as you stay completely still");
                    System.out.println("You start to hear voices.....telling you to kill");
                    System.out.println("You black out and wake up in a jailcell people crying around you frightened");
                    System.out.println("What do you do?");
                    System.out.println("Ask why are you scared or ask what happened");
                    action = userInput.nextLine();
                    
                    if (action.equals("ask why are you scared")){
                        System.out.println("A man wearing a black suit walks upto you and flashes you with a bright red light");
                        System.out.println("?????");
                        System.out.println("You lost your memories and you are stuck in jail");
                        System.out.println("The End");
                    } else if (action.equals("ask what happened")){
                        System.out.println("A man wearing a black suit walks upto you and responds");
                        System.out.println("You don't remember anything?");
                        System.out.println("You are then brought to an isolated room left to die");
                        System.out.println("The End");
                    }
                } 
                
            }
        } else if (action.equals("go to the house")) {
            System.out.println("The doors close and lock behind you");
            System.out.println("What do you do?");
            System.out.println("Attempt to break the lock or explore the house?");
            action = userInput.nextLine();
            
            if (action.equals("attempt to break the lock")){
                System.out.println("You break the lock!");
                System.out.println("You feel a presence grab your shoulder");
                System.out.println("What do you do?");
                System.out.println("Turn around or RUN?");   
                action = userInput.nextLine();
                    if (action.equals("turn around")){
                    System.out.println("A black mist consumes you");
                    System.out.println("You hear a high pitched scream and pass out");
                    System.out.println("You are dead.");
                    } else if (action.equals("run")){
                    System.out.println("YOU SLAM THE DOOR OPEN AND SAFELY RETURN HOME");
                    System.out.println("The End");
                    }
            }
            
            if (action.equals("explore the house")){
                System.out.println("You look around and walk up the stairs..");
                System.out.println("You noticed an empty room what do you do?");
                System.out.println("Keep exploring or go into the room?");
                action = userInput.nextLine();
                
                if(action.equals("keep exploring")){
                    System.out.println("You find an empty chest with a picture frame of happy family");
                    System.out.println("You feel lightheaded and passout.....");
                    System.out.println(".......You wake up infront of your home bleeding...");
                    System.out.println("The End..");
                } else if (action.equals("go into the room")){
                    System.out.println("The DOOR SHUTS IN");
                    System.out.println("The room slowly closes in and crushes you");
                    System.out.println("Looks like you became a Jill Sandwhich");
                    System.out.println("End.");
                }
                
                
            }
        }
        
        
    }
}
