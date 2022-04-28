package model;


/**
 * This class rapresent the bonus square of the table such as:
 *  - Start
 *  - Bonus (in future cards)
 *  - Malus (in future cards)
 *  - Jail
 *  - 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class BonusSquare extends Square
{

    
    private final String description;

    public BonusSquare(String name, String color, int pos, String description){
        super(name,color,pos);
        this.description = description;
    }



    public void giveMoney(){

    }

    public void takeMoney(){

    }

    public String getDescription(){
        return description;
    }


}
