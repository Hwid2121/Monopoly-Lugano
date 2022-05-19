
package model;

import javax.swing.text.Position;

/**
 * This rapresent the property in the table
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class PropertySquare extends Square {

    private Player owner = null;

    private final int price;
    private int originalPrice;
    private int priceTax;

    private int priceSell;
    private boolean monopolyColor = false;


    private final int  position;


    // private boolean mortgage = false;

    public PropertySquare(int price, int priceTax, String name, String color, int priceSell, int position) {
        super(name, color);
        this.price = price;
        this.priceTax = priceTax;
        this.priceSell = priceSell;
        this.position = position;
        originalPrice = priceTax;
    }



    public void changeOwner(Player player) {
        owner = player;
    }


    public boolean getMonopolyColor(){
        return this.monopolyColor;
    }

    public void setMononopolyColor(){
        monopolyColor = !monopolyColor;
    }

    public void setPriceTax(int priceTax){
        this.priceTax = priceTax; 
    }

    public void setPriceTaxMonopoly( ){
        this.priceTax = priceTax*2;
    }




    public int getPriceSell(){
        return priceSell;
    }

    public void resetOwner(){
        owner = null;
    }

 
    public int getPosition(){
        return position;
    }
    

    public Player getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceTax() {
        return priceTax;
    }


    public void payrent(){
        owner.increaseMoney(priceTax);
    }


    // public boolean getMortgageProperty(){
    //     return mortgage;
    // }

    // public void setMortageProperty(){
    //     mortgage = !mortgage;
    // }
    


}
