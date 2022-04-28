package model;


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
    private int[] propertiesID;



    public Player(String nickname){
        this.nickname = nickname;
        money = 1500;
        position = 0;
    }



    public int getMoney(){
        return money;
    }

    public int getPosition(){
        return position;
    }

    public String getNickname(){
        return nickname;
    }

    

}
