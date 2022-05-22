package model;

/**
 * this class rapresents all the square in the table, this class have 2 childs:
 * - PropertySquare
 * - BonusSquare
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Square {
    private final String name;
    private final String color;

    /**
     * Constructor of the class Square with Name and color (used as ID).
     * 
     * @param name  of the Square
     * @param color of the Square (used as ID of the Square)
     */
    public Square(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Get the name of the Square.
     * 
     * @return the name of the propertySquare.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the color of the Square.
     * Could be:
     * - Blue
     * - Orange
     * - Pink
     * - Red
     * - Yellow
     * - Azure
     * - Green
     * - Bonus
     * - Park
     * - Company
     * 
     * @return the value of the color of the Square.
     */
    public String getColor() {
        return this.color;
    }

}
