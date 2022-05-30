package gui;

/**
 * Position class composed by x and y coordinates.
 * 
 * 
 * @author taftan@usi.ch & sardoa@usiu.ch
 * @version 24/05/2022
 */
public class Position {

    private int x;
    private int y;

    /**
     * Constructor of the Position class.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter of the x coordinate.
     * 
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Getter of the y coordinate.
     * 
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }
}
