package model;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;





/**
 * Piece class that indetify the player.
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 24/05/2022
 */
public class Piece {

    private Random rand = new Random();
    private float redColor = rand.nextFloat();
    private float greenColor = rand.nextFloat();
    private float blueColor = rand.nextFloat();
    private Color randomColor;

    private ArrayList<Player> players = new ArrayList<>();


    /**
     * Constructor of the Piece class.
     */
    public Piece() {

        generatePiece();
        checkPiece();

    }



    /**
     * Generate the piece of the player.
     */
    public void generatePiece() {
        redColor = rand.nextFloat();
        greenColor = rand.nextFloat();
        blueColor = rand.nextFloat();
    }




    /**
     * Check if the piece is already used.
     */
    public void checkPiece() {

        for (Player player : players) {
            if (player.getPiece() == this) {
                generatePiece();
                checkPiece();
                break;
            }
        }
        this.setPiece();

    }




    /**
     * Set the piece of the player.
     */
    public void setPiece() {
        randomColor = new Color(redColor, greenColor, blueColor);

    }




    /**
     * Get the color of the piece.
     * @return the color of the piece
     */
    public Color getColor() {
        return randomColor;
    }

}
