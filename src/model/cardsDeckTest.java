package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class rapresent the main of the game, here all the principals
 * methods of monopoly are stored
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 18/05/2022
 */
public class cardsDeckTest {

    @Test
    public void cardsDecksTest() {
        cardsDeck cardsDeck = new cardsDeck();
        cardsDeck.newCards();
    }

    @Test
    public void getIndex() {
        assertEquals(0, new cardsDeck().getIndex());
    }

    @Test
    public void getRandomNumTest() {
        cardsDeck cardsDeck = new cardsDeck();
        cardsDeck.getRandomNum();
    }

    @Test
    public void playCardTest() {
        int index = 0;
        Player Nico = new Player("Nico");
        cardsDeck cardsDeck = new cardsDeck();
        cardsDeck.playCard(index, Nico);
    }
}
