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



    public int steps;


    

    public int  numOfPlayers;


    public Monopoly(ArrayList<Player> players){
        numOfPlayers = players.size();
    }





    public boolean MonopolyEND(){
        return numOfPlayers >= 1;
    }


    public int die1(){
        return dice.getDie1();
    }
    public int die2(){
        return dice.getDie2();
    }

    public int throwDice(){
        steps = dice.random();
        return steps;
    }


    public void playTurn(Player player){

        
        player.setPosition(steps);
        System.out.println("Sei arrivato alla casella: " + table.getSquareName(player.getPosition()));


        switch (table.getSquare(player.getPosition()).getColor()){
            case "white":
                Monopoly.bonusSquarePLAY();
                break;
            
            // case "black":
            //     Monopoly.jailSquarePLAY();
            
            
        }

        


        

    }
    



    public static void bonusSquarePLAY(){

    }
    




}
