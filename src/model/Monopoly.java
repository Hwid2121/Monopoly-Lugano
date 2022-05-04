package model;

import java.util.ArrayList;
import javax.print.attribute.standard.NumberOfDocuments;

/**
 * This class rapresent the main of the game, here all the principals 
 * methods of monopoly are stored
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Monopoly
{
    
    public Table  table = new Table();
    public Dice dice = new Dice();
    


    

    public int  numOfPlayers;


    public Monopoly(ArrayList<Player> players){
        numOfPlayers = players.size();
    }






    public boolean MonopolyEND(){
        return numOfPlayers > 0;
    }




}
