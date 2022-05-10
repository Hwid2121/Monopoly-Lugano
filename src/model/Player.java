package model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Thiss class rapresents the player
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Player {

    private int money;
    private final String nickname;
    private int position;
    private int turn = 0;


    // first number set to 0 Initially
    // first number rappresent number of turn to remain in jail
    // if 0 then 0, if 2 then 2
    private int inJail = 0;


    private ArrayList<Card> deckOfPlayer = new ArrayList<Card>();


    private ArrayList<String> listOfProperty = new ArrayList<String>();

    public Player(String nickname) {
        this.nickname = nickname;
        money = 1500;
        position = 0;
    }



    public int getTurnsInJail(){
        return inJail;
    }

    

    public void addCardToDeck(Card card){
        deckOfPlayer.add(card);
    }




    public int getMoney() {
        return this.money;
    }

    public String getPlayer() {
        return nickname;
    }

    public void printNickname() {
        System.out.println(nickname);
    }

    public int getPosition() {
        return position;
    }

    public String getNickname() {
        return nickname;
    }

    public void decreaseMoney(int cash){
        this.money =  getMoney() - cash;
    }

    public void increaseMoney(int cash){
        this.money = getMoney() + cash;
        }

    public void buyProperty(String house) {
        listOfProperty.add(house);
        
    }

    public int diceRollPlayer() {
        return -1;
    }

    public int getTurn() {
        return turn;
    }

    public void turnIncrement() {
        turn += 1;
    }

    public void setPosition(int pos) {
        position = (position + pos) % Table.getSizeofTable();
        System.out.println(position);
    }

    public String getProperties(){

        
        Iterator<String> it = listOfProperty.iterator();
        String out = it.next();
        if (listOfProperty.size() == 0) return "No properties";
        else 
            {
                
               while(it.hasNext()){
                   out = out + ", " + it.next();
               }
               return out;
            }
        

    }



    

    

}
