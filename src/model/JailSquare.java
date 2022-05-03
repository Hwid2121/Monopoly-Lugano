package src.model;


/**
 * Write a description of class JailSquare here.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 
 */
public class JailSquare extends Square
{
   
    private Player player;
    private int turn;



    public JailSquare(int turn, String name, String color){
        super(name, color);
        this.turn = player.getTurn();
    }
    

}
