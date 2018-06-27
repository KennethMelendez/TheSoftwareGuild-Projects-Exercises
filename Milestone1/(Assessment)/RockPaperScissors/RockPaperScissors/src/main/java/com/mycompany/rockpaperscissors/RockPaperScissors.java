/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rockpaperscissors;

/**
 *
 * @author Kenny
 */


import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {


/*.-----------------------------------------------------------------.
 /  .-.                                                         .-.  \
|  /   \                                                       /   \  |
| |\_.  |            ROCK PAPER SCISSORS BATTLE               |    /| |
|\|  | /|                      Kenneth Melendez               |\  | |/|
| `---' |                                                     | `---' |
|       |                                                     |       | *
|       |-----------------------------------------------------|       |
\       |                                                     |       /
 \     /                                                       \     /
  `---'                                                         `---'*/    
        

/*========================================================================
               Setting up Variables & Creating Ai
========================================================================*/     


        //Randomizer
        Random randomizer = new Random();                                               //Importing the randomizer!
        //GameList Options Array
        String [] RockPaperScissors = {"Rock","Paper","Scissors"};                      //Array of the game peices
        //The Ai
        int randomizedAi = randomizer.nextInt(3);                                       //Creating a randomizer that randomizes the length of the array
        //AiResponse
        String rivalsChoice = RockPaperScissors[randomizedAi];                          //Created a random response generator for the npc player rival
        
        

/*========================================================================
                     User Input && Response
========================================================================*/   

        //while the boolean is true the game will reset itself until the user chooses to stop playing
        boolean restart = true;
        while(restart == true){   
    
        //Activates Ai Chat!!
        WelcomeTheUserAndAskForRounds();

        //Gets Information about how many rounds from the user
        //roundInput is the number of rounds
        int roundInput = roundInput();
        

         
/*=============================================================================
        ROCK PAPER SCISSORS AND.......
        The following code below will contain the mechanic for the actual game
=============================================================================*/
        Scanner userGameInput = new Scanner(System.in); 
        Scanner retry = new Scanner(System.in);         

     
//------[SCOREBOARD KEEPER FOR THE GAME]

        int numberOfRoundsPassed = 0;
        int wins = 0;
        int loses = 0;
        int ties = 0;
        int playerChoice = 0;
        String playerChoiceStringOutput = RockPaperScissors[playerChoice];

        //creates a response after the user asks for rounds
        initiateBattleTextAndGiveRoundsResponse(roundInput);
        do{
            

            

        String userInputGame = userGameInput.nextLine();
            
            if(userInputGame.equalsIgnoreCase("rock")){
                playerChoice = 0;
                
            }else if(userInputGame.equalsIgnoreCase("paper")){
                playerChoice = 1;
            } else if(userInputGame.equalsIgnoreCase("scissors")){
                playerChoice = 2;
            }
//            } else{
//                System.out.println("Wait....what");
//                System.out.println("CHOOSE again!");
//                userInputGame = userGameInput.nextLine();
//            }
            playerChoiceStringOutput = RockPaperScissors[playerChoice];
            System.out.println("You chose " + playerChoiceStringOutput);
            System.out.println("I chose " + rivalsChoice);
            
            //Da Rules!
            if(playerChoiceStringOutput.equalsIgnoreCase("rock") && rivalsChoice.equalsIgnoreCase("rock") ){
                System.out.println("It's a tie!!!");
                ties+=1;
                numberOfRoundsPassed+=1;
            } else if(playerChoiceStringOutput.equalsIgnoreCase("paper") && rivalsChoice.equalsIgnoreCase("paper")){
                System.out.println("It's a tie!!!");
                ties+=1;
                numberOfRoundsPassed+=1;
            } else if (playerChoiceStringOutput.equalsIgnoreCase("scissors") && rivalsChoice.equalsIgnoreCase("scissors")){
                System.out.println("It's a tie!!!");
                ties+=1;
                numberOfRoundsPassed+=1;
            } else if (playerChoiceStringOutput.equalsIgnoreCase("rock") && rivalsChoice.equalsIgnoreCase("paper")){
                System.out.println("You lose!");
                loses+=1;
                numberOfRoundsPassed+=1;
            } else if (playerChoiceStringOutput.equalsIgnoreCase("rock") && rivalsChoice.equalsIgnoreCase("scissors")){
                System.out.println("You Won!");
                wins+=1;
                numberOfRoundsPassed+=1;
            } else if (playerChoiceStringOutput.equalsIgnoreCase("scissors") && rivalsChoice.equalsIgnoreCase("rock")){
                System.out.println("You lose!");
                loses+=1;
                numberOfRoundsPassed+=1;
            } else if (playerChoiceStringOutput.equalsIgnoreCase("scissors") && rivalsChoice.equalsIgnoreCase("paper")){
                System.out.println("You Win!");
                wins+=1;
                numberOfRoundsPassed+=1;
            }else if (playerChoiceStringOutput.equalsIgnoreCase("paper") && rivalsChoice.equalsIgnoreCase("rock")){
                System.out.println("You Win!");
                wins+=1;
                numberOfRoundsPassed+=1;
            }else if (playerChoiceStringOutput.equalsIgnoreCase("paper") && rivalsChoice.equalsIgnoreCase("scissors")){
                System.out.println("You lose!");
                loses+=1;
                numberOfRoundsPassed+=1;
            }
            
            System.out.println("Try again? Yes or no?");
            String playerRetry = retry.nextLine();
            if(playerRetry.equalsIgnoreCase("no")){
                break;
            } else if(playerRetry.equalsIgnoreCase("yes")){
                System.out.println("You shall continue!");
            }
            
            System.out.println("Rock paper scissors and....");
        }while(roundInput > numberOfRoundsPassed);
        
        System.out.println("Wow " + numberOfRoundsPassed + " have passed");
        System.out.println("You have " + wins + " wins.");
        System.out.println("You have " + loses + " loses.");
        System.out.println("You have " + ties + " ties.");
        
        Scanner playerRestart = new Scanner(System.in);
        System.out.println("Would you like to restart..? Yes or no?");
        String playerRestartResponse = playerRestart.nextLine();
        if (playerRestartResponse.equalsIgnoreCase("no")){
            restart = false;
        }
} //end of restart boolean    
    } // END OF PSVM
    
    
    
    
