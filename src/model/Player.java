package model;

import java.util.ArrayList;


/**
 * Thiss class rapresents the player
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Player
{
   
    private int money;
    private final String nickname;
    private int position;
    private int turn = 0;


    private int[] inPrison = new int[2];

    private ArrayList<PropertySquare> listOfProperty = new ArrayList<PropertySquare>(); 

    


    public Player(String nickname){
        this.nickname = nickname;
        money = 1500;
        position = 0;
        inPrison[0] = 0;
        inPrison[1] = 0;
    
    }



    public int getMoney(){
        return money;
    }

    public String getPlayer(){
        return nickname;
    }

    public void printNickname(){
        System.out.println(nickname);
    }

    public int getPosition(){
        return position;
    }

    public String getNickname(){
        return nickname;
    }

    
    public void buyProperty(PropertySquare house){
        listOfProperty.add(house.buying());
    }

    public int diceRollPlayer(){
        return -1;
    }
    
        
    public int getTurn(){
        return turn;
    }

    public void turnIncrement(){
        turn += 1;
    }



    public void setPosition(int pos){
        position = (position + pos) % Table.getSizeofTable();
        System.out.println(position);
    }



    

}
