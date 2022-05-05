package model;
import java.util.ArrayList;

/**
 * this class rapresents all the square in  the table, this class have 2 childs:
 *  - PropertySquare
 *  - BonusSquare
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Square
{
    private final String name;
    private final String color;

  
    private PropertySquare PropertySquare = new PropertySquare();

    public Square(String name, String color){
        this.name = name;
        this.color = color;
    }


    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }



}
