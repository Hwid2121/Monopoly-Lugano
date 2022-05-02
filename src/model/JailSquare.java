package src.model;


/**
 * Write a description of class JailSquare here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
