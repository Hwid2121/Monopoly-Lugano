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
    String descr;
    @Test
    public void getDescriptionTest(){
        assertEquals(descr, new Card(descr).getDescription());
    }
    @Test
    public void card0Test(){
        assertEquals(descr, new Card(descr).getDescription());
    }

    
}
