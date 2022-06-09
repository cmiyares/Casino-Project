/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;


import constants.Constants;
import java.util.HashSet;
import constants.Constants.COLOR;
import constants.Constants.FACE;
import constants.Constants.SUIT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 *
 * @author chris
 */
public class Deck {
    
    // member variable
     public Set<Card> deck;
   

    /**
     * @return the set
     */
    public Set<Card> getDeck() {
        return deck;
    }

    /**
     * @param deck the set to set
     */
    public void setDeck(Set<Card> deck) {
        this.deck = deck;
    }
    
    // custom constructor for deck. Contains all of the methods.
    // **for future me. I put void at first and it was not displaying**
      public Deck()
    {
//        System.out.println("*******************");
//        System.out.println("Generating the deck.");
//        System.out.println("*******************");
        generateDeck();
        
//        System.out.println("*******************");
//        System.out.println("Displaying the deck.");
//        System.out.println("*******************");
//        displayDeck();
        
//        System.out.println("*******************");
//        System.out.println("Shuffling the deck.");
//        System.out.println("*******************");
        shuffleDeck();
        
//        System.out.println("************************************");
//        System.out.println("Displaying the shuffled deck of cards.");
//        System.out.println("*************************************");
//        displayDeck();
        
    }
    
      // generates the deck of cards
    private void generateDeck()
    {
        deck = new HashSet<Card>(Constants.DECK);
        //loops through face and suit
       for(FACE face: FACE.values())
       {
           for(SUIT suit: SUIT.values())
           {
             Card card = new Card();
             card.setFace(face);
             card.setSuit(suit);
             
             card.getColor();
             // condition for color of card
             if(suit == SUIT.DIAMONDS || suit == SUIT.HEARTS)
             {
                 card.setColor(COLOR.RED);
             }
             else
             {
                 card.setColor(COLOR.BLACK);
             }
             // condition for filling the deck
             if(!deck.contains(card))
             {
                 deck.add(card);
             }
           }
       } 
    }
    
    // method for displaying the deck
    public void displayDeck()
    {
        
        System.out.println("Deck size:" + deck.size() + " cards");
        System.out.println("Deck includes:");
        
        // loops through and displays the deck
        for(Card card : deck)
        {
            System.out.println("Card: " +card.getFace() + " of " + 
                    card.getSuit() + " is color " + card.getColor());
        }
    }
    // method for shuffling the deck
    public void shuffleDeck()
    {
        ArrayList<Card> shuffle = new ArrayList<Card>(deck);
        Collections.shuffle(shuffle);
        
        deck = new HashSet<Card>(shuffle);
        
    }
}
    
   

    