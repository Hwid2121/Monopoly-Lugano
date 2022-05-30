
package gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

import model.Monopoly;
import model.Player;

/**
 *
 * Main panel of the gameplay of monopoly.
 * Recursive call to refresh the page.
 * 
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class CLayoutForGame extends JPanel {

    public static int puttana = 0;
    private CardLayout mainFrame = new CardLayout();

    private Monopoly monopoly = GameMain.monopoly;

    private int turn = 1;
    private int numberOfPlayers = monopoly.getNumOfplayer();
    private int skip = 0;

    private int fase = 0;

    /**
     * Constructor of the CLayoutForGame.
     * 
     * @param game main class of the game
     */
    public CLayoutForGame(GameMain game) {

        super();

        setLayout(mainFrame);

        turn = turn % numberOfPlayers;

        monopoly(monopoly.getPLayer(turn), fase);

    }

    /**
     * The main panel where all the monopoly is played.
     * 
     * @param player the player that have to play the turn
     * @param i      the fase of the game
     */
    public void monopoly(Player player, int i) {

        playerEliminate(player);
        checkEndGame();
        turn = turn % numberOfPlayers;
        player = monopoly.getPLayer(turn);

        PanelMonopoly panelMonopoly = new PanelMonopoly(this, player);
        add(panelMonopoly, "1");

        mainFrame.show(this, "1");

    }

    /**
     * Refresh the page with the update. If skip = 1 then it will be the turn
     * of the next player.
     */
    public void nextPage() {

        if (skip == 0) {
            playerEliminate(monopoly.getPLayer(turn));
            PanelMonopoly panelMonopolysa = new PanelMonopoly(this, monopoly.getPLayer(turn));
            add(panelMonopolysa, "2");

            mainFrame.show(this, "2");
        }

        else {

            resetTurn();
            resetfase();
            turn = turn + 1;
            turn = turn % numberOfPlayers;

            monopoly(monopoly.getPLayer(turn), fase);

        }
    }

    /**
     * Get the fase.
     * 
     * @return fase
     */
    public int getFase() {
        return fase;
    }

    /**
     * Increment the fase.
     */
    public void incrementFase() {
        fase = fase + 1;
    }

    /**
     * Set the fase.
     * 
     * @param index
     */
    public void setFase(int index) {
        fase = index;
    }

    /**
     * Pass the turn.
     */
    public void passTurn() {
        skip = 1;
        nextPage();
    }

    /**
     * Reset the turn.
     */
    public void resetTurn() {
        skip = 0;
    }

    /**
     * Reset the fase.
     */
    public void resetfase() {
        fase = 0;
    }

    /**
     * Check if the game is over.
     */
    public void checkEndGame() {
        if (monopoly.monopolyEND()) {

            JPanel end = new PanelPlayers(null);
            // ENDPANEL panelMonopolysa = new PanelMonopoly(this, monopoly.getPLayer(turn));
            // add(ENDPANE, "3");
            add(end, "3");

            mainFrame.show(this, "3");
        }

    }

    /**
     * Eliminate the player if he is eliminated.
     * 
     * @param player the player to check
     */
    public void playerEliminate(Player player) {
        if (player.getMoney() < 0) {
            monopoly.playerEliminated(player);
        }
    }

}
