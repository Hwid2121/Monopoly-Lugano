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
     * @param xposition the x coordinate
     * @param yposition the y coordinate
     */
    public Position(int xposition, int yposition) {
        posX = xposition;
        posY = yposition;
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
