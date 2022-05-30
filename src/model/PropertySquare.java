
package model;

/**
 * This rapresent the property Square, child of the parent class Square.
 * A proeprty can be bought and sold.
 * Composed also by the House, that the player can build.
 *
 * @author taftan@usi.ch & saordoa@usi.ch
 * @version 28/04/2022
 */
public class PropertySquare extends Square {

    private Player owner = null;

    private final int price;
    private int priceTax;
    private int priceSell;
    private boolean monopolyColor = false;
    private final int position;
    private House house;

    /**
     * Constructor of the class PropertySquare.
     * name and color are from parent class Square.
     * 
     * @param price     of the propertySquare
     * @param priceTax  of the propertySquare
     * @param name      of the propertySquare
     * @param color     of the propertySquare, used as an ID of the square
     * @param priceSell of the propertySquare
     * @param position of the propertySquare
     * @param bh        building price for the propertySquare
     * @param p1        pricetax for 1 house
     * @param p2        pricetax for 2 houses
     * @param p3        pricetax for 3 houses
     * @param p4        pricetax for 4 houses
     * @param ph        pricetax for an Hotel
     * 
     * 
     */
    public PropertySquare(int price, int priceTax, String name, String color, int priceSell, int position, int bh,
            int p1, int p2, int p3, int p4, int ph) {
        super(name, color);
        this.price = price;
        this.priceTax = priceTax;
        this.priceSell = priceSell;
        this.position = position;
        house = new House(bh, p1, p2, p3, p4, ph);

    }

    /**
     * Get the array house of type House where stored the different pricesTax.
     * 
     * @return the array composed by pricestax of the houses
     */
    public House getHouse() {
        return house;
    }

    /**
     * Set the owner of the propertySquare with the player as input.
     * 
     * @param player that will be the owner of the propertySquare
     */
    public void changeOwner(Player player) {
        owner = player;
    }

    /**
     * Set the monopolyColor true if it was false, false if it was true.
     */
    public void setMononopolyColor() {
        monopolyColor = !monopolyColor;
    }

    /**
     * Set the value of the priceTax with priceTax given as input.
     * 
     * @param priceTax to assign to the this.priceTax
     */
    public void setPriceTax(int priceTax) {
        this.priceTax = priceTax;
    }

    /**
     * Set the priceTax to the double when the player by all the square of the same
     * color.
     */
    public void setPriceTaxMonopoly() {
        this.priceTax = priceTax * 2;
    }

    /**
     * Get the value of the priceSell.
     * 
     * @return the value of the priceSell
     */
    public int getPriceSell() {
        return priceSell;
    }

    /**
     * Set the value of the owner to Null when the owner sell the property.
     * Call the method getHouse and reset the counter of the houses for the list.
     * 
     */
    public void resetOwner() {
        owner = null;
        getHouse().resetCounter();
    }

    /**
     * Get the position of the propertySquare.
     * @return the position of the propertySquare
     */
    public int getPosition() {
        return position;
    }

    /**
     * Get the player of that own the propertySquare.
     * 
     * @return the player that own the property.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Get the price of the propertySquare.
     * 
     * @return the value of the price of the propertySquare
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the value of the priceTax of the propertySquare.
     * 
     * @return the value of the priceTax of the propertySquare
     */
    public int getPriceTax() {
        return priceTax;
    }

    /**
     * Call the method of the owner(Player) to increase his money with the priceTax
     * of the propertySquare.
     */
    public void payrent() {
        owner.increaseMoney(priceTax);
    }

}
