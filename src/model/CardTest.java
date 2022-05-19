package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * The test class BonusSquareTest.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 11/05/2022
 */

public class CardTest {
    Player Nico = new Player("Nico");
    String descr;

    @Test
    public void getDescriptionTest() {
        assertEquals(descr, new Card(descr).getDescription());
    }

    @Test
    public void card0Test() {
        Card.card0(Nico);
        assertEquals(16, Nico.getPosition());
    }

    @Test
    public void card14Test() {
        Card.card14(Nico);
        assertEquals(1380, Nico.getMoney());
    }

    @Test
    public void card13Test() {
        Card.card13(Nico);
        assertEquals(1450, Nico.getMoney());
    }

    @Test
    public void card12Test() {
        Card.card12(Nico);
        assertEquals(1300, Nico.getMoney());
    }

    @Test
    public void card10Test() {
        Card.card10(Nico);
        assertEquals(1575, Nico.getMoney());
    }

    @Test
    public void card9Test() {
        Card.card9(Nico);
        assertEquals(1460, Nico.getMoney());
    }

    @Test
    public void card8Test() {
        Card.card8(Nico);
        assertEquals(1400, Nico.getMoney());
    }

    @Test
    public void card6Test() {
        Card.card6(Nico);
        assertEquals(1600, Nico.getMoney());
    }

    @Test
    public void card4Test() {
        Card.card4(Nico);
        assertEquals(1450, Nico.getMoney());
    }

    @Test
    public void card3Test() {
        Card.card3(Nico);
        assertEquals(1700, Nico.getMoney());
    }

    @Test
    public void card1Test() {
        Card.card1(Nico);
        assertEquals(1700, Nico.getMoney());
        assertEquals(0, Nico.getPosition());
    }

    public void card2Test1() {
        Nico.movePosition(7);
        assertEquals(1700, Nico.getMoney());
    }

    public void card2Test2() {
        Nico.movePosition(5);
        assertEquals(1700, Nico.getMoney());
    }

    @Test
    public void card5Test() {
        Card.card5(Nico);
        assertEquals(1, Nico.getDeck().size());
    }

}
