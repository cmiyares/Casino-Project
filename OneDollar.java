/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ScratchOffs;

import casino.Player;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chris
 */
public class OneDollar {
    //members
    private char winningBonus;
    private int winningNumber;
    private ArrayList<Integer> playerNumbers;
    private ArrayList<Character> bonus;
    private ArrayList<Double> prizes;
    private Player player;
    private Random rand;
    
    //constants
    private static final char[] SYMBOLS = {'$','%','&','#','@','!'};
    private static final int BASE = 20;
    private static final int NUMS = 5;
    private static final int SYMS = 2;
    private static final double BONUS = 10.00;
    
    public OneDollar(Player player)
     {
         this.player = player;
         rand = new Random();
         createTicket();
         displayTicket();
         cashTicket();
     }
    
    private void displayTicket()
    {
        System.out.printf("+------------------------------------------+\n");
        System.out.printf("| WINNING NUMBER        %2d%17s|\n" , this.winningNumber, " ");
        System.out.printf("|%42s|\n", " ");
        System.out.printf("| YOUR NUMBERS%29s|\n|", " ");
        
        for(Integer i: playerNumbers)
        {
            System.out.printf("%8d", i);
        }
        
        System.out.printf("  |\n");
        System.out.printf("|%42s|\n", " ");
        System.out.printf("| PRIZES%35s|\n", " ");
        System.out.printf("|%42s|\n|", " ");
        
        for(Double i : prizes)
        {
            System.out.printf("%8.2f", i);
        }
        
        System.out.printf("  |\n|%42s|\n", " ");
        System.out.printf("| SYMBOLS%34s|\n", " ");
        System.out.printf("|%42s|\n|", " ");
        
        for(Character c : bonus)
        {
            System.out.printf("%8c", c);
        }
        System.out.printf("                          |\n");
        System.out.printf("+------------------------------------------+\n");
    }
    
    private void cashTicket()
    {
        double cash = 0.0;
        System.out.println("\nBonus symbol is: " + winningBonus);
        
        for(int i = 0; i < playerNumbers.size();i++)
        {
            if(playerNumbers.get(i) == winningNumber)
            {
                cash+=prizes.get(i);
            }
        }
        
        for(int i = 0; i< bonus.size();i++)
        {
            if(bonus.get(i)== winningBonus)
            {
                cash+=BONUS;
            }
        }
        
        System.out.println("Bonus is worth $" + BONUS);
        System.out.println("Your One Dollar Scratch Off won you : $" + (int)cash);
        
        player.setCash(player.getCash()+ (int)cash);
    }
    
    private void createTicket()
    {
        winningNumber = randomNumbers();
        winningBonus = randomSymbol();
        playerNumbers = new ArrayList();
        prizes = new ArrayList();
        bonus = new ArrayList();
        for(int i = 0; i<5;i++)
        {
            playerNumbers.add(randomNumbers());
            prizes.add(randomPrize());
        }
        for(int i =0; i < SYMS; i++)
        {
            bonus.add(randomSymbol());
        }
    } // end create
    
    private int randomNumbers()
    {
        int num;
        num = rand.nextInt(BASE)+1;
        return num;
    }
    
    private double randomPrize()
    {
        double num;
        num = (double)(rand.nextInt(BASE)+1);
        return num;
    }
    
    private char randomSymbol()
    {
        int num;
        char symbol = ' ';
        num = rand.nextInt(SYMBOLS.length);
        
        switch(num)
        {
            case 0:
            {
                symbol = SYMBOLS[0];
            }
            break;
            case 1:
            {
                symbol = SYMBOLS[1];
            }
            break;
            case 2:
            {
                symbol = SYMBOLS[2];
            }
            break;
            case 3:
            {
                symbol = SYMBOLS[3];
            }
            break;
            case 4:
            {
                symbol = SYMBOLS[4];
            }
            break;
            case 5:
            {
                symbol = SYMBOLS[5];
            }
            break;
        }
        return symbol;
    }
    
}
