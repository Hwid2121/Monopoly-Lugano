package model;

import java.util.Random;

/**
 * This class rappresents the Dice used for the chaging
 * postion of the player.
 * 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */

public class Dice {
    private Random rand = new Random();
    private int die1;
    private int die2;

    /**
     * Constructor of the DIce class that randomize that call the
     * method random() for randomize itself.
     * 
     */
    public Dice() {
        random();
    }

    /**
     * This the second constructor tthat set the value of dice by the value
     * in input.
     * 
     * @param die1 rapresent the value of the die1
     * @param die2 rapresent the value of the die2
     *
     * 
     */
    public Dice(int die1, int die2) {
        this.die1 = die1;
        this.die2 = die2;
    }

    /**
     * Method random that set the values of the dice with random numbers
     * from 1 to 6.
     * And return the method getDice().
     * 
     * @return the method getDIce() that return the sum of the die1 and die2
     */
    public int random() {
        die1 = rand.nextInt(5) + 1;
        die2 = rand.nextInt(5) + 1;
        return getDice();
    }

    /**
     * Get the value of the die1.
     * 
     * @return the value of the die1
     */
    public int getDie1() {
        return die1;
    }

    /**
     * Get the value of the die2.
     * 
     * @return the value of the die2
     */
    public int getDie2() {
        return die2;
    }

    /**
     * Get the sum of die1 and die 2 that rapresent the amount of the die.
     * 
     * @return the value of die1 + die2
     */
    public int getDice() {
        return die1 + die2;
    }

    /**
     * isPerfectPair is a method used for jail method for know if the value of die1
     * and die2 are equal.
     * 
     * @return true if the die1 and die2 are the same number, false otherwise.
     */
    public boolean isPerfectPair() {
        return this.die1 == this.die2;
    }

}
