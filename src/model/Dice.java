package src.model;
import java.util.Random;

/**
 * THis class rappresents the Dice 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Dice
{
    
    private  int die1;
    private  int die2;


    public Dice(){
        random();
    }

    public void random(){
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

    public int getDie1(){
        return die1;
    }

    public int getDie2(){
        return die2;
    }

    public int getDice(){
        return die1 + die2;
    }
}




 


}
