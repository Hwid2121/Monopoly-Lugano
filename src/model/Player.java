package model;

import java.util.ArrayList;

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

    private int[] inPrison = new int[2];

    private ArrayList<PropertySquare> listOfProperty = new ArrayList<PropertySquare>();

    public Player(String nickname) {
        this.nickname = nickname;
        money = 1500;
        position = 0;
        inPrison[0] = 0;
        inPrison[1] = 0;

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

    public void setMoney(int cash){
        this.money =  getMoney() - cash;
    }

    public void buyProperty(PropertySquare house) {
        listOfProperty.add(house.buying());
        setMoney(house.getPrice());

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


        String out = "";

        
        
        for (int i =0; i < listOfProperty.size(); i++){
            out = out + listOfProperty.get(i).getName();
        }



        return out;


    }

    

}
