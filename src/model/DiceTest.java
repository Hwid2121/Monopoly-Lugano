package src.model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DiceTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DiceTest
{
    private Dice value1;
    private Dice value2;
    private Dice value3;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    
    public void setUp()
    {
        value1 = new Dice(0,0);
        value2 = new Dice(1,0);
        value3 = new Dice(1,5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @Test
    public void testGetDice()
    {
        assertEquals(0, value1);
        assertEquals(1, value2);
        assertEquals(6, value3);
    }
}
