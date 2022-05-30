package gui.panels;

import javax.swing.JPanel;

import gui.MonopolyCommandsPanel;
import gui.MonopolyGridPanel;
import gui.MonopolyPlayerPanel;
import gui.main.CLayoutForGame;
import model.Player;

import java.awt.BorderLayout;
import java.awt.Dimension;

public class PanelMonopoly extends JPanel {

    private MonopolyGridPanel monopolyGridPanel;
    private MonopolyPlayerPanel monopolyPlayerPanel;
    private MonopolyCommandsPanel monopolyCommandsPanel;

    private CLayoutForGame main;

    /**
     * PanelMonopoly  where the gameplay 
     * grid are showned:
     *  - MonopolyGridPanel
     *  - MonopolyPlayerPanel
     *  - MonopolyCommandsPanel
     * 
     * 
     * @author taftan@usi.ch & sardoa@usiu.ch
     * @version 24/05/2022
     */
    private Player player;

    public PanelMonopoly(CLayoutForGame game, Player players) {

        player = players;
        main = game;
        int width = getWidth();

        monopolyGridPanel = new MonopolyGridPanel(player);
        monopolyPlayerPanel = new MonopolyPlayerPanel();
        monopolyCommandsPanel = new MonopolyCommandsPanel(player, main, this);

        BorderLayout mainLay = new BorderLayout(0, 0);
        monopolyGridPanel.setPreferredSize(new Dimension(1000, 1000));
        monopolyPlayerPanel.setPreferredSize(new Dimension(920, 800));
        monopolyCommandsPanel.setPreferredSize(new Dimension(width, 136));

        setLayout(mainLay);

        add(monopolyGridPanel, BorderLayout.CENTER);
        add(monopolyPlayerPanel, BorderLayout.LINE_END);
        add(monopolyCommandsPanel, BorderLayout.PAGE_END);

    }

}
