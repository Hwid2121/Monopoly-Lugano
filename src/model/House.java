package model;

/**
 * This class rapresent the building that a player can build in
 * a propertySquare.
 * Can be 1 to 4 house or 1 hotel.
 * Each building increase the value of the property by a precise value.
 *
 * @author taftan@usi.ch sardoa@usi.ch
 * @version 28/04/2022
 */
public class House {

    private int buildingPrice;
    private int price1;
    private int price2;
    private int price3;
    private int price4;
    private int priceHotel;

    private int counter = 0;

    /**
     * Constructor of House class.
     * Take in input the price of:
     * - Building House
     * - Pricetax from 1 to 4 houses
     * - Pricetax for the Hotel
     * 
     */
    public House(int bh, int p1, int p2, int p3, int p4, int ph) {

        buildingPrice = bh;
        price1 = p1;
        price2 = p2;
        price3 = p3;
        price4 = p4;
        priceHotel = ph;

    }

    /**
     * This method get the price for every variable of the class.
     * Given an input as id of the price that we want see.
     *
     * @param i that is the index of the price that we want to see
     *          1 to see price1
     *          2 to see price2
     *          3 to see price3
     *          4 to see price4
     *          5 to see priceHotel
     *          6 to see BuildingPrice
     * 
     * 
     * @return the price of the field requested
     *
     * 
     */
    public int getPrice(int i) {
        switch (i) {
            case 1:
                return price1;
            case 2:
                return price2;
            case 3:
                return price3;
            case 4:
                return price4;
            case 5:
                return priceHotel;
            case 6:
                return buildingPrice;
            default:
                return 0;
        }
    }

    /**
     * Method buildHouse that set the counter of the houses to the num
     * in input.
     * If the counter is more than 5 set the counter to 5.
     * 
     * @param num rapresent the num of houses that we want to build
     * 
     */
    public void buildHouse(int num) {

        counter += num;

        if (counter > 5) {
            counter = 5;
        }

    }

    /**
     * Get the value of the counter that rapresent the number of houses.
     * 
     * @return the value of the counter
     *
     * 
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Set the conter to 0.
     *
     * 
     */
    public void resetCounter() {
        counter = 0;
    }

    /**
     * Check if the number of the houses
     * 
     * @param num that rapresenr the num of the houses that we want to build
     * @return true if the counter + num is smaller or equal than 4
     *
     * 
     */
    public boolean checkNumHouses(int num) {
        return (counter + num) <= 4;
    }
}