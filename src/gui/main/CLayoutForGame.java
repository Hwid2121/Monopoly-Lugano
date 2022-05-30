
package gui.main;

import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import model.Monopoly;
import model.Player;

import java.awt.CardLayout;

public class CLayoutForGame extends JPanel {

    public static int puttana = 0;
    private CardLayout mainFrame = new CardLayout();

    private GameMain main;
    private Monopoly monopoly = GameMain.monopoly;

    private int turn = 1;
    private int numberOfPlayers = monopoly.getNumOfplayer();
    private int skip = 0;

    private Player player;

    private int fase = 0;

    public CLayoutForGame(GameMain game) {

        super();

        main = game;
        setLayout(mainFrame);

        turn = turn % numberOfPlayers;
        player = monopoly.getPLayer(turn);

        monopoly(monopoly.getPLayer(turn), fase);

    }

    public void monopoly(Player player, int i) {

        turn = turn % numberOfPlayers;
        player = monopoly.getPLayer(turn);

        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player);
        add(panelMonopoly, "1");

        mainFrame.show(this, "1");

    }

    public void nextPage() {

        // if (monopoly.getPLayer(turn).getTurnsInJail() == -1) {

            if (skip == 0) {

                PanelMonopoly panelMonopolysa = new PanelMonopoly(this, monopoly.getPLayer(turn));
                add(panelMonopolysa, "2");
                refreshPAGE();

                mainFrame.show(this, "2");
            }
        // }
         else {

            resetTurn();
            resetfase();
            turn = turn + 1;
            turn = turn % numberOfPlayers;

            monopoly(monopoly.getPLayer(turn), fase);

        }
    }

    public int getFase() {
        return fase;
    }

    public void incrementFase() {
        fase = fase + 1;
    }

    public void setFase(int i) {
        fase = i;
    }

    public void passTurn() {
        skip = 1;
        nextPage();
    }

    public void resetTurn() {
        skip = 0;
    }

    public void resetfase() {
        fase = 0;
    }

    public void refreshPAGE() {
        // mainFrame.show(this, "2");
        // nextPage();
    }

}
