package model;


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


    private final int pos;


    public Square(String name, String color, int pos){
        this.name = name;
        this.color = color;
        this.pos = pos;
    }


    public String getName(){
        return name;
    }

    public String getColor(){
        return color;
    }

    public int getPos(){
        return pos;
    }

}
