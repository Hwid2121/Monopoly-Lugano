package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Jailsquare rapresent the prison where a player could reach in 2 ways:
 *  - By card
 *  - By dice
 * 
 * for escape have to do a perfect pair and after can throw again the dice or
 * pay 50 chf or by the card "Free from jail".
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class JailSquare extends Square {

    private Dice dice;

    private static int fine = 50;
    private static int days = 3;





    /**
     * Constructor of Jailsquare that is child of Square class.
     * @param name  name of the Square     
     * @param color color of the Square
     *
     *  
     */
    public JailSquare(String name, String color) {
        super(name, color);
    }

    
    
    
    /**
     * Payfine decrese the money of the player by 55 chf.
     * @param player where to decrese the money   
     *
     *  
     */
    public static void payFine(Player player) {
        player.decreaseMoney(55);
    }

    /**
     * Free from jail set the indicator to -1 (that is free).
     * @param player where to decrese the money   
     *
     *  
     */
    public static void freeFromJail(Player player) {
        player.setJail(-1);
    }


    /**
     * Decrease the day in jail of the player.
     * @param player where to decrese the money   
     *
     *  
     */
    public static void decreseDayInJail(Player player){
        player.decreseDayInJail();
    }

    /**
     * Get the value of the days.
     * @return the value of the days
     *  
     */
    public static int getDays() {
        return days;
    }

    /**
     * Get the value of the fine.
     *  @return the value of the fine.
     */
    public static int getFine() {
        return fine;
    }



    /**
     *
     * Check if the player own the card "Free from the Jail" return true and delete the card
     * if the player own it. 
     * @return true if the player have the card, false otherwise
     * @param player where to check the deck 
     *
     *  
     */
    public static boolean checkFreeJailCard(Player player) {

        for (Card card : player.getDeck()) {
            if (card.getDescription() == "Get Out of Jail Free") {
                player.deleteCard(card.getDescription());
                return true;
            }
        }

        return false;

    }

    /**
     * Check if the player did a perfect pair.
     * @return the dice.getperfectparil that is true when the die1 and die2 are equal
     * false otherwise
     *
     *  
     */
    public boolean checkPerfectPair() {
        return dice.getPerfectPair();
    }

    /**
     * Get the value of the die1.
     * @return the value of die1
     *
     *  
     */
    public int getPair1() {
        return dice.getDie1();
    }



    /**
     * Get the value of the die2.
     * @return the value of the die2.   
     *
     *  
     */
    public int getPair2() {
        return dice.getDie2();
    }

}
