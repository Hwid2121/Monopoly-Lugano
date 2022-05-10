package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * The test class BonusSquareTest.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 10/05/2022
 */
public class BonusSquareTest {
    @Test 
    public void getDescriptionTest(){
        assertEquals("etc", new BonusSquare("EastCampusUSI", "red", "etc", 200).getDescription());
    }

}
