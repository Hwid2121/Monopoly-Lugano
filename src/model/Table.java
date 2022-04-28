
package model;


/**
 * this class rapresent the table composed by the square and wher ethe player will play
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Table
{

    Square[] cell = new Square[40];


    public Square getSquare(int pos){
        return cell[pos];
    }

}
