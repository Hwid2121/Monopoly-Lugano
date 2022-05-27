package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test class BonusSquareTest.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 10/05/2022
 */
public class BonusSquareTest {

    BonusSquare EastCampus = new BonusSquare("EastCampusUSI", "red", "etc", 200);

    Player Nico = new Player("Nico");

    @Test
    public void getDescriptionTest() {
        assertEquals("etc", EastCampus.getDescription());
    }

    @Test
    public void getMoneyTest() {
        assertEquals(200, EastCampus.getMoney());
    }

    @Test
    public void giveMoneyTest() {
        EastCampus.giveMoney(Nico);
        assertEquals(1700, Nico.getMoney());
    }

    @Test
    public void takeMoneyTest() {
        EastCampus.takeMoney(Nico);
        assertEquals(1300, Nico.getMoney());
    }
}
