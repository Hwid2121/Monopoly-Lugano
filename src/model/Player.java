package model;

import java.util.ArrayList;

/**
 * Thiss class rapresents the player
 *
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 28/04/2022
 */
public class Player {

    private int money;
    private final String nickname;
    private int position;
    private int turn = 0;
    private Piece piece;
    private int inJail = -1;
    private ArrayList<Card> deckOfPlayer = new ArrayList<Card>();
    private ArrayList<PropertySquare> listofPropertySquares = new ArrayList<PropertySquare>();

    /**
     * The constructor of Player that take the nickname.
     * set the money of default by 1500 and the positio at 0.
     * 
     * @param nickname the nick of the player
     * 
     */
    public Player(String nickname) {
        this.nickname = nickname;
        money = 1500;
        position = 0;
        piece = new Piece();
    }

    /**
     * 
     * Used for get the piece that rapresent the player in the GUI.
     * 
     * @return the piece of the player
     * 
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Set the number of injail with the number given as input.
     * 
     * @param index to set the num of Injail
     * 
     */
    public void setJail(int index) {
        inJail = index;
    }

    /**
     * Get the value of InJail.
     * 
     * @return the value of Injail
     * 
     */
    public int getTurnsInJail() {
        return inJail;
    }

    /**
     * Decrease inJail by 1.
     * 
     */
    public void decreseDayInJail() {
        inJail -= 1;
    }

    /**
     * Check if the player is still in jail.
     * 
     * @return true if inJail is greater than 0, False otherwise
     * 
     */
    public boolean stillInJail() {
        return inJail > 0;
    }

    /**
     * Add card into the deck of the player.
     * 
     * @param card to add into the deck
     * 
     */
    public void addCardToDeck(Card card) {
        deckOfPlayer.add(card);
    }

    /**
     * Get the list of cards of the player.
     * 
     * @return the deckOfPlayer
     * 
     */
    public ArrayList<Card> getDeck() {
        return deckOfPlayer;
    }

    /**
     * Delete the card with descr given as input.
     * 
     * @param desc
     * 
     */
    public void deleteCard(String desc) {
        for (int i = 0; i < deckOfPlayer.size(); i++) {
            if (deckOfPlayer.get(i).getDescription() == desc) {
                deckOfPlayer.remove(i);
                break;
            }
        }
    }

    /**
     * Get the value of the money of the player.
     * 
     * @return the value of the money.
     * 
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Get the position of the player.
     * 
     * @return tthe position
     * 
     */
    public int getPosition() {
        return position;
    }

    /**
     * Get Nickname of the player.
     * 
     * @return the nickname of the player
     * 
     */
    public String getNickname() {

        if ("".equals(nickname)) {
            return "";
        }

        return nickname;
    }

    /**
     * Decrese the money of the player by cash.
     * 
     * @param cash the value of the money to decrease
     */
    public void decreaseMoney(int cash) {
        this.money = getMoney() - cash;
    }

    /**
     * Increase the money of the player by cash.
     * @param cash the value of the money to increase
     * 
     */
    public void increaseMoney(int cash) {
        this.money = getMoney() + cash;
    }

    /**
     * Get the size of the listofpropertySquare.
     * 
     * @return the size of the listOfPropertySquares
     * 
     */
    public int getPropertySquareNum() {
        return listofPropertySquares.size();
    }

    /**
     * Add the house in listofPropertySquares of the player.
     * 
     * @param house to add in the listofPropertySQure
     * 
     */
    public void buyPropertySquare(PropertySquare house) {
        listofPropertySquares.add(house);
    }

    /**
     * Sell the propertySquare at index i in the listOfPropertySquare.
     * Then increase the money of the player by the price sell of the
     * propertySquare.
     * 
     * @param index  as index in the listOfPropertySquare
     * @param propertySquareTemp property square to remove from the listOfPropertySquare
     * 
     */
    public void sellPropertySquare(int index, PropertySquare propertySquareTemp) {
        int cash = listofPropertySquares.get(index).getPriceSell();

        this.increaseMoney(cash);

        listofPropertySquares.remove(propertySquareTemp);

    }

    /**
     * Get the value of the turn of the player.
     * 
     * @return the value of the turn
     * 
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Increase turn of the player by 1.
     */
    public void turnIncrement() {
        turn += 1;
    }

    /**
     * Set the position of the player by position + pos and moduled by
     * the size of the table.
     * 
     * @param pos the num to increase the position
     */
    public void setPosition(int pos) {
        position = (position + pos) % Table.getSizeofTable();
    }

    /**
     * Set the position by the pos.
     * 
     * @param pos
     * 
     */
    public void movePosition(int pos) {

        position = pos;
    }

    /**
     * If the size listOfProeprtySquare is 0 then no properties else
     * return the name of each property.
     * This method is usefull in the TUI.
     * 
     * @return "No properties" if the player doesn't has properties else the
     *         name of each property
     */

    public String propertySquaretoString() {

        if (listofPropertySquares.isEmpty()) {
            return "No properties";
        } else {
            String string = listofPropertySquares.get(0).getName();

            for (int index = 1; index < listofPropertySquares.size(); index++) {

                string = string + " ," + listofPropertySquares.get(index).getName();

            }
            return string;
        }
    }

    /**
     * Remove the propertysqure Square from the list of propertySQuare owned by
     * player.
     * 
     * @param square to remove from the list of the propertySquares
     * 
     */
    public void removePropertySquare(PropertySquare square) {

        for (PropertySquare x : listofPropertySquares) {
            if (x == square) {
                listofPropertySquares.remove(x);
            }
        }

    }

    /**
     * Get the price of each propertysquare own by the player.
     * Usefull in the TUI.
     * 
     * @return "no properties" if listOfPropertySquare size is 0 else the price of
     *         each proerty own by the player
     * 
     */
    public String getSellproperString() {

        if (listofPropertySquares.isEmpty()) {
            return "No properties";
        }

        String string = "";
        for (int index = 0; index < listofPropertySquares.size(); index++) {
            string = ("[" + index + "] ") + listofPropertySquares.get(index).getName() + "Price of sell: "
                    + listofPropertySquares.get(index).getPriceSell();
        }
        return string;

    }

    /**
     * Get the listOfPropertySquare.
     * 
     * @return listofPropertySquare
     * 
     */
    public ArrayList<PropertySquare> getPropertySquare() {
        return listofPropertySquares;
    }

}
