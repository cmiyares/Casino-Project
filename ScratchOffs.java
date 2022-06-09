/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScratchOffs;

import casino.Player;
import constants.Constants;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class ScratchOffs {
    private Player player;
    private OneDollar one;
    private FiveDollar five;
    private TenDollar ten;
    private boolean play;
    private Scanner scan;
    
    public ScratchOffs(Player player)
    {
        this.player = player;
        play = true;
        scan = new Scanner(System.in);
    }
    
    public void play()
    {
        int type;
        int quantity;
        int input;
        
        System.out.println("Let's play scratch off tickets!");
        System.out.println("Players can select from One Dollar"
                + ", Five Dollar and Ten Dollars tickets");
        System.out.println("Prizes are based on the ticket selected");
        
        if(player.getCash()<Constants.ONE)
        {
            System.out.println("You do not have enough money to play");
            play = false;
        } // end if
        
        
        while(play)
        {
            System.out.println("Which Type of scratch off would you like"
                    + " (1 =  One Dollar, 5 = Five Dollar, 10= Ten Dollar)?");
            type = scan.nextInt();
            System.out.println("How many scratch offs would you like?");
            quantity = scan.nextInt();
            System.out.println("Getting your scratch offs...");
         
            System.out.println("Your Cash Balance: " + player.getCash());
            
            for(int i = 0; i < quantity;i++)
            {
                switch(type)
                {
                    case Constants.ONE:
                    {
                        player.setCash(player.getCash()-Constants.ONE);
                        one = new OneDollar(player);
                    }
                    break;
                    case Constants.FIVE:
                    {
                       player.setCash(player.getCash()-Constants.FIVE); 
                       five = new FiveDollar(player);
                    }
                    break;
                    case Constants.TEN:
                    {
                       player.setCash(player.getCash()-Constants.TEN);
                       ten = new TenDollar(player);
                    }
                    break;
                    default:
                    {
                        System.out.println("Invalid Choice");
                    }
                    break;
                }//end switch
            }//end for
            
            System.out.println("Your Cash Balance: $" + player.getCash());
            
             if(player.getCash()>=Constants.ONE)
        {
            System.out.println("Would you like to play again? (1 = Yes "
                    + "0 = No)");
            input = scan.nextInt();
            
            if(input == 1)
            {
                play = true;
            }
            else
            {
                play = false;
                
            }
         } // end if
           else
             {
                 break;
             }
            
              
        }// end while
        System.out.println("Than you for playing scratch offs: final money $:  " + player.getCash());
    }// end play
    
    
}// end class
