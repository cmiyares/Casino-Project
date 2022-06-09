/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import constants.Constants.COLOR;
import constants.Constants.FACE;
import constants.Constants.SUIT;
/**
 *
 * @author chris
 */
public class Card {

    /**
     * @return the face
     */
    public FACE getFace() {
        return face;
    }

    /**
     * @param face the face to set
     */
    public void setFace(FACE face) {
        this.face = face;
    }

    /**
     * @return the suit
     */
    public SUIT getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(SUIT suit) {
        this.suit = suit;
    }

    /**
     * @return the color
     */
    public COLOR getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(COLOR color) {
        this.color = color;
    }
    
    // member variables
    private FACE face;
    private SUIT suit;
    private COLOR color;
    private int value;
  
    public int hashCode()
    {
        int hashcode = 0;
        
        return hashcode;
    }

    // tests if object is instance of class Card
    public boolean equals(Object o) {
        if(o instanceof Card)
        {  
            Card card = (Card)o;
            return (card.face.equals(this.face) && card.color.equals(this.color) && card.suit.equals(this.suit));
        }
        
        else 
        {
            return false;
            
        }
       
    }// end equals  

    public int getValue() {
        value = 0;
       if(face == FACE.TWO)        
       {
          return value = 2;  
       }
      else if(face == FACE.THREE)        
       {
          return value = 3;  
       }
      else if(face == FACE.FOUR)        
       {
          return value = 4;  
       }
      else if(face == FACE.FIVE)        
       {
         return value = 5;  
       }
      else if(face == FACE.SIX)        
       {
          return value = 6;  
       }
      else if(face == FACE.SEVEN)        
       {
          return value = 7;  
       }
      else if(face == FACE.EIGHT)        
       {
          return value = 8;  
       }
      else if(face == FACE.NINE)        
       {
          return value = 9;  
       }
       else if(face == FACE.JACK
               ||face == FACE.QUEEN
               ||face == FACE.KING)        
       {
         return value = 10;  
       }
       else if(face == FACE.ACE)
       {
            return value = 11;
       }
       
       return value;
    }
    
    public String toString()
    {
        String card = this.face + " of " + this.suit;
        return card;
    }
    
}
