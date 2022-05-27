package gui.main;

import javax.swing.JPanel;

import gui.PanelMonopoly;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.PanelEnd;
import gui.PanelMonopoly;
import gui.panels.PanelPlayers;
import gui.panels.PanelPregame;
import gui.pregame.PanelNickname;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import java.awt.CardLayout;

public class CLayoutForGame extends JPanel  {

    
    private JPanel panelMonopoly = new PanelMonopoly();

    private CardLayout mainFrame  = new CardLayout();


    public CLayoutForGame() {

        setLayout(mainFrame);

        add(panelMonopoly, "1");

        mainFrame.show(this, "1");
        
    }
    
}
