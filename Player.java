/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import blackjack.Card;
import constants.Constants;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chris
 */

public class Player implements IPlayer

{

    // member variables  
    private String name;
    private int cash;
    private Scanner scan;
    private ArrayList<Card> hand;
    private int score;
    private boolean busted;
    private boolean play;
    
    
    public Player()
    {
//       scan = new Scanner(System.in);
//       int money;
//       String player;
//       
//        System.out.println("Enter your name:");
//        player = scan.nextLine();
//        
//        System.out.println("Enter cash. You need a minimum of $10 to play:");
//        money = scan.nextInt();
//        
//        setName(player);
//        setCash(money);
    } // end player
    
    public boolean playAgain()
    {
        int choice;
        System.out.println("Player, play another hand?"
                + " (0 = No, 1 = Yes)");
        choice = scan.nextInt();
        if(choice == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    
    
    // Getters and Setters for member variables
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the cash
     */
    public int getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(int cash) {
        this.cash = cash;
    }
    
    /**
     * @return the hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * @return the score
     */
    public int getScore() {
        score = 0;
        
        // loops through arrayList
        for(Card c : hand)
        {
           score += c.getValue(); 
            //System.out.println(c.toString());
        } 
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the busted
     */
    public boolean isBusted() {
        return busted;
    }

    /**
     * @param busted the busted to set
     */
    public void setBusted(boolean busted) {
        this.busted = busted;
    }

    /**
     * @return the play
     */
    public boolean isPlay() {
        return play;
    }

    /**
     * @param play the play to set
     */
    public void setPlay(boolean play) {
        this.play = play;
    }
    
    //implements the interface
    @Override
    public int hitOrStand() {
        
        // erased exception here
        
        System.out.println("Player, another card?"
                + " (0= STAND, 1 = HIT)");
        int choice;
        choice = scan.nextInt();
        if(choice == 1)
        {
            return Constants.HIT;
        }
        else
        {
            return Constants.STAND;
        }
    }

    

    
    
}

