package model;

import java.util.ArrayList;

/**
 * This class rapresent the main of the game.
 * Here all the classes are called and linked togheter.
 *
 * @author taftan@usi.ch & sardoa@usi.ch
 * @version 28/04/2022
 */
public class Monopoly {

    private Table table = new Table();
    private Dice dice = new Dice();

    private ArrayList<Player> players;

    private int steps;

    private int numOfPlayers;

    /**
     * Constructor of the Monopoly class.
     * Initialize the arrayList players.
     *
     * 
     */
    public Monopoly() {

        players = new ArrayList<>();

    }

    public void setNumOfPlayers(int n) {
        numOfPlayers = n;
    }

    public int getNumOfplayer() {
        return numOfPlayers;
    }

    /**
     * Get the table.
     * 
     * @return table of monopoly
     *
     * 
     */
    public Table getTable() {
        return table;
    }

    /**
     * Get the dice.
     * 
     * @return dice of monopoly
     *
     * 
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Add new player in the arrayList players.
     * 
     * @param player player to add in the arrayList player
     *
     * 
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Get the list of players.
     * 
     * @return ArrayList of players
     *
     * 
     */
    public ArrayList<Player> getListOfPlayer() {
        return players;
    }

    /**
     * Get the player in the arraylist at the number of the turn in that moment.
     * 
     * @param turn turn number.
     *
     * 
     */
    public Player getPLayer(int turn) {
        return players.get(turn);
    }

    /**
     * Get the size of the list of players.
     * 
     * @return the size of the arraylist of players
     *
     * 
     */
    public int getSizeOfPlayers() {
        return players.size();
    }

    /**
     * Remove the player that was eliminted from the list of players.
     * 
     * @param player player to eliminate
     *
     * 
     */
    public void playerEliminated(Player player) {
        players.remove(player);
    }

    /**
     * Sr
     * 
     * @param num player to add in the arrayList player
     *
     * 
     */
    // public void setNumofPlayers(int num) {
    // numOfPlayers = num;
    // }

    /**
     * Check if the size of the list of the players is greater than 1.
     * 
     * @return true if players are nore than 1, false otherwise
     */
    public boolean monopolyEND() {
        return this.getSizeOfPlayers() > 1;
    }

    /**
     * Check if the player money are under 0.
     * 
     * @param player where to check the status
     * @return true the money of the player is lower than 0, false otherwise
     */
    public boolean checkbankruptStatus(Player player) {

        return player.getMoney() < 0;
    }

    /**
     * Get the value of the die1.
     * 
     * @return the value of the die1
     * 
     */
    public int die1() {
        return dice.getDie1();
    }

    /**
     * Get the value of the die2.
     * 
     * @return the value of the die2
     * 
     */
    public int die2() {
        return dice.getDie2();
    }

    /**
     * Throw the dice, set the steps by the value of the dice.
     * Return the number of steps.
     * 
     * @return the number of the steps
     * 
     */
    public int throwDice() {
        steps = dice.random();
        return steps;
    }

    /**
     * Set the position of the player by num of steps.
     * 
     * @param player where to set the position
     * 
     */
    public void setPositionPlayer(Player player) {
        player.setPosition(steps);
    }

    /**
     * Set the owner of property square by a player.
     * 
     * @param player for set the owner of a square.
     * 
     */
    public void setOwner(Player player) {
        table.setSquareOwner(player);
    }

    /**
     * Check if the owner of a property square is the same of the player
     * given as input.
     * 
     * @return true if the player is the owner of the propertysquare
     *         false otherwise
     * @param player to check with owner
     * 
     */
    public boolean checkOwnerForRent(Player player) {
        Object obj = this.table.getSquare(player.getPosition());

        if (obj instanceof PropertySquare) {
            PropertySquare s = (PropertySquare) obj;

            return s.getOwner() == player;
        } else {
            return false;

        }

    }

}
