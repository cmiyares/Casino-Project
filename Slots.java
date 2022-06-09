/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slots;


import casino.Player;
import java.util.Random;
import java.util.Scanner;
import constants.Constants;
/**
 *
 * @author chris
 */
public class Slots {
   // member variables
    private static final int SLOTS = 3;
    private static final char[] SYMBOLS = {'$','%','&','#','@','!'};
    private char[] spins;
    private Random rand;
    private Player player;
    private boolean play;
    private Scanner scan;
    
    
    public Slots(Player player)
    {
      scan = new Scanner(System.in);
      play = true;
      rand = new Random();
      spins = new char[3];
      this.player = player;  
    } // end slots 
    
    
    public void play()
    {
        int input;
        
        System.out.println("Let's play the slot machines!");
        System.out.println("Your cash balance is $" + player.getCash());
        System.out.println("The bet is $" + Constants.BET);
        System.out.println("Match two symbols to win $" + Constants.PAIR_PAYOUT);
        System.out.println("Match all three symbols to win $" + Constants.TRIPLE_PAYOUT);
     if(player.getCash()< Constants.BET)
     {
         System.out.println("You dont have enough money to play");
         play = false;
     }
    
     while(play)
     {
         
         player.setCash(player.getCash()-Constants.BET);
         
         System.out.println("Spinning...");
         
         for(int s = 0; s < SLOTS ;s++)
         {
             spins[s] = randomSymbol();
             System.out.print(spins[s] + " ");
         }
         System.out.println("");
         if(Character.compare(spins[0], spins[1]) == 0 
                 ||Character.compare(spins[0], spins[2]) == 0
                 ||Character.compare(spins[1], spins[2]) == 0)
         {
             
             System.out.println("Two symbols matched, you won $" + Constants.PAIR_PAYOUT);
             player.setCash(player.getCash()+ Constants.PAIR_PAYOUT);
            
         }
         else if((Character.compare(spins[0],spins[1])) == 0 
                 && (Character.compare(spins[0],spins[2])) == 0)
         {
             
             System.out.println("Three symbols matched, you won $" + Constants.TRIPLE_PAYOUT);
             player.setCash(player.getCash()+ Constants.TRIPLE_PAYOUT);
             
         }
         else
         {
             System.out.println("None of the symbols matched, you did not receive money");
             
             
         }
         
         System.out.println("cash balance: $" + player.getCash());
         
         if(player.getCash() >= Constants.BET)
         {
             
             System.out.println("Would you like to spin again (Yes = 1 , No = 0)");
             input = scan.nextInt();
            if(input == 1)
            {
               play = true; 
            }
            else if(input == 0)
            {
                play = false;
            }
            
         }
         else
            {
                break;
            }
        
     }// end while
      if(player.getCash() <= 0)
      {
          System.out.println("You are out of cash, you cannot play");
      }
      else
      {
          System.out.println("Thank you for playing slots at Knights"
                + "Casino! Your Cash out is $" + player.getCash());
      }
        
    } // end play
    
    
    private char randomSymbol()
    {
        // randomly generate a value from 0-5
        int num = rand.nextInt(SYMBOLS.length);
        char symbol = 0;
        
        switch(num)
        {
            case 0:
                symbol = SYMBOLS[0];
                break;
            case 1:
                symbol = SYMBOLS[1];
                break;
            case 2:
                symbol = SYMBOLS[2];
                break;
            case 3:
                symbol = SYMBOLS[3];
                break;
            case 4:
                symbol = SYMBOLS[4];
                break;
            case 5:
                symbol = SYMBOLS[5];
                break;
        }
            return symbol;
    } // end randomSymbol
}


