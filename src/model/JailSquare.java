package model;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Write a description of class JailSquare here.
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version
 */
public class JailSquare extends Square {

    private ArrayList<Player> listOfPrisoners = new ArrayList<Player>();

    private Dice dice;


    private static int fine = 50;
    private static int days = 3;

    public JailSquare(String name, String color) {
        super(name, color);
    }



    public static void payFine(Player player){
        player.decreaseMoney(55);
    }

    public static void freeFromJail(Player player){
        player.setJail(-1);
    }

    public static int getDays(){
        return days;
    }
    public static int getFine(){
        return fine;
    }


    public boolean checkPrisoner(Player player){
        for (Player prison: listOfPrisoners){
            if (prison == player) return true;
        }
        return false;
    }

    public static boolean checkFreeJailCard(Player player){


        for(Card card : player.getDeck() ){
            if(card.getDescription() == "Get Out of Jail Free"){
                player.deleteCard(card.getDescription());
                return true;
            }
        }

        return false;
        

    }


    public void perfectPair(){
        
        dice = new Dice(); 
    }

    public boolean checkPerfectPair(){
        return dice.getPerfectPair();
    }

    public int getPair1(){
        return dice.getDie1();
    }
    public int getPair2(){
        return dice.getDie2();
    }






}
