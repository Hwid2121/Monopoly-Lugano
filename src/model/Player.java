package model;

import java.text.BreakIterator;
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

    private int inJail = -1;

    private ArrayList<Card> deckOfPlayer = new ArrayList<Card>();

    private ArrayList<String> listOfProperty = new ArrayList<String>();
    private ArrayList<PropertySquare> listofPropertySquares = new ArrayList<PropertySquare>();
    

    public Player(String nickname) {
        this.nickname = nickname;
        money = 1500;
        position = 0;
    }

    public void setJail(int i) {
        inJail = i;
    }

    public int getTurnsInJail() {
        return inJail;
    }

    public boolean stillInJail() {
        return inJail > 0;
    }

    public void addCardToDeck(Card card) {
        deckOfPlayer.add(card);
    }

    public ArrayList<Card> getDeck() {
        return deckOfPlayer;
    }

    public void deleteCard(String desc) {
        for (int i = 0; i < deckOfPlayer.size(); i++) {
            if (deckOfPlayer.get(i).getDescription() == desc) {
                deckOfPlayer.remove(i);
                break;
            }
        }
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

    public void decreaseMoney(int cash) {
        this.money = getMoney() - cash;
    }

    public void increaseMoney(int cash) {
        this.money = getMoney() + cash;
    }

    // public void buyProperty(String house) {
    //     listOfProperty.add(house);

    // }


    public void buyPropertySquare(PropertySquare house){
        listofPropertySquares.add(house);
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

    public void movePosition(int pos){
        
        position = pos;
    }

    // public String getProperties() {

    //     if (listOfProperty.size() == 0)
    //         return "No properties";

    //     Iterator<String> it = listOfProperty.iterator();
    //     String out = it.next();

    //     while (it.hasNext()) {
    //         out = out + ", " + it.next();
    //     }
    //     return out;


    // }



    public String getPropertySquare(){

        

        if (listofPropertySquares.size() == 0)
            return "No properties";
        else{
                String s = listofPropertySquares.get(0).getName();

            for(int i = 1; i< listofPropertySquares.size(); i++){

                s = s + " ," + listofPropertySquares.get(i).getName();

            }
            return s;
        }
    }




}
