package model;

import java.util.ArrayList;
//import javax.print.attribute.standard.NumberOfDocuments;
import java.util.Iterator;

/**
 * This class rapresent the main of the game, here all the principals
 * methods of monopoly are stored
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Monopoly {

    public Table table = new Table();
    public Dice dice = new Dice();

    public int steps;

    public int numOfPlayers;

    public Monopoly(ArrayList<Player> players) {
        numOfPlayers = players.size();
    }

    public boolean MonopolyEND() {
        return numOfPlayers >= 1;
    }

    public int die1() {
        return dice.getDie1();
    }

    public int die2() {
        return dice.getDie2();
    }




    public int throwDice() {
        steps = dice.random();
        return steps;
    }

    public void setPositionPlayer(Player player) {
        player.setPosition(steps);
    }

  

    public String propertyDescr(Player player) {
        return table.getDescriptionProperty(player.getPosition());
    }



    public void setOwner(Player player){
        table.setSquareOwner(player);
    }


    public String getNicknameOwner(Player player){
        return table.getSquareOwner(player.getTurn());
    }








   


    public Player checkOwnerForRent( String Nick, ArrayList<Player> players, int pos) {
        Object obj = this.table.getSquare(pos);

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            
            if (s.getOwner() == "" || s.getOwner() == Nick) return null;
            else{
                for(int i =0; i < players.size(); i++){
                    if(players.get(i).getNickname() == s.getOwner()) return players.get(i);
                }
            }
        }
        return null;
    }

}
