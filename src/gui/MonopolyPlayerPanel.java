package gui;

import java.awt.GridLayout;

import javax.swing.JPanel;

import model.Monopoly;
import model.Player;

/**
 * This class rappresents the Monopoly game board player panel.
 * 
 *
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 28/05/2022
 */

public class MonopolyPlayerPanel extends JPanel {

    private Monopoly monopoly = GameMain.monopoly;
    private int numPlayers = monopoly.getNumOfplayer();

    private GridLayout layout = new GridLayout(numPlayers, 2);




    /**
     * Constructor of the MonopolyPlayerPanel.
     * 
     */
    public MonopolyPlayerPanel() {
        super();
        setLayout(layout);

        setBackground(GameMain.SFONDO);
        setBorder(GameMain.BLACKLINE);

        setFont(GameMain.COURIER);

        for (Player x : monopoly.getListOfPlayer()) {

            add(new PlayerStatPanel(x));
        }

    }



}
