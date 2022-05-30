package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import model.Player;

/**
 * PanelMonopoly panel that show the monopoly game.
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class PanelMonopoly extends JPanel {

    private MonopolyGridPanel monopolyGridPanel;
    private MonopolyPlayerPanel monopolyPlayerPanel;
    private MonopolyCommandsPanel monopolyCommandsPanel;

    private CLayoutForGame main;
    private Player player;

    /**
     * Constructor of the PanelMonopoly.
     * 
     * @param game    main class of the game
     * @param players the players of the game
     */
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
