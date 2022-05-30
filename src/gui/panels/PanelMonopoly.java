package gui.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.MonopolyCommandsPanel;
import gui.MonopolyGridPanel;
import gui.MonopolyPlayerPanel;
import gui.main.CLayout;
import gui.main.CLayoutForGame;
import gui.main.GameMain;
import model.Player;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMonopoly extends JPanel {


    private  MonopolyGridPanel monopolyGridPanel;
    private MonopolyPlayerPanel monopolyPlayerPanel;
    private MonopolyCommandsPanel monopolyCommandsPanel;

    private CLayoutForGame main ;


    private Player player;
    public PanelMonopoly(CLayoutForGame game, Player players) {


    
        player = players;
         main = game;
        int width = getWidth();
        
        // if (main.getFase() == 0){
        //     monopolyGridPanel = new MonopolyGridPanel(player);
        // }


        monopolyGridPanel = new MonopolyGridPanel(player);
        monopolyPlayerPanel = new MonopolyPlayerPanel();
        monopolyCommandsPanel = new MonopolyCommandsPanel( player, main, this);




        BorderLayout mainLay = new BorderLayout(0,0);
        monopolyGridPanel.setPreferredSize(new Dimension(1000,1000));
        monopolyPlayerPanel.setPreferredSize(new Dimension(920, 800));
        monopolyCommandsPanel.setPreferredSize(new Dimension(width, 136));

        setLayout(mainLay);

        add(monopolyGridPanel, BorderLayout.CENTER);
        add(monopolyPlayerPanel, BorderLayout.LINE_END);
        add(monopolyCommandsPanel, BorderLayout.PAGE_END);

    }








}

