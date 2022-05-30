
package gui.main;

import javax.swing.JPanel;
import gui.panels.PanelMonopoly;
import gui.panels.PanelPlayers;
import model.Monopoly;
import model.Player;

import java.awt.CardLayout;



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

    public CLayoutForGame(GameMain game) {

        super();

        setLayout(mainFrame);

        turn = turn % numberOfPlayers;

        monopoly(monopoly.getPLayer(turn), fase);

    }



/**
 * The main panel where all the monopoly is played.
 * @param player the player  that have to play the turn
 * @param i the fase of the game
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
            playerEliminate( monopoly.getPLayer(turn));
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



    public void checkEndGame(){
        if(monopoly.monopolyEND()){


            JPanel end = new PanelPlayers(null);
            // ENDPANEL panelMonopolysa = new PanelMonopoly(this, monopoly.getPLayer(turn));
            // add(ENDPANE, "3");
            add(end, "3");

            mainFrame.show(this, "3");
        }

        







    }



    public void playerEliminate(Player player){
        if(player.getMoney()<0){
            monopoly.playerEliminated(player);
        }
    }

}
