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


    ArrayList<Player> players;

    public int steps;

    public int numOfPlayers;

    public Monopoly() {
        
        players = new ArrayList<>();
        
    }


    public void addPlayer(Player player){
        players.add(player);
    }


    public ArrayList<Player> getListOfPlayer(){
        return players;
    }


    public Player getPLayer(int turn){
        return players.get(turn);
    }

    public int getSizeOfPlayers(){
        return players.size();
    }


    // public ArrayList<Player> playerEliminated(ArrayList<Player> players, Player banned){
    //     players.remove(banned);
    //     return players;
    // }




    public void playerEliminated(Player player){
        players.remove(player);
    }


    public void setNumofPlayers(int num){
        numOfPlayers = num;
    }

    // public int getNumplayers(){
    //     return num
    // }


    public boolean MonopolyEND() {
        return this.getSizeOfPlayers() > 1;
    }


    public  boolean checkbankruptStatus(Player player){
        if (player.getMoney() > 0){
            return false;
        } else return true;
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

  

    // public String propertyDescr(Player player) {
    //     return table.getDescriptionProperty(player.getPosition());
    // }



    public void setOwner(Player player){
        table.setSquareOwner(player);
    }









   


    // public Player checkOwnerForRent( String Nick, ArrayList<Player> players, int pos) {
    //     Object obj = this.table.getSquare(pos);

    //     if (obj instanceof PropertySquare) {
    //         PropertySquare s = (PropertySquare) obj;
            
    //         if (s.getOwner() == "" || s.getOwner() == Nick) return null;
    //         else{
    //             for(int i =0; i < players.size(); i++){
    //                 if(players.get(i).getNickname() == s.getOwner()) return players.get(i);
    //             }
    //         }
    //     }
    //     return null;
    // }



    public boolean checkOwnerForRent(Player player) {
        Object obj = this.table.getSquare(player.getPosition());

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;
            
            return s.getOwner() == player;
    }
        else return false;

    }


}

