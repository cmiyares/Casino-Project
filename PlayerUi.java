/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import casino.Player;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author chris
 */
public class PlayerUi extends JPanel {

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the cashLabel
     */
    public JLabel getCashLabel() {
        return cashLabel;
    }

    /**
     * @param cashLabel the cashLabel to set
     */
    public void setCashLabel(JLabel cashLabel) {
        this.cashLabel = cashLabel;
    }

    /**
     * @return the cashBalance
     */
    public JLabel getCashBalance() {
        return cashBalance;
    }

    /**
     * @param cashBalance the cashBalance to set
     */
    public void setCashBalance(JLabel cashBalance) {
        this.cashBalance = cashBalance;
    }
    
    private Player player;
    private JLabel cashLabel;
    private JLabel cashBalance;
    public PlayerUi(Player player)
    {
        this.player = player;
        initComponents();
    }

    private void initComponents() {
        
        String name = JOptionPane.showInputDialog(null,"Enter the name of player");
        player.setName(name);
        
        String cash = JOptionPane.showInputDialog(null,"Enter Cash to Play");
          
        player.setCash(Integer.parseInt(cash));
        
       this.setPreferredSize(new Dimension(100,150));
       this.setBorder(BorderFactory.createTitledBorder(player.getName()));
       
       cashLabel = new JLabel("Cash Balance: $");
       cashLabel.setPreferredSize(new Dimension(100,100));
       
       cashBalance = new JLabel(Integer.toString(player.getCash()));
       cashBalance.setPreferredSize(new Dimension(100,100));
        
       
      this.add(cashLabel);
      this.add(cashBalance);
    }
    
    
}
