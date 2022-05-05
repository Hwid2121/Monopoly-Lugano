
package model;
import model.*;

/**
 * This rapresent the property in the table
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class PropertySquare extends Square
{
    

    private String owner;

    private final int price;
    private final int priceTax;


    public PropertySquare(int price, int priceTax, String name, String color){
        super(name,color);
        this.price = price;
        this.priceTax = priceTax;
    }

    public void changeOwner(Player player){
        owner = player.getPlayer();
    }

    public PropertySquare buying(){
        return this;
    }


    
    public void selling(){

    }

    public void setOwner(){

    }


    public int getPrice(){
        return price;
    }

    public int priceTax(){
        return priceTax;
    }










}
