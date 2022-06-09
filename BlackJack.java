/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import casino.Player;
import constants.Constants;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class BlackJack {
    
    // member variables
    private Player player;
    private boolean play;
    private  Scanner scan;
    private Deck deck;
    private Dealer dealer;
    private Card card;
    
     public BlackJack(Player player)
    {
       this.player = player;
       scan = new Scanner(System.in); 
       play = true;
       deck = new Deck();
       dealer = new Dealer();
       card = new Card();
       
    }// end BlackJack
    
   public void play()
    {
        displayRules();
        
        if(player.getCash()<Constants.BLACK_JACK_BET)
        {
            System.out.println("You are out of cash, you cannot play");
            play = false;
        }
        
        while(play)
        {
            System.out.println("Player's Cash $" + player.getCash());
            
            if(player.getCash()<Constants.BLACK_JACK_BET)
            {
                System.out.println("You are out of cash, you cannot play");
                play = false;
                break;
            }
            
            // deduct cash
          player.setCash(player.getCash()-Constants.BLACK_JACK_BET);
          
            System.out.println("Dealing...");
            
           // resetting hand
           
           player.setHand(new ArrayList<>());
           player.setScore(Constants.ZERO);
           player.setBusted(false);
           dealer.setHand(new ArrayList<>());
           dealer.setScore(Constants.ZERO);
           
           // deal the player two cards
           for(int i =0; i < 2; i++)
           {
               card = dealer.deal(deck);
               player.getHand().add(card);
           }
           
            System.out.println("Player's score " + player.getScore());
            
           // deal the dealer two cards
           for(int i = 0; i < 2; i++)
           {
               card = dealer.deal(deck);
               dealer.getHand().add(card);
           }
           
               
           while(player.hitOrStand() == Constants.HIT)           
           {
               card = dealer.deal(deck);
               player.getHand().add(card);
              System.out.println("Players score " + player.getScore());
           
              if(player.getScore() > Constants.BUST)
              {
                  System.out.println("Player has busted");
                  player.setBusted(true);
                  break;
              }
           
           }
              
               if(player.isBusted() == true)
              {
                 play = player.playAgain();
                continue;
              }
               
              else
              {
                  System.out.println("Dealers score: "+ dealer.getScore());
                  
                  while(dealer.hitOrStand() == Constants.HIT)
                  {
                      card = dealer.deal(deck);
                      dealer.getHand().add(card);
                     System.out.println("Dealers score: "+ dealer.getScore());
                      
                     if(dealer.getScore() > Constants.BUST)
                    {
                  System.out.println("Dealer has busted");
                  break;
                    }
                   
                  }// end while dealer hits loop
              }// end else
               
           results();
           play = player.playAgain();
        }// end while 
            
    }//end play
   
   private void results()
   {
       System.out.println("Players score " + player.getScore());
       System.out.println("Dealers score " + dealer.getScore());
       if(dealer.getScore() > Constants.BUST)
       {
           System.out.println("The Dealer Busted. Player wins $10");
           player.setCash(player.getCash()+10);
       }
       else if(dealer.getScore() == player.getScore())
       {
           System.out.println("That was a push. Player wins $10");
           player.setCash(player.getCash()+10);
       }
       else if(player.getScore() > dealer.getScore())
       {
           System.out.println("Player wins $20");
           player.setCash(player.getCash()+20);
       }
       else
        {
            System.out.println("The dealer wins the hand");
        }
       
   }// end results
   
   
   
   private void displayRules()
   {
       System.out.println("Let's play Black Jack!");
       System.out.println("Your cash balance is $" + player.getCash());
       System.out.println("The bet is $" + Constants.BLACK_JACK_BET);
       System.out.println("Dealer must HIT if their score is 16 or less");
       System.out.println("Dealer must STAND if their score is 17 or higher");
       System.out.println("If the player wins the hand, they receive $"
               +Constants.BLACK_JACK_WIN);
       System.out.println("If the dealer wins the hand, the $" 
               + Constants.BLACK_JACK_BET+ " bet is lost");
       System.out.println("If it is a PUSH, the player keeps their $"
               + Constants.BLACK_JACK_BET+ " bet");
   }
 
}
    
    
    

