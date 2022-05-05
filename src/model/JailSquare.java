package model;


/**
 * Write a description of class JailSquare here.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 
 */
public class JailSquare extends Square
{
   
    private Player player;
    
    private String description;

    private int days = 2;



    public JailSquare(String name, String color, String Description){
        super(name, color);
        this.description = description;
    }




    

}
