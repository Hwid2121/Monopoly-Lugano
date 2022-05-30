package gui;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.main.CLayout;
import gui.main.CLayoutForGame;
import model.Monopoly;

/**
 * This class rappresents the Monopoly End Game panel.
 * 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/05/2022
 */

public class PanelEnd extends JPanel {
    private Monopoly monopoly;

    public PanelEnd(Monopoly monopoly) {
        super();
        this.monopoly = monopoly;
        String nick = monopoly.getListOfPlayer().get(0).getNickname();
        makeUI(nick);
    }

    private void makeUI(String nick) {
        
        setBackground(new Color(205, 230, 208, 255));
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(205, 230, 208, 255));

        JLabel b = new JLabel(nick + " is the winner!");
        b.setFont(new Font("SansSerif", Font.BOLD, 22));

        //b.setBackground(new Color(205, 230, 208, 255));
        b.setForeground(new Color(246, 147, 28, 255));
        main.add(b, BorderLayout.CENTER);
        
        add(main);
        
    }
}
