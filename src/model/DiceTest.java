package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

/**
 * The test class DiceTest.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 9/05/2022
 */
public class DiceTest {
    Random rand = new Random();
    private int die1;
    private int die2;
    Dice dice = new Dice(die1, die2);

    @Test
    public void DicesTest() {
        Dice dice1 = new Dice(die1, die2);
        assertTrue(dice1 instanceof Dice);
    }

    @Test
    public void GetDie1Test() {
        assertEquals(die1, new Dice(die1, die2).getDie1());
    }

    @Test
    public void GetDie2Test() {
        assertEquals(die2, new Dice(die1, die2).getDie2());
    }

    @Test
    public void getDiceTest() {
        assertEquals(die1 + die2, new Dice(die1, die2).getDice());
    }

    @Test
    public void isPerfectPairTest() {
        assertEquals(die1 == die2, new Dice(die1, die2).isPerfectPair());
    }
}