
package model;

/**
 * This rapresent the property in the table
 *
 * @author Nicolo' Tafta & Alberto Sardo
 * @version 28/04/2022
 */
public class PropertySquare extends Square {

    private String owner = "";

    private final int price;
    private final int priceTax;


    private boolean mortgage = false;

    public PropertySquare(int price, int priceTax, String name, String color) {
        super(name, color);
        this.price = price;
        this.priceTax = priceTax;
    }

    public void changeOwner(Player player) {
        owner = player.getNickname();
    }

    public PropertySquare buying() {
        return this;
    }

    public void selling() {

    }

    public String getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceTax() {
        return priceTax;
    }


    public boolean getMortgageProperty(){
        return mortgage;
    }

    public void setMortageProperty(){
        mortgage = !mortgage;
    }
    
}
