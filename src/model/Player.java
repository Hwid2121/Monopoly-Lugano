package src.model;


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
    private int turn;


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


    public int diceRollPlayer(){
        return -1;
    }
    
    
    public int getTurn(){
        return turn;
    }

    public void turnIncrement(){
        turn += 1;
    }



    

}
