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
    
    private  int dice1 = (int)(Math.random()*6)+1;
    private  int dice2 = (int)(Math.random()*6)+1;

    
    public int getDice1(){
        return dice1;
    }
    
    public int getDice2(){
        return dice2;
    }
    public int getTot(){
            return dice1 + dice2;
    }





}
