
package src.model;

import src.model.BonusSquare;

/**
 * this class rapresent the table composed by the square and wher ethe player will play
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Table
{
    
    static private final int size = 40;
    
    Square[] cell = new Square[size];


    public void newtable(){
        cell[0] = new BonusSquare("Start","white", "The start for every player.",200);
        cell[1] = new PropertySquare(60,2, "via", "brown");
        cell[2] = new BonusSquare("Community Chest", "white", "You won at lottery you got +100", 100 );
        cell[3] = new PropertySquare(60,2, "via", "brown");
        cell[4] = new BonusSquare( "Income Tax", "white", "Income tax you have to pay 200", 200);
        cell[5] = new PropertySquare(200,2, "via", "special");
        cell[6] = new PropertySquare(100,6, "via", "blue");
        cell[7] = new BonusSquare("bonus", "white", "You won lottery you got 75", 75);
        cell[8] = new PropertySquare(100,6, "via", "blue");
        cell[9] = new PropertySquare(120, 8 , "via", "blue");
        cell[10] = new BonusSquare("Go to Jail!", "white", "now you go to the jail!", -1);

        cell[11] = new PropertySquare(140, 10, "via", "pink");
        cell[12] =new PropertySquare(150, 4xdiceroll , "eletric", "white");
        cell[13] = new PropertySquare(140,10, "via", "pink");
        cell[14] =new PropertySquare(120, 8 , "via", "blue");
    }

    public Square getSquare(int pos){
        return cell[pos];
    }

}




/**
 *  start (+200)
 *  propertyA
 * bonus
 * propertyA
 * malus (-200)
 * propertyA
 * propertyB
 * bonus
 * propertyB
 * propertyB
 * JAIL
 * propertyC
 * propertyC
 * propertyC
 * propertyC
 * propertyC
 * propertyD
 * bonus
 * propertyD
 * propertyD
 * NULL (do nothing)
 * propertyE
 * bonus/malus
 * propertyE
 * propertyE
 * propertyE
 * propertyF
 * propertyF
 * propertyF
 * propertyF
 * GO back TO JAIL
 * propertyG
 * propertyG
 * bonus
 * propertyG
 * propertyG
 * bonus/malus
 * propertyE
 * malus (-100)
 * propertyE
 * 
 * 
 */








 