/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casino;

import ScratchOffs.ScratchOffs;
import Slots.Slots;
import blackjack.BlackJack;
import java.util.Scanner;
import constants.Constants;
import userInterface.CasinoUi;
/**
 *
 * @author chris
 */
public class Casino {

    /**
     * @return the blackjack
     */
    public static BlackJack getBlackjack() {
        return blackjack;
    }

    /**
     * @param aBlackjack the blackjack to set
     */
    public static void setBlackjack(BlackJack aBlackjack) {
        blackjack = aBlackjack;
    }

    /**
     * @return the scratchers
     */
    public static ScratchOffs getScratchers() {
        return scratchers;
    }

    /**
     * @param aScratchers the scratchers to set
     */
    public static void setScratchers(ScratchOffs aScratchers) {
        scratchers = aScratchers;
    }

    /**
     * @return the slots
     */
    public static Slots getSlots() {
        return slots;
    }

    /**
     * @param aSlots the slots to set
     */
    public static void setSlots(Slots aSlots) {
        slots = aSlots;
    }

    /**
     * @return the player
     */
    public static Player getPlayer() {
        return player;
    }

    /**
     * @param aPlayer the player to set
     */
    public static void setPlayer(Player aPlayer) {
        player = aPlayer;
    }

    
    // member variables
    
    private static BlackJack blackjack;
    private static  ScratchOffs scratchers;
    private static  Slots slots;
    private static  Player player;
    private static  Scanner scan;
    private static CasinoUi ui;
    
    
    public static void main(String[] args) {
       
        int game = 0;
        
        scan = new Scanner (System.in);
        
        setPlayer(new Player());
        
        ui = new CasinoUi(new Casino());
//        game = displayMenu();
        
//        switch(game)
//        {
//            case Constants.BLACK_JACK:
//                blackjack = new BlackJack(player);
//                blackjack.play();
//                break;
//            case Constants.SCRATCH:
//                scratchers = new ScratchOffs(player);
//                scratchers.play();
//                break;
//            case Constants.SLOTS:
//                slots = new Slots(player);
//                slots.play();
//                break;
//            default:
//                System.out.println("Invalid game selection, try again.");
//        }// end switch
        
        
        
        
    } // end main
    
    private static int displayMenu()
    {
        int select;
     
        do
        {
            System.out.println("Welcome to Knights Casino!\n");
            System.out.println("Select a game to play");
            System.out.println("1. Black Jack");
            System.out.println("2. Scratch Off Tickets");
            System.out.println("3. Slot Machines");
            System.out.println("Enter the number of your choice:");
            select = scan.nextInt();
        }while(select < Constants.BLACK_JACK || select > Constants.SLOTS);
        
        return select;
    }// end displayMenu
} // end Casino
