package gui;

/**
 * Position class composed by x and y coordinates.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class Position {

    private int posX;
    private int posY;

    /**
     * Constructor of the Position class.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Position(int xPos, int yPos) {
        posX = xPos;
        posY = yPos;
    }

    /**
     * Getter of the x coordinate.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return posX;
    }

    /**
     * Getter of the y coordinate.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return posY;
    }
}
