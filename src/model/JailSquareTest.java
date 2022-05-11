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

    @Test
    public void getDaysTest(){
        assertEquals(3, new JailSquare("Via delle Aie", "blue").getDays());
    }

    @Test
    public void getFineTest(){
        assertEquals(50, new JailSquare("Via delle Aie", "blue").getFine());
    }

    @Test
    public void getPerfectPairTest(){
        assertTrue(new Dice(5, 5).getPerfectPair());
    }
    
}
