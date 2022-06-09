/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author chris
 */
public interface IDealer {
    public int hitOrStand();

    /**
     *
     * @param deck
     * @return
     */
    public Card deal(Deck deck);
}
