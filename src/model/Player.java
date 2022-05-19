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

    // private ArrayList<String> listOfProperty = new ArrayList<String>();
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
    









    // public int getPosProperty(int i){
    //     return listofPropertySquares.get(i);
    // }




    public int getMoney() {
        return this.money;
    }

    public String getPlayer() {
        return nickname;
    }

    // public void printNickname() {
    //     System.out.println(nickname);
    // }

    public int getPosition() {
        return position;
    }

    public String getNickname() {

        if (nickname == "") return "";
        return nickname;
    }

    public void decreaseMoney(int cash) {
        this.money = getMoney() - cash;
    }

    public void increaseMoney(int cash) {
        this.money = getMoney() + cash;
    }


    public int getPropertySquareNum(){
        return listofPropertySquares.size();
    }


    public void buyPropertySquare(PropertySquare house){
        listofPropertySquares.add(house);
    }


    public void sellPropertySquare(int i, PropertySquare ps){
        int cash = listofPropertySquares.get(i).getPriceSell();

        this.increaseMoney(cash); 

        listofPropertySquares.remove(ps);

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




    public String propertySquaretoString(){

        

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

    public String getSellproperString(){

        if (listofPropertySquares.size() == 0)
            return "No properties";

        String s = "";
        for(int i=0; i< listofPropertySquares.size(); i++){
                s = ("[" + i + "] ") + listofPropertySquares.get(i).getName() + "Price of sell: " + listofPropertySquares.get(i).getPriceSell();
        }
        return s;



    }


    public ArrayList<PropertySquare> getPropertySquare(){
        return listofPropertySquares;
    }



    // public boolean checkMonopolyProperty(){

    //     if (listofPropertySquares.size() < 2) return false;

        
    //     for(int i=0; i < listofPropertySquares.size(); i++){
    //         int counter=1;

    //         for (int j=1; j< listOfProperty.size(); j++){
    //             if(listofPropertySquares.get(i).getColor())
    //         }
    //     }
    // }




}
