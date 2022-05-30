package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import gui.main.GameMain;
import model.*;

/**
 * This class rappresents the Monopoly game board player panel.
 * 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/05/2022
 */

public class MonopolyPlayerPanel extends JPanel {

    private Monopoly monopoly = GameMain.monopoly;
    private int numPlayers = monopoly.getNumOfplayer();

    private GridLayout layout = new GridLayout(numPlayers, 2);

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

    public void refreshPage() {
        revalidate();
        repaint();
    }

}
