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
public class CardsDeckTest {

    @Test
    public void CardsDecksTest() {
        CardsDeck CardsDeck = new CardsDeck();
        CardsDeck.newCards();
    }

    @Test
    public void getIndex() {
        assertEquals(0, new CardsDeck().getIndex());
    }

    @Test
    public void getRandomNumTest() {
        CardsDeck CardsDeck = new CardsDeck();
        CardsDeck.getRandomNum();
    }

    @Test
    public void playCardTest() {
        int index = 0;
        Player Nico = new Player("Nico");
        CardsDeck CardsDeck = new CardsDeck();
        CardsDeck.playCard(index, Nico);
    }
}