/*========================================================================
                            Methods
========================================================================*/   
    
    public static void WelcomeTheUserAndAskForRounds(){
        //Rival Chatbox
        System.out.println("Welcome to the epic GAME of ROCK, PAPER SCISSORS!!!");
        System.out.println("How many rounds will you play? ...Max is about 10 rounds.");
    }
    
    public static int initiateBattleTextAndGiveRoundsResponse(int rounds){
        //Rival Chatbox
        System.out.println("Wow.." + rounds + " rounds?? ..Bring it ON." );
        System.out.println("Choose your weapon.");
        System.out.println("Rock, Paper, Scissors annnd...");
        return rounds;
    }
    
    public static int roundInput(){
        //playerInput
        Scanner playerRounds = new Scanner(System.in);
        //Enables the player to choose a round 
       int rounds = playerRounds.nextInt();
        //If you don't choose the right amount of rounds....the if statements in the while loop happens..
        //Do while Loop!
        do{
            
            if(rounds < 0){
                System.out.println("Hey that's not even possible. Seriously how many rounds?");
                rounds = playerRounds.nextInt();
            } else if(rounds > 10){
                System.out.println("Woah that's wayyy too high. Calm down...so seriously. How many rounds?");
                rounds = playerRounds.nextInt();
            }
//            } else{
//                System.out.println("Wait what...?");
//                rounds = playerRounds.nextInt();
//            }
        }while(rounds < 0 || rounds > 10);
        
        return rounds;
    }

} //END OF CLASS
