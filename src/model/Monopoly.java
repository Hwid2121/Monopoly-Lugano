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
        return numOfPlayers >= 1;
    }



    public void playTurn(Player player){

        // player.printNickname();
        System.out.println(player.getNickname() + " e' il tuo turno!");

        int steps = dice.random();

        System.out.println("I tuoi dadi hanno fatto " + dice.getDie1() +  " e " + dice.getDie2());
        System.out.println("Avanzi di " + steps);
        

        player.setPosition(steps);
        System.out.println("Sei arrivato alla casella: " + table.getSquareName(player.getPosition()));
        // table.getSquareName(player.getPosition())
        

    }
    




}
