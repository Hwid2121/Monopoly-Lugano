package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;

/**
 * The test class MonopolyTest.
 *
 * @author Nicolò Tafta and Alberto Sardo
 * @version 12/05/2022
 */
public class MonopolyTest {
    public Table table = new Table();
    public Dice dice = new Dice();
    Player Nico = new Player("Nico");
    Player Alberto = new Player("Alberto");
    ArrayList<Player> players = new ArrayList<Player>();
    Monopoly monopoly = new Monopoly();
    public int steps;
    public int numOfPlayers;

    @Test
    public void monopolyENDTest1() {
        monopoly.addPlayer(Nico);
        monopoly.addPlayer(Alberto);
        assertTrue(monopoly.getSizeOfPlayers() >= 1);
    }

    @Test
    public void monopolyENDTest2() {
        assertFalse(monopoly.getSizeOfPlayers() >= 1);
    }

    @Test
    public void getSizeOfPlayerTest() {
        monopoly.addPlayer(Nico);
        assertEquals(1, monopoly.getSizeOfPlayers());
    }

    @Test
    public void getListOfPlayerTest() {
        monopoly.addPlayer(Nico);
        ArrayList<Player> giocatori = new ArrayList<Player>();
        giocatori.add(Nico);
        // assertEquals(giocatori,monopoly.getListOfPlayer());
        assertEquals(giocatori, monopoly.getListOfPlayer());
    }

    @Test
    public void playerEliminatedTest() {
        monopoly.addPlayer(Nico);
        monopoly.playerEliminated(Nico);
        // assertEquals(giocatori,monopoly.getListOfPlayer());
        assertEquals(0, monopoly.getSizeOfPlayers());
    }
}