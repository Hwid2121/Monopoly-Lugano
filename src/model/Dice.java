
package  model;
import java.util.Random;




/**
 * THis class rappresents the Dice 
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class Dice
{
    Random rand = new Random();
    private  int die1;
    private  int die2;


    public Dice(){
        random();
    }
    
    public Dice(int die1, int die2){
        this.die1 = die1;
        this.die2 = die2;
    }
    
    
    public void random(){
        die1 = rand.nextInt(7);
        die2 = rand.nextInt(7);
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
