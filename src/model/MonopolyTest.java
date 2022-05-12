package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
        ArrayList <Player> players = new ArrayList<Player>();
        Monopoly monopoly = new Monopoly(players);
        //players.add(nome)
        @Test
        public void setPositionPlayerTest(){
            int steps = 10;
            Nico.setPosition(steps);
            assertEquals(10, Nico.getPosition());
        }

}
