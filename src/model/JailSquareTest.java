package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
//import javax.print.attribute.standard.NumberOfDocuments;
import java.util.Iterator;

import org.junit.Test;

/**
 * This class rapresent the main of the game, here all the principals
 * methods of monopoly are stored
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 11/05/2022
 */

public class JailSquareTest {

    private static int days = 3;
    private static int fine = 50;
    Player Nico = new Player("Nico");
    JailSquare Jail = new JailSquare("Lo stampino", "red");

    @Test
    public void getDaysTest() {
        assertEquals(3, Jail.getDays());
    }

    @Test
    public void getFineTest() {
        assertEquals(50, new JailSquare("Via delle Aie", "blue").getFine());
    }

    @Test
    public void getPerfectPairTest() {
        assertTrue(new Dice(5, 5).getPerfectPair());
    }
    // @Test
    // public void getPair1Test(){
    // Jail.getPair1();
    // assertEquals(6, new Dice(5, 6).getDie2());
    // } testare i valori in un intervallo
    // assertTrue( die1 >= )

    // @Test
    // public void getPair2Test(){
    // assertEquals(6, new Dice(5, 6).getDie2());
    // }

    @Test
    public void payFineTest() {
        Jail.payFine(Nico);
        assertEquals(1445, Nico.getMoney());
    }

    @Test
    public void freeFromJailTest() {
        Jail.freeFromJail(Nico);
        assertEquals(-1, Nico.getTurnsInJail());
    }

}
