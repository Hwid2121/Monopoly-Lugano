
package src.model;

/**
 * This rapresent the property in the table
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class PropertySquare extends Square
{
    

    private Player owner;

    private final int price;
    private final int priceTax;


    public PropertySquare(int price, int priceTax, 
                String name, String color, int pos){
        super(name,color,pos);
        this.price = price;
        this.priceTax = priceTax;
    }

    public void changeOwner(){

    }

    public void buying(){

    }

    public void selling(){

    }


    public int getPrice(){
        return price;
    }

    public int priceTax(){
        return priceTax;
    }










}
